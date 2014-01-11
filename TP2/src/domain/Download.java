/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucas
 */
@Entity
@Table(name = "DOWNLOAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Download.findAll", query = "SELECT d FROM Download d"),
    @NamedQuery(name = "Download.findByDownloadId", query = "SELECT d FROM Download d WHERE d.downloadId = :downloadId"),
    @NamedQuery(name = "Download.findByDownloadDate", query = "SELECT d FROM Download d WHERE d.downloadDate = :downloadDate")})
public class Download implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DOWNLOAD_ID")
    private Integer downloadId;
    @Basic(optional = false)
    @Column(name = "DOWNLOAD_DATE")
    @Temporal(TemporalType.DATE)
    private Date downloadDate;
    @JoinColumn(name = "DOWNLOAD_MEMBER_ID", referencedColumnName = "MEMBER_ID")
    @ManyToOne(optional = false)
    private Member1 downloadMemberId;
    @JoinColumn(name = "DOWNLOAD_APPLICATION_ID", referencedColumnName = "APPLICATION_ID")
    @ManyToOne(optional = false)
    private Application downloadApplicationId;

    public Download() {
    }

    public Download(Integer downloadId) {
        this.downloadId = downloadId;
    }

    public Download(Integer downloadId, Date downloadDate) {
        this.downloadId = downloadId;
        this.downloadDate = downloadDate;
    }

    public Integer getDownloadId() {
        return downloadId;
    }

    public void setDownloadId(Integer downloadId) {
        this.downloadId = downloadId;
    }

    public Date getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(Date downloadDate) {
        this.downloadDate = downloadDate;
    }

    public Member1 getDownloadMemberId() {
        return downloadMemberId;
    }

    public void setDownloadMemberId(Member1 downloadMemberId) {
        this.downloadMemberId = downloadMemberId;
    }

    public Application getDownloadApplicationId() {
        return downloadApplicationId;
    }

    public void setDownloadApplicationId(Application downloadApplicationId) {
        this.downloadApplicationId = downloadApplicationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (downloadId != null ? downloadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Download)) {
            return false;
        }
        Download other = (Download) object;
        if ((this.downloadId == null && other.downloadId != null) || (this.downloadId != null && !this.downloadId.equals(other.downloadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Download[ downloadId=" + downloadId + " ]";
    }
    
}
