/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import ejb.EmpresaFacadeLocal;
import entidades.Empresa;
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
@Named(value = "empresaManagedBean")
@SessionScoped
public class empresaManagedBean implements Serializable {

    @EJB
    private EmpresaFacadeLocal empresaFacade;
    private List<Empresa> listaEmpresa;
    private Empresa empresa;
    private String msj;

    public List<Empresa> getListaEmpresa() {
        this.listaEmpresa = this.empresaFacade.findAll();
        return listaEmpresa;
    }

    public List<Empresa> findAll() {
        return empresaFacade.findAll();
    }

    public void setListaEmpresa(List<Empresa> listaBanco) {
        this.listaEmpresa = listaBanco;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @PostConstruct
    public void init() {
        this.empresa = new Empresa();
    }

    public void guardar() {
        try {
            this.empresaFacade.create(empresa);
            this.msj = "Registro Creado Correctamente";
            this.empresa = new Empresa();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void actualizar() {
        try {
            this.empresaFacade.edit(empresa);
            this.msj = "Registro Actualizado Correctamente";
            this.empresa = new Empresa();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(Empresa emp) {
        try {
            this.empresaFacade.remove(emp);
            this.msj = "Registro Eliminado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(Empresa emp) {
        this.empresa = emp;
    }

    public void limpiar() {
        this.empresa = new Empresa();
    }

}
