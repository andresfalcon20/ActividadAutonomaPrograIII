package com.itsqmet.Actividad.Autonoma.Controlador;

import com.itsqmet.Actividad.Autonoma.entidad.Cliente;
import com.itsqmet.Actividad.Autonoma.entidad.Producto;
import com.itsqmet.Actividad.Autonoma.entidad.Factura;
import com.itsqmet.Actividad.Autonoma.servicio.ClienteServicio;
import com.itsqmet.Actividad.Autonoma.servicio.ProductoServicio;
import com.itsqmet.Actividad.Autonoma.servicio.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FacturaControlador {

    @Autowired
    private FacturaServicio facturaServicio;

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/formularioFactura")
    public String mostrarFormularioFactura(Model model) {
        model.addAttribute("factura", new Factura());

        List<Cliente> clientes = clienteServicio.listarClientes();
        List<Producto> productos = productoServicio.mostrarProductos();

        model.addAttribute("clientes", clientes);
        model.addAttribute("productos", productos);

        return "pages/formularioFactura";
    }

    @PostMapping("/guardarFactura")
    public String guardarFactura(@ModelAttribute Factura factura) {
        facturaServicio.guardarFactura(factura);
        return "redirect:/listarFacturas";
    }
}
