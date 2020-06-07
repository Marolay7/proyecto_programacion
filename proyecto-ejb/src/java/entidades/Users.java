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
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id")
    , @NamedQuery(name = "Users.findByDocumento", query = "SELECT u FROM Users u WHERE u.documento = :documento")
    , @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")
    , @NamedQuery(name = "Users.findByApellido", query = "SELECT u FROM Users u WHERE u.apellido = :apellido")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "Users.findByCorreo", query = "SELECT u FROM Users u WHERE u.correo = :correo")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOCUMENTO")
    private Integer documento;
    @Size(max = 255)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 255)
    @Column(name = "APELLIDO")
    private String apellido;
    @Size(max = 255)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 255)
    @Column(name = "CORREO")
    private String correo;
    @OneToMany(mappedBy = "calificadorDocumento")
    private List<Concepto> conceptoList;
    @OneToMany(mappedBy = "dirId")
    private List<FinalPractica> finalPracticaList;
    @OneToMany(mappedBy = "estId")
    private List<FinalPractica> finalPracticaList1;
    @OneToMany(mappedBy = "profDocumento")
    private List<BancoIdeas> bancoIdeasList;
    @OneToMany(mappedBy = "codirId")
    private List<Propuesta> propuestaList;
    @OneToMany(mappedBy = "dirId")
    private List<Propuesta> propuestaList1;
    @OneToMany(mappedBy = "estId")
    private List<Propuesta> propuestaList2;
    @OneToMany(mappedBy = "codirId")
    private List<TrabajoFinal> trabajoFinalList;
    @OneToMany(mappedBy = "dirId")
    private List<TrabajoFinal> trabajoFinalList1;
    @OneToMany(mappedBy = "estId")
    private List<TrabajoFinal> trabajoFinalList2;
    @JoinColumn(name = "PROGRAMA_ID", referencedColumnName = "CODIGO")
    @ManyToOne
    private Programa programaId;
    @OneToMany(mappedBy = "dirId")
    private List<PropuestaPractica> propuestaPracticaList;
    @OneToMany(mappedBy = "estId")
    private List<PropuestaPractica> propuestaPracticaList1;

    public Users() {
    }

    public Users(Integer documento) {
        this.documento = documento;
    }

    public Users(Integer documento, int id) {
        this.documento = documento;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
    public List<FinalPractica> getFinalPracticaList1() {
        return finalPracticaList1;
    }

    public void setFinalPracticaList1(List<FinalPractica> finalPracticaList1) {
        this.finalPracticaList1 = finalPracticaList1;
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
    public List<Propuesta> getPropuestaList2() {
        return propuestaList2;
    }

    public void setPropuestaList2(List<Propuesta> propuestaList2) {
        this.propuestaList2 = propuestaList2;
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
    public List<TrabajoFinal> getTrabajoFinalList2() {
        return trabajoFinalList2;
    }

    public void setTrabajoFinalList2(List<TrabajoFinal> trabajoFinalList2) {
        this.trabajoFinalList2 = trabajoFinalList2;
    }

    public Programa getProgramaId() {
        return programaId;
    }

    public void setProgramaId(Programa programaId) {
        this.programaId = programaId;
    }

    @XmlTransient
    public List<PropuestaPractica> getPropuestaPracticaList() {
        return propuestaPracticaList;
    }

    public void setPropuestaPracticaList(List<PropuestaPractica> propuestaPracticaList) {
        this.propuestaPracticaList = propuestaPracticaList;
    }

    @XmlTransient
    public List<PropuestaPractica> getPropuestaPracticaList1() {
        return propuestaPracticaList1;
    }

    public void setPropuestaPracticaList1(List<PropuestaPractica> propuestaPracticaList1) {
        this.propuestaPracticaList1 = propuestaPracticaList1;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.documento == null && other.documento != null) || (this.documento != null && !this.documento.equals(other.documento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Users[ documento=" + documento + " ]";
    }
    
}
