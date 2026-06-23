package com.DUOC.JUEGOS.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DUOC.JUEGOS.model.Genero;
import com.DUOC.JUEGOS.service.GeneroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/generos")  // http://localhost:8080/api/generos
@RequiredArgsConstructor
@Tag(name = "Géneros", description = "Operaciones relacionadas con los géneros de videojuegos")
public class GeneroController {

    private final GeneroService generoService;

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Obtener todos los géneros", description = "Devuelve una lista de todos los géneros de videojuegos disponibles en formato HAL JSON.")
    @ApiResponse(responseCode = "200", description = "Lista de géneros recuperada exitosamente")
    public ResponseEntity<CollectionModel<EntityModel<Genero>>> obtenerTodos() {
        List<EntityModel<Genero>> generos = generoService.obtenerTodos().stream()
                .map(genero -> EntityModel.of(genero,
                        linkTo(methodOn(GeneroController.class).obtenerPorId(genero.getId())).withSelfRel(),
                        linkTo(methodOn(GeneroController.class).obtenerTodos()).withRel("generos")))
                .collect(Collectors.toList());
        CollectionModel<EntityModel<Genero>> collection = CollectionModel.of(generos,
                linkTo(methodOn(GeneroController.class).obtenerTodos()).withSelfRel());

        return ResponseEntity.ok(collection);
    }

    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Obtener un género por ID", description = "Devuelve un género específico según su ID junto con enlaces de navegación.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Género recuperado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Género no encontrado")
    })
    public ResponseEntity<EntityModel<Genero>> obtenerPorId(@PathVariable Long id) {
        return generoService.obtenerPorId(id)
                .map(genero -> EntityModel.of(genero,
                        linkTo(methodOn(GeneroController.class).obtenerPorId(id)).withSelfRel(),
                        linkTo(methodOn(GeneroController.class).obtenerTodos()).withRel("generos")))
                .map(ResponseEntity::ok)                   
                .orElse(ResponseEntity.notFound().build()); 
    }   

    
}


