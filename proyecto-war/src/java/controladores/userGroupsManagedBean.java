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
import javax.ejb.EJB;

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


    

    public userGroupsManagedBean() {
    }
    
}
