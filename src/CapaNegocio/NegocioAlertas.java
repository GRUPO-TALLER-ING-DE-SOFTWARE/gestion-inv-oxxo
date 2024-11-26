package CapaNegocio;

import CapaDTO.Alerta;
import CapaConexion.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NegocioAlertas {

    ConexionMySQL conec = new ConexionMySQL();

    // Configuración de la conexión
    public void initConection() {
        conec.setNombreBaseDatos("jdbc:mysql://localhost:8025/gestioninventariooxxo");
        conec.setNombreTabla("alertas");
        conec.setCadenaConexion("com.mysql.cj.jdbc.Driver");
        conec.setUsuario("root");
        conec.setPass("GrupoSom2024");
    }

    // Método para llenar la tabla de alertas activas
    public void llenarTablaAlertasActivas(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        initConection();
        conec.setCadenaSQL("SELECT id, descripcion, fecha, prioridad FROM alertas WHERE estado = 'Activa';");
        conec.setEsSelect(true);
        conec.conectar();
        ResultSet rs = conec.getDbresultSet();

        try {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("descripcion"),
                    rs.getString("fecha"),
                    rs.getString("prioridad")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener alertas activas: " + ex.getMessage());
        }
    }

    // Método para llenar la tabla del historial de alertas
    public void llenarTablaHistorialAlertas(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        initConection();
        conec.setCadenaSQL("SELECT id, descripcion, fecha, prioridad FROM alertas WHERE estado = 'Cerrada';");
        conec.setEsSelect(true);
        conec.conectar();
        ResultSet rs = conec.getDbresultSet();

        try {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("descripcion"),
                    rs.getString("fecha"),
                    rs.getString("prioridad")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener el historial de alertas: " + ex.getMessage());
        }
    }

    // Método para cerrar una alerta
    public void cerrarAlerta(int id) {
        initConection();
        conec.setCadenaSQL("UPDATE alertas SET estado = 'Cerrada' WHERE id = " + id + ";");
        conec.setEsSelect(false);

        try {
            conec.conectar();
            JOptionPane.showMessageDialog(null, "Alerta cerrada correctamente.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la alerta: " + ex.getMessage());
        }
    }

    // Método para buscar una alerta específica
    public Alerta buscarAlerta(int id) {
        initConection();
        conec.setCadenaSQL("SELECT * FROM alertas WHERE id = " + id + ";");
        conec.setEsSelect(true);
        conec.conectar();
        ResultSet rs = conec.getDbresultSet();
        Alerta alerta = new Alerta();

        try {
            while (rs.next()) {
                alerta.setId(rs.getInt("id"));
                alerta.setDescripcion(rs.getString("descripcion"));
                alerta.setFecha(rs.getString("fecha"));
                alerta.setPrioridad(rs.getString("prioridad"));
                alerta.setEstado(rs.getString("estado"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la alerta: " + ex.getMessage());
        }

        return alerta;
    }
}
