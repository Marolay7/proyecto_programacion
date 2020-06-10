/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import ejb.UserGroupsFacadeLocal;
import entidades.UserGroups;
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
@Named(value = "userGroupsManagedBean")
@SessionScoped
public class userGroupsManagedBean implements Serializable {

    @EJB
    private UserGroupsFacadeLocal userGroupsFacade;
    private UserGroups grupo;
    private Integer id;
    private String groupname;
    private String username;
    private String msj;

    public UserGroups getGrupo() {
        return grupo;
    }

    public void setGrupo(UserGroups grupo) {
        this.grupo = grupo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserGroups> findAll() {
        return userGroupsFacade.findAll();
    }
@PostConstruct
    public void init() {
        this.grupo = new UserGroups();
        
    }

    public void guardar() {
        try {
            this.userGroupsFacade.create(grupo);
            this.msj = "Registro Creado Correctamente";
            this.grupo = new UserGroups();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void actualizar() {
        try {
            this.userGroupsFacade.edit(grupo);
            this.msj = "Registro Actualizado Correctamente";
            this.grupo = new UserGroups();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(UserGroups groups) {
        try {
            this.userGroupsFacade.remove(groups);
            this.msj = "Registro Eliminado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error " + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
      public void cargarDatos(UserGroups groups) {
        this.grupo = groups;
      }

    public void limpiar() {
        this.grupo = new UserGroups();
    }

    public userGroupsManagedBean() {
    }
    
}
