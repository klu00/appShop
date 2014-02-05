/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Administrator;
import interfaces.AdministratorLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Lucas
 */
@Stateless
@LocalBean
public class AdministratorBean implements AdministratorLocal{

    @PersistenceUnit(name="AppShopPU")
    private EntityManager em;
    
    private Logger LOGGER= Logger.getLogger("logger");
    
    @Override
    public void addAdministrator(Administrator administrator) {
        em.getTransaction().begin();
        try {
            em.persist(administrator);
        } catch (EntityExistsException e) {
            LOGGER.log(Level.SEVERE, "The administrator already exists");
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteAdministrator(Administrator administrator) {
        em.getTransaction().begin();
        try {
            em.detach(administrator);
        } catch(Exception e) {
            LOGGER.log(Level.SEVERE, "Error suppressing administrator id="+administrator.getAdministratorUsername());
        }
    }

    @Override
    public List<Administrator> findAllAdministrator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Administrator findAdministratorById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void updateAdministrator(Administrator administrator) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
