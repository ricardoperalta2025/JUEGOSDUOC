package com.DUOC.JUEGOS.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DUOC.JUEGOS.model.Plataforma;
import com.DUOC.JUEGOS.service.PlataformaService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/plataformas") // http://localhost:8080/api/plataformas    
@RequiredArgsConstructor
@Tag(name = "Plataformas", description = "Operaciones relacionadas con las plataformas de videojuegos")
public class PlataformaController {

    private final PlataformaService plataformaService;

    @GetMapping
    @Operation(summary = "Obtener todas las plataformas", description = "Devuelve una lista de todas las plataformas de videojuegos disponibles.")
    
    public ResponseEntity<List<Plataforma>> obtenerTodas() {
        return ResponseEntity.ok(plataformaService.obtenerTodas());
    }


    @GetMapping("/{id}")
    @Operation(summary = "Obtener una plataforma por ID", description = "Devuelve una plataforma específica según su ID.")
    public ResponseEntity<Plataforma> obtenerPorId(@PathVariable Long id) {
        return plataformaService.obtenerPorId(id)
                .map(ResponseEntity::ok)                   
                .orElse(ResponseEntity.notFound().build()); 
    }    



}

