package CapaNegocio;

import CapaDTO.Stock;
import CapaConexion.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class NegocioStock {
    
    ConexionMySQL conec = new ConexionMySQL();
    
    public void initConection() {
        conec.setNombreBaseDatos("jdbc:mysql://localhost:8025/gestioninventariooxxo");
        conec.setNombreTabla("stock");
        conec.setCadenaConexion("com.mysql.cj.jdbc.Driver");
        conec.setUsuario("root");
        conec.setPass("GrupoSom2024");
    }
    
    public void llenarTabla(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        initConection();
        conec.setCadenaSQL(
                "SELECT "
                + "s.id AS id_stock, "
                + "p.nombre, "
                + "s.cantidad "
                + "FROM stock s "
                + "JOIN productos p ON s.id_producto = p.id;");
        
        System.out.println(conec.getCadenaSQL());
        conec.setEsSelect(true);
        conec.conectar();
        ResultSet rs = conec.getDbresultSet();
        
        try {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_stock"),
                    rs.getString("nombre"),
                    rs.getString("cantidad")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo recorrer el ResultSet:" + ex.getMessage());
        }
    }
    
    public Stock buscarStock(String id) {
        initConection();
        conec.setCadenaSQL("SELECT * FROM stock WHERE id ='" + id + "';");
        conec.setEsSelect(true);
        conec.conectar();
        ResultSet rs = conec.getDbresultSet();
        Stock s = new Stock();
        
        try {
            while (rs.next()) {
                s.setId(rs.getInt("id"));
                s.setId_producto(rs.getInt("id_producto"));
                s.setCantidad(rs.getInt("cantidad"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo recorrer el ResultSet:" + ex.getMessage());
        }
        return s;
    }
    
    public void actualizarStock(Stock stockActual, Stock stockNuevo) {
        initConection();
        conec.setCadenaSQL("UPDATE stock SET "
                + "id_producto ='" + stockNuevo.getId_producto() + "', "
                + "cantidad = '" + stockNuevo.getCantidad() + "' "
                + "WHERE id = '" + stockActual.getId() + "';");
        conec.setEsSelect(false);
        
        try {
            conec.conectar();
            JOptionPane.showMessageDialog(null, "Se actualizaron los datos del stock correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudieron actualizar los datos. Error: " + e.getMessage());
        }
    }
    
    public void agregarStock(JTable tabla) {
        initConection();
        conec.setCadenaSQL("INSERT INTO stock (id_producto, cantidad) VALUES ('"
                + JOptionPane.showInputDialog("Ingrese el ID del producto") + "', '"
                + JOptionPane.showInputDialog("Ingrese la cantidad") + "');");
        
        System.out.println(conec.getCadenaSQL());
        conec.setEsSelect(false);
        
        try {
            conec.conectar();
            llenarTabla(tabla);
            JOptionPane.showMessageDialog(null, "Se agregó el nuevo stock correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el stock. Error: " + e.getMessage());
        }
    }
    
    public void eliminarStock(String id, JTable tabla) {
        initConection();
        conec.setCadenaSQL("DELETE FROM stock WHERE id = '" + id + "';");
        conec.setEsSelect(false);
        
        try {
            conec.conectar();
            llenarTabla(tabla);
            JOptionPane.showMessageDialog(null, "Se eliminó el stock correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el stock. Error: " + e.getMessage());
        }
    }
}