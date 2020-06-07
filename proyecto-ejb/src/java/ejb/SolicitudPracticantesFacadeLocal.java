/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.SolicitudPracticantes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marolay Duque
 */
@Local
public interface SolicitudPracticantesFacadeLocal {

    void create(SolicitudPracticantes solicitudPracticantes);

    void edit(SolicitudPracticantes solicitudPracticantes);

    void remove(SolicitudPracticantes solicitudPracticantes);

    SolicitudPracticantes find(Object id);

    List<SolicitudPracticantes> findAll();

    List<SolicitudPracticantes> findRange(int[] range);

    int count();
    
}
