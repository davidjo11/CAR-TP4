/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbservices;

import entity.user.IUserManager;
import entity.user.Client;
import exception.ManagerNotFoundException;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.EJBException;
import java.rmi.RemoteException;

/**
 *  Classe répertoriant les services disponibles sur les utilisateurs
 * @author Thibaud VERBAERE & David JOSIAS
 */
@Stateless
public class UserServices implements SessionBean {
    
    /**
     * Cherche le manager d'utilisateurs.
     * @return le manager d'utilisateurs
     * @throws ManagerNotFoundException si celui-ci est introuvable
     */
    private IUserManager lookUp() throws ManagerNotFoundException {
        try {
            Context context = new InitialContext();
            IUserManager stocks = (IUserManager) context.lookup("UserService");
            return stocks;
        } catch (NamingException ex) {
            throw new ManagerNotFoundException();
        }
    }
    
    /**
     * Permet d'ajouter un utilisateur dans le manager d'utilisateurs.
     * @param pseudo le pseudo de l'utilisateur a ajouter
     * @param password le mot de passe de l'utilisateur a ajouter
     * @param status le status de l'utilisateur a ajouter (0 : admin et 1 : client)
     * @throws ManagerNotFoundException  si le manager d'utilisateurs est introuvable
     */
    public void add(String pseudo, String password, int status) throws ManagerNotFoundException {
       this.lookUp().add(new Client(pseudo,password,status));
       
    }
    
    /**
     * Teste s'il existe un utilisateur 'login' pour un mot de passe 'password'.
     * @param login le login a tester
     * @param password le mot de passe a tester
     * @return True ou False selon le cas
     * @throws ManagerNotFoundException si le manager d'utilisateur st introuvable
     */
    public boolean isGoodLogin(String login, String password) throws ManagerNotFoundException {       
       Client c = this.lookUp().search(login);
       
       return c != null && c.getPassword().equals(password);
    }
    
    /**
     * Retourne le status de l'utilisateur passé en paramètre.
     * -1 est retourné si l'utilisateur n'apparait pas en base.
     * @param login l'utilisateur 
     * @return le status de l'utilisateur
     * @throws ManagerNotFoundException si le manager d'utilisateur st introuvable
     */
    public int getStatus(String login) throws ManagerNotFoundException {       
       Client c = this.lookUp().search(login);
       
       if (c != null)
           return c.getStatus();
       else
           return -1;
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
