package com.DUOC.JUEGOS.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.DUOC.JUEGOS.dto.VideojuegoResponseDTO;
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
    private VideojuegoResponseDTO mapToDTO(Videojuego videojuego) {
        return new VideojuegoResponseDTO(
                videojuego.getId(),
                videojuego.getTitulo(),
                videojuego.getAnioPublicacion(),
                videojuego.getSinopsis(),
                videojuego.getPrecioMercado(),
                videojuego.getValoracion(),
                videojuego.getCompania().getNombre(),
                videojuego.getGenero().getNombre(),
                videojuego.getPlataforma().getNombre()
        );
    }


    // ── OBTENER TODOS
    public List<VideojuegoResponseDTO> obtenerTodos() {
        return videojuegoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // OBTENER POR ID

    public Optional<VideojuegoResponseDTO> obtenerPorId(Long id) {
        return videojuegoRepository.findById(id).map(this::mapToDTO);
    }



}

/*
auxiliares






*/