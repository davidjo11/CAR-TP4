/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbservices;

import entity.book.Book;
import entity.book.IBookManager;
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
 *
 * @author thibaud
 */
@Stateless
public class BookServices implements SessionBean {
    
    public void add(String title, String author, int annee) throws NamingException {
       Context context = new InitialContext();
       IBookManager stocks = (IBookManager) context.lookup("BookService");
       
       stocks.add(new Book(title,author, annee));
       
    }
    
    public List<String> listAuthors() throws NamingException {
       Context context = new InitialContext();
       IBookManager stocks = (IBookManager) context.lookup("BookService");
       
       return stocks.listAuthors();
    }
    
    public List<Book> listBooks() throws NamingException {
       Context context = new InitialContext();
       IBookManager stocks = (IBookManager) context.lookup("BookService");
       
       return stocks.listBooks();
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
