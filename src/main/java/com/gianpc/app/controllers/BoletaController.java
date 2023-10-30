package com.gianpc.app.controllers;

import com.gianpc.app.models.domain.Boleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoletaController {

    @Autowired
    Boleta boleta;

    @GetMapping("/boleta")
    public String boleta(Model model){
        // Enviar boleta
        model.addAttribute("boleta",boleta);
        return "boleta";
    }








}
