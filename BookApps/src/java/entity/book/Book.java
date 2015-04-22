/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.book;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *  Classe représentant une entité Livre.
 * @author Thibaud VERBAERE et David JOSIAS
 */
@Entity
public class Book implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    private String title;
    
    private String author;
    
    private int date_p;

    /**
     * Constructeur par défaut.
     */
    public Book() {
    }
    
    /**
     * Constructeur de livre.
     * @param title le titre du livre
     * @param author l'auteur du livre
     * @param date la date de parution du livre
     */
    public Book(String title ,String author, int date) {
        this.author = author;
        this.date_p = date;
        this.title = title;
    }

    /**
     * Retourne le titre du livre.
     * @return le titre du livre
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Change le titre du livre.
     * @param title le nouveau titre du livre
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Retourne l'auteur du livre.
     * @return l'auteur du livre.
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Change l'auteur du livre.
     * @param author le nouvel auteur du livre
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    
    /**
     * Retourne la date de parution du livre.
     * @return la date de parution du livre
     */
    public int getDate() {
        return this.date_p;
    }

    /**
     * Change la date de parution du livre.
     * @param date la nouvel date de parution du livre
     */
    public void setDate(int date) {
        this.date_p = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.title != null ? this.title.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if (this.title.equals(other.title) && this.date_p == other.date_p &&
                this.author.equals(other.author)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "entity.Book[ title=" + this.title + " author=" + this.author + " [" + this.date_p + "]" +" ]";
    }
    
}
