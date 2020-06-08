
package controladores;

import ejb.BancoIdeasFacadeLocal;
import entidades.BancoIdeas;
import entidades.Docente;
import entidades.Modalidad;
import entidades.Programa;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
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
    
    private BancoIdeas banco;
    private Integer id;
    private String nombre;
    private Modalidad modalidad;
    private Programa programa;
    private Docente profesor;
    
    private List<BancoIdeas> bancoIdeasList;
    
     public List<BancoIdeas> getListaRegistro() {
        this.bancoIdeasList = this.bancoIdeasFacade.findAll();
        return bancoIdeasList;
    }

    public void setListaRegistro(List<BancoIdeas> bancoIdeasList) {
        this.bancoIdeasList = bancoIdeasList;
    }



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

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Docente getProfesor() {
        return profesor;
    }

    public void setProfesor(Docente profesor) {
        this.profesor = profesor;
    }
    
     @PostConstruct
    public void init() {
        this.banco = new BancoIdeas();
        this.modalidad = new Modalidad();
        this.programa = new Programa();
        this.profesor = new Docente();
    }

    public List<BancoIdeas> findAll() {
        return bancoIdeasFacade.findAll();
    }



    public bancoManagedBean() {
    }
    
}
