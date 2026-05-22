package com.DUOC.JUEGOS.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JuegoRequestDTO {


    @NotBlank(message = "El titulo no puede estar vacio")
    private String titulo;
    
    @NotNull(message = "Debe llevar año de publicacion")
    private Integer anioPublicacion;
    
    @NotBlank(message = "El juego debe tener sinopsis")
    private String sinopsis;
    
    @NotNull(message = "El juego debe tener precio de mercado") 
    private BigDecimal precioMercado;

    @NotNull(message = "El juego debe tener valoracion")
    @Min(1)
    @Max(5)
    private Integer valoracion;


    @NotNull(message = "El juego debe tener idGenero")
    private Long generoId;
    
    @NotNull(message = "El juego debe tener idPlataforma")
    private Long plataformaId;
    
    @NotNull(message = "El juego debe tener idCompania")
    private Long companiaId;
    
    
}

