package com.DUOC.JUEGOS.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DUOC.JUEGOS.model.Compania;
import com.DUOC.JUEGOS.service.CompaniaService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/companias")  // http://localhost:8080/api/companias       
@RequiredArgsConstructor
@Tag(name = "Compañías", description = "Operaciones relacionadas con las compañías de videojuegos")
public class CompaniaController {

    private final CompaniaService companiaService;

    @GetMapping
    @Operation(summary = "Obtener todas las compañías", description = "Devuelve una lista de todas las compañías de videojuegos disponibles.") 
    @ApiResponses(value ={
        @ApiResponse(responseCode = "200", description = "Compañías obtenidas exitosamente"),
        @ApiResponse(responseCode = "404", description = "No se encontraron compañías")
    })
    public ResponseEntity<List<Compania>> obtenerTodas() {
        return ResponseEntity.ok(companiaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una compañía por ID", description = "Devuelve una compañía específica según su ID.")
    @ApiResponses(value ={
        @ApiResponse(responseCode = "200", description = "Compañía obtenida exitosamente"),
        @ApiResponse(responseCode = "404", description = "Compañía con ese ID no encontrada")
    })
    public ResponseEntity<Compania> obtenerPorId(@PathVariable Long id) {
        return companiaService.obtenerPorId(id)
                .map(ResponseEntity::ok)                   
                .orElse(ResponseEntity.notFound().build()); 
    }    

    
}





