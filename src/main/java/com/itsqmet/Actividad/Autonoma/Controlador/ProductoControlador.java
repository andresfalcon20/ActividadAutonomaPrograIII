package com.itsqmet.Actividad.Autonoma.Controlador;

import com.itsqmet.Actividad.Autonoma.entidad.Producto;
import com.itsqmet.Actividad.Autonoma.entidad.Proveedor;
import com.itsqmet.Actividad.Autonoma.servicio.ProductoServicio;
import com.itsqmet.Actividad.Autonoma.servicio.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductoControlador {


    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private ProveedorServicio proveedorServicio;


    @GetMapping("/formularioProducto")
    public String mostrarFormulario(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("proveedores", proveedorServicio.listarProveedores()); // Aquí pasamos la lista
        return "pages/formularioProducto";
    }


    @PostMapping("/guardarProducto")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoServicio.guardarProducto(producto);
        return "redirect:/listaProductos";
    }


    @GetMapping("/listaProductos")
    public String listarProductos(Model model) {
        List<Producto> productos = productoServicio.mostrarProductos();
        model.addAttribute("productos", productos);
        return "pages/listaProductos";
    }
}
