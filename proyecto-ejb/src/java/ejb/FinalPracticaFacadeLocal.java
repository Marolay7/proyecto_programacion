/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.FinalPractica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marolay Duque
 */
@Local
public interface FinalPracticaFacadeLocal {

    void create(FinalPractica finalPractica);

    void edit(FinalPractica finalPractica);

    void remove(FinalPractica finalPractica);

    FinalPractica find(Object id);

    List<FinalPractica> findAll();

    List<FinalPractica> findRange(int[] range);

    int count();
    
}
