package com.DUOC.JUEGOS.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(title = "API de Gestion Videojuegos", 
    version = "1.0", 
    description = "API para gestionar videojuegos, incluyendo operaciones CRUD y consultas por género .\n\nAutores: Nicolas Aballais y Ricardo Peralta."))
public class SwaggerConfig {
    //Para testear Swagger, ejecutar la aplicación y acceder a http://localhost:8080/swagger-ui/index.html
}
