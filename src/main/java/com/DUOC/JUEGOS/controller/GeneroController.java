package com.DUOC.JUEGOS.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DUOC.JUEGOS.model.Genero;
import com.DUOC.JUEGOS.service.GeneroService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/generos")  // http://localhost:8080/api/generos
@RequiredArgsConstructor
public class GeneroController {

    private final GeneroService generoService;

    @GetMapping
    public ResponseEntity<List<Genero>> obtenerTodos() {
        return ResponseEntity.ok(generoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> obtenerPorId(@PathVariable Long id) {
        return generoService.obtenerPorId(id)
                .map(ResponseEntity::ok)                   
                .orElse(ResponseEntity.notFound().build()); 
    }       



    
}


