package com.gianpc.app.controllers;

import com.gianpc.app.models.services.IServicio;
import com.gianpc.app.models.services.MiServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MiController {

    @Autowired
    @Qualifier("MiServicioComplejo")
    private IServicio iServicio;

    @GetMapping("/miservicio")
    public String miServicio(Model model){
        model.addAttribute("servicio", iServicio.operacion());
        return "miservicio";
    }
}
