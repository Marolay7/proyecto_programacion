/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Modalidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marolay Duque
 */
@Local
public interface ModalidadFacadeLocal {

    void create(Modalidad modalidad);

    void edit(Modalidad modalidad);

    void remove(Modalidad modalidad);

    Modalidad find(Object id);

    List<Modalidad> findAll();

    List<Modalidad> findRange(int[] range);

    int count();
    
}
