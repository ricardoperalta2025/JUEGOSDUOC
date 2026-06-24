package com.DUOC.JUEGOS.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(title = "API de Gestion Videojuegos", 
    version = "1.0", 
    description = "API para gestionar videojuegos, incluyendo operaciones CRUD y consultas por género .\n\nAutores: Nicolas Aballais y Ricardo Peralta."))
public class SwaggerConfig {
    //Para testear Swagger, ejecutar la aplicación y acceder a http://localhost:8080/doc/swagger-ui.html
}
