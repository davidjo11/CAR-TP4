/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.user;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author thibaud
 */
@Entity
public class User implements Serializable {
    
    private static final long serialVersionUID = 2L;
    
    @Id
    private String pseudo;
    
    private String password;
    
    private int status;

    public User() {
    }
    
    public User(String pseudo, String password, int status) {
        this.pseudo = pseudo;
        this.password = password;
        this.status = status;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    
    public String getPassword() {
        return this.password;
    }

    public void setPassord(String password) {
        this.password = password;
    }
    
    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.pseudo != null ? this.pseudo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if (this.pseudo.equals(other.pseudo))
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "entity.User[ "+this.pseudo+" ]";
    }
    
}
