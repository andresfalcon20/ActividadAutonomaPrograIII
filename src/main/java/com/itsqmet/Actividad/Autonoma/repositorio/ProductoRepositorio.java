package com.itsqmet.Actividad.Autonoma.repositorio;

import com.itsqmet.Actividad.Autonoma.entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}
