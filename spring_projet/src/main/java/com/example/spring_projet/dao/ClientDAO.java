package com.example.spring_projet.dao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.spring_projet.model.Client;

public class ClientDAO {
    private List<Client> clients = new ArrayList<>();

    public ClientDAO() {

        clients.add(new Client(4L, "Antonia", "Francis", LocalDate.of(1999, 5, 12), "ABC123XYZ"));
        clients.add(new Client(5L, "Bruno", "Lille", LocalDate.of(1999, 5, 12), "ABC123XYZ"));

    }

    // 1. Lister tous les clients
    public List<Client> findAll() {

        return clients;

    }

    // 2. Trouver un client par id
    public Optional<Client> findById(int id) {
        return clients.stream().filter(c -> c.getId() == id).findFirst();
    }

    // 3. Ajouter ou modifier un client
    public void save(Client client) {
        findById(client.getId().intValue()).ifPresentOrElse(
                existing -> {
                    // Modifier client existant
                    existing.setNom(client.getNom());
                    existing.setDateNaissance(client.getDateNaissance());
                },
                () -> clients.add(client) // Ajouter nouveau client
        );
    }

    // 4. Supprimer un client par id
    public final void delete(int id) {
        clients.removeIf(c -> c.getId() == id);
    }

}
