/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoclubhibernate.models;

import java.io.Serializable;
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

/**
 * Definicion de la clase PeliculaActor
 * @author Edgar Omar Peinado Garcia
 * @version 1.0
 */
@Entity
@Table(name = "Peliculas_actores")
@NamedQueries({
    @NamedQuery(name = "PeliculaActor.findAll", query = "SELECT p FROM PeliculaActor p")})
public class PeliculaActor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "actor_id", referencedColumnName = "id")
    @ManyToOne
    private Actor actorId;
    @JoinColumn(name = "pelicula_id", referencedColumnName = "id")
    @ManyToOne
    private Pelicula peliculaId;

    public PeliculaActor() {
    }

    public PeliculaActor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Actor getActorId() {
        return actorId;
    }

    public void setActorId(Actor actorId) {
        this.actorId = actorId;
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
        if (!(object instanceof PeliculaActor)) {
            return false;
        }
        PeliculaActor other = (PeliculaActor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.uach.videoclubhibernate.models.PeliculaActor[ id=" + id + " ]";
    }
    
}
