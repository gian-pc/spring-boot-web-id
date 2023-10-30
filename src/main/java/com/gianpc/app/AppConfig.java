package com.gianpc.app;

import com.gianpc.app.models.domain.ItemBoleta;
import com.gianpc.app.models.domain.Producto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<ItemBoleta> registrarItems() {
        Producto producto1 = new Producto("Monitor LG 18.5", 350.0);
        Producto producto2 = new Producto("Teclado Microsoft", 50.90);
        Producto producto3 = new Producto("Mouse Microsoft", 20.90);
        ItemBoleta item1 = new ItemBoleta(producto1, 1);
        ItemBoleta item2 = new ItemBoleta(producto2, 2);
        ItemBoleta item3 = new ItemBoleta(producto3, 5);
        return Arrays.asList(item1,item2,item3);
    }
}
