package com.inventario.model;

// Clase que representa un producto en el inventario
public class Product {
    // Campos privados que almacenan la información del producto
    private int id;          // Identificador único del producto
    private String name;     // Nombre del producto
    private double price;    // Precio del producto
    private int quantity;     // Cantidad disponible del producto

    // Constructor de la clase que inicializa los campos del producto
    public Product(int id, String name, double price, int quantity) {
        this.id = id;             // Asigna el id al producto
        this.name = name;         // Asigna el nombre al producto
        this.price = price;       // Asigna el precio al producto
        this.quantity = quantity;  // Asigna la cantidad al producto
    }

    // Métodos "getter" y "setter" para acceder y modificar los campos

    public int getId() {
        return id;  // Devuelve el id del producto
    }

    public void setId(int id) {
        this.id = id;  // Establece un nuevo id para el producto
    }

    public String getName() {
        return name;  // Devuelve el nombre del producto
    }

    public void setName(String name) {
        this.name = name;  // Establece un nuevo nombre para el producto
    }

    public double getPrice() {
        return price;  // Devuelve el precio del producto
    }

    public void setPrice(double price) {
        this.price = price;  // Establece un nuevo precio para el producto
    }

    public int getQuantity() {
        return quantity;  // Devuelve la cantidad disponible del producto
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;  // Establece una nueva cantidad para el producto
    }
}
