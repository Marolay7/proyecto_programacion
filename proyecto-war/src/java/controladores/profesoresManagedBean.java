/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import ejb.DocenteFacadeLocal;
import entidades.Docente;
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
@Named(value = "profesoresManagedBean")
@SessionScoped
public class profesoresManagedBean implements Serializable {

    @EJB
    private DocenteFacadeLocal docenteFacade;
    
    private Docente docente;
    private Integer documento;
    private String nombre;
    private String correo;
    private String telefono;

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Docente> findAll() {
        return docenteFacade.findAll();
    }
    
          @PostConstruct
    public void init() {
        this.docente = new Docente();
    }

    public profesoresManagedBean() {
    }
    
}
