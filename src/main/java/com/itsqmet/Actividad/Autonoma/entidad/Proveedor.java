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

    public Proveedor() {
    }

    public Proveedor(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
