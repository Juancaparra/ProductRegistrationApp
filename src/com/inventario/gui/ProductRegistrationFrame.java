package com.inventario.gui;

import javax.swing.*;
import java.awt.*;
import com.inventario.model.*;

public class ProductRegistrationFrame extends JFrame {
    // Declara los componentes de la UI
    private JTextField idField;
    private JTextField nameField;
    private JTextField priceField;
    private JTextField quantityField;
    private JTextField saveButton;

    public ProductRegistrationFrame() {
        setTitle("Registro de Productos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        // Crear un panel principal
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Crear y agregar componentes
        JLabel idLabel = new JLabel("Id del producto:");
        JTextField idField = new JTextField(20);
        JLabel nameLabel = new JLabel("Nombre del producto:");
        JTextField nameField = new JTextField(20);
        JLabel priceLabel = new JLabel("Precio del producto:");
        JTextField priceField = new JTextField(20);
        JLabel quantityLabel = new JLabel("Cantidad del producto:");
        JTextField quantityField = new JTextField(20);
        JButton saveButton = new JButton("Guardar");

        // Posicionar componentes en el panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(idLabel, gbc);

        gbc.gridx = 1;
        panel.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(priceLabel, gbc);

        gbc.gridx = 1;
        panel.add(priceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(quantityLabel, gbc);

        gbc.gridx = 1;
        panel.add(quantityField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(saveButton, gbc);

        // Agregar el panel al frame
        add(panel);

        // Añadir acción al botón de guardar
        saveButton.addActionListener(e -> saveProduct());
    }

    private void saveProduct() {
        // Implementa la lógica de guardado
        int idProd = Integer.parseInt(nameField.getText());
        String nameProd = nameField.getText();
        double priceProd = Double.parseDouble(priceField.getText());
        int quantityProd = Integer.parseInt(quantityField.getText()) ;


    }


    }
}