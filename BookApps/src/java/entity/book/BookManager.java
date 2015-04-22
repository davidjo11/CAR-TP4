/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.book;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import java.util.List;
import javax.ejb.Remote;
import javax.persistence.Query;

/**
 * Implémentation du manager de livres.
 * @author Thibaud VERBAERE & David JOSIAS
 */
@Stateless(mappedName="BookService")
@Remote(IBookManager.class)
public class BookManager implements IBookManager {
    
    // la BDD :
    @PersistenceContext(unitName = "book-unit")
    EntityManager em;
    
    /**
     * Permet l'ajout d'un livre.
     * @param book le livre a ajouter
     */
    public void add(Book book) {
        em.persist(book);
    }
    
    /**
     * Permet la suppression d'un livre.
     * @param book le livre a supprimer
     */
    public void remove(Book book) {
        em.remove(book);
    }
    
    /**
     * Permet la recherche d'un livre.
     * @param title le mot clé a rechercher dans le titre
     * @return la liste des livres correspondante à la recherche
     */
    public List<Book> search(String title) {
        String ejbql = "SELECT b FROM Book b WHERE b.title LIKE '%"+title+"%'";
        Query query = em.createQuery(ejbql);
        
        return query.getResultList();
    }
    
    /**
     * Liste les livres contenus dans la manager.
     * @return la liste des livres
     */
    public List<Book> listBooks() {
        return em.createQuery("SELECT b FROM Book b ORDER BY b.title").getResultList();
    }
    
    /**
     * Liste les auteurs contenus dans la manager.
     * @return la liste des auteurs
     */
    public List<String> listAuthors() {
        return em.createQuery("SELECT DISTINCT b.author FROM Book b ORDER BY b.author").getResultList();
    }
    
}
