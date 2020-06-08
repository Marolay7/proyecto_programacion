/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marolay Duque
 */
@Entity
@Table(name = "PROPUESTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propuesta.findAll", query = "SELECT p FROM Propuesta p")
    , @NamedQuery(name = "Propuesta.findById", query = "SELECT p FROM Propuesta p WHERE p.id = :id")
    , @NamedQuery(name = "Propuesta.findByTitulo", query = "SELECT p FROM Propuesta p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "Propuesta.findByFormato", query = "SELECT p FROM Propuesta p WHERE p.formato = :formato")
    , @NamedQuery(name = "Propuesta.findByFechaEntrega", query = "SELECT p FROM Propuesta p WHERE p.fechaEntrega = :fechaEntrega")})
public class Propuesta implements Serializable {

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
    @JoinColumn(name = "CODIR_ID", referencedColumnName = "DOCUMENTO")
    @ManyToOne
    private Docente codirId;
    @JoinColumn(name = "DIR_ID", referencedColumnName = "DOCUMENTO")
    @ManyToOne
    private Docente dirId;
    @JoinColumn(name = "EST_ID", referencedColumnName = "DOCUMENTO")
    @ManyToOne
    private Estudiante estId;
    @JoinColumn(name = "MODALIDAD_ID", referencedColumnName = "ID")
    @ManyToOne
    private Modalidad modalidadId;
    @OneToMany(mappedBy = "propuestaId")
    private List<TrabajoFinal> trabajoFinalList;

    public Propuesta() {
    }

    public Propuesta(Integer id) {
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

    public Docente getCodirId() {
        return codirId;
    }

    public void setCodirId(Docente codirId) {
        this.codirId = codirId;
    }

    public Docente getDirId() {
        return dirId;
    }

    public void setDirId(Docente dirId) {
        this.dirId = dirId;
    }

    public Estudiante getEstId() {
        return estId;
    }

    public void setEstId(Estudiante estId) {
        this.estId = estId;
    }

    public Modalidad getModalidadId() {
        return modalidadId;
    }

    public void setModalidadId(Modalidad modalidadId) {
        this.modalidadId = modalidadId;
    }

    @XmlTransient
    public List<TrabajoFinal> getTrabajoFinalList() {
        return trabajoFinalList;
    }

    public void setTrabajoFinalList(List<TrabajoFinal> trabajoFinalList) {
        this.trabajoFinalList = trabajoFinalList;
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
        if (!(object instanceof Propuesta)) {
            return false;
        }
        Propuesta other = (Propuesta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Propuesta[ id=" + id + " ]";
    }
    
}
