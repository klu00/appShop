/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import domain.Administrator;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lucas
 */
@Local
public interface AdministratorLocal {
    public void addAdministrator(Administrator administrator);
    public void deleteAdministrator(Administrator administrator);
    public List<Administrator> findAllAdministrator();
    public Administrator findAdministratorById(Integer id);
    public void updateAdministrator(Administrator administrator);
}
