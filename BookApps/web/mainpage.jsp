<%-- 
    Document   : mainpage
    Created on : 17 avr. 2015, 19:10:58
    Author     : Thibaud VERBAERE & David JOSIAS
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
        <title>Librairie en ligne !</title>
    </head>
    
    <body>
        
        <a href="ListCommandBooks">Panier</a><br>
        <a href="Deconnexion">Deconnexion</a><br>
        <h1>Bienvenue dans votre librairie en ligne !</h1>
        <h2>Rechercher un livre :</h2>
        <form action="SearchBook">
            <label for="titre">Titre du livre :</label>
            <input required="required" type="text" name="title" id="title"/>
            <input type="submit" value="Rechercher" />
        </form>
        
        <a href="ListAuthors">Consulter la liste des auteurs</a><br>
        <a href="ListBooks">Consulter la liste des livres</a><br>
 
        <% if (session.getAttribute("USER").equals(0)) { %> 
            <%= "<a href=\"formulaire.jsp\">Formulaire</a><br>" %>
            <%= "<a href=\"ListCommands\">Consulter les commandes</a>" %>
        <% }%>

    </body>
    
</html>
