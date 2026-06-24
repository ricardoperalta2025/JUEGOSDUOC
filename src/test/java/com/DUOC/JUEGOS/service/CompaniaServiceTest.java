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

import com.DUOC.JUEGOS.model.Compania;
import com.DUOC.JUEGOS.repository.CompaniaRepository;
import com.DUOC.JUEGOS.repository.GeneroRepository;
import com.DUOC.JUEGOS.repository.JuegoRepository;
import com.DUOC.JUEGOS.repository.PlataformaRepository;

@SpringBootTest
@ActiveProfiles("test")
public class CompaniaServiceTest {

    @Autowired
    private CompaniaService companiaService;

    @MockitoBean private JuegoRepository juegoRepository;
    @MockitoBean private GeneroRepository generoRepository;
    @MockitoBean private CompaniaRepository companiaRepository;
    @MockitoBean private PlataformaRepository plataformaRepository;

    @Test
    public void testObtenerTodas() {
        Compania compania = new Compania();
        compania.setId(1L);
        compania.setNombre("SEGA");

        when(companiaRepository.findAll()).thenReturn(List.of(compania));

        List<Compania> resultado = companiaService.obtenerTodas();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("SEGA", resultado.get(0).getNombre());
    }

    @Test
    public void testObtenerPorId() {
        Compania compania = new Compania();
        compania.setId(1L);
        compania.setNombre("Nintendo");

        when(companiaRepository.findById(1L)).thenReturn(Optional.of(compania));

        Optional<Compania> resultado = companiaService.obtenerPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals(1L, resultado.get().getId());
        assertEquals("Nintendo", resultado.get().getNombre());
    }
}