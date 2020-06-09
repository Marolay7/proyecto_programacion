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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marolay Duque
 */
@Named(value = "bancoManagedBean")
@SessionScoped
public class bancoManagedBean implements Serializable {

    @EJB
    private BancoIdeasFacadeLocal bancoIdeasFacade;
    private List<BancoIdeas> listaBanco;
    private BancoIdeas banco;
    private String msj;

    public List<BancoIdeas> getListaBanco() {
        this.listaBanco = this.bancoIdeasFacade.findAll();
        return listaBanco;
    }

    public List<BancoIdeas> findAll() {
        return bancoIdeasFacade.findAll();
    }

    public void setListaBanco(List<BancoIdeas> listaBanco) {
        this.listaBanco = listaBanco;
    }

    public BancoIdeas getBanco() {
        return banco;
    }

    public void setBancoIdeas(BancoIdeas banco) {
        this.banco = banco;
    }

    @PostConstruct
    public void init() {
        this.banco = new BancoIdeas();
        Modalidad mod = new Modalidad();
        Docente doc = new Docente();
        Programa pro = new Programa();
    }

    public void guardar() {
        try {
            this.bancoIdeasFacade.create(banco);
            this.msj = "Registro Creado Correctamente";
            this.banco = new BancoIdeas();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void actualizar() {
        try {
            this.bancoIdeasFacade.edit(banco);
            this.msj = "Registro Actualizado Correctamente";
            this.banco = new BancoIdeas();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(BancoIdeas ban) {
        try {
            this.bancoIdeasFacade.remove(ban);
            this.msj = "Registro Eliminado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(BancoIdeas ba) {
        this.banco = ba;
    }

    public void limpiar() {
        this.banco = new BancoIdeas();
    }

}
