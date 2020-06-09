
package controladores;

import ejb.UsersFacadeLocal;
import entidades.Programa;
import entidades.Users;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Marolay Duque
 */
@Named(value = "usuariosManagedBean")
@SessionScoped
public class usuariosManagedBean implements Serializable {
    

    @EJB
    private UsersFacadeLocal usersFacade;
     
    private Users user;
    
    
    private int id;
    private Integer documento;
    private String username;
    private String apellido;
    private String password;
    private String correo;
    private Programa programaId;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Programa getProgramaId() {
        return programaId;
    }

    public void setProgramaId(Programa programaId) {
        this.programaId = programaId;
    }

    public List<Users> findAll() {
        return usersFacade.findAll();
    }
    

    public usuariosManagedBean() {
    }
    
}
