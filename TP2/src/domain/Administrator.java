/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucas
 */
@Entity
@Table(name = "ADMINISTRATOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a"),
    @NamedQuery(name = "Administrator.findByAdministratorId", query = "SELECT a FROM Administrator a WHERE a.administratorId = :administratorId"),
    @NamedQuery(name = "Administrator.findByAdministratorUsername", query = "SELECT a FROM Administrator a WHERE a.administratorUsername = :administratorUsername"),
    @NamedQuery(name = "Administrator.findByAdministratorPassword", query = "SELECT a FROM Administrator a WHERE a.administratorPassword = :administratorPassword")})
public class Administrator implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ADMINISTRATOR_ID")
    private Integer administratorId;
    @Basic(optional = false)
    @Column(name = "ADMINISTRATOR_USERNAME")
    private String administratorUsername;
    @Basic(optional = false)
    @Column(name = "ADMINISTRATOR_PASSWORD")
    private String administratorPassword;

    public Administrator() {
    }

    public Administrator(Integer administratorId) {
        this.administratorId = administratorId;
    }

    public Administrator(Integer administratorId, String administratorUsername, String administratorPassword) {
        this.administratorId = administratorId;
        this.administratorUsername = administratorUsername;
        this.administratorPassword = administratorPassword;
    }

    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

    public String getAdministratorUsername() {
        return administratorUsername;
    }

    public void setAdministratorUsername(String administratorUsername) {
        this.administratorUsername = administratorUsername;
    }

    public String getAdministratorPassword() {
        return administratorPassword;
    }

    public void setAdministratorPassword(String administratorPassword) {
        this.administratorPassword = administratorPassword;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (administratorId != null ? administratorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrator)) {
            return false;
        }
        Administrator other = (Administrator) object;
        if ((this.administratorId == null && other.administratorId != null) || (this.administratorId != null && !this.administratorId.equals(other.administratorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Administrator[ administratorId=" + administratorId + " ]";
    }
    
}
