package com.example.spring_projet.model;

import java.time.LocalDate;

public class Client {

    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String numeroPermis;

    public Client(){}

    public Client(Long id, String nom, String prenom, LocalDate dateNaissance, String numeroPermis) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.numeroPermis = numeroPermis;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getNom () {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public String getNumeroPermis() {
        return numeroPermis;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setNumeroPermis(String numeroPermis) {
        this.numeroPermis = numeroPermis;
    }
}
