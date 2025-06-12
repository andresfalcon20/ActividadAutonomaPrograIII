package com.itsqmet.Actividad.Autonoma.Controlador;

import com.itsqmet.Actividad.Autonoma.entidad.Cliente;
import com.itsqmet.Actividad.Autonoma.servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/listaCliente")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteServicio.listarClientes());
        return "pages/listaCliente";
    }

    @GetMapping("/formularioCliente")
    public String mostrarFormularioCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "pages/formularioCliente";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        clienteServicio.guardarCliente(cliente);
        return "redirect:/listaCliente";
    }

    @GetMapping("/editarCliente/{cedula}")
    public String editarCliente(@PathVariable("cedula") String cedula, Model model) {
        Cliente cliente = clienteServicio.buscarPorCedula(cedula);
        model.addAttribute("cliente", cliente);
        return "pages/formularioCliente";
    }

    @GetMapping("/eliminarCliente/{cedula}")
    public String eliminarCliente(@PathVariable("cedula") String cedula) {
        clienteServicio.eliminarCliente(cedula);
        return "redirect:/listaCliente";
    }

}
