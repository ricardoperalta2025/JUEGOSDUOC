package com.DUOC.JUEGOS.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DUOC.JUEGOS.dto.JuegoRequestDTO;
import com.DUOC.JUEGOS.dto.JuegoResponseDTO;
import com.DUOC.JUEGOS.service.JuegoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/juegos")  // http://localhost:8080/api/juegos
@RequiredArgsConstructor
public class JuegoController {

    private final JuegoService juegoService;

    // get  http://localhost:8080/api/juegos
    @GetMapping
    public ResponseEntity<List<JuegoResponseDTO>> obtenerTodosVideojuegos() {
        return ResponseEntity.ok(juegoService.obtenerTodos());
    }

    // get  http://localhost:8080/api/juegos/52

    @GetMapping("/{id}")
    public ResponseEntity<JuegoResponseDTO> obtenerVideojuegoPorId(@PathVariable Long id) {
        return juegoService.obtenerPorId(id)
                .map(ResponseEntity::ok)                   
                .orElse(ResponseEntity.notFound().build()); 
    }   

    //post http://localhost:8080/api/juegos
    @PostMapping
    public ResponseEntity<JuegoResponseDTO> guardar(@Valid @RequestBody JuegoRequestDTO juego) {
        return ResponseEntity.status(201).body(juegoService.guardar(juego));
    }

    /*
    
    para testear post en postman:

    {
    "titulo": "Resident Evil Village",
    "anioPublicacion": 2021,
    "sinopsis": "Ethan Winters se enfrenta a horrores en un oscuro y nevado pueblo europeo.",
    "precioMercado": 39.99,
    "valoracion": 5,
    "companiaId": 12,
    "generoId": 6,
    "plataformaId": 2
    }

    {
    "titulo": "Super Mario Bros. Wonder",
    "anioPublicacion": 2023,
    "sinopsis": "Mario y sus amigos viajan al Reino Flor enfrentando locuras mágicas.",
    "precioMercado": 59.99,
    "valoracion": 5,
    "companiaId": 4,
    "generoId": 4,
    "plataformaId": 4
    }

    {
    "titulo": "Persona 3 Reload",
    "anioPublicacion": 2024,
    "sinopsis": "Despierta tu poder y explora los misterios de la Hora Oscura.",
    "precioMercado": 69.99,
    "valoracion": 5,
    "companiaId": 14,
    "generoId": 3,
    "plataformaId": 1
    }
    
    */

    // put http://localhost:8080/api/juegos/1
    @PutMapping("/{id}")            
    public ResponseEntity<JuegoResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody JuegoRequestDTO dto) {
        return juegoService.actualizar(id, dto)             
                .map(ResponseEntity::ok)                   
                .orElse(ResponseEntity.notFound().build());
    }

    /*

    para testear put en postman:    
    
    http://localhost:8080/api/juegos/1

    {
    "titulo": "Yu-Gi-Oh! Master Duel",
    "anioPublicacion": 2022,
    "sinopsis": "Simulador definitivo y competitivo del popular juego de cartas coleccionables de Konami.",
    "precioMercado": 19.99,
    "valoracion": 5,
    "companiaId": 1,
    "generoId": 1,
    "plataformaId": 1
    }

    http://localhost:8080/api/juegos/3

    {
    "titulo": "Elden Ring",
    "anioPublicacion": 2022,
    "sinopsis": "Aclamada aventura de rol de acción en un inmenso y oscuro mundo abierto, desarrollada en colaboración con George R.R. Martin.",
    "precioMercado": 39.99,
    "valoracion": 5,
    "companiaId": 3,
    "generoId": 5,
    "plataformaId": 2
    }

    http://localhost:8080/api/juegos/53

    {
    "titulo": "Super Smash Bros. (Original)",
    "anioPublicacion": 1999,
    "sinopsis": "El legendario inicio de la saga de lucha cruzada donde las estrellas de Nintendo se enfrentan por primera vez.",
    "precioMercado": 45.50,
    "valoracion": 4,
    "companiaId": 4,
    "generoId": 9,
    "plataformaId": 7
    }
    
    */


    // delete http://localhost:8080/api/juegos/eliminar/1
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (juegoService.obtenerPorId(id).isEmpty()) return ResponseEntity.notFound().build();
        juegoService.eliminar(id);
        return ResponseEntity.noContent().build();      
    }

/*
    http://localhost:8080/api/juegos/eliminar/100
    http://localhost:8080/api/juegos/eliminar/5
    http://localhost:8080/api/juegos/eliminar/2

*/


    //Buscar por titulo get http://localhost:8080/api/juegos/titulo?titulo=zelda
    @GetMapping("/titulo")
    public ResponseEntity<List<JuegoResponseDTO>> buscarPorTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(juegoService.buscarPorTitulo(titulo));
    }

  
    //Buscar por precio menor a: get http://localhost:8080/api/juegos/precio-menor?precio=50
    @GetMapping("/precio-menor")
    public ResponseEntity<List<JuegoResponseDTO>> buscarPorPrecioMenor(@RequestParam BigDecimal precio) {
        return ResponseEntity.ok(juegoService.buscarPorPrecioMenor(precio));
    }   
    
    //Buscar por compania id: get http://localhost:8080/api/juegos/compania/1  
    @GetMapping("/compania/{companiaId}")
    public ResponseEntity<List<JuegoResponseDTO>> buscarPorCompania(@PathVariable Long companiaId) {
        return ResponseEntity.ok(juegoService.buscarPorCompania(companiaId));
    }
 
    // buscar por compania nombre: get http://localhost:8080/api/juegos/compania?nombre=capcom
    @GetMapping("/compania")
    public ResponseEntity<List<JuegoResponseDTO>> buscarPorNombreCompania(@RequestParam String nombre) {
        return ResponseEntity.ok(juegoService.buscarPorNombreCompania(nombre));
    }

    //Buscar por plataforma id: get http://localhost:8080/api/juegos/plataforma/1
    @GetMapping("/plataforma/{plataformaId}")
    public ResponseEntity<List<JuegoResponseDTO>> buscarPorPlataforma(@PathVariable Long plataformaId) {
        return ResponseEntity.ok(juegoService.buscarPorPlataforma(plataformaId));
    }   

    // buscar por plataforma nombre: get http://localhost:8080/api/juegos/plataforma?nombre=pc  
    @GetMapping("/plataforma")  
    public ResponseEntity<List<JuegoResponseDTO>> buscarPorNombrePlataforma(@RequestParam String nombre) {
        return ResponseEntity.ok(juegoService.buscarPorNombrePlataforma(nombre));
    }

    //Buscar por genero id: get http://localhost:8080/api/juegos/genero/1   
    @GetMapping("/genero/{generoId}")
    public ResponseEntity<List<JuegoResponseDTO>> buscarPorGenero(@PathVariable Long generoId) {
        return ResponseEntity.ok(juegoService.buscarPorGenero(generoId));
    }

    // buscar por genero nombre: get http://localhost:8080/api/juegos/genero?nombre=moba
    @GetMapping("/genero")
    public ResponseEntity<List<JuegoResponseDTO>> buscarPorNombreGenero(@RequestParam String nombre) {
        return ResponseEntity.ok(juegoService.buscarPorNombreGenero(nombre));
    }

    //Buscar por precio menor a descendiente: get http://localhost:8080/api/juegos/precio-menor-ordenado?precio=50
    @GetMapping("/precio-menor-ordenado")
    public ResponseEntity<List<JuegoResponseDTO>> buscarPorPrecioOrdenado(@RequestParam BigDecimal precio) {
        return ResponseEntity.ok(juegoService.buscarPorPrecioOrdenado(precio));
    }       

    // Ordenar en precio descendiente: get http://localhost:8080/api/juegos/ordenar-precio
    @GetMapping("/ordenar-precio")
    public ResponseEntity<List<JuegoResponseDTO>> ordenarPorPrecio() {
        return ResponseEntity.ok(juegoService.ordenarPorPrecio());
    }   

    // orden alfabeto acendente A-Z: get http://localhost:8080/api/juegos/ordenar-titulo-acs
    @GetMapping("/ordenar-titulo-acs")
    public ResponseEntity<List<JuegoResponseDTO>> ordenarPorTituloAsc() {
        return ResponseEntity.ok(juegoService.ordenarPorTituloAsc());
    }   

    // orden alfabeto descendente Z-A: get http://localhost:8080/api/juegos/ordenar-titulo-desc
    @GetMapping("/ordenar-titulo-desc")
    public ResponseEntity<List<JuegoResponseDTO>> ordenarPorTituloDesc() {
        return ResponseEntity.ok(juegoService.ordenarPorTituloDesc());
    }

    //Ordenar por valoracion descendiente: get http://localhost:8080/api/juegos/ordenar-valoracion
    @GetMapping("/ordenar-valoracion")
    public ResponseEntity<List<JuegoResponseDTO>>  ordenarPorValoracionDesc(){
        return ResponseEntity.ok(juegoService.ordenarPorValoracion());
    }
}



   