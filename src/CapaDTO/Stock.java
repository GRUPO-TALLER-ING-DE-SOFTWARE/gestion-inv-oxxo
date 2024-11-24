package CapaDTO;

/**
 * Clase DTO (Data Transfer Object) para la entidad Stock
 * @author oscar
 */
public class Stock {
    // Atributos
    private int id;
    private int id_producto;
    private int cantidad;
    
    // Constructor vacío
    public Stock() {
    }
    
    // Constructor con todos los campos
    public Stock(int id, int id_producto, int cantidad) {
        this.id = id;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }
    
    // Constructor sin id (útil para inserciones donde el id es autoincremental)
    public Stock(int id_producto, int cantidad) {
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }
    
    // Getters y Setters
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
    
    // Método toString para facilitar la depuración
    @Override
    public String toString() {
        return "Stock{" + 
                "id=" + id + 
                ", id_producto=" + id_producto + 
                ", cantidad=" + cantidad + 
                '}';
    }
    
    // Método para clonar un objeto Stock
    public Stock clonar() {
        return new Stock(this.id, this.id_producto, this.cantidad);
    }
}