/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Propuesta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Marolay Duque
 */
@Stateless
public class PropuestaFacade extends AbstractFacade<Propuesta> implements PropuestaFacadeLocal {

    @PersistenceContext(unitName = "proyecto-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PropuestaFacade() {
        super(Propuesta.class);
    }
    
}
