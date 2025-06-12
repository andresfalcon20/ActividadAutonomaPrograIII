package com.itsqmet.Actividad.Autonoma.Controlador;

import com.itsqmet.Actividad.Autonoma.entidad.Proveedor;
import com.itsqmet.Actividad.Autonoma.servicio.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class ProveedorControlador {

    @Autowired
    private ProveedorServicio proveedorServicio;

    //listar proveedor
    @GetMapping("/listarProveedor")
    public String listarProveedores(@RequestParam(name = "buscarProveedor", required = false, defaultValue = "") String buscarProveedor, Model model) {
        List<Proveedor> proveedores = proveedorServicio.buscarProveedorPorNombre(buscarProveedor);

        model.addAttribute("buscarProveedor", buscarProveedor);
        model.addAttribute("proveedores", proveedores);

        return "pages/listaProveedor";
    }


    //crear
    @GetMapping("/formularioProveedor")
    public String formularioProveedor(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "pages/formularioProveedor";
    }

    //guardar
    @PostMapping("/guardarProveedor")
    public String guardarProveedor(@ModelAttribute Proveedor proveedor) {
        proveedorServicio.guardarProveedor(proveedor);
        return "redirect:/listarProveedor";
    }

    //editar
    @GetMapping("/editarProveedor/{codigo}")
    public String editarProveedor(@PathVariable Integer codigo, Model model) {
        Optional<Proveedor> proveedor = proveedorServicio.buscarProveedorPorCodigo(codigo);
            model.addAttribute("proveedor", proveedor);
            return "pages/formularioProveedor";

    }

    //eliminar
    @GetMapping("/eliminarProveedor/{codigo}")
    public String eliminarProveedor(@PathVariable Integer codigo) {
        proveedorServicio.eliminarProveedor(codigo);
        return "redirect:/listarProveedor";
    }
}
