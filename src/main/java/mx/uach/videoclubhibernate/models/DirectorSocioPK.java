/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoclubhibernate.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Definicion de la clase DirectorSocioPK
 * @author Edgar Omar Peinado Garcia
 * @version 1.0
 */
@Embeddable
public class DirectorSocioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "socio_id")
    private int socioId;
    @Basic(optional = false)
    @Column(name = "director_id")
    private int directorId;

    public DirectorSocioPK() {
    }

    public DirectorSocioPK(String id, int socioId, int directorId) {
        this.id = id;
        this.socioId = socioId;
        this.directorId = directorId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSocioId() {
        return socioId;
    }

    public void setSocioId(int socioId) {
        this.socioId = socioId;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        hash += (int) socioId;
        hash += (int) directorId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DirectorSocioPK)) {
            return false;
        }
        DirectorSocioPK other = (DirectorSocioPK) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        if (this.socioId != other.socioId) {
            return false;
        }
        if (this.directorId != other.directorId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.uach.videoclubhibernate.models.DirectorSocioPK[ id=" + id + ", socioId=" + socioId + ", directorId=" + directorId + " ]";
    }
    
}
