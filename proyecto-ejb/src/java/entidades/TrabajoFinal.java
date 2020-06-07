/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marolay Duque
 */
@Entity
@Table(name = "TRABAJO_FINAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrabajoFinal.findAll", query = "SELECT t FROM TrabajoFinal t")
    , @NamedQuery(name = "TrabajoFinal.findById", query = "SELECT t FROM TrabajoFinal t WHERE t.id = :id")
    , @NamedQuery(name = "TrabajoFinal.findByTitulo", query = "SELECT t FROM TrabajoFinal t WHERE t.titulo = :titulo")
    , @NamedQuery(name = "TrabajoFinal.findByFormato", query = "SELECT t FROM TrabajoFinal t WHERE t.formato = :formato")
    , @NamedQuery(name = "TrabajoFinal.findByFechaEntrega", query = "SELECT t FROM TrabajoFinal t WHERE t.fechaEntrega = :fechaEntrega")})
public class TrabajoFinal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "TITULO")
    private String titulo;
    @Size(max = 255)
    @Column(name = "FORMATO")
    private String formato;
    @Column(name = "FECHA_ENTREGA")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @JoinColumn(name = "CONCEPTO_ID", referencedColumnName = "ID")
    @ManyToOne
    private Concepto conceptoId;
    @JoinColumn(name = "MODALIDAD_ID", referencedColumnName = "ID")
    @ManyToOne
    private Modalidad modalidadId;
    @JoinColumn(name = "PROPUESTA_ID", referencedColumnName = "ID")
    @ManyToOne
    private Propuesta propuestaId;
    @JoinColumn(name = "CODIR_ID", referencedColumnName = "DOCUMENTO")
    @ManyToOne
    private Users codirId;
    @JoinColumn(name = "DIR_ID", referencedColumnName = "DOCUMENTO")
    @ManyToOne
    private Users dirId;
    @JoinColumn(name = "EST_ID", referencedColumnName = "DOCUMENTO")
    @ManyToOne
    private Users estId;

    public TrabajoFinal() {
    }

    public TrabajoFinal(Integer id) {
        this.id = id;
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

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Concepto getConceptoId() {
        return conceptoId;
    }

    public void setConceptoId(Concepto conceptoId) {
        this.conceptoId = conceptoId;
    }

    public Modalidad getModalidadId() {
        return modalidadId;
    }

    public void setModalidadId(Modalidad modalidadId) {
        this.modalidadId = modalidadId;
    }

    public Propuesta getPropuestaId() {
        return propuestaId;
    }

    public void setPropuestaId(Propuesta propuestaId) {
        this.propuestaId = propuestaId;
    }

    public Users getCodirId() {
        return codirId;
    }

    public void setCodirId(Users codirId) {
        this.codirId = codirId;
    }

    public Users getDirId() {
        return dirId;
    }

    public void setDirId(Users dirId) {
        this.dirId = dirId;
    }

    public Users getEstId() {
        return estId;
    }

    public void setEstId(Users estId) {
        this.estId = estId;
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
        if (!(object instanceof TrabajoFinal)) {
            return false;
        }
        TrabajoFinal other = (TrabajoFinal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TrabajoFinal[ id=" + id + " ]";
    }
    
}
