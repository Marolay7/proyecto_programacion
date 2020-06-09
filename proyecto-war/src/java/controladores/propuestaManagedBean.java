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

/**
 *
 * @author Marolay Duque
 */
@Named(value = "propuestaManagedBean")
@SessionScoped
public class propuestaManagedBean implements Serializable {

    @EJB
    private PropuestaFacadeLocal propuestaFacade;
    
    private Propuesta propuesta;
    
    private Integer id;
    private String titulo;
    private String formato;
    private String fechaEntrega;
    private Concepto concepto;
    private Docente codir;
    private Docente dir;
    private Estudiante est;
    private Modalidad modalidad;

    public Propuesta getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(Propuesta propuesta) {
        this.propuesta = propuesta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Concepto getConceptoId() {
        return concepto;
    }

    public void setConceptoId(Concepto conceptoId) {
        this.concepto = conceptoId;
    }

    public Docente getCodirId() {
        return codir;
    }

    public void setCodirId(Docente codirId) {
        this.codir = codirId;
    }

    public Docente getDirId() {
        return dir;
    }

    public void setDirId(Docente dirId) {
        this.dir = dirId;
    }

    public Estudiante getEstId() {
        return est;
    }

    public void setEstId(Estudiante estId) {
        this.est = estId;
    }

    public Modalidad getModalidadId() {
        return modalidad;
    }

    public void setModalidadId(Modalidad modalidadId) {
        this.modalidad = modalidadId;
    }

    public List<Propuesta> findAll() {
        return propuestaFacade.findAll();
    }

     @PostConstruct
    public void init() {
        this.propuesta = new Propuesta();
        this.concepto = new Concepto();
        this.dir = new Docente();
        this.codir = new Docente();
        this.est = new Estudiante();
        this.modalidad = new Modalidad();
    }

    
    public propuestaManagedBean() {
    }
    
}
