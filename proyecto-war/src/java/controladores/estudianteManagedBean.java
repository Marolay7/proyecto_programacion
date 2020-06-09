/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import ejb.EstudianteFacadeLocal;
import entidades.Estudiante;
import entidades.Programa;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Marolay Duque
 */
@Named(value = "estudianteManagedBean")
@SessionScoped
public class estudianteManagedBean implements Serializable {

    @EJB
    private EstudianteFacadeLocal estudianteFacade;
    private Estudiante estudiante;
    
     private Integer documento;

    private String nombre;

    private String correo;

    private String telefono;

    private Programa programa;

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
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

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public List<Estudiante> findAll() {
        return estudianteFacade.findAll();
    }

    
    

    public estudianteManagedBean() {
    }
    
}
