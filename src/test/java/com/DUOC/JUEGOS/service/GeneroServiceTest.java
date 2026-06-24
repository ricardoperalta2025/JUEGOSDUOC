package com.DUOC.JUEGOS.service;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.DUOC.JUEGOS.model.Genero;
import com.DUOC.JUEGOS.repository.CompaniaRepository;
import com.DUOC.JUEGOS.repository.GeneroRepository;
import com.DUOC.JUEGOS.repository.JuegoRepository;
import com.DUOC.JUEGOS.repository.PlataformaRepository;

@SpringBootTest
@ActiveProfiles("test")
public class GeneroServiceTest {

    @Autowired
    private GeneroService generoService;

    // Igualamos el contexto para que Spring Boot no se confunda
    @MockitoBean private JuegoRepository juegoRepository;
    @MockitoBean private GeneroRepository generoRepository;
    @MockitoBean private CompaniaRepository companiaRepository;
    @MockitoBean private PlataformaRepository plataformaRepository;

    @Test
    public void testObtenerTodos() {
        Genero genero = new Genero();
        genero.setId(1L);
        genero.setNombre("RPG");

        when(generoRepository.findAll()).thenReturn(List.of(genero));

        List<Genero> resultado = generoService.obtenerTodos();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("RPG", resultado.get(0).getNombre());
    }

    @Test
    public void testObtenerPorId() {
        Genero genero = new Genero();
        genero.setId(1L);
        genero.setNombre("Lucha");

        when(generoRepository.findById(1L)).thenReturn(Optional.of(genero));

        Optional<Genero> resultado = generoService.obtenerPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals(1L, resultado.get().getId());
        assertEquals("Lucha", resultado.get().getNombre());
    }
}