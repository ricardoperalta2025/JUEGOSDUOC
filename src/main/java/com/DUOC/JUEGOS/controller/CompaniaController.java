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

import com.DUOC.JUEGOS.model.Compania;
import com.DUOC.JUEGOS.service.CompaniaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/companias")  // http://localhost:8080/api/companias       
@RequiredArgsConstructor
@Tag(name = "Compañías", description = "Operaciones relacionadas con las compañías de videojuegos")
public class CompaniaController {

    private final CompaniaService companiaService;

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Obtener todas las compañías", description = "Devuelve una lista hipermedia de todas las compañías de videojuegos disponibles.") 
    @ApiResponse(responseCode = "200", description = "Compañías obtenidas exitosamente")
    public ResponseEntity<CollectionModel<EntityModel<Compania>>> obtenerTodas() {
        List<EntityModel<Compania>> companias = companiaService.obtenerTodas().stream()
                .map(compania -> EntityModel.of(compania,
                        linkTo(methodOn(CompaniaController.class).obtenerPorId(compania.getId())).withSelfRel(),
                        linkTo(methodOn(CompaniaController.class).obtenerTodas()).withRel("companias")))
                .collect(Collectors.toList());
        CollectionModel<EntityModel<Compania>> collection = CollectionModel.of(companias,
                linkTo(methodOn(CompaniaController.class).obtenerTodas()).withSelfRel());
        return ResponseEntity.ok(collection);
    }

    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Obtener una compañía por ID", description = "Devuelve una compañía específica según su ID con sus respectivos enlaces de navegación.")
    @ApiResponses(value ={
        @ApiResponse(responseCode = "200", description = "Compañía obtenida exitosamente"),
        @ApiResponse(responseCode = "404", description = "Compañía con ese ID no encontrada")
    })
    public ResponseEntity<EntityModel<Compania>> obtenerPorId(@PathVariable Long id) {
        return companiaService.obtenerPorId(id)
                .map(compania -> EntityModel.of(compania,
                        linkTo(methodOn(CompaniaController.class).obtenerPorId(id)).withSelfRel(),
                        linkTo(methodOn(CompaniaController.class).obtenerTodas()).withRel("companias")))
                .map(ResponseEntity::ok)                   
                .orElse(ResponseEntity.notFound().build()); 
    }

    
}





