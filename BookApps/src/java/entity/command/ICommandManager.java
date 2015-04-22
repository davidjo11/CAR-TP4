/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.command;

import javax.ejb.Remote;
import java.util.List;

/**
 * Interface du manager de commandes.
 * @author Thibaud VERBAERE & David JOSIAS
 */
@Remote
public interface ICommandManager {
    
    /**
     * Permet l'ajout d'une commande.
     * @param command la commande a ajouter
     */
    public void add(Command command);
    
    /**
     * Permet de lister l'ensemble des commandes du manager.
     * @return toutes les commandes
     */
    public List<Command> listCommands();
        
}
