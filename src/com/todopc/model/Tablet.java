package com.todopc.model;

public class Tablet extends Equipo {
    private String tamanoDiagonal;
    private String tipoPantalla; // Capacitiva o Resistiva
    private String memoriaNAND;
    private String sistemaOperativo;

    public Tablet(String fabricante, String modelo, String microprocesador, String memoria,
                  String tamanoDiagonal, String tipoPantalla, String memoriaNAND, String sistemaOperativo) {

        super(fabricante, modelo, microprocesador, memoria);

        this.tamanoDiagonal = tamanoDiagonal;
        this.tipoPantalla = tipoPantalla;
        this.memoriaNAND = memoriaNAND;
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Tamaño diagonal de pantalla: " + tamanoDiagonal + "\n" +
                "¿Capacitiva/Resistiva?: " + tipoPantalla + "\n" +
                "Tamaño memoria NAND: " + memoriaNAND + "\n" +
                "Sistema Operativo: " + sistemaOperativo;
    }
}