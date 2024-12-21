package com.boutique.repositories;

import com.boutique.model.Client;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ClientRepository extends HibernateRepository<Client> {

    public Client findByTelephone(String telephone) {
        try (Session session = getSession()) {
            Query<Client> query = session.createQuery("FROM Client WHERE telephone = :telephone", Client.class);
            query.setParameter("telephone", telephone);
            return query.uniqueResult();
        }
    }
}
