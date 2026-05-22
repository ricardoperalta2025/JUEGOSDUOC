package com.DUOC.JUEGOS.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DUOC.JUEGOS.model.Compania;
import com.DUOC.JUEGOS.model.Genero;
import com.DUOC.JUEGOS.model.Juego;
import com.DUOC.JUEGOS.model.Plataforma;


public interface JuegoRepository extends JpaRepository<Juego, Long>{

    List<Juego> findByTituloContainingIgnoreCase(String titulo);
    List<Juego> findByPrecioMercadoLessThan(BigDecimal precio);
    List<Juego> findByCompania(Compania compania);
    List<Juego> findByPlataforma(Plataforma plataforma);
    List<Juego> findByGenero(Genero genero);
    List<Juego> findByCompaniaNombreContainingIgnoreCase(String nombreCompania);
    List<Juego> findByGeneroNombreContainingIgnoreCase(String nombreGenero);
    List<Juego> findByPlataformaNombreContainingIgnoreCase(String nombrePlataforma);
    // Ordenar de la A a la Z (Ascendente)
    List<Juego> findAllByOrderByTituloAsc();
    // Ordenar de la Z a la A (Descendente)
    List<Juego> findAllByOrderByTituloDesc();
    //Buscar por id de Genero
    @Query("SELECT j FROM Juego j WHERE j.genero.id = :generoId")
    List<Juego> findByGeneroId(@Param("generoId") Long generoId);

    //Buscar por id de compania
    @Query("SELECT j FROM Juego j WHERE j.compania.id =:companiaId")
    List<Juego> findByCompaniaId(@Param("companiaId") Long companiaId);

    //Buscar por id de plataforma
    @Query("SELECT j FROM Juego j WHERE j.plataforma.id =:plataformaId")
    List<Juego> findByPlataformaId(@Param("plataformaId") Long plataformaId);

    //Ordenar por precio descendiente
    @Query("SELECT j FROM Juego j WHERE j.precioMercado <= :precioMax ORDER BY j.precioMercado DESC")
    List<Juego> findJuegoBajoPrecio(@Param("precioMax") BigDecimal precio);

    //Ordenar por precio Mayor a menor
    @Query(
        value="SELECT * FROM juegos ORDER BY precio_mercado DESC ",
        nativeQuery= true
    )
    List<Juego> OrdenarVideojuegos();
    
}
