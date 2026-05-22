package com.DUOC.JUEGOS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DUOC.JUEGOS.dto.JuegoResponseDTO;
import com.DUOC.JUEGOS.model.Compania;
import com.DUOC.JUEGOS.model.Genero;
import com.DUOC.JUEGOS.model.Plataforma;
import com.DUOC.JUEGOS.model.Videojuego;


public interface VideojuegoRepository extends JpaRepository<Videojuego, Long>{
    List<JuegoResponseDTO> findByTituloContainingIgnoreCase(String titulo);
    List<JuegoResponseDTO> findByPrecioLessThan(Double precio);
    List<JuegoResponseDTO> findByCompania(Compania compania);
    List<JuegoResponseDTO> findByPlataforma(Plataforma plataforma);
    List<JuegoResponseDTO> findByGenero(Genero genero);
    //Buscar por id de Genero
    @Query("SELECT v FROM  Videojuego v WHERE v.genero.id = :generoId")
    List<JuegoResponseDTO> findByGeneroId(@Param("generoId") Long generoId);

    //Buscar por id de compania
    @Query("SELECT v FROM Videojuego v WHERE v.compania.id =:companiaId")
    List<JuegoResponseDTO> findByCompaniaId(@Param("companiaId") Long companiaId);


    //Buscar por id de plataforma
    @Query("SELECT v FROM Videojuego v WHERE v.plataforma.id =:plataformaId")
    List<JuegoResponseDTO> findByPlataformaId(@Param("plataformaId") Long plataformaId);

    //Ordenar por precio descendiente
    @Query("SELECT v FROM Videojuego v WHERE v.precio <= :precioMax ORDER BY v.precio DESC")
    List<JuegoResponseDTO> findVideojuegoBajoPrecio(@Param("precioMax") Double precioMax);

    //Ordenar por precio Mayor a menor
    @Query(
        value="SELECT * FROM videojuegos ORDERY BY precio DESC ",
        nativeQuery= true
    )
    List<JuegoResponseDTO> OrdenarVideojuegos();
    
}
