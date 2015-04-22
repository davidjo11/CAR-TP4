/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejbservices.CartServices;
import entity.book.Book;
import exception.ManagerNotFoundException;
import javax.servlet.http.*; 
import javax.servlet.*; 
import java.io.*;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;

/**
 *  Servlet créant une page HTML listant le contenu du panier.
 * @author Thibaud VERBARE & David JOSIAS
 */
@WebServlet(name="ListCommandBooks", urlPatterns={"/ListCommandBooks"})
public class ListCommandBooksServlet extends HttpServlet {
    
    @EJB
    CartServices cart;
    
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
            session.getAttribute("USER").equals(1);
            
            // On récupère la liste des livres du panier.
            List<Book> list = cart.list();

            response.setContentType( "text/html" );

            PrintWriter out = response.getWriter();

            out.println( "<html><body>" ); 

            out.println( "<h1>Votre panier :</h1>" );
            out.println( "<table>" );
            
            for (Book book : list)
                out.println( "<tr><td>"+book.getTitle()+"</td><td>"+book.getAuthor()+"</td><td>"+book.getDate()+"</td><td><form action=\"RemoveCommandBook\"><input type=\"hidden\" name=\"title\" id=\"title\" value=\""+book.getTitle()+"\"/><input type=\"submit\" value=\"Retirer\" /></form></td></tr>" );

            out.println( "</table>" );

            out.println( "<form action=\"SendCommand\"><input type=\"submit\" value=\"Commander\" /></form>" );
            
            out.println( "<a href=\"mainpage.jsp\">Retour</a>" );
            
            out.println( "</body></html>" ); 
                
        }
        catch (IOException e) {
            // On essaye d'acceder a la page sans être connecté : retour à l'accueil !
            response.sendRedirect(response.encodeRedirectURL("index.jsp"));
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
