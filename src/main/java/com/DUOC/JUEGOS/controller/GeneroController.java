package com.DUOC.JUEGOS.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DUOC.JUEGOS.model.Genero;
import com.DUOC.JUEGOS.service.GeneroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/generos")  // http://localhost:8080/api/generos
@RequiredArgsConstructor
@Tag(name = "Géneros", description = "Operaciones relacionadas con los géneros de videojuegos")
public class GeneroController {

    private final GeneroService generoService;

    @GetMapping
    @Operation(summary = "Obtener todos los géneros", description = "Devuelve una lista de todos los géneros de videojuegos disponibles.")
    public ResponseEntity<List<Genero>> obtenerTodos() {
        return ResponseEntity.ok(generoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un género por ID", description = "Devuelve un género específico según su ID.")
    public ResponseEntity<Genero> obtenerPorId(@PathVariable Long id) {
        return generoService.obtenerPorId(id)
                .map(ResponseEntity::ok)                   
                .orElse(ResponseEntity.notFound().build()); 
    }       

    
}


