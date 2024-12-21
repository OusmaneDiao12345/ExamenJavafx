package com.boutique.service;

import com.boutique.model.Commande;
import com.boutique.repository.CommandeRepository;
import java.sql.SQLException;
import java.util.List;

public class CommandeService {

    private final CommandeRepository commandeRepository;

    public CommandeService() {
        this.commandeRepository = new CommandeRepository();
    }

    // Ajouter une commande
    public void save(Commande commande) {
        commandeRepository.save(commande);
    }

    // Récupérer toutes les commandes
    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }

    // Récupérer une commande par ID
    public Commande findById(int id) {
        return commandeRepository.findById(id);
    }
}

