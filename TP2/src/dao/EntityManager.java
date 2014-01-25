/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.logging.Level;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class EntityManager {
 
 public void test() {
    //EntityManager bootstrap
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("myPersistenceUnitName");
    javax.persistence.EntityManager em = factory.createEntityManager();

    //Begin a transaction
    em.getTransaction().begin();

    //Create a POJO, it's out of the persistence context
    Computer c = new Computer();
    c.setModel("Lenovo L420");
    c.setOperatingSystem("Windows XP");

    try {
    em.persist(c);
    //Now the object is in the persistence context
    LOGGER.log(Level.INFO, "The computer id is now: {0}", c.getId());
    } catch (EntityExistsException e) {
    LOGGER.log(Level.INFO, "The computer already exists", e);
    //We can manually rollback the transaction if we have a problem
    em.getTransaction().rollback();
    }

    c.setOperatingSystem("Windows 7");
    //Merge an object means synchronize the object instance with its DB representation
    c = em.merge(c);
    LOGGER.log(Level.INFO, "The computer OS is now: {0}", c.getOperatingSystem());

    //Remove the object from the persistence context, it doesn't mean the object is deleted from the memory
    em.remove(c);
    LOGGER.log(Level.INFO, "The computer no longer exists in the DB");

    //Since we don't use a Java EE container, we have to manually handle the transaction
    em.getTransaction().commit();

    //Never ever forget to close the resources!!
    em.close();
    factory.close();

    //The object isn't in the persistence context, but it still live
    LOGGER.log(Level.INFO, "Hi, I am the computer {0} and I am detached of the persistence context", c.getModel());

   }
 }
 
