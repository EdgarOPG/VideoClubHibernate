/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoclubhibernate.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author edgar
 */
@Entity
@Table(name = "Actores")
public class Actor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actorId")
    private Set<ActorSocio> actoreSocioSet;
    @OneToMany(mappedBy = "actorId")
    private Set<PeliculasActores> peliculasActoresSet;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    
    @Column(name = "apellido")
    private String apellido;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public Actor() {
    }

    public Actor(String nombre, String apellido) {
        setId(id);
        this.nombre = nombre;
        this.apellido = apellido;
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
        if (!(object instanceof Actor)) {
            return false;
        }
        Actor other = (Actor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Actores[ nombre=" + nombre + " ]";
    }

    public Actor(Integer id) {
        this.id = id;
    }

    public Set<ActorSocio> getActoreSocioSet() {
        return actoreSocioSet;
    }

    public void setActoreSocioSet(Set<ActorSocio> actoreSocioSet) {
        this.actoreSocioSet = actoreSocioSet;
    }

    public Set<PeliculasActores> getPeliculasActoresSet() {
        return peliculasActoresSet;
    }

    public void setPeliculasActoresSet(Set<PeliculasActores> peliculasActoresSet) {
        this.peliculasActoresSet = peliculasActoresSet;
    }
    
}
