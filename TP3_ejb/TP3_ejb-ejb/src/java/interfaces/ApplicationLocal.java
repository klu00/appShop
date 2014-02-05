/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import domain.Application;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lucas
 */
@Local
public interface ApplicationLocal {
    public void addAdministrator(Application application);
    public void deleteApplication(Application application);
    public List<Application> findAllApplications();
    public Application findApplicationById(Integer id);
    public void updateApplication(Application application);
}
