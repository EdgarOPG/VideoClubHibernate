/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoclubhibernate.models;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Definicion de la clase DirectorSocio
 * @author Edgar Omar Peinado Garcia
 * @version 1.0
 */
@Entity
@Table(name = "Directores_socios")
@NamedQueries({
    @NamedQuery(name = "DirectorSocio.findAll", query = "SELECT d FROM DirectorSocio d")})
public class DirectorSocio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DirectorSocioPK directorSocioPK;
    @JoinColumn(name = "director_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Director director;
    @JoinColumn(name = "socio_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Socio socio;

    public DirectorSocio() {
    }

    public DirectorSocio(DirectorSocioPK directorSocioPK) {
        this.directorSocioPK = directorSocioPK;
    }

    public DirectorSocio(String id, int socioId, int directorId) {
        this.directorSocioPK = new DirectorSocioPK(id, socioId, directorId);
    }

    public DirectorSocioPK getDirectorSocioPK() {
        return directorSocioPK;
    }

    public void setDirectorSocioPK(DirectorSocioPK directorSocioPK) {
        this.directorSocioPK = directorSocioPK;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (directorSocioPK != null ? directorSocioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DirectorSocio)) {
            return false;
        }
        DirectorSocio other = (DirectorSocio) object;
        if ((this.directorSocioPK == null && other.directorSocioPK != null) || (this.directorSocioPK != null && !this.directorSocioPK.equals(other.directorSocioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.uach.videoclubhibernate.models.DirectorSocio[ directorSocioPK=" + directorSocioPK + " ]";
    }
    
}
