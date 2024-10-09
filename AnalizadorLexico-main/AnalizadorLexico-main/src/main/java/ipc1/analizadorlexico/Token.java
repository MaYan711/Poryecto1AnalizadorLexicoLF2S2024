package ipc1.analizadorlexico;

public class Token {
    private String token;
    private String expresionRegular;
    private String lenguaje;
    private String tipo;
    private int fila;
    private int columna;
    private String lenguajeSugerido;
    
    public Token(String token, String expresionRegular, String lenguaje, String tipo, int fila, int columna) {
        
        this.token = token;
        this.expresionRegular = expresionRegular;
        
        this.lenguaje = lenguaje;
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
        this.lenguajeSugerido = lenguajeSugerido;
    }

    // Getters para acceder a los atributos
    public String getToken() {
        return token;
    }

    public String getExpresionRegular() {
        return expresionRegular;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public String getTipo() {
        return tipo;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
    
     public String getLenguajeSugerido() {
        return lenguajeSugerido;
    }
}
