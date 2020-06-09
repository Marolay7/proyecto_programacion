/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import ejb.ConceptoFacadeLocal;
import entidades.Concepto;
import entidades.Docente;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Marolay Duque
 */
@Named(value = "conceptoManagedBean")
@SessionScoped
public class conceptoManagedBean implements Serializable {

    @EJB
    private ConceptoFacadeLocal conceptoFacade;

    private Concepto concepto;
    
    private Integer id;
    private String nombre;
    private Docente calificadorDocumento;

    public Concepto getConcepto() {
        return concepto;
    }

    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
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

    public Docente getCalificadorDocumento() {
        return calificadorDocumento;
    }

    public void setCalificadorDocumento(Docente calificadorDocumento) {
        this.calificadorDocumento = calificadorDocumento;
    }

    public List<Concepto> findAll() {
        return conceptoFacade.findAll();
    }
    
    
    public conceptoManagedBean() {
    }
    
}
