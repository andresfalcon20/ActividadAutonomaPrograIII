package com.itsqmet.Actividad.Autonoma.repositorio;

import com.itsqmet.Actividad.Autonoma.entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, String> {
}
