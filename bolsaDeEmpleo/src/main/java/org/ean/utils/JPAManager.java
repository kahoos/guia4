package org.ean.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAManager {
    private static final String PERSISTENCE_UNIT_NAME = "persistence";
    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;
    public EntityManager getEntityManager(){
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
