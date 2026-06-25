package com.DUOC.JUEGOS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient 
public class JuegosApplication {
    public static void main(String[] args) {
        SpringApplication.run(JuegosApplication.class, args);
    }
}

// para copiar y crear la bd en laragon y testear
// db_videojuegos_vm
// Bd para los test: db_videojuegos_dev y db_videojuegos_test
// http://localhost:8080/doc/swagger-ui.html