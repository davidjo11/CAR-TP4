/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejbservices.UserServices;
import exception.ManagerNotFoundException;
import javax.servlet.http.*; 
import javax.servlet.*; 
import java.io.*;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;

/**
 *  Servlet de connexion.
 * @author Thibaud VERBARE & David JOSIAS
 */
@WebServlet(name="Connexion", urlPatterns={"/Connexion"})
public class ConnexionServlet extends HttpServlet {
    
    @EJB
    UserServices userServ;

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
            // On récupère les champs du formulaire de connexion :
            String user = request.getParameter("user");
            String password = request.getParameter("password");
            
            if (!userServ.isGoodLogin(user, password)) {
                // Si c'est pas bon : retour au point de départ !
                response.sendRedirect(response.encodeRedirectURL("index.jsp"));
            }
            else {
                // On crée une nouvelle session :
                HttpSession session = request.getSession(true);
                session.setAttribute( "USER", userServ.getStatus(user) );
                session.setAttribute( "LOGIN", user );
                // On peut aller à la page principale du site :                            
                response.sendRedirect(response.encodeRedirectURL("mainpage.jsp"));
            }
           
            
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
