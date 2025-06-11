package com.itsqmet.Actividad.Autonoma.entidad;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    private String nombre;
    private Double precioUnitario;

    //Relacion con provedor
    //muchos a uno
    @ManyToOne
    @JoinColumn(name = "codigo_proveedor")
    private Proveedor proveedor;

    //Relacion con facturas
    //uno a muchos
    @OneToMany(mappedBy = "producto")
    private List<Factura> facturas;

}
