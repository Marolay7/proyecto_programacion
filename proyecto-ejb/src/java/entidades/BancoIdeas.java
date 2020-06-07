/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marolay Duque
 */
@Entity
@Table(name = "BANCO_IDEAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BancoIdeas.findAll", query = "SELECT b FROM BancoIdeas b")
    , @NamedQuery(name = "BancoIdeas.findById", query = "SELECT b FROM BancoIdeas b WHERE b.id = :id")
    , @NamedQuery(name = "BancoIdeas.findByNombre", query = "SELECT b FROM BancoIdeas b WHERE b.nombre = :nombre")})
public class BancoIdeas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @JoinColumn(name = "MODALIDAD_ID", referencedColumnName = "ID")
    @ManyToOne
    private Modalidad modalidadId;
    @JoinColumn(name = "PROGRAMA_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne
    private Programa programaCodigo;
    @JoinColumn(name = "PROF_DOCUMENTO", referencedColumnName = "DOCUMENTO")
    @ManyToOne
    private Users profDocumento;

    public BancoIdeas() {
    }

    public BancoIdeas(Integer id) {
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

    public Modalidad getModalidadId() {
        return modalidadId;
    }

    public void setModalidadId(Modalidad modalidadId) {
        this.modalidadId = modalidadId;
    }

    public Programa getProgramaCodigo() {
        return programaCodigo;
    }

    public void setProgramaCodigo(Programa programaCodigo) {
        this.programaCodigo = programaCodigo;
    }

    public Users getProfDocumento() {
        return profDocumento;
    }

    public void setProfDocumento(Users profDocumento) {
        this.profDocumento = profDocumento;
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
        if (!(object instanceof BancoIdeas)) {
            return false;
        }
        BancoIdeas other = (BancoIdeas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.BancoIdeas[ id=" + id + " ]";
    }
    
}
