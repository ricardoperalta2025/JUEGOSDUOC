package com.DUOC.JUEGOS.service;

<<<<<<< HEAD
public class PlataformaService {

}
=======
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.DUOC.JUEGOS.model.Plataforma;
import com.DUOC.JUEGOS.repository.PlataformaRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class PlataformaService {

    private final PlataformaRepository plataformaRepository;

    //obtener todos

    public List<Plataforma> obtenerTodas() {
        return plataformaRepository.findAll();
    }   

    // obtener por id

    public Optional<Plataforma> obtenerPorId(Long id) {
        return plataformaRepository.findById(id);
    }


}

/*


    public List<Categoria> obtenerTodas() {
        return categoriaRepository.findAll();
    }
*/
>>>>>>> 63259eb8c545aa13fe5c750cf813a94779992be7
