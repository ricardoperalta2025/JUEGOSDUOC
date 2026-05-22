package com.DUOC.JUEGOS.service;

<<<<<<< HEAD
public class CompaniaService {

}
=======
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.DUOC.JUEGOS.model.Compania;
import com.DUOC.JUEGOS.repository.CompaniaRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CompaniaService {

    private final CompaniaRepository companiaRepository;

    // obtener todas    
    public List<Compania> obtenerTodas() {
        return companiaRepository.findAll();
    }   

    // obtener por id   

    public Optional<Compania> obtenerPorId(Long id) {
        return companiaRepository.findById(id);
    }   

}

/*

    public List<Categoria> obtenerTodas() {
        return categoriaRepository.findAll();
    }

*/
>>>>>>> 63259eb8c545aa13fe5c750cf813a94779992be7
