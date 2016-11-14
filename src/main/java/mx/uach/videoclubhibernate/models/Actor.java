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
 * Definicion de la clase Autor
 * @author Edgar Omar Peinado Garcia
 * @version 1.0
 */
@Entity
@Table(name = "Actores")
@NamedQueries({
    @NamedQuery(name = "Actor.findAll", query = "SELECT a FROM Actor a")})
public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actorId")
    private Set<ActorSocio> actorSocioSet;
    @OneToMany(mappedBy = "actorId")
    private Set<PeliculaActor> peliculaActorSet;

    public Actor() {
    }

    public Actor(Integer id) {
        this.id = id;
    }

    public Actor(String nombre, String apellido) {
        setId(id);
        this.nombre = nombre;
        this.apellido = apellido;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Set<ActorSocio> getActorSocioSet() {
        return actorSocioSet;
    }

    public void setActorSocioSet(Set<ActorSocio> actorSocioSet) {
        this.actorSocioSet = actorSocioSet;
    }

    public Set<PeliculaActor> getPeliculaActorSet() {
        return peliculaActorSet;
    }

    public void setPeliculaActorSet(Set<PeliculaActor> peliculaActorSet) {
        this.peliculaActorSet = peliculaActorSet;
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
        return "mx.uach.videoclubhibernate.models.Actor[ id=" + id + " ]";
    }
    
}
