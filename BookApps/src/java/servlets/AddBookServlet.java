/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejbservices.AddBook;
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
@WebServlet(name="AddBook", urlPatterns={"/AddBook"})
public class AddBookServlet extends HttpServlet {
    
    @EJB
    AddBook addbook;
    
    
    protected void processRequest(HttpServletRequest request,  HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String author = request.getParameter("author");
            String parution = request.getParameter("parution");
            String title = request.getParameter("title");
            
            addbook.add(title, author, Integer.parseInt(parution));
            
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
