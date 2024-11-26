package CapaNegocio;

import CapaDTO.Venta;
import CapaDTO.DetalleVenta;
import CapaConexion.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NegocioVenta {
    
    private ConexionMySQL conec;
    
    public NegocioVenta() {
        conec = new ConexionMySQL();
        initConection();
    }
    
    private void initConection() {
        conec.setNombreBaseDatos("jdbc:mysql://localhost:8025/gestioninventariooxxo");
        conec.setNombreTabla("ventas");
        conec.setCadenaConexion("com.mysql.cj.jdbc.Driver");
        conec.setUsuario("root");
        conec.setPass("GrupoSom2024");
    }
    
    public void llenarTablaVenta(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Limpiar tabla
        
        conec.setCadenaSQL(
            "SELECT dv.id_producto, p.nombre as producto, dv.cantidad, " +
            "p.precio as precio_unitario, (dv.cantidad * p.precio) as precio_total " +
            "FROM detalle_venta dv " +
            "JOIN productos p ON dv.id_producto = p.id " +
            "WHERE dv.id_venta = (SELECT MAX(id) FROM ventas WHERE estado = 'PENDIENTE')");
        
        conec.setEsSelect(true);
        conec.conectar();
        ResultSet rs = conec.getDbresultSet();
        
        try {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("producto"),
                    rs.getInt("cantidad"),
                    rs.getDouble("precio_unitario"),
                    rs.getDouble("precio_total")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar la tabla: " + ex.getMessage());
        }
    }
    
    public void agregarProductoAVenta(int idProducto, int cantidad) {
        // Primero verificamos si hay stock suficiente
        if (!verificarStock(idProducto, cantidad)) {
            JOptionPane.showMessageDialog(null, "No hay suficiente stock disponible");
            return;
        }
        
        // Verificamos si hay una venta pendiente
        int idVenta = obtenerVentaPendiente();
        if (idVenta == -1) {
            // Crear nueva venta
            idVenta = crearNuevaVenta();
        }
        
        // Agregar detalle de venta
        agregarDetalleVenta(idVenta, idProducto, cantidad);
    }
    
    private boolean verificarStock(int idProducto, int cantidad) {
        conec.setCadenaSQL("SELECT cantidad FROM stock WHERE id_producto = " + idProducto);
        conec.setEsSelect(true);
        conec.conectar();
        
        try {
            ResultSet rs = conec.getDbresultSet();
            if (rs.next()) {
                return rs.getInt("cantidad") >= cantidad;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar stock: " + ex.getMessage());
        }
        return false;
    }
    
    private int obtenerVentaPendiente() {
        conec.setCadenaSQL("SELECT id FROM ventas WHERE estado = 'PENDIENTE' ORDER BY id DESC LIMIT 1");
        conec.setEsSelect(true);
        conec.conectar();
        
        try {
            ResultSet rs = conec.getDbresultSet();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener venta pendiente: " + ex.getMessage());
        }
        return -1;
    }
    
    private int crearNuevaVenta() {
        conec.setCadenaSQL("INSERT INTO ventas (fecha, estado, total) VALUES (NOW(), 'PENDIENTE', 0)");
        conec.setEsSelect(false);
        conec.conectar();
        
        // Obtener el ID de la venta creada
        conec.setCadenaSQL("SELECT LAST_INSERT_ID() as id");
        conec.setEsSelect(true);
        conec.conectar();
        
        try {
            ResultSet rs = conec.getDbresultSet();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear nueva venta: " + ex.getMessage());
        }
        return -1;
    }
    
    private void agregarDetalleVenta(int idVenta, int idProducto, int cantidad) {
        conec.setCadenaSQL(
            "INSERT INTO detalle_venta (id_venta, id_producto, cantidad) " +
            "VALUES (" + idVenta + ", " + idProducto + ", " + cantidad + ")");
        conec.setEsSelect(false);
        
        try {
            conec.conectar();
            actualizarStock(idProducto, cantidad);
            actualizarTotalVenta(idVenta);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar detalle: " + ex.getMessage());
        }
    }
    
    private void actualizarStock(int idProducto, int cantidad) {
        conec.setCadenaSQL(
            "UPDATE stock SET cantidad = cantidad - " + cantidad + 
            " WHERE id_producto = " + idProducto);
        conec.setEsSelect(false);
        conec.conectar();
    }
    
    private void actualizarTotalVenta(int idVenta) {
        conec.setCadenaSQL(
            "UPDATE ventas v SET total = (" +
            "SELECT SUM(d.cantidad * p.precio) " +
            "FROM detalle_venta d " +
            "JOIN productos p ON d.id_producto = p.id " +
            "WHERE d.id_venta = v.id) " +
            "WHERE v.id = " + idVenta);
        conec.setEsSelect(false);
        conec.conectar();
    }
    
    public double calcularVuelto(double pagoCon, int idVenta) {
        conec.setCadenaSQL("SELECT total FROM ventas WHERE id = " + idVenta);
        conec.setEsSelect(true);
        conec.conectar();
        
        try {
            ResultSet rs = conec.getDbresultSet();
            if (rs.next()) {
                double total = rs.getDouble("total");
                return pagoCon - total;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al calcular vuelto: " + ex.getMessage());
        }
        return 0;
    }
    
    public void registrarVenta(int idVenta, double pagoCon) {
        double vuelto = calcularVuelto(pagoCon, idVenta);
        if (vuelto < 0) {
            JOptionPane.showMessageDialog(null, "El pago es insuficiente");
            return;
        }
        
        conec.setCadenaSQL(
            "UPDATE ventas SET estado = 'COMPLETADA', " +
            "pago_con = " + pagoCon + ", " +
            "vuelto = " + vuelto + " " +
            "WHERE id = " + idVenta);
        conec.setEsSelect(false);
        
        try {
            conec.conectar();
            JOptionPane.showMessageDialog(null, "Venta registrada con éxito\nVuelto: $" + vuelto);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar venta: " + ex.getMessage());
        }
    }
}