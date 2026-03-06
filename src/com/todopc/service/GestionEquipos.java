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


        if(fabricante.isEmpty() || modelo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Los datos no pueden quedar vacíos.");
            return;
        }

        String microprocesador = JOptionPane.showInputDialog("Ingrese el Microprocesador:");

        if (tipo == 1) {
            String memoria = JOptionPane.showInputDialog("Ingrese la Memoria:");
            String tarjetagrafica = JOptionPane.showInputDialog("Ingrese la Tarjeta Gráfica:");
            String tamanoTorre = JOptionPane.showInputDialog("Ingrese el tamaño de la torre:");
            String capacidadDisco = JOptionPane.showInputDialog("Ingrese la Capacidad de Disco:");
            Desktop nuevaDesktop = new Desktop(fabricante, modelo, microprocesador, memoria, tarjetagrafica, tamanoTorre, capacidadDisco);
            agregarEquipo(nuevaDesktop);
            JOptionPane.showMessageDialog(null, "Desktop registrada exitosamente.");

        } else if (tipo == 2) {
            String memoria = JOptionPane.showInputDialog("Ingrese el Memoria:");
            String tamanoPantalla = JOptionPane.showInputDialog("Ingrese el tamaño de la pantalla:");
            String capacidadDisco = JOptionPane.showInputDialog("Ingrese la Capacidad de Disco:");

            Laptop nuevaLaptop = new Laptop(fabricante, modelo, microprocesador, memoria, tamanoPantalla, capacidadDisco);
            agregarEquipo(nuevaLaptop);
            JOptionPane.showMessageDialog(null, "Laptop registrada exitosamente.");

        } else if (tipo == 3) {
            // La tabla no pide Memoria RAM estándar para Tablet, le pasamos "N/A" al constructor padre
            String memoria = "N/A";
            String tamanoDiagonal = JOptionPane.showInputDialog("Ingrese el tamaño diagonal de pantalla:");
            String tipoPantalla = JOptionPane.showInputDialog("¿Es Capacitiva o Resistiva?");
            String memoriaNAND = JOptionPane.showInputDialog("Ingrese el tamaño de memoria NAND:");
            String sistemaOperativo = JOptionPane.showInputDialog("Ingrese el Sistema Operativo:");

            Tablet nuevaTablet = new Tablet(fabricante, modelo, microprocesador, memoria, tamanoDiagonal, tipoPantalla, memoriaNAND, sistemaOperativo);
            agregarEquipo(nuevaTablet);
            JOptionPane.showMessageDialog(null, "Tablet registrada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de equipo inválido.");
        }
    }

    // Listar equipos en orden segun su instanceof
    // Listar equipos según su tipo (Desktop, Laptop o Tablet)
    public void listarEquipos() {
        // Verificamos si la lista está vacía
        if (listaEquipos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay equipos registrados en el sistema actualmente.");
            return;
        }

        // Preguntamos qué tipo de equipo desea ver (Requisito del PDF)
        String tipoStr = JOptionPane.showInputDialog(
                "¿Qué tipo de equipo desea ver?\n" +
                        "1. Desktops\n" +
                        "2. Laptops\n" +
                        "3. Tablets"
        );

        if (tipoStr == null) return; // Si el usuario presiona "Cancelar"
        int tipo = Integer.parseInt(tipoStr);

        // Variable para acumular el texto que mostraremos
        String listado = "";
        boolean encontrados = false; // Bandera para saber si encontramos al menos uno

        // Recorremos el ArrayList y filtramos con instanceof
        for (Equipo equipo : listaEquipos) {

            if (tipo == 1 && equipo instanceof Desktop) {
                listado += "=== DESKTOP ===\n" + equipo.toString() + "\n\n";
                encontrados = true;

            } else if (tipo == 2 && equipo instanceof Laptop) {
                listado += "=== LAPTOP ===\n" + equipo.toString() + "\n\n";
                encontrados = true;

            } else if (tipo == 3 && equipo instanceof Tablet) {
                listado += "=== TABLET ===\n" + equipo.toString() + "\n\n";
                encontrados = true;
            }
        }

        // Apartado de mensaje de equipos no encontrados
        if (!encontrados) {
            JOptionPane.showMessageDialog(null, "No se encontraron equipos registrados de esta categoría.");
        } else {
            // Mostramos los equipos
            JOptionPane.showMessageDialog(null, listado, "Listado de Equipos", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
