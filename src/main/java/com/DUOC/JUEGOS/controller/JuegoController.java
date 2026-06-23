package com.DUOC.JUEGOS.controller;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
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

import com.DUOC.JUEGOS.assembler.JuegoModelAssembler;
import com.DUOC.JUEGOS.dto.JuegoRequestDTO;
import com.DUOC.JUEGOS.dto.JuegoResponseDTO;
import com.DUOC.JUEGOS.service.JuegoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/juegos")  // http://localhost:8080/api/juegos
@RequiredArgsConstructor
@Tag(name = "Videojuegos", 
    description = "Controlador para gestionar los videojuegos")
public class JuegoController {

    private final JuegoService juegoService;
    private final JuegoModelAssembler juegoModelAssembler;

    // get, post, put, delete, juegos en general

    // get  http://localhost:8080/api/juegos
    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Obtener todos los videojuegos", description = "Devuelve una lista de todos los videojuegos disponibles en la base de datos.")
    @ApiResponse(responseCode = "200", description = "Lista de videojuegos recuperada exitosamente")
    public ResponseEntity<CollectionModel<EntityModel<JuegoResponseDTO>>> obtenerTodosVideojuegos() {
        List<EntityModel<JuegoResponseDTO>> juegos = juegoService.obtenerTodos().stream()
                .map(juegoModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<JuegoResponseDTO>> collection = CollectionModel.of(juegos,
                linkTo(methodOn(JuegoController.class).obtenerTodosVideojuegos()).withSelfRel());

        return ResponseEntity.ok(collection);
    }
    /*
    

    public ResponseEntity<CollectionModel<EntityModel<JuegoResponseDTO>>> obtenerTodosVideojuegos() {
        // 1. Obtenemos la lista normal y la pasamos por el assembler
        List<EntityModel<JuegoResponseDTO>> juegos = juegoService.obtenerTodos().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        // 2. Envolvemos la lista completa en un CollectionModel y le damos un link a sí misma
        CollectionModel<EntityModel<JuegoResponseDTO>> collection = CollectionModel.of(juegos,
                linkTo(methodOn(JuegoController.class).obtenerTodosVideojuegos()).withSelfRel());

        return ResponseEntity.ok(collection);
    }
    
    
    */

    // get  http://localhost:8080/api/juegos/52

    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Obtener un videojuego por ID", description = "Devuelve un videojuego específico según su ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Videojuego encontrado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Videojuego no encontrado en la base de datos")
    })      
    public ResponseEntity<EntityModel<JuegoResponseDTO>> obtenerVideojuegoPorId(@PathVariable Long id) {
        return juegoService.obtenerPorId(id)
                .map(juegoModelAssembler::toModel)                   
                .map(ResponseEntity::ok)                   
                .orElse(ResponseEntity.notFound().build()); 
    }

//post http://localhost:8080/api/juegos
    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Crear un nuevo videojuego", description = "Permite crear un nuevo videojuego proporcionando los detalles necesarios en el cuerpo de la solicitud.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Videojuego creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos de solicitud inválidos (Error de validación)")
    })
    public ResponseEntity<EntityModel<JuegoResponseDTO>> guardar(@Valid @RequestBody JuegoRequestDTO juego) {
        JuegoResponseDTO nuevoJuego = juegoService.guardar(juego);
        EntityModel<JuegoResponseDTO> entityModel = juegoModelAssembler.toModel(nuevoJuego);
        
        return ResponseEntity
                .created(linkTo(methodOn(JuegoController.class).obtenerVideojuegoPorId(nuevoJuego.getId())).toUri())
                .body(entityModel);
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
    @PutMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)            
    @Operation(summary = "Actualizar un videojuego existente", description = "Permite actualizar los detalles de un videojuego existente proporcionando su ID y los nuevos datos en el cuerpo de la solicitud.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Videojuego actualizado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos de solicitud inválidos (Error de validación)"),
        @ApiResponse(responseCode = "404", description = "Videojuego no encontrado para actualizar")
    })
    public ResponseEntity<EntityModel<JuegoResponseDTO>> actualizar(@PathVariable Long id, @Valid @RequestBody JuegoRequestDTO dto) {
        return juegoService.actualizar(id, dto)             
                .map(juegoModelAssembler::toModel)                   
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

    http://localhost:8080/api/juegos/15

{
    "titulo": "Klifur (Definitive Edition)",
    "anioPublicacion": 2024,
    "sinopsis": "Juego de rompecabezas minimalista basado en físicas de escalada. Ahora incluye nuevos niveles de desafío extremo.",
    "precioMercado": 2.99,
    "valoracion": 5,
    "companiaId": 8, 
    "generoId": 11,
    "plataformaId": 1 
}
    
    */


    // delete http://localhost:8080/api/juegos/eliminar/1
    @DeleteMapping(value = "/eliminar/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Eliminar un videojuego por ID", description = "Permite eliminar un videojuego específico según su ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Videojuego eliminado exitosamente (Sin contenido de retorno)"),
        @ApiResponse(responseCode = "404", description = "Videojuego no encontrado para eliminar")
    })
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (juegoService.obtenerPorId(id).isEmpty()) return ResponseEntity.notFound().build();
        juegoService.eliminar(id);
        return ResponseEntity.noContent().build();      
    }
/*
    para testear delete en postman:

    http://localhost:8080/api/juegos/eliminar/100
    http://localhost:8080/api/juegos/eliminar/5
    http://localhost:8080/api/juegos/eliminar/2

*/


    // compañia
    //Buscar por compania id: get http://localhost:8080/api/juegos/compania/1  
    @GetMapping(value = "/compania/{companiaId}", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Buscar videojuegos por compañía", description = "Devuelve una lista de videojuegos asociados a una compañía específica.")
    @ApiResponse(responseCode = "200", description = "Búsqueda realizada exitosamente")
    public ResponseEntity<CollectionModel<EntityModel<JuegoResponseDTO>>> buscarPorCompania(@PathVariable Long companiaId) {
        List<EntityModel<JuegoResponseDTO>> juegos = juegoService.buscarPorCompania(companiaId).stream()
                .map(juegoModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<JuegoResponseDTO>> collection = CollectionModel.of(juegos,
                linkTo(methodOn(JuegoController.class).buscarPorCompania(companiaId)).withSelfRel());

        return ResponseEntity.ok(collection);
    }
 
    // buscar por compania nombre: get http://localhost:8080/api/juegos/compania?nombre=capcom
    @GetMapping(value = "/compania", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Buscar videojuegos por nombre de compañía", description = "Devuelve una lista de videojuegos asociados a una compañía específica.")
    @ApiResponse(responseCode = "200", description = "Búsqueda realizada exitosamente")
    public ResponseEntity<CollectionModel<EntityModel<JuegoResponseDTO>>> buscarPorNombreCompania(@RequestParam String nombre) {
        List<EntityModel<JuegoResponseDTO>> juegos = juegoService.buscarPorNombreCompania(nombre).stream()
                .map(juegoModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<JuegoResponseDTO>> collection = CollectionModel.of(juegos,
                linkTo(methodOn(JuegoController.class).buscarPorNombreCompania(nombre)).withSelfRel());

        return ResponseEntity.ok(collection);
    }

    // plataforma
    //Buscar por plataforma id: get http://localhost:8080/api/juegos/plataforma/1
    @GetMapping(value = "/plataforma/{plataformaId}", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Buscar videojuegos por plataforma", description = "Devuelve una lista de videojuegos asociados a una plataforma específica mediante el id de la plataforma.")
    @ApiResponse(responseCode = "200", description = "Búsqueda realizada exitosamente")
    public ResponseEntity<CollectionModel<EntityModel<JuegoResponseDTO>>> buscarPorPlataforma(@PathVariable Long plataformaId) {
        List<EntityModel<JuegoResponseDTO>> juegos = juegoService.buscarPorPlataforma(plataformaId).stream()
                .map(juegoModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<JuegoResponseDTO>> collection = CollectionModel.of(juegos,
                linkTo(methodOn(JuegoController.class).buscarPorPlataforma(plataformaId)).withSelfRel());

        return ResponseEntity.ok(collection);
    } 

    // buscar por plataforma nombre: get http://localhost:8080/api/juegos/plataforma?nombre=pc  
    @GetMapping(value = "/plataforma", produces = MediaTypes.HAL_JSON_VALUE)  
    @Operation(summary = "Buscar videojuegos por nombre de plataforma", description = "Devuelve una lista de videojuegos asociados a una plataforma específica.")
    @ApiResponse(responseCode = "200", description = "Búsqueda realizada exitosamente")
    public ResponseEntity<CollectionModel<EntityModel<JuegoResponseDTO>>> buscarPorNombrePlataforma(@RequestParam String nombre) {
        List<EntityModel<JuegoResponseDTO>> juegos = juegoService.buscarPorNombrePlataforma(nombre).stream()
                .map(juegoModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<JuegoResponseDTO>> collection = CollectionModel.of(juegos,
                linkTo(methodOn(JuegoController.class).buscarPorNombrePlataforma(nombre)).withSelfRel());

        return ResponseEntity.ok(collection);
    }

    // género
    //Buscar por género id: get http://localhost:8080/api/juegos/genero/1   
    @GetMapping(value = "/genero/{generoId}", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Buscar videojuegos por género", description = "Devuelve una lista de videojuegos asociados a un género específico mediante el id del género.")
    @ApiResponse(responseCode = "200", description = "Búsqueda realizada exitosamente")
    public ResponseEntity<CollectionModel<EntityModel<JuegoResponseDTO>>> buscarPorGenero(@PathVariable Long generoId) {
        List<EntityModel<JuegoResponseDTO>> juegos = juegoService.buscarPorGenero(generoId).stream()
                .map(juegoModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<JuegoResponseDTO>> collection = CollectionModel.of(juegos,
                linkTo(methodOn(JuegoController.class).buscarPorGenero(generoId)).withSelfRel());

        return ResponseEntity.ok(collection);
    }

    // buscar por género nombre: get http://localhost:8080/api/juegos/genero?nombre=moba
    @GetMapping(value = "/genero", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Buscar videojuegos por nombre de género", description = "Devuelve una lista de videojuegos asociados a un género específico.")
    @ApiResponse(responseCode = "200", description = "Búsqueda realizada exitosamente") 
    public ResponseEntity<CollectionModel<EntityModel<JuegoResponseDTO>>> buscarPorNombreGenero(@RequestParam String nombre) {
        List<EntityModel<JuegoResponseDTO>> juegos = juegoService.buscarPorNombreGenero(nombre).stream()
                .map(juegoModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<JuegoResponseDTO>> collection = CollectionModel.of(juegos,
                linkTo(methodOn(JuegoController.class).buscarPorNombreGenero(nombre)).withSelfRel());

        return ResponseEntity.ok(collection);
    }
    //precio
    //Buscar por precio menor a: get http://localhost:8080/api/juegos/precio-menor?precio=50
    @GetMapping(value = "/precio-menor", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Buscar videojuegos por precio menor al solicitado por parametro", description = "Devuelve una lista de videojuegos con precio menor al especificado.")
    @ApiResponse(responseCode = "200", description = "Búsqueda realizada exitosamente")
    public ResponseEntity<CollectionModel<EntityModel<JuegoResponseDTO>>> buscarPorPrecioMenor(@RequestParam BigDecimal precio) {
        List<EntityModel<JuegoResponseDTO>> juegos = juegoService.buscarPorPrecioMenor(precio).stream()
                .map(juegoModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<JuegoResponseDTO>> collection = CollectionModel.of(juegos,
                linkTo(methodOn(JuegoController.class).buscarPorPrecioMenor(precio)).withSelfRel());

        return ResponseEntity.ok(collection);
    }
    //Buscar por precio menor a descendiente: get http://localhost:8080/api/juegos/precio-menor-ordenado?precio=50
    @GetMapping(value = "/precio-menor-ordenado", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Buscar videojuegos por precio menor al solicitado por parametro y ordenados", description = "Devuelve una lista de videojuegos con precio menor al especificado y ordenados.")
    @ApiResponse(responseCode = "200", description = "Búsqueda realizada exitosamente")
    public ResponseEntity<CollectionModel<EntityModel<JuegoResponseDTO>>> buscarPorPrecioOrdenado(@RequestParam BigDecimal precio) {
        List<EntityModel<JuegoResponseDTO>> juegos = juegoService.buscarPorPrecioOrdenado(precio).stream()
                .map(juegoModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<JuegoResponseDTO>> collection = CollectionModel.of(juegos,
                linkTo(methodOn(JuegoController.class).buscarPorPrecioOrdenado(precio)).withSelfRel());

        return ResponseEntity.ok(collection);
    }     

    // Ordenar en precio descendiente: get http://localhost:8080/api/juegos/ordenar-precio
    @GetMapping(value = "/ordenar-precio", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Ordenar videojuegos por precio", description = "Devuelve una lista de videojuegos ordenados por precio de forma descendente.")
    @ApiResponse(responseCode = "200", description = "Ordenamiento realizado exitosamente")
    public ResponseEntity<CollectionModel<EntityModel<JuegoResponseDTO>>> ordenarPorPrecio() {
        List<EntityModel<JuegoResponseDTO>> juegos = juegoService.ordenarPorPrecio().stream()
                .map(juegoModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<JuegoResponseDTO>> collection = CollectionModel.of(juegos,
                linkTo(methodOn(JuegoController.class).ordenarPorPrecio()).withSelfRel());

        return ResponseEntity.ok(collection);
    }
    
    //título juegos
    // orden alfabeto acendente A-Z: get http://localhost:8080/api/juegos/ordenar-titulo-asc
    @GetMapping(value = "/ordenar-titulo-asc", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Ordenar videojuegos por título ascendente", description = "Devuelve una lista de videojuegos ordenados por título de forma ascendente (A-Z).")
    @ApiResponse(responseCode = "200", description = "Ordenamiento realizado exitosamente")
    public ResponseEntity<CollectionModel<EntityModel<JuegoResponseDTO>>> ordenarPorTituloAsc() {
        List<EntityModel<JuegoResponseDTO>> juegos = juegoService.ordenarPorTituloAsc().stream()
                .map(juegoModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<JuegoResponseDTO>> collection = CollectionModel.of(juegos,
                linkTo(methodOn(JuegoController.class).ordenarPorTituloAsc()).withSelfRel());

        return ResponseEntity.ok(collection);
    } 

    // orden alfabeto descendente Z-A: get http://localhost:8080/api/juegos/ordenar-titulo-desc
    @GetMapping(value = "/ordenar-titulo-desc", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Ordenar videojuegos por título descendente", description = "Devuelve una lista de videojuegos ordenados por título de forma descendente (Z-A).")
    @ApiResponse(responseCode = "200", description = "Ordenamiento realizado exitosamente")
    public ResponseEntity<CollectionModel<EntityModel<JuegoResponseDTO>>> ordenarPorTituloDesc() {
        List<EntityModel<JuegoResponseDTO>> juegos = juegoService.ordenarPorTituloDesc().stream()
                .map(juegoModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<JuegoResponseDTO>> collection = CollectionModel.of(juegos,
                linkTo(methodOn(JuegoController.class).ordenarPorTituloDesc()).withSelfRel());

        return ResponseEntity.ok(collection);
    }

    //Buscar por titulo get http://localhost:8080/api/juegos/titulo?titulo=zelda
    @GetMapping(value = "/titulo", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Buscar videojuegos por título", description = "Devuelve una lista de videojuegos que coinciden con el título especificado.")
    @ApiResponse(responseCode = "200", description = "Búsqueda realizada exitosamente")
    public ResponseEntity<CollectionModel<EntityModel<JuegoResponseDTO>>> buscarPorTitulo(@RequestParam String titulo) {
        List<EntityModel<JuegoResponseDTO>> juegos = juegoService.buscarPorTitulo(titulo).stream()
                .map(juegoModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<JuegoResponseDTO>> collection = CollectionModel.of(juegos,
                linkTo(methodOn(JuegoController.class).buscarPorTitulo(titulo)).withSelfRel());

        return ResponseEntity.ok(collection);
    }

    //valoración
    // orden por valoracion descendiente: get http://localhost:8080/api/juegos/ordenar-valoracion-desc      
    @GetMapping(value = "/ordenar-valoracion-desc", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Ordenar videojuegos por valoración descendente", description = "Devuelve una lista de videojuegos ordenados por valoración de forma descendente.")
    @ApiResponse(responseCode = "200", description = "Ordenamiento realizado exitosamente")
    public ResponseEntity<CollectionModel<EntityModel<JuegoResponseDTO>>> ordenarPorValoracionDesc() {      
        List<EntityModel<JuegoResponseDTO>> juegos = juegoService.ordenarPorValoracionDesc().stream()
                .map(juegoModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<JuegoResponseDTO>> collection = CollectionModel.of(juegos,
                linkTo(methodOn(JuegoController.class).ordenarPorValoracionDesc()).withSelfRel());

        return ResponseEntity.ok(collection);
    }

    // orden por valoracion ascendente: get http://localhost:8080/api/juegos/ordenar-valoracion-asc     
    @GetMapping(value = "/ordenar-valoracion-asc", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Ordenar videojuegos por valoración ascendente", description = "Devuelve una lista de videojuegos ordenados por valoración de forma ascendente.")
    @ApiResponse(responseCode = "200", description = "Ordenamiento realizado exitosamente")
    public ResponseEntity<CollectionModel<EntityModel<JuegoResponseDTO>>> ordenarPorValoracionAsc() {   
        List<EntityModel<JuegoResponseDTO>> juegos = juegoService.ordenarPorValoracionAsc().stream()
                .map(juegoModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<JuegoResponseDTO>> collection = CollectionModel.of(juegos,
                linkTo(methodOn(JuegoController.class).ordenarPorValoracionAsc()).withSelfRel());

        return ResponseEntity.ok(collection);
    }    

    //año publicación
    // orden por año de publicacion descendiente: get http://localhost:8080/api/juegos/ordenar-anio-desc    
    @GetMapping(value = "/ordenar-anio-desc", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Ordenar videojuegos por año de publicación descendente", description = "Devuelve una lista de videojuegos ordenados por año de publicación de forma descendente.")
    @ApiResponse(responseCode = "200", description = "Ordenamiento realizado exitosamente")
    public ResponseEntity<CollectionModel<EntityModel<JuegoResponseDTO>>> ordenarPorAnioPublicacionDesc() {     
        List<EntityModel<JuegoResponseDTO>> juegos = juegoService.ordenarPorAnioPublicacionDesc().stream()
                .map(juegoModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<JuegoResponseDTO>> collection = CollectionModel.of(juegos,
                linkTo(methodOn(JuegoController.class).ordenarPorAnioPublicacionDesc()).withSelfRel());

        return ResponseEntity.ok(collection);
    }

    // orden por año de publicacion ascendente: get http://localhost:8080/api/juegos/ordenar-anio-asc       
    @GetMapping(value = "/ordenar-anio-asc", produces = MediaTypes.HAL_JSON_VALUE)
    @Operation(summary = "Ordenar videojuegos por año de publicación ascendente", description = "Devuelve una lista de videojuegos ordenados por año de publicación de forma ascendente.")
    @ApiResponse(responseCode = "200", description = "Ordenamiento realizado exitosamente")
    public ResponseEntity<CollectionModel<EntityModel<JuegoResponseDTO>>> ordenarPorAnioPublicacionAsc() {   
        List<EntityModel<JuegoResponseDTO>> juegos = juegoService.ordenarPorAnioPublicacionAsc().stream()
                .map(juegoModelAssembler::toModel)
                .collect(Collectors.toList());

        CollectionModel<EntityModel<JuegoResponseDTO>> collection = CollectionModel.of(juegos,
                linkTo(methodOn(JuegoController.class).ordenarPorAnioPublicacionAsc()).withSelfRel());

        return ResponseEntity.ok(collection);
    }


}



   