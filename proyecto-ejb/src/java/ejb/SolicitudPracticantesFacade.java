/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.SolicitudPracticantes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Marolay Duque
 */
@Stateless
public class SolicitudPracticantesFacade extends AbstractFacade<SolicitudPracticantes> implements SolicitudPracticantesFacadeLocal {

    @PersistenceContext(unitName = "proyecto-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudPracticantesFacade() {
        super(SolicitudPracticantes.class);
    }
    
}
