package com.boutique.controller;

import com.boutique.model.Article;
import com.boutique.model.Client;
import com.boutique.model.Commande;
import com.boutique.services.ArticleService;
import com.boutique.services.ClientService;
import com.boutique.services.CommandeService;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CommandeController {
    @FXML private TextField tfTelephone;
    @FXML private TextField tfNom;
    @FXML private TextField tfAdresse;
    @FXML private TableView<Article> tableArticles;

    private final ClientService clientService = new ClientService();
    private final ArticleService articleService = new ArticleService();
    private final CommandeService commandeService = new CommandeService();

    private Client currentClient;

    @FXML
    public void onSearchClient() {
        String telephone = tfTelephone.getText();
        currentClient = clientService.findClientByTelephone(telephone);

        if (currentClient != null) {
            tfNom.setText(currentClient.getNom() + " " + currentClient.getPrenom());
            tfAdresse.setText(currentClient.getVille() + " | " + currentClient.getQuartier() + " | " + currentClient.getNumeroVilla());
            tableArticles.setDisable(false);
        } else {
            tfNom.clear();
            tfAdresse.clear();
            tableArticles.setDisable(true);
        }
    }

    @FXML
    public void onAddArticle() {
       
    }

    @FXML
    public void onValidateCommande() {
        
    }
}
