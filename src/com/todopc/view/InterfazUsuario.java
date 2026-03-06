package com.todopc.view;

/**
 * Esta clase se encargará de la interacción con el usuario, mostrando menús, solicitando datos y mostrando resultados.
 * Lógica de presentación: Aquí se implementará el método para mostrar el menú principal para solicitar y mostrar los datos de los equipos.
 * */


import javax.swing.JOptionPane;

public class InterfazUsuario {

    public void mostrarMenu() {

        int opcion;

        do {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENU PRINCIPAL\n\n" +
                            "1. Registrar equipo\n" +
                            "2. Ver equipos\n" +
                            "3. Salir "
            ));

            switch (opcion) {

                case 1:
                    registrarEquipo();
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "Aquí se mostrarán los equipos");
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");

            }

        } while (opcion != 3);
    }

    public void registrarEquipo() {

        int tipo = Integer.parseInt(JOptionPane.showInputDialog(
                "Seleccione tipo de equipo\n\n" +
                        "1. Desktop\n" +
                        "2. Laptop\n" +
                        "3. Tablet"
        ));

        String marca = JOptionPane.showInputDialog("Ingrese la marca del equipo");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo del equipo");

        switch (tipo) {

            case 1:
                JOptionPane.showMessageDialog(null,
                        "Desktop registrado\nMarca: " + marca + "\nModelo: " + modelo);
                break;

            case 2:
                JOptionPane.showMessageDialog(null,
                        "Laptop registrada\nMarca: " + marca + "\nModelo: " + modelo);
                break;

            case 3:
                JOptionPane.showMessageDialog(null,
                        "Tablet registrada\nMarca: " + marca + "\nModelo: " + modelo);
                break;

            default:
                JOptionPane.showMessageDialog(null, "Tipo inválido");

        }
    }
}

