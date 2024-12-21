package com.boutique.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Optional;

public class HibernateRepository<T> {
    private final Class<T> entityType;

    
    private static final org.hibernate.SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml") // Charger le fichier hibernate.cfg.xml
            .buildSessionFactory();

    
    public HibernateRepository(Class<T> entityType) {
        this.entityType = entityType;
    }

    
    protected Session getSession() {
        return sessionFactory.openSession();
    }

    
    public void save(T entity) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    
    public void update(T entity) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    
    public void delete(T entity) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    
    public Optional<T> findById(int id) {
        try (Session session = getSession()) {
            return Optional.ofNullable(session.get(entityType, id));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

   
    public List<T> findAll() {
        try (Session session = getSession()) {
            return session.createQuery("from " + entityType.getSimpleName(), entityType).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

  
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}


