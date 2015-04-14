<%-- 
    Document   : index
    Created on : 14 avr. 2015, 14:50:52
    Author     : thibaud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book</title>
    </head>
    <body>
        <h1>Formulaire</h1>
        <form method="post" action="recap.jsp">
            <fieldset>
            <legend>Informations sur le livre</legend>
                <label for="titre">Titre du livre :</label>
                <input type="text" name="title" id="title" value="<%= session.getAttribute( "title" ) %>"/>
                
                <label for="parution">Annee de parution :</label>
                <input type="date" name="parution" id="parution" value="<%= session.getAttribute( "parution" ) %>"/>
            </fieldset>  
            
            <fieldset>
            <legend>Informations sur l'auteur</legend>
                <label for="auteur">Auteur du livre :</label>
                <input type="text" name="author" id="author" value="<%= session.getAttribute( "parution" ) %>"/>
            </fieldset>  
                
            <input type="submit" value="Envoyer" />
        </form>
    </body>
</html>
