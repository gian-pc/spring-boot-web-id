package com.gianpc.app.models.services;

import org.springframework.stereotype.Component;

@Component("MiServicio")
public class MiServicio implements IServicio{

    @Override
    public String operacion() {
        return "Ejecutando algo desde MiServicio...!";
    }
}
