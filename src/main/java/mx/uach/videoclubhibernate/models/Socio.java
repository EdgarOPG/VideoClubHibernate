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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author edgar
 */
@Entity
@Table(name = "Socios")
@NamedQueries({
    @NamedQuery(name = "Socio.findAll", query = "SELECT s FROM Socio s")})
public class Socio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socioId")
    private Set<Ficha> fichaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socioId")
    private Set<ActorSocio> actoreSocioSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socio")
    private Set<DirectorSocio> directorSocioSet;
    @OneToMany(mappedBy = "socioid")
    private Set<Lista> listaSet;

    public Socio() {
    }

    public Socio(Integer id) {
        this.id = id;
    }

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<Ficha> getFichaSet() {
        return fichaSet;
    }

    public void setFichaSet(Set<Ficha> fichaSet) {
        this.fichaSet = fichaSet;
    }

    public Set<ActorSocio> getActoreSocioSet() {
        return actoreSocioSet;
    }

    public void setActoreSocioSet(Set<ActorSocio> actoreSocioSet) {
        this.actoreSocioSet = actoreSocioSet;
    }

    public Set<DirectorSocio> getDirectorSocioSet() {
        return directorSocioSet;
    }

    public void setDirectorSocioSet(Set<DirectorSocio> directorSocioSet) {
        this.directorSocioSet = directorSocioSet;
    }

    public Set<Lista> getListaSet() {
        return listaSet;
    }

    public void setListaSet(Set<Lista> listaSet) {
        this.listaSet = listaSet;
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
        if (!(object instanceof Socio)) {
            return false;
        }
        Socio other = (Socio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.uach.videoclubhibernate.models.Socio[ id=" + id + " ]";
    }
    
}
