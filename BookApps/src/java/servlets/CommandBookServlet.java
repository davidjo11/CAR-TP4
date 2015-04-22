/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejbservices.BookServices;
import ejbservices.CartServices;
import entity.book.Book;
import exception.ManagerNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *  Servlet qui ajoute une commande au manager de commandes.
 *  Cette servlet est déclenchée quand le bouton "commander" du panier est enclenché.
 * @author Thibaud VERBARE & David JOSIAS
 */
@WebServlet(name = "CommandBook", urlPatterns = {"/CommandBook"})
public class CommandBookServlet extends HttpServlet {

    @EJB
    BookServices bookServ;
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // On regarde si une session existe, sinon une exception est lancée.
            HttpSession session = request.getSession(true);
            session.getAttribute("USER").equals(1);
            
            // On recupère le livre a commander
            String title = request.getParameter("title");
            List<Book> book = bookServ.searchBook(title);
            
            // On l'ajoute au panier.
            cart.addBookToCart(book.get(0));   
            
            // retour au panier.
            response.sendRedirect(response.encodeRedirectURL("ListCommandBooks"));

        }
        catch (IOException e) {
            // On essaye d'acceder a la page sans être connecté : retour à l'accueil !
            response.sendRedirect(response.encodeRedirectURL("index.jsp"));
        }
        catch (ManagerNotFoundException e2) {
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
