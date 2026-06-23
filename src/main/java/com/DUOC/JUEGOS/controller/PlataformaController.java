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

import com.DUOC.JUEGOS.model.Plataforma;
import com.DUOC.JUEGOS.service.PlataformaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/plataformas") // http://localhost:8080/api/plataformas    
@RequiredArgsConstructor
@Tag(name = "Plataformas", description = "Operaciones relacionadas con las plataformas de videojuegos")
public class PlataformaController {

    private final PlataformaService plataformaService;

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Obtener todas las plataformas", description = "Devuelve una lista hipermedia de todas las plataformas de videojuegos disponibles.")
    @ApiResponse(responseCode = "200", description = "Lista de plataformas recuperada exitosamente")
    public ResponseEntity<CollectionModel<EntityModel<Plataforma>>> obtenerTodas() {
        List<EntityModel<Plataforma>> plataformas = plataformaService.obtenerTodas().stream()
                .map(plataforma -> EntityModel.of(plataforma,
                        linkTo(methodOn(PlataformaController.class).obtenerPorId(plataforma.getId())).withSelfRel(),
                        linkTo(methodOn(PlataformaController.class).obtenerTodas()).withRel("plataformas")))
                .collect(Collectors.toList());
        CollectionModel<EntityModel<Plataforma>> collection = CollectionModel.of(plataformas,
                linkTo(methodOn(PlataformaController.class).obtenerTodas()).withSelfRel());
        return ResponseEntity.ok(collection);
    }


    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Obtener una plataforma por ID", description = "Devuelve una plataforma específica según su ID con sus respectivos enlaces de navegación.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Plataforma recuperada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Plataforma no encontrada")
    })
    public ResponseEntity<EntityModel<Plataforma>> obtenerPorId(@PathVariable Long id) {
        return plataformaService.obtenerPorId(id)
                .map(plataforma -> EntityModel.of(plataforma,
                        linkTo(methodOn(PlataformaController.class).obtenerPorId(id)).withSelfRel(),
                        linkTo(methodOn(PlataformaController.class).obtenerTodas()).withRel("plataformas")))
                .map(ResponseEntity::ok)                   
                .orElse(ResponseEntity.notFound().build()); 
    }



}

