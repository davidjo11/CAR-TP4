/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import ejbservices.CommandServices;
import entity.book.Book;
import exception.ManagerNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.naming.NamingException;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *  Classe modélisant le panier.
 * @author Thibaud VERBAERE & David JOSIAS
 */

@Stateful
@Remote(Cart.class)
public class CartBean implements Cart, Serializable {
    
    @EJB
    CommandServices commandServ;

    // Liste des livres actuellement dans le panier :
    private List<Book> products;
    

    /**
     * Initialisation du panier.
     */
    @PostConstruct
    public void CartBean(){
	this.products = new ArrayList<Book>();
    }

    /**
     * Permet d'ajouter un livre dans le panier.
     * @param book le livre a ajouter
     */
    public void addBookToCart(Book book) {
	products.add(book);
    }

    /**
     * Permet de retirer un livre dans le panier.
     * @param book  le livre a retirer
     */
    public void removeBookToCart(Book book) {
       products.remove(book);
    }
    
    /**
     * Affiche le panier. C'est donc une liste de livres qui est affichée.
     * @return la liste de livre contenue dans le panier d'un client
     */
    public List<Book> list() {
        return products;
    }

    /**
     * Permet d'envoyer une commande.
     * Les livres du panier sont supprimés de la liste et une nouvelle
     * entrée de commande est créée.
     * @param user l'utilisateur envoyant la commande
     * @throws ManagerNotFoundException si le manager de livre est introuvable
     */
    public void sendCommand(String user) throws ManagerNotFoundException {
        // Pour chaque livre du panier on passe la commande et on réinitialise
        // le panier à la fin.
        for (Book b : products) {
            commandServ.addCommand(user, b.getTitle());
        }
        
        products = new ArrayList<Book>();
        
    }

}
