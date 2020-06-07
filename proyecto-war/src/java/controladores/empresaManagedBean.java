/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import ejb.EmpresaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Marolay Duque
 */
@Named(value = "empresaManagedBean")
@SessionScoped
public class empresaManagedBean implements Serializable {

    @EJB
    private EmpresaFacadeLocal empresaFacade;

    
    public empresaManagedBean() {
    }
    
}
