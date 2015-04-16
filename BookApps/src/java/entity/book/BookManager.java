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

/**
 *
 * @author thibaud
 */
@Stateless(mappedName="BookService")
@Remote(IBookManager.class)
public class BookManager implements IBookManager {
    
    @PersistenceContext(unitName = "book-unit")
    EntityManager em;
    
    @Override
    public void add(Book book) {
        em.persist(book);
    }
    
    @Override
    public Book search(String title) {
        return em.find(Book.class, title);
    }
    
    @Override
    public List<Book> listBooks() {
        return em.createQuery("SELECT b FROM Book b ORDER BY b.title").getResultList();
    }
    
    @Override
    public List<String> listAuthors() {
        return em.createQuery("SELECT DISTINCT b.author FROM Book b ORDER BY b.author").getResultList();
    }
    
}
