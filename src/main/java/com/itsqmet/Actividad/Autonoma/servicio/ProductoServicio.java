package com.itsqmet.Actividad.Autonoma.servicio;

import com.itsqmet.Actividad.Autonoma.entidad.Producto;
import com.itsqmet.Actividad.Autonoma.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public List<Producto> mostrarProductos() {
        return productoRepositorio.findAll();
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }



}
