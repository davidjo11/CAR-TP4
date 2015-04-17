<%-- 
    Document   : inscription.jsp
    Created on : 17 avr. 2015, 19:42:35
    Author     : thibaud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription</title>
    </head>
    <body>
        <h1>Inscription au site :</h1>
        
        <form method="post" action="AddUser">
            <p><input type="text" name="user" placeholder="Identifiant"></p>
            <p><input type="password" name="password" placeholder="Mot de passe"></p>
            <p><input type="submit" value="S'inscrire"></p>
        </form>
    </body>
</html>
