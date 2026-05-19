package com.DUOC.JUEGOS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DUOC.JUEGOS.dto.VideojuegoResponseDTO;
import com.DUOC.JUEGOS.model.Compania;
import com.DUOC.JUEGOS.model.Genero;
import com.DUOC.JUEGOS.model.Plataforma;
import com.DUOC.JUEGOS.model.Videojuego;


public interface VideojuegoRepository extends JpaRepository<Videojuego, Long>{
    List<VideojuegoResponseDTO> findByTituloContainingIgnoreCase(String titulo);
    List<VideojuegoResponseDTO> findByPrecioMercadoLessThan(Double precio);
    List<VideojuegoResponseDTO> findByCompania(Compania compania);
    List<VideojuegoResponseDTO> findByPlataforma(Plataforma plataforma);
    List<VideojuegoResponseDTO> findByGenero(Genero genero);
    
}
