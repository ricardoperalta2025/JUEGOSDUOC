package com.DUOC.JUEGOS.assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;

import com.DUOC.JUEGOS.controller.JuegoController;
import com.DUOC.JUEGOS.dto.JuegoResponseDTO;

@Component
public class JuegoModelAssembler implements RepresentationModelAssembler<JuegoResponseDTO,EntityModel<JuegoResponseDTO>> {

    @Override
    public EntityModel<JuegoResponseDTO> toModel(
            JuegoResponseDTO juego) {

        return EntityModel.of(juego,
            linkTo(methodOn(JuegoController.class).obtenerVideojuegoPorId(juego.getId())).withSelfRel(),
            linkTo(methodOn(JuegoController.class).obtenerTodosVideojuegos()).withRel("juegos")
        );
    }
}
