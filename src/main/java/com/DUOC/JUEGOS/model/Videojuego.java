package com.DUOC.JUEGOS.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="videojuegos")
public class Videojuego {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(nullable=false)
    private Integer anioPublicacion;

    @Column(nullable = false, length = 200)
    private String sinopsis;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioMercado;

    @Min(1)
    @Max(5)
    @Column(nullable = true)
    private Integer valoracion; 
    
    @ManyToOne
    @JoinColumn(name = "compania_id", nullable = false)
    private Compania compania;
    
    @ManyToOne
    @JoinColumn(name = "genero_id", nullable = false)
    private Genero genero;
    
    @ManyToOne
    @JoinColumn(name = "plataforma_id", nullable = false)
    private Plataforma plataforma;


}

    // id, titulo, añoPublicacion, sinopsis, precioMercado, valoracion


    // pendientes: genero, plataforma, compañia

    /*
    
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}
    
    */

