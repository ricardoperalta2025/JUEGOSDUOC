package com.DUOC.JUEGOS.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideojuegoResponseDTO {
    
    private Long id;
    private String titulo;
    private Integer anioPublicacion;
    private String sinopsis;
    private BigDecimal precioMercado;
    private Integer valoracion;
    private String companiaNombre;
    private String generoNombre;
    private String plataformaNombre;

}
