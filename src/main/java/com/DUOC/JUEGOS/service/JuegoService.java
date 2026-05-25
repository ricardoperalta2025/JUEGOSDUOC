package com.DUOC.JUEGOS.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.DUOC.JUEGOS.dto.JuegoRequestDTO;
import com.DUOC.JUEGOS.dto.JuegoResponseDTO;
import com.DUOC.JUEGOS.model.Compania;
import com.DUOC.JUEGOS.model.Genero;
import com.DUOC.JUEGOS.model.Juego;
import com.DUOC.JUEGOS.model.Plataforma;
import com.DUOC.JUEGOS.repository.CompaniaRepository;
import com.DUOC.JUEGOS.repository.GeneroRepository;
import com.DUOC.JUEGOS.repository.JuegoRepository;
import com.DUOC.JUEGOS.repository.PlataformaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JuegoService {

    private final JuegoRepository juegoRepository;
    private final GeneroRepository generoRepository;
    private final CompaniaRepository companiaRepository;
    private final PlataformaRepository plataformaRepository;

    //Mapping
    private JuegoResponseDTO mapToDTO(Juego juego){
        return new JuegoResponseDTO(
            juego.getId(),
            juego.getTitulo(),
            juego.getAnioPublicacion(),
            juego.getSinopsis(),
            juego.getPrecioMercado(),
            juego.getValoracion(),
            juego.getCompania().getNombre(),    
            juego.getGenero().getNombre(),
            juego.getPlataforma().getNombre()
        );
    }

    //Obtener todos
    public List<JuegoResponseDTO> obtenerTodos(){
        return juegoRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    //Buscar por id
    public Optional<JuegoResponseDTO> obtenerPorId(Long id){
        return juegoRepository.findById(id).map(this::mapToDTO);
    }

    //Guardar
    public JuegoResponseDTO guardar(JuegoRequestDTO dto){
        Genero genero= generoRepository.findById(dto.getGeneroId()).orElseThrow();
        Compania compania=companiaRepository.findById(dto.getCompaniaId()).orElseThrow();
        Plataforma plataforma=plataformaRepository.findById(dto.getPlataformaId()).orElseThrow();
        Juego juego = new Juego(
            null,
            dto.getTitulo(),
            dto.getAnioPublicacion(),
            dto.getSinopsis(),
            dto.getPrecioMercado(),
            dto.getValoracion(),
            compania, 
            genero, 
            plataforma);
            return mapToDTO(juegoRepository.save(juego));
    }

    //Actualizar 
    public Optional<JuegoResponseDTO> actualizar(Long id, JuegoRequestDTO dto){
        return juegoRepository.findById(id).map(existente ->{
            Genero genero = generoRepository.findById(dto.getGeneroId()).orElseThrow();
            Compania compania = companiaRepository.findById(dto.getCompaniaId()).orElseThrow();
            Plataforma plataforma = plataformaRepository.findById(dto.getPlataformaId()).orElseThrow();
            existente.setTitulo(dto.getTitulo());
            existente.setAnioPublicacion(dto.getAnioPublicacion());
            existente.setSinopsis(dto.getSinopsis());
            existente.setValoracion(dto.getValoracion());
            existente.setPrecioMercado(dto.getPrecioMercado());
            existente.setCompania(compania);
            existente.setPlataforma(plataforma);
            existente.setGenero(genero);
            return mapToDTO(juegoRepository.save(existente));
        });
    }

    //Eliminar
    public void eliminar(Long id){juegoRepository.deleteById(id);}

    //Buscar por titulo
    public List<JuegoResponseDTO> buscarPorTitulo(String titulo){
        return juegoRepository.findByTituloContainingIgnoreCase(titulo)
        .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    // buscar por genero id
    public List<JuegoResponseDTO> buscarPorGenero(Long generoId){
        return juegoRepository.findByGeneroId(generoId)
        .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    // buscar por genero nombre
    public List<JuegoResponseDTO> buscarPorNombreGenero(String nombreGenero){
        return juegoRepository.findByGeneroNombreContainingIgnoreCase(nombreGenero)
        .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    // buscar por nombre compania
    public List<JuegoResponseDTO> buscarPorNombreCompania(String nombreCompania){
        return juegoRepository.findByCompaniaNombreContainingIgnoreCase(nombreCompania)
        .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    // buscar por nombre plataforma
    public List<JuegoResponseDTO> buscarPorNombrePlataforma(String nombrePlataforma){
        return juegoRepository.findByPlataformaNombreContainingIgnoreCase(nombrePlataforma)
        .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    //Buscar por precio menor a 
    public List<JuegoResponseDTO> buscarPorPrecioMenor(BigDecimal precio){
        return juegoRepository.findByPrecioMercadoLessThan(precio)
        .stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    //Buscar por compania id
    public List<JuegoResponseDTO> buscarPorCompania(Long companiaId){
        return juegoRepository.findByCompaniaId(companiaId)
        .stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    //Buscar por plataforma id
    public List<JuegoResponseDTO> buscarPorPlataforma(Long plataformaId){
        return juegoRepository.findByPlataformaId(plataformaId)
        .stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    //Buscar por precio menor a descendiente
    public List<JuegoResponseDTO> buscarPorPrecioOrdenado(BigDecimal precio){
        return juegoRepository.findJuegoBajoPrecio(precio)
        .stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    //Ordenar en precio descendiente
    public List<JuegoResponseDTO> ordenarPorPrecio(){
        return juegoRepository.OrdenarVideojuegos()
        .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    // Ordenar títulos A-Z
    public List<JuegoResponseDTO> ordenarPorTituloAsc(){
        return juegoRepository.findAllByOrderByTituloAsc()
        .stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    //Ordenar por valoracion desc
    public List<JuegoResponseDTO> ordenarPorValoracion(){
        return juegoRepository.OrdenarJuegoPorValoracion().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    // Ordenar títulos Z-A
    public List<JuegoResponseDTO> ordenarPorTituloDesc(){
        return juegoRepository.findAllByOrderByTituloDesc()
        .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    // ordenar por valoracion descendiente  
    public List<JuegoResponseDTO> ordenarPorValoracionDesc(){
        return juegoRepository.findAllByOrderByValoracionDesc()
        .stream().map(this::mapToDTO).collect(Collectors.toList());
    }   
    // ordenar por valoracion ascendente 
    public List<JuegoResponseDTO> ordenarPorValoracionAsc(){
        return juegoRepository.findAllByOrderByValoracionAsc()
        .stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    // ordenaar por año de ppublicacion descendiente    
    public List<JuegoResponseDTO> ordenarPorAnioPublicacionDesc(){
        return juegoRepository.findAllByOrderByAnioPublicacionDesc()
        .stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    // ordenar por año de publicacion ascendente
    public List<JuegoResponseDTO> ordenarPorAnioPublicacionAsc(){
        return juegoRepository.findAllByOrderByAnioPublicacionAsc()
        .stream().map(this::mapToDTO).collect(Collectors.toList());
    }   
    
}

