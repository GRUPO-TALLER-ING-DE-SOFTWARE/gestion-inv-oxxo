/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.Inventario;
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
    
    public void initConection(){
        conec.setNombreBaseDatos("jdbc:mysql://localhost/GestionInventarioOXXO"); // Este link va directamente relacionado con la base de datos que vamos a crear en XAMPP (phpMyAdmin), si no saben como poner el link dejenlo asi no más con un comentario poniendo lo que esperaban hacer, yo lo arreglo :D
        conec.setNombreTabla("productos"); // No tiene mucho rodeo, aqui hay que cambiar por el nombre de la tabla perteneciente al Negocio.
        conec.setCadenaConexion("com.mysql.cj.jdbc.Driver"); // Nada que cambiar, hay un error que sale a veces que sugiere cambiarlo, si quieren lo hacen, si no, no no más.
        conec.setUsuario("root"); // Por defecto
        conec.setPass(""); // Por defecto
    }
    
    public void /* Las funciones se instancian asi, public <tipo de dato a devolver>*/ llenarTabla(JTable table /* Aca se ponen los datos que se esperan recoger al momento de la ejecución de la función, se pueden usar directamente en la logica. */){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        initConection(); // Inicio de conexión para poder hacer la consulta SQL
        conec.setCadenaSQL("SELECT * FROM inventario;"); // Esto es una consulta SQL, con esto se pueden guiar para hacer las demas
        conec.setEsSelect(true); // consultas. Solamente los SELECT devuelven un valor ResultSet en el conec.getDbresultSet(). Acordarse siempre de confirmar el valor conec.setEsSelect() para que no hayan errores.
        conec.conectar();
        ResultSet rs = conec.getDbresultSet();
        try { // Para que un sistema no se caiga y avise del fallo al usuario, usamos try... catch, nos sirve para intentar correr el código y ante cualquier error, lo recoge y lo notifica.
            while(rs.next()){ // Esta es la forma de recorrer el ResultSet que entrega un SELECT
               model.addRow(new Object[]{rs.getString("id"), // Para recoger los valores del ResultSet, tenemos amplia gama de .get<tipo de dato>, creo que estan todos. Pueden hacerlo por el nombre de la columna en la base de datos o por el número. Recomiendo usar el nombre. 
                                        rs.getString("nombre"), 
                                        rs.getString("categoria"), 
                                        rs.getString("cantidad"),
                                        rs.getString("estado"),
                                        rs.getString("precio"),
                                        rs.getString("nivel_reorden")}); 
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No se pudo recorrer el ResultSet:" + ex.getMessage()); // El JOptionPane es una pantallita anexa que aparece para mostrar el error en este caso. Hay varios tipos por si quieren lograr algo. El que me parece más util es el showConfirmDialog, funciona re bien para confirmar eliminaciones o acciones peligrosas.
        }
    }
    
    public Inventario buscarProducto(String id){
        initConection();
        conec.setCadenaSQL("SELECT * FROM inventario WHERE id ='"+id+"' ;");
        conec.setEsSelect(true);
        conec.conectar();
        ResultSet rs = conec.getDbresultSet();
        Inventario i = new Inventario();
        try {
            while(rs.next()){
                i.setId(rs.getInt("id"));
                i.setNombre(rs.getString("nombre"));
                i.setCategoria(rs.getString("categoria"));
                i.setCantidad(rs.getInt("cantidad"));
                i.setEstado(rs.getString("estado"));
                i.setPrecio(rs.getFloat("precio"));
                i.setNivel_reorden(rs.getInt("nivel_reorden"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo recorrer el ResultSet:" + ex.getMessage());
        }
        return i;
    }
}


