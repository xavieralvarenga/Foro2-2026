package com.todopc.service;

import com.todopc.model.Desktop;
import com.todopc.model.Equipo;
import com.todopc.model.Laptop;
import com.todopc.model.Tablet;

import javax.swing.*;
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
    // Método auxiliar para registrar usando JOptionPane
    public void registrarNuevoEquipo() {
        String tipoStr = JOptionPane.showInputDialog(
                "¿Qué tipo de equipo desea registrar?\n" +
                        "1. Desktop\n" +
                        "2. Laptop\n" +
                        "3. Tablet"
        );

        if (tipoStr == null) return; // Si cancela, regresamos al menú principal

        int tipo = Integer.parseInt(tipoStr);


        String fabricante = JOptionPane.showInputDialog("Ingrese el Fabricante:");
        String modelo = JOptionPane.showInputDialog("Ingrese el Modelo:");
        String microprocesador = JOptionPane.showInputDialog("Ingrese el Microprocesador:");
        String memoria = JOptionPane.showInputDialog("Ingrese el Memoria:");
        String tarjetagrafica = JOptionPane.showInputDialog("Ingrese el Tarjeta de Grafica:");

        String capacidadDisco = JOptionPane.showInputDialog("Ingrese el Capacidad Grafica:");


        if(fabricante.isEmpty() || modelo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Los datos no pueden quedar vacíos.");
            return;
        }


        if (tipo == 1) {
            String tamanoTorre = JOptionPane.showInputDialog("Ingrese el tamaño de la torre:");

            Desktop nuevaDesktop = new Desktop(fabricante, modelo, microprocesador,memoria,tarjetagrafica,tamanoTorre,capacidadDisco);

            agregarEquipo(nuevaDesktop);
            JOptionPane.showMessageDialog(null, "Desktop registrada exitosamente.");

        } else if (tipo == 2) {
            // Lógica para pedir datos de Laptop e instanciarla
            // Laptop nuevaLaptop = new Laptop(...);
            // gestion.agregarEquipo(nuevaLaptop);

        } else if (tipo == 3) {
            // Lógica para pedir datos de Tablet e instanciarla
            // Tablet nuevaTablet = new Tablet(...);
            // gestion.agregarEquipo(nuevaTablet);
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de equipo inválido.");
        }
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
                System.out.println(e.toString());
            } else if (e instanceof Laptop) {
                System.out.println("LAPTOP");
                System.out.println(e.toString());
            } else if (e instanceof Tablet) {
                System.out.println("TABLET");
                System.out.println(e.toString());
            }

            System.out.println("-------------------------");
        }
    }
}
