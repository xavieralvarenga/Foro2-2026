package com.todopc.model;

/**
 * Clase Base Abstracta (Superclase) que contiene los atributos comunes
 * definidos en la Tabla 1 para todos los equipos.
 */
public abstract class Equipo {
    // Atributos protegidos (protected) para que las subclases puedan acceder a ellos
    protected String fabricante;
    protected String modelo;
    protected String microprocesador;
    protected String memoria;

    /**
     * Constructor de la clase base.
     * Se invoca desde las subclases usando super().
     */
    public Equipo(String fabricante, String modelo, String microprocesador, String memoria) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.microprocesador = microprocesador;
        this.memoria = memoria;
    }

    // Métodos Getter y Setter (Encapsulamiento)
    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getMicroprocesador() { return microprocesador; }
    public void setMicroprocesador(String microprocesador) { this.microprocesador = microprocesador; }

    public String getMemoria() { return memoria; }
    public void setMemoria(String memoria) { this.memoria = memoria; }

    /**
     * Sobreescritura del método toString para devolver los datos básicos.
     * Las subclases llamarán a este método y le añadirán sus propios datos.
     */
    @Override
    public String toString() {
        return "Fabricante: " + fabricante + "\n" +
                "Modelo: " + modelo + "\n" +
                "Microprocesador: " + microprocesador + "\n" +
                "Memoria: " + memoria;
    }
}