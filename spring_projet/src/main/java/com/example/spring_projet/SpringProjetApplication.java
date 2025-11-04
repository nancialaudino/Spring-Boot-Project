package com.example.spring_projet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjetApplication.class, args);
	}

}




































/**
 *
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

 public Client saveClient(Client client) {
 if (!isLicenceValid(client.getNumeroPermis())) {
 throw new RuntimeException("Numéro de permis invalide !");
 }
 return clientRepository.save(client);
 }

 public void deleteClient(Long id) {
 clientRepository.deleteById(id);
 }

 private boolean isLicenceValid(String numero) {
 String url = "http://localhost:8082/api/licences/" + numero;
 try {
 LicenceResponse response = restTemplate.getForObject(url, LicenceResponse.class);
 return response != null && response.isValide();
 } catch (Exception e) {
 return false;
 }
 }
 }

 */