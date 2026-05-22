package com.DUOC.JUEGOS.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JuegoRequestDTO {
    @NotBlank(message = "El titulo no puede estar vacio")
    private String titulo;
    
    @NotBlank(message = "Debe llevar año de publicacion")
    private int anioPublicacion;
    
    @NotBlank(message = "El juego debe tener sinopsis")
    private String sinopsis;

    @NotBlank(message = "El juego debe tener sinopsis")
    private BigDecimal precioMercado;
    
    @NotBlank(message = "El juego debe tener valoracion")
    private int valoracion;
    
    @NotBlank(message = "El juego debe tener idGenero")
    private Long generoId;
    
    @NotBlank(message = "El juego debe tener idGenero")
    private  Long plataformaId;
    
    @NotBlank(message = "El juego debe tener idGenero")
    private Long companiaId;
    
    
}
