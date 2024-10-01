package com.inventario.gui;

import javax.swing.*;
import java.awt.*;
import com.inventario.model.*;

public class ProductRegistrationFrame extends JFrame {
    // Componentes de la interfaz gráfica
    private JTextField idField;      // Campo de texto para ingresar el ID del producto
    private JTextField nameField;    // Campo de texto para el nombre del producto
    private JTextField priceField;   // Campo de texto para el precio del producto
    private JTextField quantityField; // Campo de texto para la cantidad del producto
    private JButton saveButton;      // Botón para guardar el producto

    private ProductTableModel tableModel;  // Modelo de la tabla donde se muestran los productos
    private JTable productTable;  // La tabla para mostrar los productos guardados

    public ProductRegistrationFrame() {
        // Configuración inicial de la ventana
        setTitle("Registro de Productos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Cerrar aplicación al cerrar la ventana
        setLocationRelativeTo(null);  // Centrar la ventana

        initComponents();  // Método que crea y organiza todos los componentes de la interfaz
    }

    private void initComponents() {
        // Creamos un panel principal para el formulario
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Espacio entre los componentes

        // Crear etiquetas y campos de texto
        JLabel idLabel = new JLabel("Id del producto:");
        idField = new JTextField(20);  // Campo de texto para el ID

        JLabel nameLabel = new JLabel("Nombre del producto:");
        nameField = new JTextField(20);  // Campo de texto para el nombre

        JLabel priceLabel = new JLabel("Precio del producto:");
        priceField = new JTextField(20);  // Campo de texto para el precio

        JLabel quantityLabel = new JLabel("Cantidad del producto:");
        quantityField = new JTextField(20);  // Campo de texto para la cantidad

        saveButton = new JButton("Guardar");  // Botón para guardar el producto

        // Añadir los componentes al panel con posiciones usando GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(idLabel, gbc);  // Añadir la etiqueta de ID
        gbc.gridx = 1;
        panel.add(idField, gbc);  // Añadir el campo de ID

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(nameLabel, gbc);  // Añadir la etiqueta del nombre
        gbc.gridx = 1;
        panel.add(nameField, gbc);  // Añadir el campo de nombre

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(priceLabel, gbc);  // Añadir la etiqueta del precio
        gbc.gridx = 1;
        panel.add(priceField, gbc);  // Añadir el campo de precio

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(quantityLabel, gbc);  // Añadir la etiqueta de cantidad
        gbc.gridx = 1;
        panel.add(quantityField, gbc);  // Añadir el campo de cantidad

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(saveButton, gbc);  // Añadir el botón de guardar

        // Crear el modelo de la tabla y la tabla
        tableModel = new ProductTableModel();  // Crea un modelo de tabla para manejar los productos
        productTable = new JTable(tableModel);  // Crea una tabla que usa ese modelo

        // Añadir la tabla dentro de un panel con barra de desplazamiento
        JScrollPane tableScrollPane = new JScrollPane(productTable);
        tableScrollPane.setPreferredSize(new Dimension(500, 200));  // Tamaño del área de la tabla

        // Añadir los componentes de la interfaz gráfica al marco
        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);  // Añadir el formulario en la parte superior
        add(tableScrollPane, BorderLayout.CENTER);  // Añadir la tabla en el centro

        // Añadir acción al botón "Guardar"
        saveButton.addActionListener(e -> saveProduct());  // Ejecutar el método saveProduct cuando se presiona el botón
    }

    // Método para guardar el producto
    private void saveProduct() {
        // Verificar que todos los campos estén llenos
        if (idField.getText().trim().isEmpty() ||
                nameField.getText().trim().isEmpty() ||
                priceField.getText().trim().isEmpty() ||
                quantityField.getText().trim().isEmpty()) {

            // Si algún campo está vacío, mostrar un mensaje de error
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Detener el proceso de guardado si hay campos vacíos
        }

        // Convertir los valores ingresados a sus respectivos tipos (ID y cantidad a entero, precio a double)
        try {
            int idProd = Integer.parseInt(idField.getText());
            String nameProd = nameField.getText();
            double priceProd = Double.parseDouble(priceField.getText());
            int quantityProd = Integer.parseInt(quantityField.getText());

            // Crear un nuevo producto con los datos ingresados
            Product product = new Product(idProd, nameProd, priceProd, quantityProd);

            // Añadir el producto a la tabla
            tableModel.addProduct(product);  // Añadir el producto al modelo de la tabla

            // Limpiar los campos de texto después de guardar
            idField.setText("");
            nameField.setText("");
            priceField.setText("");
            quantityField.setText("");

            // Mostrar un mensaje indicando que el producto se guardó correctamente
            JOptionPane.showMessageDialog(this, "Producto guardado correctamente");
        } catch (NumberFormatException e) {
            // Si hay algún error al convertir números, mostrar un mensaje de error
            JOptionPane.showMessageDialog(this, "Error en los datos numéricos, verifique e intente nuevamente.");
        }
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProductRegistrationFrame().setVisible(true);  // Crear y mostrar la ventana del formulario
        });
    }
}
