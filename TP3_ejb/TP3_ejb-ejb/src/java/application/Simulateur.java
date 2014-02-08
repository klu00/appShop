/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import domain.Administrator;
import interfaces.AdministratorLocal;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import service.AdministratorBean;

/**
 *
 * @author aupligot
 */
public class Simulateur {
    @EJB
    private static AdministratorBean adminB;

    public static void main(String[] args) {

        int id = 1;
       /* adminB.addAdministrator(new Administrator(id, "JohnDoe", "JohnDoe"));
        Administrator admin = adminB.findAdministratorById(id);
        System.out.println(admin);
*/
            
        AdministratorLocal adminLocal = null;
        try {
            // Context compEnv = (Context) new InitialContext().lookup("java:comp/env");

            // service = (HelloService)new InitialContext().lookup("java:comp/env/ejb/HelloService");
            adminLocal = (AdministratorLocal) new InitialContext().lookup("TP2PU");
        } catch (NamingException ex) {
            Logger.getLogger(Simulateur.class.getName()).log(Level.SEVERE, null, ex);
        }



        adminLocal.addAdministrator(new Administrator(id, "JohnDoe", "JohnDoe"));
        adminLocal.addAdministrator(new Administrator(2, "Aurelien", "Aurelien"));
        Administrator ad = adminLocal.findAdministratorById(id);
        System.out.println(ad);

        List<Administrator> list = adminLocal.findAllAdministrator();

        System.out.println(list);
    }
}
