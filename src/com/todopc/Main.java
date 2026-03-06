package com.todopc;

import com.todopc.view.InterfazUsuario;

/**
 * Esta clase es el punto de entrada de la aplicación, donde se inicializará la interfaz de usuario y se gestionarán las interacciones.
 * Lógica de control: Aquí se implementará el método main para iniciar la aplicación, crear instancias de InterfazUsuario y GestionEquipos,
 * Para manejar la lógica de control del programa.
 */
public class Main {
    public static void main(String[] args) {

        InterfazUsuario interfaz = new InterfazUsuario();
        interfaz.mostrarMenu();

    }

}
