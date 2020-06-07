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
@Table(name = "FINAL_PRACTICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinalPractica.findAll", query = "SELECT f FROM FinalPractica f")
    , @NamedQuery(name = "FinalPractica.findById", query = "SELECT f FROM FinalPractica f WHERE f.id = :id")
    , @NamedQuery(name = "FinalPractica.findByTitulo", query = "SELECT f FROM FinalPractica f WHERE f.titulo = :titulo")
    , @NamedQuery(name = "FinalPractica.findByProgramaCodigo", query = "SELECT f FROM FinalPractica f WHERE f.programaCodigo = :programaCodigo")
    , @NamedQuery(name = "FinalPractica.findByNumeroConvenio", query = "SELECT f FROM FinalPractica f WHERE f.numeroConvenio = :numeroConvenio")
    , @NamedQuery(name = "FinalPractica.findByFechaConvenio", query = "SELECT f FROM FinalPractica f WHERE f.fechaConvenio = :fechaConvenio")
    , @NamedQuery(name = "FinalPractica.findByFormato", query = "SELECT f FROM FinalPractica f WHERE f.formato = :formato")
    , @NamedQuery(name = "FinalPractica.findByFechaEntrega", query = "SELECT f FROM FinalPractica f WHERE f.fechaEntrega = :fechaEntrega")})
public class FinalPractica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "PROGRAMA_CODIGO")
    private Integer programaCodigo;
    @Column(name = "NUMERO_CONVENIO")
    private Integer numeroConvenio;
    @Column(name = "FECHA_CONVENIO")
    @Temporal(TemporalType.DATE)
    private Date fechaConvenio;
    @Size(max = 255)
    @Column(name = "FORMATO")
    private String formato;
    @Column(name = "FECHA_ENTREGA")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @JoinColumn(name = "CONCEPTO_ID", referencedColumnName = "ID")
    @ManyToOne
    private Concepto conceptoId;
    @JoinColumn(name = "EMPRESA_ID", referencedColumnName = "ID")
    @ManyToOne
    private Empresa empresaId;
    @JoinColumn(name = "MODALIDAD_ID", referencedColumnName = "ID")
    @ManyToOne
    private Modalidad modalidadId;
    @JoinColumn(name = "PROPUESTA_ID", referencedColumnName = "ID")
    @ManyToOne
    private PropuestaPractica propuestaId;
    @JoinColumn(name = "DIR_ID", referencedColumnName = "DOCUMENTO")
    @ManyToOne
    private Users dirId;
    @JoinColumn(name = "EST_ID", referencedColumnName = "DOCUMENTO")
    @ManyToOne
    private Users estId;

    public FinalPractica() {
    }

    public FinalPractica(Integer id) {
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

    public Integer getProgramaCodigo() {
        return programaCodigo;
    }

    public void setProgramaCodigo(Integer programaCodigo) {
        this.programaCodigo = programaCodigo;
    }

    public Integer getNumeroConvenio() {
        return numeroConvenio;
    }

    public void setNumeroConvenio(Integer numeroConvenio) {
        this.numeroConvenio = numeroConvenio;
    }

    public Date getFechaConvenio() {
        return fechaConvenio;
    }

    public void setFechaConvenio(Date fechaConvenio) {
        this.fechaConvenio = fechaConvenio;
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

    public Empresa getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Empresa empresaId) {
        this.empresaId = empresaId;
    }

    public Modalidad getModalidadId() {
        return modalidadId;
    }

    public void setModalidadId(Modalidad modalidadId) {
        this.modalidadId = modalidadId;
    }

    public PropuestaPractica getPropuestaId() {
        return propuestaId;
    }

    public void setPropuestaId(PropuestaPractica propuestaId) {
        this.propuestaId = propuestaId;
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
        if (!(object instanceof FinalPractica)) {
            return false;
        }
        FinalPractica other = (FinalPractica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.FinalPractica[ id=" + id + " ]";
    }
    
}
