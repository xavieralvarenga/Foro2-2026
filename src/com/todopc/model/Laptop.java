package com.todopc.model;

public class Laptop extends Equipo {
    private String tamanoPantalla;
    private String capacidadDisco;

    public Laptop(String fabricante, String modelo, String microprocesador, String memoria,
                  String tamanoPantalla, String capacidadDisco) {

        // Inicializamos los 4 campos base en la superclase
        super(fabricante, modelo, microprocesador, memoria);

        this.tamanoPantalla = tamanoPantalla;
        this.capacidadDisco = capacidadDisco;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Tamaño pantalla: " + tamanoPantalla + "\n" +
                "Capacidad de disco duro: " + capacidadDisco;
    }
}