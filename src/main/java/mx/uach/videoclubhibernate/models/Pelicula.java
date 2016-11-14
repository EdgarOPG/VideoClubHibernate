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
@Table(name = "Peliculas")
@NamedQueries({
    @NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p")})
public class Pelicula implements Serializable {

    @OneToMany(mappedBy = "peliculaId")
    private Set<PeliculasActores> peliculasActoresSet;
    @OneToMany(mappedBy = "peliculasId")
    private Set<Lista> listaSet;
    @OneToMany(mappedBy = "peliculaId")
    private Set<Cinta> cintaSet;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "genero")
    private String genero;
    @Column(name = "duracion")
    private Integer duracion;
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    @ManyToOne
    private Director directorId;

    public Pelicula() {
    }

    public Pelicula(Integer id) {
        this.id = id;
    }

    public Pelicula(String titulo, String genero, Integer duracion, Director directorId) {
        setId(id);
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.directorId = directorId;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Director getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Director directorId) {
        this.directorId = directorId;
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
        if (!(object instanceof Pelicula)) {
            return false;
        }
        Pelicula other = (Pelicula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pelicula[ titulo=" + titulo + " ]";
    }

    public Set<PeliculasActores> getPeliculasActoresSet() {
        return peliculasActoresSet;
    }

    public void setPeliculasActoresSet(Set<PeliculasActores> peliculasActoresSet) {
        this.peliculasActoresSet = peliculasActoresSet;
    }

    public Set<Lista> getListaSet() {
        return listaSet;
    }

    public void setListaSet(Set<Lista> listaSet) {
        this.listaSet = listaSet;
    }

    public Set<Cinta> getCintaSet() {
        return cintaSet;
    }

    public void setCintaSet(Set<Cinta> cintaSet) {
        this.cintaSet = cintaSet;
    }
    
}
