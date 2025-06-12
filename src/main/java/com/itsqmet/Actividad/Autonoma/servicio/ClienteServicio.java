package com.itsqmet.Actividad.Autonoma.servicio;

import com.itsqmet.Actividad.Autonoma.entidad.Cliente;
import com.itsqmet.Actividad.Autonoma.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cliente> listarClientes() {
        return clienteRepositorio.findAll();
    }


    public void guardarCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);
    }

    public Cliente buscarPorCedula(String cedula) {
        Optional<Cliente> optionalCliente = clienteRepositorio.findById(cedula);
        return optionalCliente.orElse(null);
    }

    public void eliminarCliente(String cedula) {
        clienteRepositorio.deleteById(cedula);
    }
}
