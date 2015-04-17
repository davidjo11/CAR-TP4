<%-- 
    Document   : mainpage
    Created on : 17 avr. 2015, 19:10:58
    Author     : thibaud
--%>

<%
    try {
        if (session.getAttribute("USER").equals("1")) {
            // RIEN
        }
            
    }
    catch (Exception e) {
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Librairie en ligne</title>
    </head>
    
    <body>
        <h1>Bienvenue dans votre librairie en ligne !</h1>
        
        <a href="ListAuthors">Test ListAuthors</a>
        <a href="ListBooks">Test ListBooks</a>
        <% if (session.getAttribute("USER").equals(0)) { %> 
            <%= "<a href=\"formulaire.jsp\">Formulaire</a>" %>
        <% }%>
        <a href="Deconnexion">Deconnexion</a>

    </body>
    
</html>
