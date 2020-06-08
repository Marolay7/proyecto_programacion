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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PROGRAMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programa.findAll", query = "SELECT p FROM Programa p")
    , @NamedQuery(name = "Programa.findByCodigo", query = "SELECT p FROM Programa p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Programa.findByNombre", query = "SELECT p FROM Programa p WHERE p.nombre = :nombre")})
public class Programa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private Integer codigo;
    @Size(max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @JoinColumn(name = "COORDINACION_ID", referencedColumnName = "ID")
    @ManyToOne
    private Coordinacion coordinacionId;
    @JoinColumn(name = "FACULTAD_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne
    private Facultad facultadCodigo;
    @OneToMany(mappedBy = "programaCodigo")
    private List<BancoIdeas> bancoIdeasList;
    @OneToMany(mappedBy = "programaId")
    private List<Estudiante> estudianteList;
    @OneToMany(mappedBy = "programaId")
    private List<Users> usersList;

    public Programa() {
    }

    public Programa(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Coordinacion getCoordinacionId() {
        return coordinacionId;
    }

    public void setCoordinacionId(Coordinacion coordinacionId) {
        this.coordinacionId = coordinacionId;
    }

    public Facultad getFacultadCodigo() {
        return facultadCodigo;
    }

    public void setFacultadCodigo(Facultad facultadCodigo) {
        this.facultadCodigo = facultadCodigo;
    }

    @XmlTransient
    public List<BancoIdeas> getBancoIdeasList() {
        return bancoIdeasList;
    }

    public void setBancoIdeasList(List<BancoIdeas> bancoIdeasList) {
        this.bancoIdeasList = bancoIdeasList;
    }

    @XmlTransient
    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }

    @XmlTransient
    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Programa[ codigo=" + codigo + " ]";
    }
    
}
