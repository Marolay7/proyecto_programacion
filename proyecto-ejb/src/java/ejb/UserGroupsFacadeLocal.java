/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.UserGroups;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marolay Duque
 */
@Local
public interface UserGroupsFacadeLocal {

    void create(UserGroups userGroups);

    void edit(UserGroups userGroups);

    void remove(UserGroups userGroups);

    UserGroups find(Object id);

    List<UserGroups> findAll();

    List<UserGroups> findRange(int[] range);

    int count();
    
}
