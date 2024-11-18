/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;
import CapaConexion.ConexionMySQL; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lab301
 */
public class NegocioInventario {
    ConexionMySQL conec = new ConexionMySQL();
    public ResultSet selectInventario() {
        conec.setNombreBaseDatos("jdbc:mysql://localhost/GestionInvOXXO");
        conec.setNombreTabla("inventario");
        conec.setCadenaConexion("com.mysql.cj.jdbc.Driver");
        conec.setUsuario("root");
        conec.setPass("");
        conec.setCadenaSQL("SELECT * FROM inventario;");
        conec.setEsSelect(true);
        conec.conectar();
        return conec.getDbresultSet();
    }
    
    public void añadirElementosTabla(JTable tabla){
        ResultSet rs = selectInventario();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        try {
            while(rs.next()){
                model.addRow(new Object[]{rs.getString("id"), rs.getString("nombre"), rs.getString("categoria"),rs.getString("cantidad"),rs.getString("estado"),rs.getString("precio"),rs.getString("nivel_reorden")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No se pudo recorrer el ResultSet:" + ex.getMessage());
        }
    }//HAY QUE REVISAR EL TEMA DE LA BASE DE DATOS PARA PODER EXPORTAR Y TRABAJAR
}
