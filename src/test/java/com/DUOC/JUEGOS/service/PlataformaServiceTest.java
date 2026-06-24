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

import com.DUOC.JUEGOS.model.Plataforma;
import com.DUOC.JUEGOS.repository.CompaniaRepository;
import com.DUOC.JUEGOS.repository.GeneroRepository;
import com.DUOC.JUEGOS.repository.JuegoRepository;
import com.DUOC.JUEGOS.repository.PlataformaRepository;

@SpringBootTest
@ActiveProfiles("test")
public class PlataformaServiceTest {

    @Autowired
    private PlataformaService plataformaService;

    // Igualamos el contexto para que Spring Boot no se confunda
    @MockitoBean private JuegoRepository juegoRepository;
    @MockitoBean private GeneroRepository generoRepository;
    @MockitoBean private CompaniaRepository companiaRepository;
    @MockitoBean private PlataformaRepository plataformaRepository;

    @Test
    public void testObtenerTodas() {
        Plataforma plataforma = new Plataforma();
        plataforma.setId(1L);
        plataforma.setNombre("PC");

        when(plataformaRepository.findAll()).thenReturn(List.of(plataforma));

        List<Plataforma> resultado = plataformaService.obtenerTodas();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("PC", resultado.get(0).getNombre());
    }

    @Test
    public void testObtenerPorId() {
        Plataforma plataforma = new Plataforma();
        plataforma.setId(1L);
        plataforma.setNombre("PlayStation 5");

        when(plataformaRepository.findById(1L)).thenReturn(Optional.of(plataforma));

        Optional<Plataforma> resultado = plataformaService.obtenerPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals(1L, resultado.get().getId());
        assertEquals("PlayStation 5", resultado.get().getNombre());
    }
}