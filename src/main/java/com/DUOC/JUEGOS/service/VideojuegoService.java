package com.DUOC.JUEGOS.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.DUOC.JUEGOS.dto.*;
import com.DUOC.JUEGOS.model.*;
import com.DUOC.JUEGOS.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VideojuegoService {
    private final VideojuegoRepository videojuegoRepository;
    private final GeneroRepository generoRepository;
    private final CompaniaRepository companiaRepository;
    private final PlataformaRepository plataformaRepository;

    //Mapping
    private JuegoResponseDTO mapToDTO(Videojuego videojuego){
        return new JuegoResponseDTO(
            videojuego.getId(),
            videojuego.getTitulo(),
            videojuego.getAnioPublicacion(),
            videojuego.getPrecioMercado(),
            videojuego.getValoracion(),
            videojuego.getCompania().getNombre(),
            videojuego.getGenero().getNombre(),
            videojuego.getPlataforma().getNombre()
        );
    }
    //Obtener todos
    public List<JuegoResponseDTO> obtenerTodos(){
        return videojuegoRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    //Buscar por id
    public Optional<JuegoResponseDTO> obtenerPorId(Long id){
        return videojuegoRepository.findById(id).map(this::mapToDTO);
    }

    //Guardar
    public JuegoResponseDTO guardar(JuegoRequestDTO dto){
        Genero genero= generoRepository.findById(dto.getGeneroId()).orElseThrow();
        Compania compania=companiaRepository.findById(dto.getCompaniaId()).orElseThrow();
        Plataforma plataforma=plataformaRepository.findById(dto.getPlataformaId()).orElseThrow();
        Videojuego videojuego=new Videojuego(
            null,
            dto.getTitulo(),
            dto.getAnioPublicacion(),
            dto.getSinopsis(),
            dto.getPrecioMercado(),
            dto.getValoracion(),
            compania, 
            genero, 
            plataforma);
            return mapToDTO(videojuegoRepository.save(videojuego));
    }

    //Actualizar 
    public Optional<JuegoResponseDTO> actualizar(Long id, JuegoRequestDTO dto){
        return videojuegoRepository.findById(id).map(existente ->{
            Genero genero= generoRepository.findById(dto.getGeneroId()).orElseThrow();
            Compania compania=companiaRepository.findById(dto.getCompaniaId()).orElseThrow();
            Plataforma plataforma=plataformaRepository.findById(dto.getPlataformaId()).orElseThrow();
            existente.setTitulo(dto.getTitulo());
            existente.setAnioPublicacion(dto.getAnioPublicacion());
            existente.setPrecioMercado(dto.getPrecioMercado());
            existente.setCompania(compania);
            existente.setPlataforma(plataforma);
            existente.setGenero(genero);
            return mapToDTO(videojuegoRepository.save(existente));
        });
    }
    //Eliminar
    public void eliminar(Long id){videojuegoRepository.deleteById(id);}
    //Buscar por titulo
    public List<JuegoResponseDTO> buscarPorTitulo(String texto){
        return videojuegoRepository.findByTituloContainingIgnoreCase(texto);
    }
    //Buscar por precio menor a 
    public List<JuegoResponseDTO> buscarPorPrecioMenor(Double precio){
        return videojuegoRepository.findByPrecioMercadoLessThan(precio);
    }
    //Buscar por compania id
    public List<JuegoResponseDTO> buscarPorCompania(Long companiaId){
        return videojuegoRepository.findByCompaniaId(companiaId);
    }
    //Buscar por plataforma id
    public List<JuegoResponseDTO> buscarPorPlataforma(Long plataformaId){
        return videojuegoRepository.findByPlataformaId(plataformaId);
    }
    //Buscar por precio menor a descendiente
    public List<JuegoResponseDTO> buscarPorPrecioOrdenado(Double precio){
        return videojuegoRepository.findVideojuegoBajoPrecio(precio);
    }
    //Ordenar en precio descendiente
    public List<JuegoResponseDTO> ordenarPorPrecio(){
        return videojuegoRepository.OrdenarVideojuegos();
    }


}