/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import ejb.PropuestaFacadeLocal;
import entidades.Concepto;
import entidades.Docente;
import entidades.Estudiante;
import entidades.Modalidad;
import entidades.Propuesta;
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
@Named(value = "propuestaManagedBean")
@SessionScoped
public class propuestaManagedBean implements Serializable {

    @EJB
    private PropuestaFacadeLocal propuestaFacade;
    private List<Propuesta> listaPropuesta;
    private Propuesta propuesta;
    private String msj;

    public List<Propuesta> getListaPropuesta() {
        this.listaPropuesta = this.propuestaFacade.findAll();
        return listaPropuesta;
    }

    public List<Propuesta> findAll() {
        return propuestaFacade.findAll();
    }

    public void setListaPropuesta(List<Propuesta> listaPropuesta) {
        this.listaPropuesta = listaPropuesta;
    }

    public Propuesta getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(Propuesta propuesta) {
        this.propuesta = propuesta;
    }

    @PostConstruct
    public void init() {
        this.propuesta = new Propuesta();
        Concepto concepto = new Concepto();
        Docente dir = new Docente();
        Docente codir = new Docente();
        Estudiante est = new Estudiante();
        Modalidad modalidad = new Modalidad();
    }

    public void guardar() {
        try {
            this.propuestaFacade.create(propuesta);
            this.msj = "Registro Creado Correctamente";
            this.propuesta = new Propuesta();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void actualizar() {
        try {
            this.propuestaFacade.edit(propuesta);
            this.msj = "Registro Actualizado Correctamente";
            this.propuesta = new Propuesta();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(Propuesta ban) {
        try {
            this.propuestaFacade.remove(ban);
            this.msj = "Registro Eliminado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(Propuesta ba) {
        this.propuesta = ba;
    }

    public void limpiar() {
        this.propuesta = new Propuesta();
    }


}
