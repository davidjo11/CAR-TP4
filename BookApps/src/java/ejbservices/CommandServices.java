/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbservices;

import entity.command.Command;
import entity.command.ICommandManager;
import exception.ManagerNotFoundException;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.EJBException;
import java.rmi.RemoteException;
import java.util.List;

/**
 *  Classe répertoriant les services disponibles sur les commandes.
 * @author Thibaud VERBAERE & David JOSIAS
 */
@Stateless
public class CommandServices implements SessionBean {
    
    /**
     * Cherche le manager de commandes.
     * @return le manager de commandes
     * @throws ManagerNotFoundException si celui-ci est introuvable
     */
    private ICommandManager lookUp() throws ManagerNotFoundException {
        try {
            Context context = new InitialContext();
            ICommandManager stocks = (ICommandManager) context.lookup("CommandService");
            return stocks;
        } catch (NamingException ex) {
            throw new ManagerNotFoundException();
        }
    }
    
    /**
     * Permet de lister les commandes de livres.
     * @return la liste de toutes les commandes
     * @throws ManagerNotFoundException si le manager de commande est introuvable
     */
    public List<Command> listCommands() throws ManagerNotFoundException {      
       return this.lookUp().listCommands();
    }
    
    /**
     * Permet de créer une nouvelle commande.
     * @param user l'utilisateur envoyant la commande
     * @param title le titre du livre a commander
     * @throws ManagerNotFoundException si le manager de commande est introuvable
     */
    public void addCommand(String user, String title) throws ManagerNotFoundException {       
       this.lookUp().add(new Command(user,title));
    }
    

    @Override
    public void setSessionContext(SessionContext ctx) throws EJBException, RemoteException {
      
    }

    @Override
    public void ejbRemove() throws EJBException, RemoteException {
        
    }

    @Override
    public void ejbActivate() throws EJBException, RemoteException {
    
    }

    @Override
    public void ejbPassivate() throws EJBException, RemoteException {
        
    }
}
