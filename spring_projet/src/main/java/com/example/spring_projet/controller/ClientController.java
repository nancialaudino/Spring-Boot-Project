package com.example.spring_projet.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import com.example.spring_projet.model.Client;
import com.example.spring_projet.service.ClientService;
import java.util.List;

import java.util.List;

@RestController
@RequestMapping("/clients")
@Tag(name = "Clients", description = "Operation related to the client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // GET /clients
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }


    // GET /clients/{id}
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id)
                .orElseThrow(() -> new RuntimeException("Client Not Found"));
    }


    @PostMapping
    @Operation(summary = "Add a new client", description = "Receives a new client and creates a new data entry")
    public void addClient(@RequestBody Client client) {
        clientService.saveClient(client);
    }


    @PutMapping
    @Operation(summary = "Update client data", description = "Receives the client data and updates the client")
    public void updateClient(@RequestBody Client client) {
        clientService.saveClient(client);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete client", description = "Receives client's id and deletes the client")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

}

