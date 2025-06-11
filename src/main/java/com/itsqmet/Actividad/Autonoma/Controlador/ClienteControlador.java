package com.itsqmet.Actividad.Autonoma.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteControlador {

    @GetMapping("/formularioCliente")
    public String formularioCliente() {
        return "pages/formularioCliente";
    }

}
