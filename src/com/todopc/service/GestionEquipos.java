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
    // ArrayList donde se guardaran los equipos
    private ArrayList<Equipo> listaEquipos;

    public GestionEquipos() {
        listaEquipos = new ArrayList<>();
    }

    // Agregar equipo
    public void agregarEquipo(Equipo equipo) {
        listaEquipos.add(equipo);
    }

    // Listar equipos en orden segun su instanceof
    public void listarEquipos() {
        if (listaEquipos.isEmpty()) {
            System.out.println("No hay equipos registrados");
            return;
        }

        for (Equipo e: listaEquipos) {
            if (e instanceof Desktop) {
                System.out.println("DESKTOP");
                System.out.println(e);
            } else if (e instanceof Laptop) {
                System.out.println("LAPTOP");
                System.out.println(e);
            } else if (e instanceof Tablet) {
                System.out.println("TABLET");
                System.out.println(e);
            }

            System.out.println("-------------------------");
        }
    }
}
