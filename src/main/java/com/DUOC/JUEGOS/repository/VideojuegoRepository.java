package com.DUOC.JUEGOS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DUOC.JUEGOS.model.Compania;
import com.DUOC.JUEGOS.model.Genero;
import com.DUOC.JUEGOS.model.Plataforma;
import com.DUOC.JUEGOS.model.Videojuego;
import com.DUOC.JUEGOS.dto.JuegoResponseDTO;

import java.util.List;


public interface VideojuegoRepository extends JpaRepository<Videojuego, Long>{
    List<JuegoResponseDTO> findByTituloContainingIgnoreCase(String titulo);
    List<JuegoResponseDTO> findByPrecioMercadoLessThan(Double precio);
    List<JuegoResponseDTO> findByCompania(Compania compania);
    List<JuegoResponseDTO> findByPlataforma(Plataforma plataforma);
    List<JuegoResponseDTO> findByGenero(Genero genero);
    
}
