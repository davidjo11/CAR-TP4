/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejbservices.ListAuthors;
import javax.servlet.http.*; 
import javax.servlet.*; 
import java.io.*;
import javax.ejb.EJB;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author thibaud
 */
@WebServlet(name="ListAuthors", urlPatterns={"/ListAuthors"})
public class ListAuthorsServlet extends HttpServlet {
    
    @EJB
    ListAuthors listAuthors;
    
    
    protected void processRequest(HttpServletRequest request,  HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            List<String> list = listAuthors.list();
         
            response.setContentType( "text/html" );
         
            PrintWriter out = response.getWriter();
         
            out.println( "<html><body>" ); 
        
            out.println( "<h1>Liste des auteurs :</h1>" );
            out.println( "<ul>" );
        
            for (String author : list)
               out.println( "<li>"+author+"</li>" );
        
            out.println( "</ul>" );
        
            out.println( "</body></html>" ); 

        }
        catch (NamingException e) {
            e.printStackTrace();
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
