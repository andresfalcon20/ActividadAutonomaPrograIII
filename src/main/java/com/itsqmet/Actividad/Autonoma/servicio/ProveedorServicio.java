package com.itsqmet.Actividad.Autonoma.servicio;

import com.itsqmet.Actividad.Autonoma.entidad.Proveedor;
import com.itsqmet.Actividad.Autonoma.repositorio.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServicio {

    @Autowired
    private ProveedorRepositorio proveedorRepositorio;

    // Listar
    public List<Proveedor> listarProveedores() {
        return proveedorRepositorio.findAll();
    }

    // Buscar por nombre
    public List<Proveedor> buscarProveedorPorNombre(String buscarProveedor) {
        if (buscarProveedor == null || buscarProveedor.isEmpty()) {
            return proveedorRepositorio.findAll();
        } else {
            return proveedorRepositorio.findByNombreContainingIgnoreCase(buscarProveedor);
        }
    }

    // Buscar por codigo
    public Optional<Proveedor> buscarProveedorPorCodigo(Integer codigo) {
        return proveedorRepositorio.findById(codigo);
    }

    // Guardar
    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepositorio.save(proveedor);
    }

    // Eliminar
    public void eliminarProveedor(Integer codigo) {
        proveedorRepositorio.deleteById(codigo);
    }
}
