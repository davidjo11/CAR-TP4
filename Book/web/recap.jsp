<%-- 
    Document   : recap.jsp
    Created on : 14 avr. 2015, 14:58:32
    Author     : thibaud
--%>

<%
   String author = request.getParameter( "author" );
   session.setAttribute( "author", author );
   
   String title = request.getParameter( "title" );
   session.setAttribute( "title", title );
   
   String parution = request.getParameter( "parution" );
   session.setAttribute( "parution", parution );
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= request.getParameter("title") %></h1>
        <h2>Livre paru en <%= request.getParameter("parution") %></h2>
        <h2>L'auteur est <%= request.getParameter("author") %></h2>
        
        <br>
        <h3>Revenir au formulaire (pré-rempli avec les valeurs) :</h3>
        <a href="index.jsp">lien</a>
    </body>
</html>
