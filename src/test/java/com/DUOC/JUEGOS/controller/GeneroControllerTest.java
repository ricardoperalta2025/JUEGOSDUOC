package com.DUOC.JUEGOS.controller;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.DUOC.JUEGOS.model.Genero;
import com.DUOC.JUEGOS.service.GeneroService;

@WebMvcTest(GeneroController.class)
public class GeneroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private GeneroService generoService;

    @Test
    public void testObtenerTodos() throws Exception {
        Genero genero = new Genero();
        genero.setId(1L);
        genero.setNombre("RPG");

        when(generoService.obtenerTodos()).thenReturn(List.of(genero));

        mockMvc.perform(get("/api/generos")
                .accept(MediaType.valueOf("application/hal+json")))
                .andExpect(status().isOk());
    }

    @Test
    public void testObtenerPorId() throws Exception {
        Genero genero = new Genero();
        genero.setId(1L);
        genero.setNombre("Lucha");

        when(generoService.obtenerPorId(1L)).thenReturn(Optional.of(genero));

        mockMvc.perform(get("/api/generos/1")
                .accept(MediaType.valueOf("application/hal+json")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Lucha"));
    }
}