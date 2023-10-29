package com.gianpc.app.models.services;

import org.springframework.stereotype.Component;

@Component("MiServicioComplejo")
public class MiServicioComplejo implements IServicio{
    @Override
    public String operacion() {
        return "Ejecutando algo desde MiServicioComplejo...!";
    }
}
