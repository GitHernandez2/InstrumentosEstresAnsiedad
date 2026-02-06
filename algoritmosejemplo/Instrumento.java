package com.example.algoritmosejemplo;

public class Instrumento {

    private String nombre;
    private Tipo tipo;
    private Forma forma;
    private boolean validez;
    private boolean confiabilidad;
    private Condicion condicion;
    private int clave;
    private String autor;
    private int cita;

    public Instrumento() {
        this.nombre = "Instrumento01";
    }

    //Enums

    public enum Tipo {
        IDENTIFICAR,
        MANEJAR
    }

    public enum Forma {
        ESCALA,
        CUESTIONARIO,
        TEST
    }

    public enum Condicion {
        ESTRES,
        ANSIEDAD,
        AMBOS
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Forma getForma() {
        return forma;
    }

    public void setForma(Forma forma) {
        this.forma = forma;
    }

    public Condicion getCondicion() {
        return condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }

    public boolean getValidez() {
        return validez;
    }

    public void setValidez(boolean validez) {
        this.validez = validez;
    }

    public boolean isConfiabilidad() {
        return confiabilidad;
    }

    public void setConfiabilidad(boolean confiabilidad) {
        this.confiabilidad = confiabilidad;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getCita() {
        return cita;
    }

    public void setCita(int cita) {
        this.cita = cita;
    }

    @Override
    public String toString() {
        return nombre + ", " + autor;
    }
}
