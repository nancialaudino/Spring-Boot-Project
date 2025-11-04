package com.example.spring_projet.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.spring_projet.model.Client;
import com.example.spring_projet.dao.ClientDAO;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final List<Client> clients = Arrays.asList(
            new Client(1L, "Laudino", "Nana", LocalDate.of(2005, 5, 12), "ABC123XYZ"),
            new Client(2L, "Jackson", "Ana", LocalDate.of(1985, 8, 22), "XYZ987ABC"),
            new Client(3L, "Joseph", "Adam", LocalDate.of(1992, 3, 10), "QWE456RTY")
    );

    private final ClientDAO clientDAO = new ClientDAO();
    private final RestTemplate restTemplate;

    // Construtor para injeção de RestTemplate
    public ClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Client> getAllClients() {
        return clients;
    }

    public Optional<Client> getClientById(Long id) {
        return clients.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    // Save client with the validation of the permission number
    public void saveClient(Client client) {
        if (isLicenceValid(client.getNumeroPermis())) {
            clientDAO.save(client);
        } else {
            throw new RuntimeException("Numéro de permis invalide !");
        }
    }

    public void deleteClient(int id) {
        clientDAO.delete(id);
    }

    // used to call the external API and check the number
    private boolean isLicenceValid(String numero) {
        String url = "http://localhost:8082/licences/" + numero;
        try {
            LicenceResponse response = restTemplate.getForObject(url, LicenceResponse.class);
            return response != null && response.isValide();
        } catch (Exception e) {
            return false;
        }
    }
}