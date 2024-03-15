package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")

public class Producto implements Serializable { //serializacion porque se va almacenar ciertos datos en el disco

    private static final long serialVersionUID = 1L; //para poder hacer el ciclo de la sumatoria de la producto.

    @Id //id producto es la llave de la tabla producto. 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Los valores generados que estrategia usan, identico a la BD 
    @Column(name = "id_producto") //decir cual es el nombre en la base de datos. Se hace la asociación 
    private long idProducto;
    //private long idCategoria;
    private String descripcion;
    private String detalle;
    private double precio;
    private String rutaImagen;
    private boolean activo;
    private int existencias;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    Categoria categoria;
    
    
    public Producto() {
    }   

    public Producto(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

}