/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDTO;

/**
 *
 * @author cbas2
 */
public class Inventario {
    private int id; // Primary key del inventario, auto incremental no nulo
    private String nombre; // Varchar(50) not null, esto es de producto, hay que editar
    private String categoria; // Varchar(25) not null, lo mismo que el de arriba
    private int cantidad; // int not null
    private String estado; // Varchar(25) not null
    private float precio; // float not null, tambien viene desde producto
    private int nivel_reorden; // int not null
    /*Recomiendo para este objeto hacer lo siguiente:
    - Borrar todos los getter and setter para luego hacerlos cuando hagamos bien los datos.
    - Borrar todos los datos que vienen desde la tabla producto, y traer solo la primary key como foreign key.
    */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getNivel_reorden() {
        return nivel_reorden;
    }

    public void setNivel_reorden(int nivel_reorden) {
        this.nivel_reorden = nivel_reorden;
    }
}
