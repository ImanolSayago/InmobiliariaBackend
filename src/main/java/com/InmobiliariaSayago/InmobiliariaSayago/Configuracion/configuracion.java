package com.InmobiliariaSayago.InmobiliariaSayago.Configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class configuracion implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permitir todas las rutas
                .allowedOrigins("http://localhost:4200") // Permitir el origen del frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE","PATCH") // Métodos permitidos
                .allowedHeaders("*") // Todos los encabezados
                .allowCredentials(true); // Permitir enviar cookies y credenciales


    }
}