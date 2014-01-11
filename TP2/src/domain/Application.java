/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lucas
 */
@Entity
@Table(name = "APPLICATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Application.findAll", query = "SELECT a FROM Application a"),
    @NamedQuery(name = "Application.findByApplicationId", query = "SELECT a FROM Application a WHERE a.applicationId = :applicationId"),
    @NamedQuery(name = "Application.findByApplicationReleaseDate", query = "SELECT a FROM Application a WHERE a.applicationReleaseDate = :applicationReleaseDate"),
    @NamedQuery(name = "Application.findByApplicationWebsite", query = "SELECT a FROM Application a WHERE a.applicationWebsite = :applicationWebsite"),
    @NamedQuery(name = "Application.findByApplicationName", query = "SELECT a FROM Application a WHERE a.applicationName = :applicationName"),
    @NamedQuery(name = "Application.findByApplicationVersion", query = "SELECT a FROM Application a WHERE a.applicationVersion = :applicationVersion")})
public class Application implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "APPLICATION_ID")
    private Integer applicationId;
    @Column(name = "APPLICATION_RELEASE_DATE")
    @Temporal(TemporalType.DATE)
    private Date applicationReleaseDate;
    @Column(name = "APPLICATION_WEBSITE")
    private String applicationWebsite;
    @Basic(optional = false)
    @Column(name = "APPLICATION_NAME")
    private String applicationName;
    @Basic(optional = false)
    @Column(name = "APPLICATION_VERSION")
    private String applicationVersion;
    @JoinColumn(name = "APPLICATION_PLATFORM_ID", referencedColumnName = "PLATFORM_ID")
    @ManyToOne(optional = false)
    private Platform applicationPlatformId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "downloadApplicationId")
    private Collection<Download> downloadCollection;

    public Application() {
    }

    public Application(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Application(Integer applicationId, String applicationName, String applicationVersion) {
        this.applicationId = applicationId;
        this.applicationName = applicationName;
        this.applicationVersion = applicationVersion;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Date getApplicationReleaseDate() {
        return applicationReleaseDate;
    }

    public void setApplicationReleaseDate(Date applicationReleaseDate) {
        this.applicationReleaseDate = applicationReleaseDate;
    }

    public String getApplicationWebsite() {
        return applicationWebsite;
    }

    public void setApplicationWebsite(String applicationWebsite) {
        this.applicationWebsite = applicationWebsite;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public Platform getApplicationPlatformId() {
        return applicationPlatformId;
    }

    public void setApplicationPlatformId(Platform applicationPlatformId) {
        this.applicationPlatformId = applicationPlatformId;
    }

    @XmlTransient
    public Collection<Download> getDownloadCollection() {
        return downloadCollection;
    }

    public void setDownloadCollection(Collection<Download> downloadCollection) {
        this.downloadCollection = downloadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (applicationId != null ? applicationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Application)) {
            return false;
        }
        Application other = (Application) object;
        if ((this.applicationId == null && other.applicationId != null) || (this.applicationId != null && !this.applicationId.equals(other.applicationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Application[ applicationId=" + applicationId + " ]";
    }
    
}
