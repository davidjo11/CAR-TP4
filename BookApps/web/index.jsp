<%-- 
    Document   : index
    Created on : 15 avr. 2015, 19:03:28
    Author     : Thibaud VERBAERE & David JOSIAS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        
        <h1>Veuillez vous connecter :</h1>
        
        <form method="post" action="Connexion">
            <p><input type="text" name="user" placeholder="Identifiant"></p>
            <p><input type="password" name="password" placeholder="Mot de passe"></p>
            <p><input type="submit" value="Connexion"></p>
        </form>
        
        <a href="Initialisation">Initialisation (indispensable pour la premiere utilisation)</a><br>
        <a href="inscription.jsp">S'inscrire</a>
    </body>
</html>
