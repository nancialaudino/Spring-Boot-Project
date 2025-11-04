package com.example.spring_projet.service;

import com.example.spring_projet.model.Client;
import com.example.spring_projet.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final RestTemplate restTemplate;

    public ClientService(ClientRepository clientRepository, RestTemplate restTemplate) {
        this.clientRepository = clientRepository;
        this.restTemplate = restTemplate;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }


    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }


    public void saveClient(Client client) {
        if (isLicenceValid(client.getNumeroPermis())) {
            clientRepository.save(client);
        } else {
            throw new RuntimeException("Numéro de permis invalide !");
        }
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }


    private boolean isLicenceValid(String numero) {
        String url = "http://localhost:8082/licenses/" + numero;

            Boolean response = restTemplate.getForObject(url, Boolean.class);
            return response != null && response;

    }
}
