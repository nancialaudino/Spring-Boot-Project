package com.example.spring_projet.controller;

import org.springframework.web.bind.annotation.*;
import com.example.spring_projet.model.Client;
import com.example.spring_projet.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
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

   /*
    //POST   /clients
    @PostMapping
    public Client addClient (){
        return
    }


    //PUT    /clients

    @PutMapping

    //DELETE  /clients/{id}


    @DeleteMapping



     */

}