package com.boutique.repositories;

import com.boutique.model.Article;

public class ArticleRepository extends HibernateRepository<Article>  {
    private final EntityManager entityManager;

    public ArticleRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Article findById(int id) {
        return entityManager.find(Article.class, id);
    }

    public void updateStock(Article article, int newStock) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        article.setQuantiteStock(newStock);
        entityManager.merge(article);
        transaction.commit();
    }
}
