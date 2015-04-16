/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbservices;

import entity.user.IUserManager;
import entity.user.Client;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.EJBException;
import java.rmi.RemoteException;

/**
 *
 * @author thibaud
 */
@Stateless
public class UserServices implements SessionBean {
    
    public void add(String pseudo, String password, int status) throws NamingException {
       Context context = new InitialContext();
       IUserManager stocks = (IUserManager) context.lookup("UserService");
       
       stocks.add(new Client(pseudo,password,status));
       
    }
    
    public boolean isGoodLogin(String login, String password) throws NamingException {
       Context context = new InitialContext();
       IUserManager stocks = (IUserManager) context.lookup("UserService");
       
       Client c = stocks.search(login);
       
       return c != null && c.getPassword().equals(password);
    }
    
    public int getStatus(String login) throws NamingException {
       Context context = new InitialContext();
       IUserManager stocks = (IUserManager) context.lookup("UserService");
       
       Client c = stocks.search(login);
       
       if (c != null)
           return c.getStatus();
       else
           return -1;
    }

    @Override
    public void ejbActivate() {
    } 

    @Override
    public void ejbPassivate() {
    }

    @Override
     public void ejbRemove() {
    }

    @Override
    public void setSessionContext(SessionContext arg0) throws EJBException, RemoteException {
    }
   
    public void ejbCreate() {
    }
}
