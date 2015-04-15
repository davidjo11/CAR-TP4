/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.ejb.Singleton;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author thibaud
 */
@Singleton
public class BookManager implements IBookManager {
    
    @PersistenceContext
    EntityManager em;
    
    public void add(Book book) {
        em.persist(book);
    }
    
    public Book search(String title) {
        return em.find(Book.class, title);
    }
    
    public List<Book> list() {
        return em.createQuery("SELECT b FROM Book b ORDER BY b.title").getResultList();
    }
    
}
