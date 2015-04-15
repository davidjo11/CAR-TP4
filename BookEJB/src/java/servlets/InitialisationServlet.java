/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import javax.servlet.http.*; 
import javax.servlet.*; 
import java.io.*;

/**
 *
 * @author thibaud
 */
public class InitialisationServlet extends HttpServlet {
    
     public void service( HttpServletRequest request,  HttpServletResponse response ) throws ServletException, IOException {
         
        response.setContentType( "text/html" );
         
        PrintWriter out = response.getWriter();
         
        out.println( "<html><body>" ); 
        out.println( "<h1>Initialisation effectuee !</h1>" ); 
        out.println( "</body></html>" ); 
         
     }
    
}
