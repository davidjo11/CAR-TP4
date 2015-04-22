/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.command;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import java.util.List;
import javax.ejb.Remote;

/**
 * Implémentation du manager de commandes.
 * @author Thibaud VERBAERE & David JOSIAS
 */
@Stateless(mappedName="CommandService")
@Remote(ICommandManager.class)
public class CommandManager implements ICommandManager {
    
    // La BDD :
    @PersistenceContext(unitName = "command-unit")
    EntityManager em;
    
    /**
     * Permet l'ajout d'une commande.
     * @param command la commande a ajouter
     */
    public void add(Command command) {
        em.persist(command);
    }
    
   
    /**
     * Permet de lister l'ensemble des commandes du manager.
     * @return toutes les commandes
     */
    public List<Command> listCommands() {
        return em.createQuery("SELECT c FROM Command c ORDER BY c.c_user").getResultList();
    }
    
}
