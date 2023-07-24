package anbara.labs;

import anbara.labs.entities.Employee;
import anbara.labs.persistence.CustomPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

/**
 * @author Ayoub ANBARA
 */
public class Main {
    public static void main(String[] args) {
        /**
         *    using XML
         * */
       /*
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
        /**
         *    Programmatically
         * */
       /*
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

        }*/
        var customPersistenceUnitInfo = new CustomPersistenceUnitInfo();
        EntityManager entityManager;
        try (var entityManagerFactory = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(customPersistenceUnitInfo, new HashMap())) {
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();

         /*   Employee employee = entityManager.find(Employee.class, 1);

            if (employee!=null) {
                employee.setName("new Name3"); // update just on context
                System.out.println(employee);
            }*/
            Employee employee=new Employee();
            employee.setId(1);
            employee.setName("said");
            employee.setAddress("address mmff");
//            entityManager.merge(employee);
            entityManager.persist(employee);

            transaction.commit();   // remove and update on Database

//            persist() -> Adding an entity in the context
//            find() -> Get from DB, adn add it to the context if it does not already exist
//            remove -> Marking an entity for removal
//            merge -> Merges an entity from outside the context to the context
//            refresh -> Mirror the context from the DB
//            detach -> Taking the entity out of the context
        }
    }
}