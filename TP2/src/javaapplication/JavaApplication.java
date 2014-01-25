/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import domain.Application;
import domain.Member1;
import domain.Platform;
import domain.Sequence;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author Lucas
 */
public class JavaApplication {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("TP2PU");
    private EntityManager em = factory.createEntityManager();
    private Logger LOGGER = Logger.getLogger("logger");

    public static void main(String[] args) {
        JavaApplication app = new JavaApplication();
        app.addMember("toto1", "titi1", "toto1@titi.com", "tototiti1", "toto1");
        app.addApplication("apptest", "1.0", app.getPlatform(""));
        
    }
    
    private Platform getPlatform(String name) { 
        //em.getTransaction().begin();
        //CriteriaBuilder cb = em.getCriteriaBuilder().createQuery(Platform.class).;
        //Platform p = em.createQuery("");
        //return p;
        return null;
    }
    
     private void addApplication(String applicationName, String applicationVersion, Platform platform) {
        em.getTransaction().begin();

        Application app = new Application();
        app.setApplicationName(applicationName);
        app.setApplicationVersion(applicationVersion);
        app.setApplicationPlatformId(platform);
       
        try {
            em.persist(app);
        } catch (EntityExistsException e) {
            LOGGER.log(Level.INFO, "The application already exists");
        }

        //Merge an object means synchronize the object instance with its DB representation
        app = em.merge(app);
        LOGGER.log(Level.INFO, "The member name is now: {0}", app.getApplicationName());

        //Since we don't use a Java EE container, we have to manually handle the transaction
        em.getTransaction().commit();
        //Never ever forget to close the resources!!
    }

    private void addMember(String lastname, String firstname, String username, String email, String password) {
        em.getTransaction().begin();

        Member1 m = new Member1();
        m.setMemberLastname(lastname);
        m.setMemberFirstname(firstname);
        m.setMemberEmail(email);
        m.setMemberUsername(username);
        m.setMemberPassword(password);

        try {
            em.persist(m);
            LOGGER.log(Level.INFO, "The member id is now: {0}", m.getMemberId());
        } catch (EntityExistsException e) {
            LOGGER.log(Level.INFO, "The member already exists", m);
        }

        //Merge an object means synchronize the object instance with its DB representation
        m = em.merge(m);
        LOGGER.log(Level.INFO, "The member name is now: {0}", m.getMemberLastname());

        //Since we don't use a Java EE container, we have to manually handle the transaction
        em.getTransaction().commit();
        //Never ever forget to close the resources!!
    }
}
