/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import domain.Download;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lucas
 */
@Local
public interface DownloadLocal {
    public void addDownload(Download download);
    public void deleteDownload(Download download);
    public List<Download> findAllDownloads();
    public Download findDownloadById(Integer id);
    public void updateDownload(Download download);
}
