package com.itsqmet.Actividad.Autonoma.entidad;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    private String nombre;

    private String direccion;

    //relacion con productos
    @OneToMany(mappedBy = "proveedor")
    private List<Producto> productos;

}
