package com.itsqmet.Actividad.Autonoma.repositorio;

import com.itsqmet.Actividad.Autonoma.entidad.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProveedorRepositorio extends JpaRepository<Proveedor, Integer> {
    List<Proveedor> findByNombreContainingIgnoreCase(String nombre);
}
