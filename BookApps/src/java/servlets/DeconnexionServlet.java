/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejbservices.UserServices;
import javax.servlet.http.*; 
import javax.servlet.*; 
import java.io.*;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author thibaud
 */
@WebServlet(name="Deconnexion", urlPatterns={"/Deconnexion"})
public class DeconnexionServlet extends HttpServlet {
    
    @EJB
    UserServices userServ;
    
    protected void processRequest(HttpServletRequest request,  HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        session.removeAttribute("USER");
        response.sendRedirect(response.encodeRedirectURL("index.jsp"));
        
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
