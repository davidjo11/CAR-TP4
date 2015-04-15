/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejbservices.ListBooks;
import entity.Book;
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
@WebServlet(name="ListBooks", urlPatterns={"/ListBooks"})
public class ListBooksServlet extends HttpServlet {
    
    @EJB
    ListBooks listBooks;
    
    
    protected void processRequest(HttpServletRequest request,  HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            List<Book> list = listBooks.list();
         
            response.setContentType( "text/html" );
         
            PrintWriter out = response.getWriter();
         
            out.println( "<html><body>" ); 
        
            out.println( "<h1>Liste des livres :</h1>" );
            out.println( "<table>" );
        
            for (Book book : list)
               out.println( "<tr><td>"+book.getTitle()+"</td><td>"+book.getAuthor()+"</td><td>"+book.getDate()+"</td></tr>" );
        
            out.println( "</table>" );
        
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
