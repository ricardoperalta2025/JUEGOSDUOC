package com.DUOC.JUEGOS.dto;

import com.DUOC.JUEGOS.model.Compania;
import com.DUOC.JUEGOS.model.Genero;
import com.DUOC.JUEGOS.model.Plataforma;

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
    
    @NotBlank(message = "El juego debe tener valoracion")
    private int valoracion;
    
    @NotBlank(message = "El juego debe tener idGenero")
    private Genero idGenero;
    
    @NotBlank(message = "El juego debe tener idGenero")
    private  Plataforma plataformaId;
    
    @NotBlank(message = "El juego debe tener idGenero")
    private Compania companiaId;
    
    
}
