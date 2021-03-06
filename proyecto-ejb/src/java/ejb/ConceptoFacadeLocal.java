/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Concepto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marolay Duque
 */
@Local
public interface ConceptoFacadeLocal {

    void create(Concepto concepto);

    void edit(Concepto concepto);

    void remove(Concepto concepto);

    Concepto find(Object id);

    List<Concepto> findAll();

    List<Concepto> findRange(int[] range);

    int count();
    
}
