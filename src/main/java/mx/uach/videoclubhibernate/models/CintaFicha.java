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
 * Definicion de la clase CintaFicha
 * @author Edgar Omar Peinado Garcia
 * @version 1.0
 */
@Entity
@Table(name = "Cintas_fichas")
@NamedQueries({
    @NamedQuery(name = "CintaFicha.findAll", query = "SELECT c FROM CintaFicha c")})
public class CintaFicha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Column(name = "estatus")
    private String estatus;
    @JoinColumn(name = "cintas_id", referencedColumnName = "id")
    @ManyToOne
    private Cinta cintasId;
    @JoinColumn(name = "ficha_id", referencedColumnName = "id")
    @ManyToOne
    private Ficha fichaId;

    public CintaFicha() {
    }

    public CintaFicha(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Cinta getCintasId() {
        return cintasId;
    }

    public void setCintasId(Cinta cintasId) {
        this.cintasId = cintasId;
    }

    public Ficha getFichaId() {
        return fichaId;
    }

    public void setFichaId(Ficha fichaId) {
        this.fichaId = fichaId;
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
        if (!(object instanceof CintaFicha)) {
            return false;
        }
        CintaFicha other = (CintaFicha) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.uach.videoclubhibernate.models.CintaFicha[ id=" + id + " ]";
    }
    
}
