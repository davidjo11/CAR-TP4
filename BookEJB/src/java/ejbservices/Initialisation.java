/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbservices;

import entity.Book;
import entity.IBookManager;
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
public class Initialisation implements SessionBean {
    
    public void initialisation() throws NamingException {
       Context context = new InitialContext();
       IBookManager stocks = (IBookManager) context.lookup("BookManager/remote");
       
       stocks.add(new Book("Babar a la plage","Dora l'exploratrice", 2001));
       stocks.add(new Book("Meurtre a Lille1","Agatha Christie", 1987));
       stocks.add(new Book("Ma vie","David Josias", 2014));
       stocks.add(new Book("Il etait une fois dans le nord","Sergio Leone", 1976));
       stocks.add(new Book("Le bon, la brute et l'alcoolique","Sergio Leone", 1975));
       stocks.add(new Book("Comment avoir son master informatique","Johnny Jackson", 1999));
       
    }

    public void ejbActivate() {
    } 

    public void ejbPassivate() {
    }

     public void ejbRemove() {
    }

    public void setSessionContext(SessionContext arg0) throws EJBException, RemoteException {
    }
   
    public void ejbCreate() {
    }
}
