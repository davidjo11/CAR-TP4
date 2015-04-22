/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbservices;

import entity.book.Book;
import entity.book.IBookManager;
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
 *  Classe répertoriant les services disponibles sur les livres.
 * @author Thibaud VERBAERE & David JOSIAS
 */
@Stateless
public class BookServices implements SessionBean {
    
    /**
     * Cherche le manager de livres.
     * @return le manager de livres
     * @throws ManagerNotFoundException si celui-ci est introuvable
     */
    private IBookManager lookUp() throws ManagerNotFoundException {
        try {
            Context context = new InitialContext();
            IBookManager stocks = (IBookManager) context.lookup("BookService");
            return stocks;
        } catch (NamingException ex) {
            throw new ManagerNotFoundException();
        }
    }
    
    /**
     * Ajoute un livre dans le manager de livre.
     * @param title le titre du livre a ajouter
     * @param author l'auteur du livre a ajouter
     * @param annee la date de parution du livre a ajouter
     * @throws ManagerNotFoundException si le manager est introuvable
     */
    public void add(String title, String author, int annee) throws ManagerNotFoundException {
       this.lookUp().add(new Book(title,author, annee));
    }
    
    /**
     * Retire un livre dans le manager de livres.
     * @param book le livre a retirer
     * @throws exception.ManagerNotFoundException si le manager est introuvable
     */
    public void remove(Book book) throws ManagerNotFoundException {
        this.lookUp().remove(book);
    }
    
    /**
     * Liste les auteurs présents dans le manager de livres.
     * @return la liste des auteurs
     * @throws ManagerNotFoundException si le manager est introuvable
     */
    public List<String> listAuthors() throws ManagerNotFoundException {
       return this.lookUp().listAuthors();
    }
    
    /**
     * Liste les livres présents dans le manager de livres.
     * @return la liste des livres
     * @throws ManagerNotFoundException si le manager est introuvable
     */
    public List<Book> listBooks() throws ManagerNotFoundException {      
       return this.lookUp().listBooks();
    }
    
    /**
     * Cherche les livres dont le titre contient un certain mot clé passée en paramètre.
     * @param title le mot clé
     * @return la liste de livre correspondant à la recherche
     * @throws ManagerNotFoundException si le manager est introuvable
     */
    public List<Book> searchBook(String title) throws ManagerNotFoundException { 
       return this.lookUp().search(title);
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
