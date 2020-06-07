/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.PropuestaPractica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marolay Duque
 */
@Local
public interface PropuestaPracticaFacadeLocal {

    void create(PropuestaPractica propuestaPractica);

    void edit(PropuestaPractica propuestaPractica);

    void remove(PropuestaPractica propuestaPractica);

    PropuestaPractica find(Object id);

    List<PropuestaPractica> findAll();

    List<PropuestaPractica> findRange(int[] range);

    int count();
    
}
