/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.TrabajoFinal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marolay Duque
 */
@Local
public interface TrabajoFinalFacadeLocal {

    void create(TrabajoFinal trabajoFinal);

    void edit(TrabajoFinal trabajoFinal);

    void remove(TrabajoFinal trabajoFinal);

    TrabajoFinal find(Object id);

    List<TrabajoFinal> findAll();

    List<TrabajoFinal> findRange(int[] range);

    int count();
    
}
