package com.DUOC.JUEGOS.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
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

@Schema(description = "DTO para la creación de un juego")
public class JuegoRequestDTO {

    @Schema(description = "Título del juego", example = "The Legend of Zelda: Breath of the Wild")
    @NotBlank(message = "El titulo no puede estar vacio")
    private String titulo;
    
    @Schema(description = "Año de publicación del juego", example = "2017")
    @NotNull(message = "Debe llevar año de publicacion")
    private Integer anioPublicacion;
    
    @Schema(description = "Sinopsis del juego", example = "Un joven guerrero se embarca en una aventura para salvar su tierra.")
    @NotBlank(message = "El juego debe tener sinopsis")
    private String sinopsis;
    
    @Schema(description = "Precio de mercado del juego", example = "59.99")
    @NotNull(message = "El juego debe tener precio de mercado") 
    private BigDecimal precioMercado;

    @Schema(description = "Valoración del juego", example = "5")
    @NotNull(message = "El juego debe tener valoracion")
    @Min(1)
    @Max(5)
    private Integer valoracion;


    @Schema(description = "ID del género del juego")
    @NotNull(message = "El juego debe tener idGenero")
    private Long generoId;
    
    @Schema(description = "ID de la plataforma del juego")
    @NotNull(message = "El juego debe tener idPlataforma")
    private Long plataformaId;
    
    @Schema(description = "ID de la compañía del juego")
    @NotNull(message = "El juego debe tener idCompania")
    private Long companiaId;
    
    
}

