package com.todopc.model;

// La palabra 'extends' establece la relación de herencia con la clase base
public class Desktop extends Equipo {
    // Atributos específicos definidos en el requerimiento
    private String tarjetaGrafica;
    private String tamanoTorre;
    private String capacidadDisco;

    // El constructor recibe todos los datos (comunes y específicos)
    public Desktop(String fabricante, String modelo, String microprocesador, String memoria,
                   String tarjetaGrafica, String tamanoTorre, String capacidadDisco) {

        // 'super' llama al constructor de la clase Padre (Equipo) para llenar los datos básicos
        super(fabricante, modelo, microprocesador, memoria);

        // Luego asignamos los atributos propios de esta subclase
        this.tarjetaGrafica = tarjetaGrafica;
        this.tamanoTorre = tamanoTorre;
        this.capacidadDisco = capacidadDisco;
    }

    // Sobreescritura de toString para mostrar la ficha técnica completa
    @Override
    public String toString() {
        // Llamamos al toString del padre y le concatenamos los datos de Desktop
        return super.toString() + "\n" +
                "Tarjeta gráfica: " + tarjetaGrafica + "\n" +
                "Tamaño de torre: " + tamanoTorre + "\n" +
                "Capacidad de disco duro: " + capacidadDisco;
    }
}