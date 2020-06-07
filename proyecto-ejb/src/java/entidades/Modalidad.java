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
@Table(name = "MODALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modalidad.findAll", query = "SELECT m FROM Modalidad m")
    , @NamedQuery(name = "Modalidad.findById", query = "SELECT m FROM Modalidad m WHERE m.id = :id")
    , @NamedQuery(name = "Modalidad.findByNombre", query = "SELECT m FROM Modalidad m WHERE m.nombre = :nombre")})
public class Modalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(mappedBy = "modalidadId")
    private List<FinalPractica> finalPracticaList;
    @OneToMany(mappedBy = "modalidadId")
    private List<BancoIdeas> bancoIdeasList;
    @OneToMany(mappedBy = "modalidadId")
    private List<Propuesta> propuestaList;
    @OneToMany(mappedBy = "modalidadId")
    private List<TrabajoFinal> trabajoFinalList;
    @OneToMany(mappedBy = "modalidadId")
    private List<PropuestaPractica> propuestaPracticaList;

    public Modalidad() {
    }

    public Modalidad(Integer id) {
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
        if (!(object instanceof Modalidad)) {
            return false;
        }
        Modalidad other = (Modalidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Modalidad[ id=" + id + " ]";
    }
    
}
