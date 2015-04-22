/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.book;

import javax.ejb.Remote;
import java.util.List;

/**
 * Interface du manager de livres.
 * @author Thibaud VERBAERE & David JOSIAS
 */
@Remote
public interface IBookManager {
    
    /**
     * Permet l'ajout d'un livre.
     * @param book le livre a ajouter
     */
    public void add(Book book);
    
    /**
     * Permet la suppression d'un livre.
     * @param book le livre a supprimer
     */
    public void remove(Book book);
    
    /**
     * Permet la recherche d'un livre.
     * @param title le mot clé a rechercher dans le titre
     * @return la liste des livres correspondante à la recherche
     */
    public List<Book> search(String title);
    
    /**
     * Liste les livres contenus dans la manager.
     * @return la liste des livres
     */
    public List<Book> listBooks();
    
    /**
     * Liste les auteurs contenus dans la manager.
     * @return la liste des auteurs
     */
    public List<String> listAuthors();
}
