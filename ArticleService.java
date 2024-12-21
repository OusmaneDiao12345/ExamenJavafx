package com.boutique.service;

import com.boutique.model.Article;
import com.boutique.repository.ClientRepository;
import java.sql.SQLException;
import java.util.List;

public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService() {
        this.articleRepository = new ArticleRepository();
    }

    // Récupérer tous les articles disponibles
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    // Ajouter un article
    public void save(Article article) {
        articleRepository.save(article);
    }

    // Mettre à jour un article
    public void update(Article article) {
        articleRepository.update(article);
    }

    // Supprimer un article
    public void delete(int id) {
        articleRepository.delete(id);
    }
}
