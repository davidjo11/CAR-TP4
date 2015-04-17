<%-- 
    Document   : index
    Created on : 14 avr. 2015, 14:50:52
    Author     : thibaud
--%>


<%
    try {
        if (session.getAttribute("USER").equals("1")) {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
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
        <title>Formulaire</title>
    </head>
    <body>
        <h1>Ajouter un livre</h1>
        <form method="post" action="AddBook">
            <fieldset>
            <legend>Informations sur le livre</legend>
                <label for="titre">Titre du livre :</label>
                <input required="required" type="text" name="title" id="title"/>
                
                <label for="parution">Annee de parution :</label>
                <input required="required" type="date" name="parution" id="parution"/>
            </fieldset>  
            
            <fieldset>
            <legend>Informations sur l'auteur</legend>
                <label for="auteur">Auteur du livre :</label>
                <input required="required" type="text" name="author" id="author"/>
            </fieldset>  
                
            <input type="submit" value="Envoyer" />
            <input type="reset" value="Effacer" />
        </form>
    </body>
</html>
