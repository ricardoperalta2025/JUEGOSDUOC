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
                .map(ResponseEntity::ok)                   // 200 con el objeto
                .orElse(ResponseEntity.notFound().build()); // 404 sin cuerpo
    }    



}


/*
    auxiliares:

    // ── POST /api/categorias ─────────────────────────
    // 201 Created con el objeto recién guardado (incluye el id generado).
    // @Valid activa las validaciones de la entidad (@NotBlank, @Size, etc.)
    // Si falla la validación → Spring devuelve 400 Bad Request automáticamente.
    @PostMapping
    public ResponseEntity<Categoria> crear(@Valid @RequestBody Categoria categoria) {
        Categoria nueva = categoriaService.guardar(categoria);
        return ResponseEntity.status(201).body(nueva);
    }

    // ── PUT /api/categorias/{id} ─────────────────────
    // 200 OK con el objeto actualizado, o 404 si no existe el id.
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Categoria datos) {
        return categoriaService.obtenerPorId(id)
                .map(existente -> {
                    datos.setId(id); // aseguramos que se actualice el correcto
                    return ResponseEntity.ok(categoriaService.guardar(datos));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // ── DELETE /api/categorias/{id} ──────────────────
    // 204 No Content: éxito sin cuerpo de respuesta.
    // 404 si el id no existe en la BD.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (categoriaService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        categoriaService.eliminar(id);
        return ResponseEntity.noContent().build(); // 204
    }

*/