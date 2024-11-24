package CapaDTO;

/**
 * Clase DTO (Data Transfer Object) para la entidad Stock
 * @author oscar
 */
public class Stock {
    private int id;              // ID del stock
    private int id_producto;     // ID del producto asociado al stock
    private int cantidad;        // Cantidad en stock

    // Constructor por defecto
    public Stock() {
    }

    // Constructor con parámetros
    public Stock(int id, int id_producto, int cantidad) {
        this.id = id;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }

    // Getters y setters para cada atributo
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Método toString para mostrar la información del objeto de manera legible
    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", id_producto=" + id_producto +
                ", cantidad=" + cantidad +
                '}';
    }
  }
 

