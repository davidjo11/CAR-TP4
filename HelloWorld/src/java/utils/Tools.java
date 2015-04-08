/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author josias
 */
public class Tools {
    
    public static String head = "<head>"
            + "<meta http-equiv=\"Content-type\" content=\"text/html; charset=UTF-8\" />"
            + "<script src=\"https://code.jquery.com/jquery-1.10.2.js\"></script>"
            + "</head>";

    public static String bookForm(){
        return "<html>"
                +   head
                +   "<body>"
                +       "<h4>Rechercher un livre</h4>"
                +       "<form action=\"bookForm.jsp\" method=\"post\">"
                +           "<table>"
                +               "<tr>"
                +                   "<td><label for=\"title\">Titre</label></td>"
                +                   "<td>:<input type=\"text\" name=\"title\" placeholder=\"Le titre du livre\"/></td>"
                +               "</tr>"
                +               "<tr>"
                +                   "<td><label for=\"author\">Auteur</label></td>"
                +                   "<td>:<input type=\"text\" name=\"author\" placeholder=\"Auteur\"/></td>"
                +               "</tr>"
                +               "<tr>"
                +                   "<td><label for=\"date\">Date de parution</label></td>"
                +                   "<td>:<input type=\"date\" name=\"date\" placeholder=\"jj/mm/aaaa\"/></td>"
                +               "</tr>"
                +               "<tr>"
                +                   "<td/><td><button type=\"submit\">Valider</button></td>"
                +               "</tr>"
                +           "</table>"
                +       "</form>"
                +   "</body>"
                + "</html>";
    }
}
