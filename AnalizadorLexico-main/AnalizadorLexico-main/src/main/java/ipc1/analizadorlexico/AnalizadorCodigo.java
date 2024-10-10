
package ipc1.analizadorlexico;

public class AnalizadorCodigo {
    
    public String optimizarCodigo(String codigo) {
        codigo = codigo.replaceAll("//.*", "");

        codigo = codigo.replaceAll("/\\*[^*]*\\*+(?:[^/*][^*]*\\*+)*/", "");

       
        codigo = codigo.replaceAll("<!--.*?-->", "");

        
        codigo = codigo.replaceAll("\\n{2,}", "\n");

        
        codigo = codigo.trim();

        return codigo;
    }
    
}
