package com.todopc.view;

import com.todopc.model.Desktop;
import com.todopc.model.Laptop;
import com.todopc.model.Tablet;
import com.todopc.service.GestionEquipos;

import javax.swing.*;

/**
 * Esta clase se encargará de la interacción con el usuario, mostrando menús, solicitando datos y mostrando resultados.
 * Lógica de presentación: Aquí se implementará el método para mostrar el menú principal para solicitar y mostrar los datos de los equipos.
 * */

public class InterfazUsuario {

    //Instancia de la clase GestionEquipos para gestionar los equipos (simulación de inyección de dependencias)
    private GestionEquipos gestor;

    //Al crear una instancia de InterfazUsuario, se inicializa el gestor de equipos
    public  InterfazUsuario() {
        gestor = new GestionEquipos();
    }

    //-- MÉTODO DE VALIDACIÓN

    /**
     * Método para leer datos del usuario con validación para asegurarse de que no se ingresen valores vacíos o nulos.
     * */
    private String leerDato(String mensaje) {
        String input;
        do {
            input = JOptionPane.showInputDialog(mensaje);
            // Si el usuario presiona "Cancelar" o deja vacío el campo
            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error: El dato es obligatorio y no puede estar vacío.");
            }
        } while (input == null || input.trim().isEmpty());
        return input;
    }

    // --- MÉTODOS DE CAPTURA (TABLA 1) ---

    private Desktop solicitarDatosDesktop() {
        // Datos comunes (Clase Padre)
        String fab = leerDato("Fabricante:");
        String mod = leerDato("Modelo:");
        String cpu = leerDato("Microprocesador:");
        String ram = leerDato("Memoria RAM:");
        // Datos específicos (Tabla 1)
        String gpu = leerDato("Tarjeta Gráfica:");
        String tor = leerDato("Tamaño de Torre:");
        String dsc = leerDato("Capacidad Disco Duro:");
        return new Desktop(fab, mod, cpu, ram, gpu, tor, dsc);
    }

    private Laptop solicitarDatosLaptop() {
        String fab = leerDato("Fabricante:");
        String mod = leerDato("Modelo:");
        String cpu = leerDato("Microprocesador:");
        String ram = leerDato("Memoria RAM:");
        // Datos específicos (Tabla 1)
        String pan = leerDato("Tamaño Pantalla:");
        String dsc = leerDato("Capacidad Disco Duro:");
        return new Laptop(fab, mod, cpu, ram, pan, dsc);
    }

    private Tablet solicitarDatosTablet() {
        String fab = leerDato("Fabricante:");
        String mod = leerDato("Modelo:");
        String cpu = leerDato("Microprocesador:");
        String ram = leerDato("Memoria RAM:");
        // Datos específicos (Tabla 1)
        String dia = leerDato("Tamaño Diagonal Pantalla:");
        String tip = leerDato("¿Capacitiva o Resistiva?:");
        String nan = leerDato("Tamaño Memoria NAND:");
        String sos = leerDato("Sistema Operativo:");
        return new Tablet(fab, mod, cpu, ram, dia, tip, nan, sos);
    }

     //-- MÉTODO PARA MOSTRAR EL MENÚ PRINCIPAL
     public void mostrarMenu() {
         String[] opciones = {"Registrar Equipo", "Ver Equipos", "Salir"};
         int seleccion;

         do {
             // Mostramos el menú principal usando botones de JOptionPane
             seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "TODO PC - Sistema de Registro",
                     JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

             switch (seleccion) {
                 case 0: // Registrar
                     ejecutarSubMenuRegistro();
                     break;
                 case 1: // Ver
                     ejecutarSubMenuConsulta();
                     break;
                 case 2:
                     JOptionPane.showMessageDialog(null, "Gracias por usar TODO PC. ¡Hasta luego!");
                     break;
             }
         } while (seleccion != 2 && seleccion != -1); // 2 es Salir, -1 es cerrar ventana
     }

    private void ejecutarSubMenuRegistro() {
        String[] tipos = {"Desktop", "Laptop", "Tablet"};
        int tipo = JOptionPane.showOptionDialog(null, "Tipo de equipo a registrar:", "Registro",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);

        if (tipo == 0) gestor.registrarEquipo(solicitarDatosDesktop());
        else if (tipo == 1) gestor.registrarEquipo(solicitarDatosLaptop());
        else if (tipo == 2) gestor.registrarEquipo(solicitarDatosTablet());
    }

    private void ejecutarSubMenuConsulta() {
        String[] tipos = {"Desktop", "Laptop", "Tablet"};
        int tipo = JOptionPane.showOptionDialog(null, "Tipo de equipo a consultar:", "Consulta",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);

        if (tipo != -1) {
            // El gestor genera el texto y la interfaz lo muestra (Separación de responsabilidades)
            String reporte = gestor.obtenerReportePorInstancia(tipo + 1);
            JOptionPane.showMessageDialog(null, reporte);
        }
    }


}

