/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaDTO.Inventario;
import CapaConexion.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lab301
 */
public class NegocioInventario {

    ConexionMySQL conec = new ConexionMySQL();

    public void initConection() {
        conec.setNombreBaseDatos("jdbc:mysql://localhost:8025/gestioninventariooxxo"); // Este link va directamente relacionado con la base de datos que vamos a crear en XAMPP (phpMyAdmin), si no saben como poner el link dejenlo asi no más con un comentario poniendo lo que esperaban hacer, yo lo arreglo :D
        conec.setNombreTabla("inventario"); // No tiene mucho rodeo, aqui hay que cambiar por el nombre de la tabla perteneciente al Negocio.
        conec.setCadenaConexion("com.mysql.cj.jdbc.Driver"); // Nada que cambiar, hay un error que sale a veces que sugiere cambiarlo, si quieren lo hacen, si no, no no más.
        conec.setUsuario("root"); // Por defecto
        conec.setPass("GrupoSom2024"); // Por defecto
    }

    public void /* Las funciones se instancian asi, public <tipo de dato a devolver>*/ llenarTabla(JTable table /* Aca se ponen los datos que se esperan recoger al momento de la ejecución de la función, se pueden usar directamente en la logica. */) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        initConection(); // Inicio de conexión para poder hacer la consulta SQL
        conec.setCadenaSQL(
                "SELECT"
                + " i.id AS id_inventario,"
                + " p.nombre,"
                + " p.categoria,"
                + " i.cantidad,"
                + " i.estado,"
                + " p.precio,"
                + " i.nivel_reorden"
                + " FROM "
                + " inventario i"
                + " JOIN"
                + " productos p ON i.id_producto = p.id;"); // Esto es una consulta SQL, con esto se pueden guiar para hacer las demas
        System.out.println(conec.getCadenaSQL());
        conec.setEsSelect(true); // consultas. Solamente los SELECT devuelven un valor ResultSet en el conec.getDbresultSet(). Acordarse siempre de confirmar el valor conec.setEsSelect() para que no hayan errores.
        conec.conectar();
        ResultSet rs = conec.getDbresultSet();
        try { // Para que un sistema no se caiga y avise del fallo al usuario, usamos try... catch, nos sirve para intentar correr el código y ante cualquier error, lo recoge y lo notifica.
            while (rs.next()) { // Esta es la forma de recorrer el ResultSet que entrega un SELECT
                model.addRow(new Object[]{rs.getString("id_inventario"), // Para recoger los valores del ResultSet, tenemos amplia gama de .get<tipo de dato>, creo que estan todos. Pueden hacerlo por el nombre de la columna en la base de datos o por el número. Recomiendo usar el nombre. 
                    rs.getString("nombre"),
                    rs.getString("categoria"),
                    rs.getString("cantidad"),
                    rs.getString("estado"),
                    rs.getString("precio"),
                    rs.getString("nivel_reorden")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo recorrer el ResultSet:" + ex.getMessage()); // El JOptionPane es una pantallita anexa que aparece para mostrar el error en este caso. Hay varios tipos por si quieren lograr algo. El que me parece más util es el showConfirmDialog, funciona re bien para confirmar eliminaciones o acciones peligrosas.
        }
    }

    public Inventario buscarProducto(String id) {
        initConection();
        conec.setCadenaSQL("SELECT * FROM inventario WHERE id ='" + id + "' ;");
        conec.setEsSelect(true);
        conec.conectar();
        ResultSet rs = conec.getDbresultSet();
        Inventario i = new Inventario();
        try {
            while (rs.next()) {
                i.setId(rs.getInt("id")); // 1
                i.setId_producto(rs.getInt("id_producto"));
                i.setCantidad(rs.getInt("cantidad"));
                i.setEstado(rs.getString("estado"));
                i.setNivel_reorden(rs.getInt("nivel_reorden")); // 5
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo recorrer el ResultSet:" + ex.getMessage());
        }
        return i;
    }

    public void editarInventario(Inventario i, Inventario iNuevo) {
        initConection();
        conec.setCadenaSQL("UPDATE inventario SET id_producto ='" + iNuevo.getId_producto()
                + "', cantidad = '" + iNuevo.getCantidad()
                + "', estado = '" + iNuevo.getEstado()
                + "', nivel_reorden = '" + iNuevo.getNivel_reorden() + "'");
        conec.setEsSelect(false);
        try {
            conec.conectar();
            JOptionPane.showMessageDialog(null, "Se actualizaron los datos de la tabla inventario.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudieron actualizar los datos. Error: " + e.getMessage());
        }
    }

    public void agregarInventario(JTable tabla) {
        initConection();
        conec.setCadenaSQL("INSERT INTO inventario (id_producto, cantidad, estado, nivel_reorden) VALUES ('"
                + JOptionPane.showInputDialog("Ingrese un ID de producto") + "','"
                + JOptionPane.showInputDialog("Ingrese una cantidad") + "','"
                + JOptionPane.showInputDialog("Ingrese el estado") + "','"
                + JOptionPane.showInputDialog("Ingrese el nivel de reorden") + "');");
        System.out.println(conec.getCadenaSQL());
        conec.setEsSelect(false);
        try {
            conec.conectar();
            llenarTabla(tabla);
            JOptionPane.showMessageDialog(null, "Se actualizaron los datos de la tabla inventario.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudieron actualizar los datos. Error: " + e.getMessage());
        }
    }

}
