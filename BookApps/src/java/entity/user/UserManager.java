/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.user;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author thibaud
 */
@Stateless(mappedName="UserService")
@Remote(IUserManager.class)
public class UserManager implements IUserManager {
    
    @PersistenceContext(unitName = "user-unit")
    EntityManager em;
    
    @Override
    public void add(Client user) {
        em.persist(user);
    }
    
    @Override
    public Client search(String login) {
        return em.find(Client.class, login);
    }
    
    @Override
    public List<Client> listUsers() {
        return em.createQuery("SELECT u FROM Client u ORDER BY u.pseudo").getResultList();
    }
    
    @Override
    public int getStatus(String login) {
        return em.find(Client.class, login).getStatus();
    }
    
}
