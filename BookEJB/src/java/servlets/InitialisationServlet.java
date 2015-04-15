/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejbservices.Initialisation;
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
@WebServlet(name="Initialisation", urlPatterns={"/Initialisation"})
public class InitialisationServlet extends HttpServlet {
    
    @EJB
    Initialisation init;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            init.initialisation();

            response.setContentType( "text/html" );

            PrintWriter out = response.getWriter();

            out.println( "<html><body>" ); 
            out.println( "<h1>Initialisation effectuee !</h1>" ); 
            out.println( "</body></html>" );
            
            out.close();
        }
        catch (NamingException e) {
            e.getStackTrace();
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
    
}
