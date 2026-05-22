package com.DUOC.JUEGOS.service;

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
