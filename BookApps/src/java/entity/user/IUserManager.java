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
    
    public void add(User user);
    
    public User search(String login);
    
    public List<User> listUsers();
    
    public int getStatus(String login);
}
