package com.boutique.service;

import com.boutique.model.Client;
import com.boutique.repository.ClientRepository;
import java.sql.SQLException;
import java.util.List;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findOrCreateClient(String telephone, String nom, String prenom, String ville, String quartier, String numeroVilla) {
        try {
            return clientRepository.findByTelephone(telephone);
        } catch (Exception e) {
            Client client = new Client();
            client.setNom(nom);
            client.setPrenom(prenom);
            client.setTelephone(telephone);
            client.setVille(ville);
            client.setQuartier(quartier);
            client.setNumeroVilla(numeroVilla);
            clientRepository.save(client);
            return client;
        }
    }
}