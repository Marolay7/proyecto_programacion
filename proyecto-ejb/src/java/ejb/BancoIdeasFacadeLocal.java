/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.BancoIdeas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marolay Duque
 */
@Local
public interface BancoIdeasFacadeLocal {

    void create(BancoIdeas bancoIdeas);

    void edit(BancoIdeas bancoIdeas);

    void remove(BancoIdeas bancoIdeas);

    BancoIdeas find(Object id);

    List<BancoIdeas> findAll();

    List<BancoIdeas> findRange(int[] range);

    int count();
    
}
