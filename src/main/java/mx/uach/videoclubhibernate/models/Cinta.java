/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoclubhibernate.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author edgar
 */
@Entity
@Table(name = "Cintas")
@NamedQueries({
    @NamedQuery(name = "Cinta.findAll", query = "SELECT c FROM Cinta c")})
public class Cinta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "numero_copia")
    private Integer numeroCopia;
    @OneToMany(mappedBy = "cintasId")
    private Set<CintaFicha> cintaFichaSet;
    @JoinColumn(name = "pelicula_id", referencedColumnName = "id")
    @ManyToOne
    private Pelicula peliculaId;

    public Cinta() {
    }

    public Cinta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroCopia() {
        return numeroCopia;
    }

    public void setNumeroCopia(Integer numeroCopia) {
        this.numeroCopia = numeroCopia;
    }

    public Set<CintaFicha> getCintaFichaSet() {
        return cintaFichaSet;
    }

    public void setCintaFichaSet(Set<CintaFicha> cintaFichaSet) {
        this.cintaFichaSet = cintaFichaSet;
    }

    public Pelicula getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(Pelicula peliculaId) {
        this.peliculaId = peliculaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cinta)) {
            return false;
        }
        Cinta other = (Cinta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.uach.videoclubhibernate.models.Cinta[ id=" + id + " ]";
    }
    
}
