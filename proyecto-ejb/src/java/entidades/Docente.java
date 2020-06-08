/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marolay Duque
 */
@Entity
@Table(name = "DOCENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d")
    , @NamedQuery(name = "Docente.findByDocumento", query = "SELECT d FROM Docente d WHERE d.documento = :documento")
    , @NamedQuery(name = "Docente.findByNombre", query = "SELECT d FROM Docente d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Docente.findByCorreo", query = "SELECT d FROM Docente d WHERE d.correo = :correo")
    , @NamedQuery(name = "Docente.findByTelefono", query = "SELECT d FROM Docente d WHERE d.telefono = :telefono")})
public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOCUMENTO")
    private Integer documento;
    @Size(max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 255)
    @Column(name = "CORREO")
    private String correo;
    @Size(max = 15)
    @Column(name = "TELEFONO")
    private String telefono;
    @OneToMany(mappedBy = "calificadorDocumento")
    private List<Concepto> conceptoList;
    @OneToMany(mappedBy = "dirId")
    private List<FinalPractica> finalPracticaList;
    @OneToMany(mappedBy = "profDocumento")
    private List<BancoIdeas> bancoIdeasList;
    @OneToMany(mappedBy = "codirId")
    private List<Propuesta> propuestaList;
    @OneToMany(mappedBy = "dirId")
    private List<Propuesta> propuestaList1;
    @OneToMany(mappedBy = "codirId")
    private List<TrabajoFinal> trabajoFinalList;
    @OneToMany(mappedBy = "dirId")
    private List<TrabajoFinal> trabajoFinalList1;
    @OneToMany(mappedBy = "dirId")
    private List<PropuestaPractica> propuestaPracticaList;

    public Docente() {
    }

    public Docente(Integer documento) {
        this.documento = documento;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<Concepto> getConceptoList() {
        return conceptoList;
    }

    public void setConceptoList(List<Concepto> conceptoList) {
        this.conceptoList = conceptoList;
    }

    @XmlTransient
    public List<FinalPractica> getFinalPracticaList() {
        return finalPracticaList;
    }

    public void setFinalPracticaList(List<FinalPractica> finalPracticaList) {
        this.finalPracticaList = finalPracticaList;
    }

    @XmlTransient
    public List<BancoIdeas> getBancoIdeasList() {
        return bancoIdeasList;
    }

    public void setBancoIdeasList(List<BancoIdeas> bancoIdeasList) {
        this.bancoIdeasList = bancoIdeasList;
    }

    @XmlTransient
    public List<Propuesta> getPropuestaList() {
        return propuestaList;
    }

    public void setPropuestaList(List<Propuesta> propuestaList) {
        this.propuestaList = propuestaList;
    }

    @XmlTransient
    public List<Propuesta> getPropuestaList1() {
        return propuestaList1;
    }

    public void setPropuestaList1(List<Propuesta> propuestaList1) {
        this.propuestaList1 = propuestaList1;
    }

    @XmlTransient
    public List<TrabajoFinal> getTrabajoFinalList() {
        return trabajoFinalList;
    }

    public void setTrabajoFinalList(List<TrabajoFinal> trabajoFinalList) {
        this.trabajoFinalList = trabajoFinalList;
    }

    @XmlTransient
    public List<TrabajoFinal> getTrabajoFinalList1() {
        return trabajoFinalList1;
    }

    public void setTrabajoFinalList1(List<TrabajoFinal> trabajoFinalList1) {
        this.trabajoFinalList1 = trabajoFinalList1;
    }

    @XmlTransient
    public List<PropuestaPractica> getPropuestaPracticaList() {
        return propuestaPracticaList;
    }

    public void setPropuestaPracticaList(List<PropuestaPractica> propuestaPracticaList) {
        this.propuestaPracticaList = propuestaPracticaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documento != null ? documento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.documento == null && other.documento != null) || (this.documento != null && !this.documento.equals(other.documento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Docente[ documento=" + documento + " ]";
    }
    
}
