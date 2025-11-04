package com.example.spring_projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring_projet.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
