package com.DUOC.JUEGOS.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.DUOC.JUEGOS.dto.JuegoResponseDTO;
import com.DUOC.JUEGOS.service.VideojuegoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/videojuegos")  // http://localhost:8080/api/videojuegos
@RequiredArgsConstructor
public class VideojuegoController {

    private final VideojuegoService videojuegoService;

    
    @GetMapping
    public ResponseEntity<List<JuegoResponseDTO>> obtenerTodosVideojuegos() {
        return ResponseEntity.ok(videojuegoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JuegoResponseDTO> obtenerVideojuegoPorId(@PathVariable Long id) {
        return videojuegoService.obtenerPorId(id)
                .map(ResponseEntity::ok)                   
                .orElse(ResponseEntity.notFound().build()); 
    }   



}


    /*
    
    Auxiliares: todos usan ResponseEntity y RespondeDTO

    post

        @PostMapping
    public ResponseEntity<LibroResponseDTO> crear(@Valid @RequestBody LibroRequestDTO libro) {
        return ResponseEntity.status(201).body(libroService.guardar(libro));
    }

    //PUT /api/libros/{id} 200 OK o 404 Not found

    put

    @PutMapping("/{id}")
    public ResponseEntity<LibroResponseDTO> actualizar ( @PathVariable Long id, @Valid @RequestBody LibroRequestDTO dto){
        return libroService.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    delete

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (libroService.obtenerPorId(id).isEmpty()) return ResponseEntity.notFound().build();
        libroService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    búsqueda especial

    // ── NUEVOS ENDPOINTS CLASE 2 ──────────────────────
    // @RequestParam captura el parámetro de la URL: ?titulo=clean
    // GET /api/libros/buscar?titulo=clean  → Query Method
    @GetMapping("/buscar")
    public ResponseEntity<List<LibroResponseDTO>> buscarPorTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(libroService.buscarPorTitulo(titulo));
    }


    usando query metodos


        // GET /api/libros/categoria/1  → @Query JPQL
    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<LibroResponseDTO>> buscarPorCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(libroService.buscarPorCategoria(id));
    }

    // GET /api/libros/presupuesto?max=40.0  → @Query JPQL ordenado
    @GetMapping("/presupuesto")
    public ResponseEntity<List<LibroResponseDTO>> bajoPresupuesto(@RequestParam Double max) {
        return ResponseEntity.ok(libroService.buscarBajoPresupuesto(max));
    }

    // GET /api/libros/buscar-nativo?texto=sql  → SQL nativo
    @GetMapping("/buscar-nativo")
    public ResponseEntity<List<LibroResponseDTO>> buscarNativo(@RequestParam String texto) {
        return ResponseEntity.ok(libroService.buscarPorTituloNativo(texto));
    }


    */