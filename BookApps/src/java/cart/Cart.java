/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import entity.book.Book;
import exception.ManagerNotFoundException;
import java.util.List;
import javax.ejb.Remote;

/**
 *  Interface des opérations réalisables sur le panier de livres.
 * @author Thibaud VERBAERE & David JOSIAS
 */
@Remote
public interface Cart {
     
    /**
     * Permet d'ajouter un livre dans le panier.
     * @param book le livre a ajouter
     */
    public void addBookToCart(Book book);

    /**
     * Permet de retirer un livre dans le panier.
     * @param book  le livre a retirer
     */
    public void removeBookToCart(Book book);
    
    /**
     * Permet d'envoyer une commande.
     * Les livres du panier sont supprimés de la liste et une nouvelle
     * entrée de commande est créée.
     * @param user l'utilisateur envoyant la commande
     * @throws ManagerNotFoundException si le manager de livre est introuvable
     */
    public void sendCommand(String user) throws ManagerNotFoundException;
    
    /**
     * Affiche le panier. C'est donc une liste de livres qui est affichée.
     * @return la liste de livre contenue dans le panier d'un client
     */
    public List<Book> list();

}
