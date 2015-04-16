/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.book;

import javax.ejb.Remote;
import java.util.List;

/**
 *
 * @author thibaud
 */
@Remote
public interface IBookManager {
    
    public void add(Book book);
    
    public Book search(String title);
    
    public List<Book> listBooks();
    
    public List<String> listAuthors();
}
