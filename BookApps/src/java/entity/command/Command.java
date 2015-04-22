/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.command;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *  Classe représentant une entité Commande.
 * @author Thibaud VERBAERE et David JOSIAS
 */
@Entity
public class Command implements Serializable {
    
    private static final long serialVersionUID = 3L;
    
    @Id
    private String title;
    
    @Id
    private String c_user;

    /**
     * Constructeur par défaut.
     */
    public Command() {
    }
    
    /**
     * Constructeur de commande.
     * @param user l'utilisateur passant la commande
     * @param book le livre a commander
     */
    public Command(String user ,String book) {
        this.c_user = user;
        this.title = book;
    }
    
    /**
     * Retourne le titre du livre de la commande.
     * @return le titre du livre commandé
     */
    public String getTitle() {
        return this.title;
    }
    
    /**
     * Change le titre du livre de la commande.
     * @param title le nouveau titre du livre
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Retourne l'utilisateur passant la commande.
     * @return l'utilisateur qui commande
     */
    public String getUser() {
        return this.c_user;
    }
    
    /**
     * Change l'utilisateur passant la commande.
     * @param user le nouvel utilisateur qui passe commande
     */
    public void setUser(String user) {
        this.c_user = user;
    }

    
}
