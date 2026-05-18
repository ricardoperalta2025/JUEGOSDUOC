package com.DUOC.JUEGOS.dto;

import java.math.BigDecimal;

import com.DUOC.JUEGOS.model.Compania;
import com.DUOC.JUEGOS.model.Genero;
import com.DUOC.JUEGOS.model.Plataforma;

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
    private BigDecimal precioMercado;
    private int valoracion;
    private Compania compania;
    private Genero genero;
    private Plataforma plataforma;
}
