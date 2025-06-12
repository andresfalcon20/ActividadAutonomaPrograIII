package com.itsqmet.Actividad.Autonoma.repositorio;

import com.itsqmet.Actividad.Autonoma.entidad.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepositorio extends JpaRepository<Factura, Integer> {
}
