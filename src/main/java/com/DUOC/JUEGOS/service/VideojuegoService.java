package com.DUOC.JUEGOS.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.DUOC.JUEGOS.dto.JuegoResponseDTO;
import com.DUOC.JUEGOS.dto.JuegoResponseDTO;
import com.DUOC.JUEGOS.model.Compania;
import com.DUOC.JUEGOS.model.Genero;
import com.DUOC.JUEGOS.model.Plataforma;
import com.DUOC.JUEGOS.model.Videojuego;
import com.DUOC.JUEGOS.repository.CompaniaRepository;
import com.DUOC.JUEGOS.repository.GeneroRepository;
import com.DUOC.JUEGOS.repository.PlataformaRepository;
import com.DUOC.JUEGOS.repository.VideojuegoRepository;



import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VideojuegoService {

    private final VideojuegoRepository videojuegoRepository;
    private final CompaniaRepository companiaRepository;
    private final GeneroRepository generoRepository;
    private final PlataformaRepository plataformaRepository;

    // mapeo privado
    private JuegoResponseDTO mapToDTO(Videojuego videojuego) {
        return new JuegoResponseDTO(
                videojuego.getId(),
                videojuego.getTitulo(),
                videojuego.getAnioPublicacion(),
                videojuego.getSinopsis(),
                videojuego.getPrecioMercado(),
                videojuego.getValoracion(),
                videojuego.getCompania(),
                videojuego.getGenero(),
                videojuego.getPlataforma()
        );
    }


    // ── OBTENER TODOS ────────────────────────────────
    public List<JuegoResponseDTO> obtenerTodos() {
        return videojuegoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }


}

/*
auxiliares


public class JuegoResponseDTO {
    private Long id;
    private String titulo;
    private Integer anioPublicacion;
    private String sinopsis;
    private BigDecimal precioMercado;
    private Integer valoracion;
    private Compania compania;
    private Genero genero;
    private Plataforma plataforma;
}



    private LibroResponseDTO mapToDTO(Libro libro) {
        return new LibroResponseDTO(
                libro.getId(),
                libro.getTitulo(),
                libro.getIsbn(),
                libro.getPrecio(),
                libro.getCategoria().getNombre()
        );
    }

    // ── OBTENER TODOS ────────────────────────────────
    // Antes: List<Libro>. Ahora: List<LibroResponseDTO>.
    public List<LibroResponseDTO> obtenerTodos() {
        return libroRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

*/