/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import domain.Member1;
import java.util.logging.Level;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class JavaApplication {
    
  
    public static void main(String[] args) {
       //EntityManager bootstrap
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("TP2PU");
    EntityManager em = factory.createEntityManager();
    //Begin a transaction
    em.getTransaction().begin();
    //Create a POJO, it's out of the persistence context
    Member1 m = new Member1(Integer.SIZE, "NomPers", "mail@test.fr", "PrenomPers", "test");

    
    try {
        em.persist(m);
        //Now the object is in the persistence context
     //   LOGGER.log(Level.INFO, "The member id is now: {0}", m.getMemberId());
        System.out.println("The member id is now: "+m.getMemberId());
        } catch (EntityExistsException e) {
      //  LOGGER.log(Level.INFO, "The member already exists", m);            
        System.out.println("The member already exists: "+m);
        //We can manually rollback the transaction if we have a problem
       // em.getTransaction().rollback();
        }
        //Merge an object means synchronize the object instance with its DB representation
        m = em.merge(m);
      //  LOGGER.log(Level.INFO, "The member name is now: {0}", m.getMemberLastname());          
        System.out.println("The member name is now: "+m.getMemberLastname());
        //Remove the object from the persistence context, it doesn't mean the object is deleted from the memory
        //em.remove(m);
      //  LOGGER.log(Level.INFO, "The computer no longer exists in the DB");
        //System.out.println("The member not exist in DB ");
        //Since we don't use a Java EE container, we have to manually handle the transaction
        em.getTransaction().commit();
        //Never ever forget to close the resources!!
        em.close();
        factory.close();
     //   30
        //The object isn't in the persistence context, but it still live
     //   LOGGER.log(Level.INFO, "Hi, I am the computer {0} and I am detached of the persistence context", c.getModel());
         System.out.println("Hi, I am the member "+m.getMemberUsername()+" and I am detached of the persistence context");
    }
}
