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

/**
 *
 * @author Marolay Duque
 */
@Named(value = "solicitudManagedBean")
@SessionScoped
public class solicitudManagedBean implements Serializable {

    @EJB
    private SolicitudPracticantesFacadeLocal solicitudPracticantesFacade;

    private SolicitudPracticantes solicitud;
    private Integer id;
    private Empresa empresa;
    private List<SolicitudPracticantes> solicitudPracticantesList;

    public SolicitudPracticantes getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudPracticantes solicitud) {
        this.solicitud = solicitud;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Empresa getEmpresaId() {
        return empresa;
    }

    public void setEmpresaId(Empresa empresaId) {
        this.empresa = empresaId;
    }

    public List<SolicitudPracticantes> getListaSolicitud() {
        this.solicitudPracticantesList = this.solicitudPracticantesFacade.findAll();
        return solicitudPracticantesList;
    }

    public void setListaSolicitud(List<SolicitudPracticantes> solicitudPracticantesList) {
        this.solicitudPracticantesList = solicitudPracticantesList;
    }
    
      @PostConstruct
    public void init() {
        this.solicitud = new SolicitudPracticantes();
        this.empresa = new Empresa();
    }
    public List<SolicitudPracticantes> findAll() {
        return solicitudPracticantesFacade.findAll();
    }
    
    
    
    public solicitudManagedBean() {
    }
    
}
