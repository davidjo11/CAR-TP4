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
import java.util.logging.Level;
import java.util.logging.Logger;
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
            
            response.setContentType( "text/html" );

            PrintWriter out = response.getWriter();

            out.println( "<html><body>" ); 
            out.println( "<h1>"+title+" a ete enregistre !</h1>" ); 
            out.println( "</body></html>" );
            
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
