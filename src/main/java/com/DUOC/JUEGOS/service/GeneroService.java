package com.DUOC.JUEGOS.service;

<<<<<<< HEAD
public class GeneroService {

}
=======
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.DUOC.JUEGOS.model.Genero;
import com.DUOC.JUEGOS.repository.GeneroRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class GeneroService {

    private final GeneroRepository generoRepository;

    // obtener todos
    public List<Genero> obtenerTodos() {
        return generoRepository.findAll();
    }

    // obtener por id   

    public Optional <Genero> obtenerPorId(Long id) {
        return generoRepository.findById(id);
    }



}


/*

    public List<Categoria> obtenerTodas() {
        return categoriaRepository.findAll();
    }

*/
>>>>>>> 63259eb8c545aa13fe5c750cf813a94779992be7
