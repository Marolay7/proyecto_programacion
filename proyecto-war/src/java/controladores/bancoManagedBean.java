/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import ejb.BancoIdeasFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Marolay Duque
 */
@Named(value = "bancoManagedBean")
@SessionScoped
public class bancoManagedBean implements Serializable {

    @EJB
    private BancoIdeasFacadeLocal bancoIdeasFacade;


    public bancoManagedBean() {
    }
    
}
