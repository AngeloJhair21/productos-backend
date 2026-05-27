package com.UTP.productos.entidad;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Esta clase debe convertise en una tabla mysql
@Entity
//Crea tabla llamada productos
@Table(name = "productos")
//Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    //como es ID tiene que ir autoincremento
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //No acepta valores nulos
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private Double precio;

    private Integer cantidad;
}
