/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaConexion;

import java.sql.*;

/**
 *
 * @author Tamponi
 */
public class ConexionMySQL 
{
    //Variables de Instancia
    
    private String nombreBaseDatos;
    private String nombreTabla;
    private String cadenaConexion;
    private String cadenaSQL;
    private boolean esSelect;
    private Connection dbConnection;
    private ResultSet dbresultSet;
    private String usuario;
    private String pass;

    /**
     * @return the nombreBaseDatos
     */
    public String getNombreBaseDatos() {
        return nombreBaseDatos;
    }

    /**
     * @param nombreBaseDatos the nombreBaseDatos to set
     */
    public void setNombreBaseDatos(String nombreBaseDatos) {
        this.nombreBaseDatos = nombreBaseDatos;
    }

    /**
     * @return the nombreTabla
     */
    public String getNombreTabla() {
        return nombreTabla;
    }

    /**
     * @param nombreTabla the nombreTabla to set
     */
    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    /**
     * @return the cadenaConexion
     */
    public String getCadenaConexion() {
        return cadenaConexion;
    }

    /**
     * @param cadenaConexion the cadenaConexion to set
     */
    public void setCadenaConexion(String cadenaConexion) {
        this.cadenaConexion = cadenaConexion;
    }

    /**
     * @return the cadenaSQL
     */
    public String getCadenaSQL() {
        return cadenaSQL;
    }

    /**
     * @param cadenaSQL the cadenaSQL to set
     */
    public void setCadenaSQL(String cadenaSQL) {
        this.cadenaSQL = cadenaSQL;
    }

    /**
     * @return the esSelect
     */
    public boolean isEsSelect() {
        return esSelect;
    }

    /**
     * @param esSelect the esSelect to set
     */
    public void setEsSelect(boolean esSelect) {
        this.esSelect = esSelect;
    }

    /**
     * @return the dbConnection
     */
    public Connection getDbConnection() {
        return dbConnection;
    }

    /**
     * @param dbConnection the dbConnection to set
     */
    public void setDbConnection(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    /**
     * @return the dbresultSet
     */
    public ResultSet getDbresultSet() {
        return dbresultSet;
    }

    /**
     * @param dbresultSet the dbresultSet to set
     */
    public void setDbresultSet(ResultSet dbresultSet) {
        this.dbresultSet = dbresultSet;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    public void cerrar()
    {
       try
       {
           this.getDbConnection().close();
       }
       catch(Exception ex)
       {
           System.out.println("Error de cierre " + ex.getMessage());
       }
    
    } //Fin Cerrar
    

     public void conectar()
     {
         if (this.getNombreBaseDatos().length() == 0)
         {
             System.out.println("falta nombre base de datos "); 
             return;
         }
         
         if (this.getNombreTabla().length() == 0)
         {
             System.out.println("falta nombre tabla "); 
             return;
         }
         
         if (this.getCadenaConexion().length() == 0)
         {
             System.out.println("falta cadena conexion "); 
             return;
         }

         if (this.getCadenaSQL().length() == 0)
         {
             System.out.println("falta cadena SQL "); 
             return;
         }

         if (this.getUsuario().length() == 0)
         {
             System.out.println("falta Usuario "); 
             return;
         }

/*         if (this.getPass().length() == 0)
         {
             JOptionPane.showMessageDialog(null, "falta Clave "); 
             return;
         }
*/
         
         
         //Se instancia la conexion
         
         Statement st = null;
         
         try
         {
             //Se carga el Driver
             Class.forName(this.getCadenaConexion());
             
             this.setDbConnection(DriverManager.getConnection(this.getNombreBaseDatos(),this.getUsuario(),this.getPass()));
             st = this.getDbConnection().createStatement();
         }
         catch(Exception ex)
         {
             System.out.println("Error de conexion " + ex.getMessage()); 
             return;
         }
         
         if(this.isEsSelect()) //SELECT
         {
             //Se carga el ResultSet
             //try
             //{
                 //this.setDbresultSet(st.executeQuery(this.getCadenaSQL()));
             //}
             //catch(Exception ex)
             //{
                //JOptionPane.showMessageDialog(null, "Error de carga ResultSet " + ex.getMessage()); 
                //return;
             
             //}
         }
         else //UPDATE - INSERT - DELETE
         {
             try
             {
                 int insertarFila = st.executeUpdate(this.getCadenaSQL());
             }
             catch(Exception ex)
             {
                 System.out.println("Error de SQL " + ex.getMessage()); 
                return;
             
             }
         
         
         }
         
        // this.cerrar();
         
     } //Cerrar Conectar

  /*  public static void main(String[] args)
    {
         ConexionMySQL conec = new ConexionMySQL();
         conec.setNombreBaseDatos("jdbc:mysql://localhost/prueba");
         conec.setNombreTabla("Cliente");
         conec.setCadenaConexion("com.mysql.jdbc.Driver");
         conec.setUsuario("root");
         conec.setPass("");
         conec.setCadenaSQL("INSERT INTO cliente (rut,nombre) VALUES ('1111','Prueba Guru');");
         conec.setEsSelect(false);
         conec.conectar();
    
    } 
     
     */
     
    
    
} //Fin clase
