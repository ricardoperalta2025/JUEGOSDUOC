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

import com.DUOC.JUEGOS.model.Plataforma;
import com.DUOC.JUEGOS.service.PlataformaService;

@WebMvcTest(PlataformaController.class)
public class PlataformaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PlataformaService plataformaService;

    @Test
    public void testObtenerTodas() throws Exception {
        Plataforma plataforma = new Plataforma();
        plataforma.setId(1L);
        plataforma.setNombre("PC");

        when(plataformaService.obtenerTodas()).thenReturn(List.of(plataforma));

        mockMvc.perform(get("/api/plataformas")
                .accept(MediaType.valueOf("application/hal+json")))
                .andExpect(status().isOk());
    }

    @Test
    public void testObtenerPorId() throws Exception {
        Plataforma plataforma = new Plataforma();
        plataforma.setId(1L);
        plataforma.setNombre("PlayStation 5");

        when(plataformaService.obtenerPorId(1L)).thenReturn(Optional.of(plataforma));

        mockMvc.perform(get("/api/plataformas/1")
                .accept(MediaType.valueOf("application/hal+json")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("PlayStation 5"));
    }
}