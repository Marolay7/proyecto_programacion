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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marolay Duque
 */
@Entity
@Table(name = "CONCEPTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concepto.findAll", query = "SELECT c FROM Concepto c")
    , @NamedQuery(name = "Concepto.findById", query = "SELECT c FROM Concepto c WHERE c.id = :id")
    , @NamedQuery(name = "Concepto.findByNombre", query = "SELECT c FROM Concepto c WHERE c.nombre = :nombre")})
public class Concepto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @JoinColumn(name = "CALIFICADOR_DOCUMENTO", referencedColumnName = "DOCUMENTO")
    @ManyToOne
    private Users calificadorDocumento;
    @OneToMany(mappedBy = "conceptoId")
    private List<FinalPractica> finalPracticaList;
    @OneToMany(mappedBy = "conceptoId")
    private List<Propuesta> propuestaList;
    @OneToMany(mappedBy = "conceptoId")
    private List<TrabajoFinal> trabajoFinalList;
    @OneToMany(mappedBy = "conceptoId")
    private List<PropuestaPractica> propuestaPracticaList;

    public Concepto() {
    }

    public Concepto(Integer id) {
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

    public Users getCalificadorDocumento() {
        return calificadorDocumento;
    }

    public void setCalificadorDocumento(Users calificadorDocumento) {
        this.calificadorDocumento = calificadorDocumento;
    }

    @XmlTransient
    public List<FinalPractica> getFinalPracticaList() {
        return finalPracticaList;
    }

    public void setFinalPracticaList(List<FinalPractica> finalPracticaList) {
        this.finalPracticaList = finalPracticaList;
    }

    @XmlTransient
    public List<Propuesta> getPropuestaList() {
        return propuestaList;
    }

    public void setPropuestaList(List<Propuesta> propuestaList) {
        this.propuestaList = propuestaList;
    }

    @XmlTransient
    public List<TrabajoFinal> getTrabajoFinalList() {
        return trabajoFinalList;
    }

    public void setTrabajoFinalList(List<TrabajoFinal> trabajoFinalList) {
        this.trabajoFinalList = trabajoFinalList;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concepto)) {
            return false;
        }
        Concepto other = (Concepto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Concepto[ id=" + id + " ]";
    }
    
}
