/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import ejb.ModalidadFacadeLocal;
import entidades.Modalidad;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Marolay Duque
 */
@Named(value = "modalidadManagedBean")
@SessionScoped
public class ModalidadManagedBean implements Serializable {

    @EJB
    private ModalidadFacadeLocal modalidadFacade;
     
    Modalidad modalidad = new Modalidad();
    private Integer id;
    private String nombre;

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
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

    public List<Modalidad> findAll() {
        return modalidadFacade.findAll();
    }

    
    
    public ModalidadManagedBean() {
    }
    
}
