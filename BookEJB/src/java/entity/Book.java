/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author thibaud
 */
@Entity
public class Book implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    private String title;
    
    private String author;
    
    private int date_p;
    
    public Book(String title ,String author, int date) {
        this.author = author;
        this.date_p = date;
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public int getDate() {
        return this.date_p;
    }

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
