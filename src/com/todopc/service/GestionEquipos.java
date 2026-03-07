package com.todopc.service;

import com.todopc.model.Desktop;
import com.todopc.model.Equipo;
import com.todopc.model.Laptop;
import com.todopc.model.Tablet;

import java.util.ArrayList;

/**
 * Esta clase se encargará de gestionar la creación y almacenamiento de los equipos
 * Lógica de negocio: Aquí se implementarán los métodos para crear instancias de Desktop, Laptop y Tablet,
 * (CRUD y ArrayList para almacenar los equipos) y cualquier otra funcionalidad relacionada con la gestión de los equipos.
 */

public class GestionEquipos {
    // Definimos la lista dinámica que almacenará cualquier tipo de equipo (Polimorfismo)
    private ArrayList<Equipo> listaEquipos;

    // Constructor: Inicializa el ArrayList en memoria
    public GestionEquipos() {
        this.listaEquipos = new ArrayList<>();
    }

    // Método para agregar un objeto (ya sea Desktop, Laptop o Tablet) a la lista
    public void registrarEquipo(Equipo nuevoEquipo) {
        this.listaEquipos.add(nuevoEquipo);
    }

    // Método que recorre la lista y filtra por tipo para devolver un reporte en String
    public String obtenerReportePorInstancia(int tipoBuscado) {
        /**
         * (StringBuilder) Se utiliza en lugar de un String normal porque es mucho más eficiente para concatenar texto dentro de un bucle.
         * Evita crear múltiples objetos innecesarios en la memoria.
         * */
        StringBuilder sb = new StringBuilder();

        // Recorremos la lista de equipos y verificamos el tipo de cada uno usando 'instanceof'
        for (Equipo e : listaEquipos) {
            boolean agregar = false;
            // 'instanceof' verifica si el objeto en la lista coincide con la clase hija
            if (tipoBuscado == 1 && e instanceof Desktop) agregar = true;
            else if (tipoBuscado == 2 && e instanceof Laptop) agregar = true;
            else if (tipoBuscado == 3 && e instanceof Tablet) agregar = true;

            if (agregar) {
                // Se ejecuta el toString() específico de la subclase y se agrega al StringBuilder
                sb.append(e.toString()).append("\n----------------------\n");
            }
        }
        // Si el StringBuilder está vacío, significa que no hubo coincidencias
        return sb.length() > 0 ? sb.toString() : "No hay equipos registrados en esta categoría.";
    }

}
