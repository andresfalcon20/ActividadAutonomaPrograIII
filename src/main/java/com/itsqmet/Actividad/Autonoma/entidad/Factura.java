package com.itsqmet.Actividad.Autonoma.entidad;


import jakarta.persistence.*;

@Entity
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero;


    private Integer cantidad;
    private Double precio;
    private Double subtotal;
    private Double total;


    //Relacion con cliente
    @ManyToOne
    @JoinColumn(name = "cedula_cliente")
    private Cliente cliente;

    //Relacion con producto

    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Producto producto;
}
