/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import ejb.SolicitudPracticantesFacadeLocal;
import entidades.Empresa;
import entidades.SolicitudPracticantes;
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
@Named(value = "solicitudManagedBean")
@SessionScoped
public class solicitudManagedBean implements Serializable {

    @EJB
    private SolicitudPracticantesFacadeLocal solicitudPracticantesFacade;
    private List<SolicitudPracticantes> listaSolicitud;
    private SolicitudPracticantes solicitud;
    private String msj;

    public List<SolicitudPracticantes> getListaSolicitudPracticantes() {
        this.listaSolicitud = this.solicitudPracticantesFacade.findAll();
        return listaSolicitud;
    }

    public List<SolicitudPracticantes> findAll() {
        return solicitudPracticantesFacade.findAll();
    }

    public void setListaSolicitudPracticantes(List<SolicitudPracticantes> listaSolicitud) {
        this.listaSolicitud = listaSolicitud;
    }

    public SolicitudPracticantes getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudPracticantes solicitud) {
        this.solicitud = solicitud;
    }

    @PostConstruct
    public void init() {
        this.solicitud = new SolicitudPracticantes();
        Empresa emp=new Empresa();
    }

    public void guardar() {
        try {
            this.solicitudPracticantesFacade.create(solicitud);
            this.msj = "Registro Creado Correctamente";
            this.solicitud = new SolicitudPracticantes();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void actualizar() {
        try {
            this.solicitudPracticantesFacade.edit(solicitud);
            this.msj = "Registro Actualizado Correctamente";
            this.solicitud = new SolicitudPracticantes();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(SolicitudPracticantes ban) {
        try {
            this.solicitudPracticantesFacade.remove(ban);
            this.msj = "Registro Eliminado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(SolicitudPracticantes ba) {
        this.solicitud = ba;
    }

    public void limpiar() {
        this.solicitud = new SolicitudPracticantes();
    }

}
