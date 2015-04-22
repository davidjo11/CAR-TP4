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
 *  Classe représentant une entité Client.
 * @author Thibaud VERBAERE et David JOSIAS
 */
@Entity
public class Client implements Serializable {
    
    private static final long serialVersionUID = 2L;
    
    @Id
    private String pseudo;
    
    private String password;
    
    private int status;

    /**
     * Constructeur par defaut.
     */
    public Client() {
    }
    
    /**
     * Constructeur de client.
     * @param pseudo le pseudo du client a créer
     * @param password le mot de passe du client a créer
     * @param status le status du client a créer (0 pour admin, 1 pour utilisateur lambda)
     */
    public Client(String pseudo, String password, int status) {
        this.pseudo = pseudo;
        this.password = password;
        this.status = status;
    }

    /**
     * Retourne le pseudo du client.
     * @return le pseudo du client
     */
    public String getPseudo() {
        return this.pseudo;
    }

    /**
     * Change le pseudo du client.
     * @param pseudo le nouveau pseudo du client
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    
    /**
     * Retourne le mot de passe du client.
     * @return le mot de passe du client
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Change le mot de passe du client
     * @param password le nouveau mot de passe du client
     */
    public void setPassord(String password) {
        this.password = password;
    }
    
    /**
     * Retourne le status du client.
     * @return le status du client
     */
    public int getStatus() {
        return this.status;
    }

    /**
     * Change le status du client.
     * @param status le status du client
     */
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if (this.pseudo.equals(other.pseudo))
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "entity.Client[ "+this.pseudo+" ]";
    }
    
}
