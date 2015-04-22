/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.user;

import javax.ejb.Remote;
import java.util.List;

/**
 * Interface du manager d'utilisateurs.
 * @author Thibaud VERBAERE & David JOSIAS
 */
@Remote
public interface IUserManager {
    
    /**
     * Ajoute un client au manager.
     * @param user l'utilisateur a ajouter
     */
    public void add(Client user);
    
    /**
     * Recherche un utilisateur par son login.
     * @param login le login de l'utilisateur a trouver
     * @return l'utilisateur
     */
    public Client search(String login);
    
    /**
     * Liste l'ensemble des utilisateurs du manager.
     * @return la liste des utilisateurs
     */
    public List<Client> listUsers();
    
    /**
     * Retourne le status d'un utilisateur dont on connait le pseudo.
     * @param login le pseudo de l'utilisateur.
     * @return le status de l'utilisateur ou -1 si on ne trouve pas
     */
    public int getStatus(String login);
}
