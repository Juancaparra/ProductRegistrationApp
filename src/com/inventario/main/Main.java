package com.inventario.main;  // Indica que esta clase pertenece al paquete 'com.inventario.main'.

import com.inventario.gui.ProductRegistrationFrame;  // Importa la clase que tiene la ventana de registro de productos.
import javax.swing.SwingUtilities;  // Importa la utilidad Swing que maneja la interfaz gráfica.

public class Main {  // La clase principal del programa.

    public static void main(String[] args) {  // El método principal que arranca el programa.

        // Aquí usamos `invokeLater` para decirle a Swing que ejecute el código de la interfaz gráfica de forma segura.
        SwingUtilities.invokeLater(() -> {
            // Creamos una nueva instancia de la ventana de registro de productos.
            ProductRegistrationFrame frame = new ProductRegistrationFrame();

            // Hacemos que la ventana sea visible en la pantalla para que el usuario la vea y use.
            frame.setVisible(true);
        });
    }
}

