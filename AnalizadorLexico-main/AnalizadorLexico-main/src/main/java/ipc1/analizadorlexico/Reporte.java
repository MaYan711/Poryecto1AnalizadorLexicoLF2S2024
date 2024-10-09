 package ipc1.analizadorlexico;

import java.util.ArrayList;
import java.util.List;



public class Reporte {
    private List<Token> tokens;
    private List<Token> listaDeTokens;
    
    private final List<Token> listaDeErrores;
    
    

    public Reporte() {
        tokens = new ArrayList<>();
         listaDeTokens = new ArrayList<>();
         this.listaDeTokens = new ArrayList<>();
         
        this.listaDeErrores = new ArrayList<>();
    }

    public void agregarToken(Token token) {
        tokens.add(token);
          listaDeTokens.add(token);
    }
    
    public List<Token> getListaDeTokens() {
        return listaDeTokens;
    }
    
    public List<Token> getListaDeErrores() {
        return listaDeErrores;
    }
    
    public void agregarError(Token error) {
        listaDeErrores.add(error);
    }


    
    public String generarReporte() {
       StringBuilder reporteHtml = new StringBuilder();

    reporteHtml.append("<table border='1' cellspacing='0' cellpadding='5'>");
    reporteHtml.append("<tr>");
    reporteHtml.append("<th>TOKEN</th>");
    reporteHtml.append("<th>EXPRESIÓN REGULAR</th>");
    reporteHtml.append("<th>LENGUAJE</th>");
    reporteHtml.append("<th>TIPO</th>");
    reporteHtml.append("<th>ESTADO</th>");
    reporteHtml.append("<th>FILA</th>");
    reporteHtml.append("<th>COLUMNA</th>");
    reporteHtml.append("</tr>");

    for (Token token : listaDeTokens) {
        reporteHtml.append("<tr>");
        reporteHtml.append("<td>").append(token.getToken()).append("</td>");
        reporteHtml.append("<td>").append(token.getExpresionRegular()).append("</td>");
        reporteHtml.append("<td>").append(token.getLenguaje()).append("</td>");
        reporteHtml.append("<td>").append(token.getTipo()).append("</td>");
        reporteHtml.append("<td>").append("Estado").append("</td>"); 
        reporteHtml.append("<td>").append(token.getFila()).append("</td>");
        reporteHtml.append("<td>").append(token.getColumna()).append("</td>");
        reporteHtml.append("</tr>");
    }

    // Cerrar la tabla
    reporteHtml.append("</table>");

    return reporteHtml.toString();

    }
}