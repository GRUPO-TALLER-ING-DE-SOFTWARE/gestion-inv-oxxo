package CapaDTO;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Venta {
    // Atributos principales
    private int id;
    private Date fecha;
    private double total;
    private String estado;
    private List<DetalleVenta> detalles;
    
    // Constructor vacío
    public Venta() {
        this.detalles = new ArrayList<>();
    }
    
    // Constructor completo
    public Venta(int id, Date fecha, double total, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
        this.detalles = new ArrayList<>();
    }
    
    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }
    
    // Método para agregar un detalle a la venta
    public void agregarDetalle(DetalleVenta detalle) {
        this.detalles.add(detalle);
        calcularTotal();
    }
    
    // Método para calcular el total de la venta
    private void calcularTotal() {
        this.total = detalles.stream()
                .mapToDouble(detalle -> detalle.getCantidad() * detalle.getPrecioUnitario())
                .sum();
    }
}