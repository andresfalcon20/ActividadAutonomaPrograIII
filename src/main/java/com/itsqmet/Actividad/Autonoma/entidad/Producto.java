package com.itsqmet.Actividad.Autonoma.entidad;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "productos")
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

    public Producto() {
    }

    public Producto(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
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

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}

