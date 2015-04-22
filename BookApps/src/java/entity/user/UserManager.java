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
 * Implémentation du manager d'utilisateurs.
 * @author Thibaud VERBAERE & David JOSIAS
 */
@Stateless(mappedName="UserService")
@Remote(IUserManager.class)
public class UserManager implements IUserManager {
    
    // La BDD :
    @PersistenceContext(unitName = "user-unit")
    EntityManager em;
    
    /**
     * Ajoute un client au manager.
     * @param user l'utilisateur a ajouter
     */
    public void add(Client user) {
        em.persist(user);
    }
    
    /**
     * Recherche un utilisateur par son login.
     * @param login le login de l'utilisateur a trouver
     * @return l'utilisateur
     */
    public Client search(String login) {
        return em.find(Client.class, login);
    }
    
    /**
     * Liste l'ensemble des utilisateurs du manager.
     * @return la liste des utilisateurs
     */
    public List<Client> listUsers() {
        return em.createQuery("SELECT u FROM Client u ORDER BY u.pseudo").getResultList();
    }
    
    /**
     * Retourne le status d'un utilisateur dont on connait le pseudo.
     * @param login le pseudo de l'utilisateur.
     * @return le status de l'utilisateur ou -1 si on ne trouve pas
     */
    public int getStatus(String login) {
        return em.find(Client.class, login).getStatus();
    }
    
}
