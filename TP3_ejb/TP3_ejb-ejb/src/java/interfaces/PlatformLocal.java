/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import domain.Platform;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lucas
 */
@Local
public interface PlatformLocal {
    public void addPlatform(Platform platform);
    public void deletePlatform(Platform platform);
    public List<Platform> findAllPlatforms();
    public Platform findPlatformById(Integer id);
    public void updatePlatform(Platform platform);
}
