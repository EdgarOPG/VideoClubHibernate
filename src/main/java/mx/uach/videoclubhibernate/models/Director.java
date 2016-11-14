
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
 * Definicion de la clase Directores
 * @author Edgar Omar Peinado Garcia
 * @version 1.0
 */
@Entity
@Table(name = "Directores")
@NamedQueries({
    @NamedQuery(name = "Director.findAll", query = "SELECT d FROM Director d")})
public class Director implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "director")
    private Set<DirectorSocio> directorSocioSet;
    @OneToMany(mappedBy = "directorId")
    private Set<Pelicula> peliculaSet;

    public Director() {
    }

    public Director(Integer id) {
        this.id = id;
    }

    public Director(String nombre) {
        setId(id);
        this.nombre = nombre;
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

    public Set<DirectorSocio> getDirectorSocioSet() {
        return directorSocioSet;
    }

    public void setDirectorSocioSet(Set<DirectorSocio> directorSocioSet) {
        this.directorSocioSet = directorSocioSet;
    }

    public Set<Pelicula> getPeliculaSet() {
        return peliculaSet;
    }

    public void setPeliculaSet(Set<Pelicula> peliculaSet) {
        this.peliculaSet = peliculaSet;
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
        if (!(object instanceof Director)) {
            return false;
        }
        Director other = (Director) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.uach.videoclubhibernate.models.Director[ id=" + id + " ]";
    }
    
}
