/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbservices;

import entity.book.Book;
import exception.ManagerNotFoundException;
import javax.ejb.Stateless;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.EJBException;
import java.rmi.RemoteException;
import javax.ejb.EJB;

/**
 * Initialise une session pour l'utilisateur.
 * @author Thibaud VERBAERE & David JOSIAS
 */
@Stateless
public class InitialisationService implements SessionBean {
    
    @EJB
    BookServices bookServ;
    @EJB
    CartServices cart;
    @EJB
    CommandServices commandServ;
    @EJB
    UserServices userServ;
    
    /**
     * Initialise une session pour l'utilisateur.
     * @throws exception.ManagerNotFoundException s'il existe un probleme avec l'un des managers
     */
    public void initialisation() throws ManagerNotFoundException {
        
        // Ajout de l'admin.
        if ( userServ.getStatus("admin") == -1 )
            userServ.add("admin","admin",0);
           
        if (bookServ.searchBook("Babar a la plage").isEmpty())
            bookServ.add("Babar a la plage","Dora l'exploratrice", 2001);
        if (bookServ.searchBook("Meurtre a Lille1").isEmpty())
            bookServ.add("Meurtre a Lille1","Agatha Christie", 1987);
        if (bookServ.searchBook("Ma vie").isEmpty())
            bookServ.add("Ma vie","David Josias", 2014);
        if (bookServ.searchBook("Il etait une fois dans le nord").isEmpty())
            bookServ.add("Il etait une fois dans le nord","Sergio Leone", 1976);
        if (bookServ.searchBook("Le bon la brute et le sherif").isEmpty())
            bookServ.add("Le bon la brute et le sherif","Sergio Leone", 1975);
        if (bookServ.searchBook("Comment avoir son master informatique").isEmpty())
            bookServ.add("Comment avoir son master informatique","Johnny Jackson", 1999);
        
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
