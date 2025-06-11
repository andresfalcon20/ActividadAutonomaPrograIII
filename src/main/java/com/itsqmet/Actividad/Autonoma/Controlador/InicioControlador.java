package com.itsqmet.Actividad.Autonoma.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioControlador {

    @GetMapping("/index")
    public String Inicio() {
        return "index";
    }
}
