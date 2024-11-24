package CapaDTO;

public class DetalleVenta {
    private int id;
    private int idVenta;
    private int idProducto;
    private String nombreProducto;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
    
    // Constructor vacío
    public DetalleVenta() {
    }
    
    // Constructor completo
    public DetalleVenta(int id, int idVenta, int idProducto, String nombreProducto, 
            int cantidad, double precioUnitario) {
        this.id = id;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.calcularSubtotal();
    }
    
    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.calcularSubtotal();
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
        this.calcularSubtotal();
    }
    
    public double getSubtotal() {
        return subtotal;
    }
    
    // Método para calcular el subtotal
    private void calcularSubtotal() {
        this.subtotal = this.cantidad * this.precioUnitario;
    }
}