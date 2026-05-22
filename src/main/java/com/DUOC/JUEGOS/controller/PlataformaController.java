package com.DUOC.JUEGOS.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DUOC.JUEGOS.model.Plataforma;
import com.DUOC.JUEGOS.service.PlataformaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/plataformas") // http://localhost:8080/api/plataformas    
@RequiredArgsConstructor
public class PlataformaController {

    private final PlataformaService plataformaService;

    @GetMapping
    public ResponseEntity<List<Plataforma>> obtenerTodas() {
        return ResponseEntity.ok(plataformaService.obtenerTodas());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Plataforma> obtenerPorId(@PathVariable Long id) {
        return plataformaService.obtenerPorId(id)
                .map(ResponseEntity::ok)                   
                .orElse(ResponseEntity.notFound().build()); 
    }    



}

