package com.itsqmet.Actividad.Autonoma.servicio;

import com.itsqmet.Actividad.Autonoma.entidad.Factura;
import com.itsqmet.Actividad.Autonoma.repositorio.FacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServicio {

    @Autowired
    private FacturaRepositorio facturaRepositorio;

    public List<Factura> listarFacturas() {
        return facturaRepositorio.findAll();
    }

    public Factura guardarFactura(Factura factura) {
        return facturaRepositorio.save(factura);
    }
}
