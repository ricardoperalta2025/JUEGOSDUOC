package com.DUOC.JUEGOS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.DUOC.JUEGOS.model.Compania;
import com.DUOC.JUEGOS.repository.CompaniaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompaniaService {

    private final CompaniaRepository companiaRepository;
    
    public List<Compania> obtenerTodos() {
        return companiaRepository.findAll();
    }


}


/*

apoyo

    // SELECT * FROM categorias WHERE id = ?
    // Devuelve Optional: el Controller decide si hay 404.
    public Optional<Categoria> obtenerPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    // INSERT o UPDATE según si tiene id o no
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // DELETE WHERE id = ?
    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }

*/