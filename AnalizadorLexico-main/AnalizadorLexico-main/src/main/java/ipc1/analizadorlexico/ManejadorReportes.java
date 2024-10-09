 package ipc1.analizadorlexico;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ManejadorReportes {

    public void generarReporteErrores(List<TokenError> errores, String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            writer.write("<html>\n<head>\n<title>Reporte de Errores</title>\n</head>\n<body>\n");
            writer.write("<h1>Reporte de Errores</h1>\n");
            writer.write("<table border='1'>\n");
            writer.write("<tr><th>Token</th><th>Lenguaje donde se encontró</th><th>Lenguaje sugerido</th><th>Fila</th><th>Columna</th></tr>\n");
            
            for (TokenError error : errores) {
                writer.write("<tr>");
                writer.write("<td>" + error.getToken() + "</td>");
                writer.write("<td>" + error.getLenguajeEncontrado() + "</td>");
                writer.write("<td>" + error.getLenguajeSugerido() + "</td>");
                writer.write("<td>" + error.getFila() + "</td>");
                writer.write("<td>" + error.getColumna() + "</td>");
                writer.write("</tr>\n");
            }
            
            writer.write("</table>\n");
            writer.write("</body>\n</html>");
        } catch (IOException e) {
            System.out.println("Error al generar el reporte: " + e.getMessage());
        }
    }
    
    public class TokenError {
    private String token;
    private String lenguajeEncontrado;
    private String lenguajeSugerido;
    private int fila;
    private int columna;

    public TokenError(String token, String lenguajeEncontrado, String lenguajeSugerido, int fila, int columna) {
        this.token = token;
        this.lenguajeEncontrado = lenguajeEncontrado;
        this.lenguajeSugerido = lenguajeSugerido;
        this.fila = fila;
        this.columna = columna;
    }

    public String getToken() {
        return token;
    }

    public String getLenguajeEncontrado() {
        return lenguajeEncontrado;
    }

    public String getLenguajeSugerido() {
        return lenguajeSugerido;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
}

}
