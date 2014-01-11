/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lucas
 */
@Entity
@Table(name = "PLATFORM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Platform.findAll", query = "SELECT p FROM Platform p"),
    @NamedQuery(name = "Platform.findByPlatformId", query = "SELECT p FROM Platform p WHERE p.platformId = :platformId"),
    @NamedQuery(name = "Platform.findByPlatformName", query = "SELECT p FROM Platform p WHERE p.platformName = :platformName"),
    @NamedQuery(name = "Platform.findByPlatformVersion", query = "SELECT p FROM Platform p WHERE p.platformVersion = :platformVersion")})
public class Platform implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PLATFORM_ID")
    private Integer platformId;
    @Basic(optional = false)
    @Column(name = "PLATFORM_NAME")
    private String platformName;
    @Basic(optional = false)
    @Column(name = "PLATFORM_VERSION")
    private String platformVersion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applicationPlatformId")
    private Collection<Application> applicationCollection;

    public Platform() {
    }

    public Platform(Integer platformId) {
        this.platformId = platformId;
    }

    public Platform(Integer platformId, String platformName, String platformVersion) {
        this.platformId = platformId;
        this.platformName = platformName;
        this.platformVersion = platformVersion;
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    @XmlTransient
    public Collection<Application> getApplicationCollection() {
        return applicationCollection;
    }

    public void setApplicationCollection(Collection<Application> applicationCollection) {
        this.applicationCollection = applicationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (platformId != null ? platformId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Platform)) {
            return false;
        }
        Platform other = (Platform) object;
        if ((this.platformId == null && other.platformId != null) || (this.platformId != null && !this.platformId.equals(other.platformId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Platform[ platformId=" + platformId + " ]";
    }
    
}
