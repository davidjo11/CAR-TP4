/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbservices;

import cart.Cart;
import entity.book.Book;
import exception.ManagerNotFoundException;
import javax.ejb.Stateless;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.EJBException;
import java.rmi.RemoteException;
import java.util.List;
import javax.ejb.EJB;

/**
 *  Classe répertoriant les services disponibles sur le panier.
 * @author Thibaud VERBAERE & David JOSIAS
 */
@Stateless
public class CartServices implements SessionBean {
    
    @EJB
    Cart cart;
    
    /**
     * Permet d'ajouter un livre dans le panier.
     * @param book le livre a ajouter
     */
    public void addBookToCart(Book book) {
        cart.addBookToCart(book);
    }

    /**
     * Permet de retirer un livre dans le panier.
     * @param book  le livre a retirer
     */
    public void removeBookToCart(Book book) {
        cart.removeBookToCart(book);
    }
    
    /**
     * Permet d'envoyer une commande.
     * Les livres du panier sont supprimés de la liste et une nouvelle
     * entrée de commande est créée.
     * @param user l'utilisateur envoyant la commande
     * @throws ManagerNotFoundException si le manager de livre est introuvable
     */
    public void sendCommand(String user) throws ManagerNotFoundException {
        cart.sendCommand(user);
    }
    
    /**
     * Affiche le panier. C'est donc une liste de livres qui est affichée.
     * @return la liste de livre contenue dans le panier d'un client
     */
    public List<Book> list() {
        return cart.list();
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
