/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Propuesta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marolay Duque
 */
@Local
public interface PropuestaFacadeLocal {

    void create(Propuesta propuesta);

    void edit(Propuesta propuesta);

    void remove(Propuesta propuesta);

    Propuesta find(Object id);

    List<Propuesta> findAll();

    List<Propuesta> findRange(int[] range);

    int count();
    
}
