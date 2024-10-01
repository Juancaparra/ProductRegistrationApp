package com.inventario.model;

import javax.swing.table.AbstractTableModel;  // Importa la clase AbstractTableModel para crear un modelo de tabla
import java.util.List;                         // Importa la interfaz List
import java.util.ArrayList;                    // Importa la clase ArrayList

// Clase que extiende AbstractTableModel para representar una tabla de productos
public class ProductTableModel extends AbstractTableModel {
    private final List<Product> productList;   // Lista que almacena los productos
    private final String[] columnNames = {"ID", "Nombre", "Precio", "Cantidad"};  // Nombres de las columnas

    // Constructor que inicializa la lista de productos
    public ProductTableModel() {
        this.productList = new ArrayList<>();  // Crea una nueva lista de productos
    }

    // Implementa el método que devuelve el número de filas (productos)
    @Override
    public int getRowCount() {
        return productList.size();  // Devuelve el tamaño de la lista de productos
    }

    // Implementa el método que devuelve el número de columnas
    @Override
    public int getColumnCount() {
        return columnNames.length;  // Devuelve la longitud del arreglo de nombres de columnas
    }

    // Implementa el método que devuelve el valor en una celda específica
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Obtiene el producto en la fila correspondiente
        Product product = productList.get(rowIndex);

        // Devuelve el valor adecuado según la columna solicitada
        switch (columnIndex) {
            case 0:
                return product.getId();        // Columna ID
            case 1:
                return product.getName();      // Columna Nombre
            case 2:
                return product.getPrice();     // Columna Precio
            case 3:
                return product.getQuantity();  // Columna Cantidad
            default:
                return null;  // Devuelve null si el índice de columna es inválido
        }
    }

    // Implementa el método que devuelve el nombre de la columna
    @Override
    public String getColumnName(int column) {
        return columnNames[column];  // Devuelve el nombre de la columna correspondiente
    }

    // Método para agregar un producto a la lista
    public void addProduct(Product product) {
        // Añadir producto a la lista
        productList.add(product);

        // Notificar que se ha añadido una nueva fila a la tabla
        fireTableRowsInserted(productList.size() - 1, productList.size() - 1);
    }

    // Método para obtener el producto en una fila específica (opcional)
    public Product getProductAt(int rowIndex) {
        return productList.get(rowIndex);  // Devuelve el producto en la fila especificada
    }
}
