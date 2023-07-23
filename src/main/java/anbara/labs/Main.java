package anbara.labs;

import anbara.labs.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

/**
 * @author Ayoub ANBARA
 */
public class Main {
    public static void main(String[] args) {
       /* using xml
       try (var entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");

             EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            EntityTransaction transaction = entityManager.getTransaction();

            var p = new Product();
            p.setId(1L);
            p.setName("Macbook");

            transaction.begin();

            entityManager.persist(p);

            transaction.commit();
        }*/
        var customPersistenceUnitInfo = new CustomPersistenceUnitInfo();
        EntityManager entityManager;
        try (var entityManagerFactory = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(customPersistenceUnitInfo, new HashMap())) {
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();

            var p = new Product();
            p.setId(4L);
            p.setName("book444");

            transaction.begin();

            entityManager.persist(p);

            transaction.commit();

        }
    }}