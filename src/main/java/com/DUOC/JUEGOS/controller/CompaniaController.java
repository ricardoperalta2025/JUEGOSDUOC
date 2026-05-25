package com.DUOC.JUEGOS.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DUOC.JUEGOS.model.Compania;
import com.DUOC.JUEGOS.service.CompaniaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/companias")  // http://localhost:8080/api/companias       
@RequiredArgsConstructor
public class CompaniaController {

    private final CompaniaService companiaService;

    @GetMapping
    public ResponseEntity<List<Compania>> obtenerTodas() {
        return ResponseEntity.ok(companiaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compania> obtenerPorId(@PathVariable Long id) {
        return companiaService.obtenerPorId(id)
                .map(ResponseEntity::ok)                   
                .orElse(ResponseEntity.notFound().build()); 
    }    

    
}





