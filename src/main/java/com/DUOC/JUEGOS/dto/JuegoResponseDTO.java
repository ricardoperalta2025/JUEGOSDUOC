package com.DUOC.JUEGOS.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JuegoResponseDTO {
    private Long id;
    private String titulo;
    private int anioPublicacion;
    private BigDecimal precio;
    private int valoracion;
    private String companiaNombre;
    private String generoNombre;
    private String plataformaNombre;
}
