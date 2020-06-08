
package controladores;

import ejb.ProgramaFacadeLocal;
import entidades.Coordinacion;
import entidades.Facultad;
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
@Named(value = "programaManagedBean")
@SessionScoped
public class programaManagedBean implements Serializable {

    @EJB
    private ProgramaFacadeLocal programaFacade;
     
    Programa programa = new Programa();
        private Integer codigo;
    private String nombre;
    private Coordinacion coordinacionId;
    private Facultad facultadCodigo;

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Coordinacion getCoordinacionId() {
        return coordinacionId;
    }

    public void setCoordinacionId(Coordinacion coordinacionId) {
        this.coordinacionId = coordinacionId;
    }

    public Facultad getFacultadCodigo() {
        return facultadCodigo;
    }

    public void setFacultadCodigo(Facultad facultadCodigo) {
        this.facultadCodigo = facultadCodigo;
    }

    public List<Programa> findAll() {
        return programaFacade.findAll();
    }

    
    public programaManagedBean() {
    }
    
}
