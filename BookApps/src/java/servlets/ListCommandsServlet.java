/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejbservices.CommandServices;
import entity.command.Command;
import exception.ManagerNotFoundException;
import javax.servlet.http.*; 
import javax.servlet.*; 
import java.io.*;
import javax.ejb.EJB;
import java.util.List;
import javax.servlet.annotation.WebServlet;

/**
 *  Servlet créant une page HTML listant les commandes.
 * @author Thibaud VERBARE & David JOSIAS
 */
@WebServlet(name="ListCommands", urlPatterns={"/ListCommands"})
public class ListCommandsServlet extends HttpServlet {
    
    @EJB
    CommandServices commandServ;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,  HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            // On regarde si une session existe, sinon une exception est lancée.
            HttpSession session = request.getSession(true);
            if (session.getAttribute("USER").equals(1)) {
                // De plus seul l'admin peut accèder a la page donc si le status est 1 : redirection !
                response.sendRedirect(response.encodeRedirectURL("index.jsp"));
            }
            
            // On recupère la liste des commandes :
            List<Command> list = commandServ.listCommands();

            response.setContentType( "text/html" );

            PrintWriter out = response.getWriter();

            out.println( "<html><body>" ); 

            out.println( "<h1>Liste des commandes :</h1>" );
            out.println( "<table>" );

            for (Command c : list)
                out.println( "<tr><td>"+c.getUser()+"</td><td>"+c.getTitle()+"</td></tr>" );

            out.println( "</table>" );
            
            out.println( "<a href=\"mainpage.jsp\">Retour</a>" );

            out.println( "</body></html>" ); 
                
        }
        catch (IOException e) {
            // On essaye d'acceder a la page sans être connecté : retour à l'accueil !
            response.sendRedirect(response.encodeRedirectURL("index.jsp"));
        } catch (ManagerNotFoundException ex) {
            // Si probleme de managers : -> not found
            response.sendRedirect(response.encodeRedirectURL("notfound.jsp"));
        }
         
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold> 

    
}
