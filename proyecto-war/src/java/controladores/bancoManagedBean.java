
package controladores;

import ejb.BancoIdeasFacadeLocal;
import entidades.BancoIdeas;
import entidades.Modalidad;
import entidades.Programa;
import entidades.Users;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Marolay Duque
 */
@Named(value = "bancoManagedBean")
@SessionScoped
public class bancoManagedBean implements Serializable {

    @EJB
    private BancoIdeasFacadeLocal bancoIdeasFacade;
    
    BancoIdeas banco = new BancoIdeas();
    
    private Integer id;
    private String nombre;
    private Modalidad modalidadId;
    private Programa programaCodigo;
    private Users profDocumento;

    public BancoIdeas getBanco() {
        return banco;
    }

    public void setBanco(BancoIdeas banco) {
        this.banco = banco;
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

    public List<BancoIdeas> findAll() {
        return bancoIdeasFacade.findAll();
    }
    

    public bancoManagedBean() {
    }
    
}
