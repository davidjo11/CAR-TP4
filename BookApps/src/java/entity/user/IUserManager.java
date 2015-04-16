/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.user;

import javax.ejb.Remote;
import java.util.List;

/**
 *
 * @author thibaud
 */
@Remote
public interface IUserManager {
    
    public void add(Client user);
    
    public Client search(String login);
    
    public List<Client> listUsers();
    
    public int getStatus(String login);
}
