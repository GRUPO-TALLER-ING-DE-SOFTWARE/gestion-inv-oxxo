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
    private int id_producto; // Varchar(50) not null, esto es de producto, hay que editar
    private int cantidad; // int not null
    private String estado; // Varchar(25) not null
    private int nivel_reorden; // int not null
    /*
    
    TABLAS SQL:
create table productos (id int primary key auto_increment not null, nombre varchar(50) not null, categoria varchar(50), precio float not null);
create table inventario (id int primary key auto_increment not null, id_producto int not null, estado int not null, nivel_reorden int not null, foreign key (id_producto) references productos(id));
create table stock (id int primary key auto_increment not null, id_producto int not null, cantidad int not null, foreign key (id_producto) references productos(id));
create table venta (id int primary key auto_increment not null, id_producto int not null, cantidad int not null, precio_total float not null, fecha date not null, foreign key (id_producto) references productos(id));

    */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
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

    public int getNivel_reorden() {
        return nivel_reorden;
    }

    public void setNivel_reorden(int nivel_reorden) {
        this.nivel_reorden = nivel_reorden;
    }
}

