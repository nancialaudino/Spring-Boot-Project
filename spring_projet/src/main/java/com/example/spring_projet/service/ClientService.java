package com.example.spring_projet.service;
import org.springframework.stereotype.Service;
import com.example.spring_projet.model.Client;

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

    public List<Client> getAllClients() {
        return clients;
    }

    public Optional<Client> getClientById(Long id) {
        return clients.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }
}
