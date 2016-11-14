/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoclubhibernate.models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author edgar
 */
@Entity
@Table(name = "Listas")
@NamedQueries({
    @NamedQuery(name = "Lista.findAll", query = "SELECT l FROM Lista l")})
public class Lista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "estatus")
    private String estatus;
    @JoinColumn(name = "peliculas_id", referencedColumnName = "id")
    @ManyToOne
    private Pelicula peliculasId;
    @JoinColumn(name = "Socio_id", referencedColumnName = "id")
    @ManyToOne
    private Socio socioid;

    public Lista() {
    }

    public Lista(Integer id) {
        this.id = id;
    }

    public Lista(Date fecha, String estatus, Pelicula peliculasId, Socio socioid) {
        setId(id);
        this.fecha = fecha;
        this.estatus = estatus;
        this.peliculasId = peliculasId;
        this.socioid = socioid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Pelicula getPeliculasId() {
        return peliculasId;
    }

    public void setPeliculasId(Pelicula peliculasId) {
        this.peliculasId = peliculasId;
    }

    public Socio getSocioid() {
        return socioid;
    }

    public void setSocioid(Socio socioid) {
        this.socioid = socioid;
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
        if (!(object instanceof Lista)) {
            return false;
        }
        Lista other = (Lista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.uach.videoclubhibernate.models.Lista[ id=" + id + " ]";
    }
    
}
