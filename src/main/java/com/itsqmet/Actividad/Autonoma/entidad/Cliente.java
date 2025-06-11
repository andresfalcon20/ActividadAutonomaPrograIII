package com.itsqmet.Actividad.Autonoma.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Cliente {
    @Id
    private String cedula;

    private String nombre;
    private String apellido;
    private String direccion;
    private LocalDate fechaNacimiento;

    //Relacion con facturas
    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturas;

}
