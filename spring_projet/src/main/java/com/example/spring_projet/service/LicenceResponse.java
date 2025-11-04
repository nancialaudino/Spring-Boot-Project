package com.example.spring_projet.service;

public class LicenceResponse {

    private String numero;
    private boolean valide;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

}
