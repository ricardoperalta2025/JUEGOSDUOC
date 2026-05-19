package com.DUOC.JUEGOS.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DUOC.JUEGOS.dto.JuegoResponseDTO;
import com.DUOC.JUEGOS.model.Videojuego;
import com.DUOC.JUEGOS.service.VideojuegoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/videojuegos")
@RequiredArgsConstructor
public class VideojuegoController {

    private final VideojuegoService videojuegoService;

    @GetMapping
    public ResponseEntity<List<JuegoResponseDTO>> obtenerTodosVideojuegos() {
        return ResponseEntity.ok(videojuegoService.obtenerTodos());
    }

    /*
    
        public List<JuegoResponseDTO> obtenerTodos() {
        return videojuegoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    */
}
