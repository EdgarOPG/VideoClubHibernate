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
 *
 * @author edgar
 */
@Entity
@Table(name = "Actores_socios")
@NamedQueries({
    @NamedQuery(name = "ActoreSocio.findAll", query = "SELECT a FROM ActoreSocio a")})
public class ActorSocio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "actor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Actor actorId;
    @JoinColumn(name = "socio_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Socio socioId;

    public ActorSocio() {
    }

    public ActorSocio(Integer id) {
        this.id = id;
    }

    public ActorSocio(Actor actorId, Socio socioId) {
        setId(id);
        this.actorId = actorId;
        this.socioId = socioId;
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

    public Socio getSocioId() {
        return socioId;
    }

    public void setSocioId(Socio socioId) {
        this.socioId = socioId;
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
        if (!(object instanceof ActorSocio)) {
            return false;
        }
        ActorSocio other = (ActorSocio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.uach.videoclubhibernate.models.ActoreSocio[ id=" + id + " ]";
    }
    
}
