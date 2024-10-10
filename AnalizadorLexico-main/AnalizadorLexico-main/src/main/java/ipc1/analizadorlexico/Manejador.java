package ipc1.analizadorlexico;

import ipc1.analizadorlexico.ManejadorReportes.TokenError;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manejador {

    private final String textoEntrada;
    private String cssContent = "";
    private String jsContent = "";
    private String htmlContent = "";
    
    private Reporte reporte;
    private AnalizadorCodigo optimizador;

    public Manejador(String textoEntrada) {
        this.textoEntrada = textoEntrada;
        this.reporte = new Reporte();
        this.optimizador = new AnalizadorCodigo();
        analizar();
    }

    private void analizar() {
        separarLenguajes();  

        
        cssContent = optimizador.optimizarCodigo(cssContent);
        jsContent = optimizador.optimizarCodigo(jsContent);
        htmlContent = optimizador.optimizarCodigo(htmlContent);
        System.out.println("Contenido JS (Optimizado): " + jsContent);
        System.out.println("Contenido HTML (Optimizado): " + htmlContent);
        
   

    String patronPalabraReservadaJS = "\\b(function|let|var|if|else|for|while|return)\\b";
    String patronIdentificadorJS = "[a-zA-Z]([a-zA-Z]|[0-9]|[_])*";
    String patronEtiquetaHtml = "<[a-zA-Z]+>";
    String patronError = "errorToken"; 

    System.out.println("Analizando JavaScript...");
    analizarTexto(jsContent, patronPalabraReservadaJS, "JavaScript", "Palabra Reservada");
    analizarTexto(jsContent, patronIdentificadorJS, "JavaScript", "Identificador");

    System.out.println("Analizando HTML...");
    analizarTexto(htmlContent, patronEtiquetaHtml, "HTML", "Etiqueta de Apertura");
    analizarTexto(htmlContent, patronError, "HTML", "Error");

    String resultadoReporte = reporte.generarReporte();
    System.out.println("Reporte generado:");
    System.out.println(resultadoReporte);
    }
     
    private void analizarTexto(String contenido, String patron, String lenguaje, String tipo) {
    Pattern pattern = Pattern.compile(patron);
    Matcher matcher = pattern.matcher(contenido);
    int fila = 1; 
    int columna = 1;
    System.out.println("Buscando patrón: " + patron + " en " + lenguaje);
    
    while (matcher.find()) {
        String tokenEncontrado = matcher.group();
        System.out.println("Token encontrado: " + tokenEncontrado); 
        reporte.agregarToken(new Token(tokenEncontrado, patron, lenguaje, tipo, fila, columna));
        columna += tokenEncontrado.length();
    }
}
    

   
    private void separarLenguajes() {
        String[] lineas = textoEntrada.split("\n");
        StringBuilder cssBuilder = new StringBuilder();
        StringBuilder jsBuilder = new StringBuilder();
        StringBuilder htmlBuilder = new StringBuilder();
        String seccionActual = "";
        for (String linea : lineas) {
            
            if (linea.startsWith(">>[css]")) {
                seccionActual = "css";
            } else if (linea.startsWith(">>[js]")) {
                seccionActual = "js";
            } else if (linea.startsWith(">>[html]")) {
                seccionActual = "html";
            } else {
                
                if (seccionActual.equals("css")) {
                    cssBuilder.append(linea).append("\n");
                } else if (seccionActual.equals("js")) {
                    jsBuilder.append(linea).append("\n");
                } else if (seccionActual.equals("html")) {
                    htmlBuilder.append(linea).append("\n");
                }
            }
        }

       
        cssContent = cssBuilder.toString().trim();
        jsContent = jsBuilder.toString().trim();
        htmlContent = htmlBuilder.toString().trim();
    }

    public void generarArchivoHtml(String rutaCarpeta, String nombreArchivo) {
        try {
            File carpeta = new File(rutaCarpeta);
            if (!carpeta.exists()) {
                System.out.println("La carpeta especificada no existe.");
                return;
            }

            
            String rutaCompleta = rutaCarpeta + File.separator + nombreArchivo;

        
            String htmlFinal =
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "    <style>\n" +
                "    /* Aquí todo el lenguaje CSS */\n" +
                cssContent +  
                "    </style>\n" +
                "    <script>\n" +
                "    /* Aquí todo el lenguaje JavaScript */\n" +
                jsContent +  
                "    </script>\n" +
                "</head>\n" +
                "<body>\n" +
                "    /* Aquí todo el lenguaje HTML */\n" +
                htmlContent +  
                "\n</body>\n" +
                "</html>";

            
            try (FileWriter writer = new FileWriter(rutaCompleta)) {
                writer.write(htmlFinal);
                System.out.println("Archivo HTML generado exitosamente en: " + rutaCompleta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   public String obtenerReporteTokens() {
   return reporte.generarReporte();
    }

    public void generarReporteOptimizacion(String rutaCarpeta, String nombreArchivo) {
    try {
       
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<!DOCTYPE html>\n");
        htmlBuilder.append("<html lang=\"en\">\n");
        htmlBuilder.append("<head>\n");
        htmlBuilder.append("    <meta charset=\"UTF-8\">\n");
        htmlBuilder.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        htmlBuilder.append("    <title>Reporte de Optimización</title>\n");
        htmlBuilder.append("    <style>\n");
        htmlBuilder.append("        table { border-collapse: collapse; width: 100%; }\n");
        htmlBuilder.append("        th, td { border: 1px solid black; padding: 8px; text-align: left; }\n");
        htmlBuilder.append("        th { background-color: #f2f2f2; }\n");
        htmlBuilder.append("    </style>\n");
        htmlBuilder.append("</head>\n");
        htmlBuilder.append("<body>\n");
        htmlBuilder.append("<h2>Reporte de Optimización</h2>\n");
        htmlBuilder.append("<table>\n");
        htmlBuilder.append("    <tr>\n");
        htmlBuilder.append("        <th>TOKEN</th>\n");
        htmlBuilder.append("        <th>EXPRESIÓN REGULAR</th>\n");
        htmlBuilder.append("        <th>LENGUAJE</th>\n");
        htmlBuilder.append("        <th>TIPO</th>\n");
        htmlBuilder.append("        <th>FILA</th>\n");
        htmlBuilder.append("        <th>COLUMNA</th>\n");
        htmlBuilder.append("    </tr>\n");

        for (Token token : reporte.getListaDeTokens()) {
            htmlBuilder.append("    <tr>\n");
            htmlBuilder.append("        <td>").append(token.getToken()).append("</td>\n");
            htmlBuilder.append("        <td>").append(token.getExpresionRegular()).append("</td>\n");
            htmlBuilder.append("        <td>").append(token.getLenguaje()).append("</td>\n");
            htmlBuilder.append("        <td>").append(token.getTipo()).append("</td>\n");
            htmlBuilder.append("        <td>").append(token.getFila()).append("</td>\n");
            htmlBuilder.append("        <td>").append(token.getColumna()).append("</td>\n");
            htmlBuilder.append("    </tr>\n");
        }

        htmlBuilder.append("</table>\n");
        htmlBuilder.append("</body>\n");
        htmlBuilder.append("</html>");

        // Crear el archivo HTML
        File archivo = new File(rutaCarpeta + File.separator + nombreArchivo);
        try (FileWriter writer = new FileWriter(archivo)) {
            writer.write(htmlBuilder.toString());
        }
        System.out.println("Reporte de optimización generado exitosamente en: " + archivo.getAbsolutePath());

    } catch (IOException e) {
        e.printStackTrace();
    }
}
     public void generarReporteErrores(String rutaCarpeta, String nombreArchivo) {
    try {
            File carpeta = new File(rutaCarpeta);
            if (!carpeta.exists()) {
                System.out.println("La carpeta especificada no existe.");
                return;
            }

            String rutaCompleta = rutaCarpeta + File.separator + nombreArchivo;
            StringBuilder htmlBuilder = new StringBuilder();
            htmlBuilder.append("<!DOCTYPE html>\n");
            htmlBuilder.append("<html lang=\"en\">\n");
            htmlBuilder.append("<head>\n");
            htmlBuilder.append("    <meta charset=\"UTF-8\">\n");
            htmlBuilder.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
            htmlBuilder.append("    <title>Reporte de Errores</title>\n");
            htmlBuilder.append("    <style>\n");
            htmlBuilder.append("        table { border-collapse: collapse; width: 100%; }\n");
            htmlBuilder.append("        th, td { border: 1px solid black; padding: 8px; text-align: left; }\n");
            htmlBuilder.append("        th { background-color: #f2f2f2; }\n");
            htmlBuilder.append("    </style>\n");
            htmlBuilder.append("</head>\n");
            htmlBuilder.append("<body>\n");
            htmlBuilder.append("<h2>REPORTE ERRORES</h2>\n");
            htmlBuilder.append("<table>\n");
            htmlBuilder.append("    <tr>\n");
            htmlBuilder.append("        <th>TOKEN</th>\n");
            htmlBuilder.append("        <th>LENGUAJE DONDE SE ENCONTRÓ</th>\n");
            htmlBuilder.append("        <th>FILA</th>\n");
            htmlBuilder.append("        <th>COLUMNA</th>\n");
            htmlBuilder.append("        <th>LENGUAJE SUGERIDO</th>\n");
            htmlBuilder.append("    </tr>\n");

            for (Token error : reporte.getListaDeTokens()) {
                htmlBuilder.append("    <tr>\n");
                htmlBuilder.append("        <td>").append(error.getToken()).append("</td>\n");
              //  htmlBuilder.append("        <td>").append(error.getLenguajeEncontrado() != null ? error.getLenguajeEncontrado() : "No especificado").append("</td>\n");
                htmlBuilder.append("        <td>").append(error.getLenguajeSugerido()).append("</td>\n");
                htmlBuilder.append("        <td>").append(error.getFila()).append("</td>\n");
                htmlBuilder.append("        <td>").append(error.getColumna()).append("</td>\n");
                htmlBuilder.append("    </tr>\n");
            }

            htmlBuilder.append("</table>\n");
            htmlBuilder.append("</body>\n");
            htmlBuilder.append("</html>");

            try (FileWriter writer = new FileWriter(rutaCompleta, StandardCharsets.UTF_8)) {
                writer.write(htmlBuilder.toString());
                System.out.println("Archivo HTML generado exitosamente en: " + rutaCompleta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
}
    


    
    public String getHtmlOrdenado() {
        return ">>[css]\n" + cssContent + "\n\n" +
               ">>[js]\n" + jsContent + "\n\n" +
               ">>[html]\n" + htmlContent;
    }

    private Iterable<Token> getListaDeErrores() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}     