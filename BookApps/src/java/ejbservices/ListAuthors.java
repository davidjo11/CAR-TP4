/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbservices;

import entity.IBookManager;
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
public class ListAuthors implements SessionBean {
    
    public List<String> list() throws NamingException {
       Context context = new InitialContext();
       IBookManager stocks = (IBookManager) context.lookup("BookService");
       
       return stocks.listAuthors();
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
