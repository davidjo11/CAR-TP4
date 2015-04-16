/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejbservices.AddUser;
import javax.servlet.http.*; 
import javax.servlet.*; 
import java.io.*;
import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author thibaud
 */
@WebServlet(name="AddUser", urlPatterns={"/AddUser"})
public class AddUserServlet extends HttpServlet {
    
    @EJB
    AddUser adduser;
    
    protected void processRequest(HttpServletRequest request,  HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String user = request.getParameter("user");
            String password = request.getParameter("password");
            
            
            adduser.add(user, password, 1);
            
            response.sendRedirect(response.encodeRedirectURL("http://localhost:8080/BookApps/index.jsp"));
            
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    
}
