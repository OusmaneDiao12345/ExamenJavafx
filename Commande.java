package com.boutique.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private double total;

    @OneToMany(mappedBy = "commande")
    private List<CommandeArticle> articles;

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<CommandeArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<CommandeArticle> articles) {
        this.articles = articles;
    }
}
