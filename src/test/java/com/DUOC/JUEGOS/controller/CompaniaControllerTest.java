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

import com.DUOC.JUEGOS.model.Compania;
import com.DUOC.JUEGOS.service.CompaniaService;

@WebMvcTest(CompaniaController.class)
public class CompaniaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CompaniaService companiaService;

    @Test
    public void testObtenerTodas() throws Exception {
        Compania compania = new Compania();
        compania.setId(1L);
        compania.setNombre("SEGA");

        when(companiaService.obtenerTodas()).thenReturn(List.of(compania));

        mockMvc.perform(get("/api/companias")
                .accept(MediaType.valueOf("application/hal+json")))
                .andExpect(status().isOk());
    }

    @Test
    public void testObtenerPorId() throws Exception {
        Compania compania = new Compania();
        compania.setId(1L);
        compania.setNombre("Nintendo");

        when(companiaService.obtenerPorId(1L)).thenReturn(Optional.of(compania));

        mockMvc.perform(get("/api/companias/1")
                .accept(MediaType.valueOf("application/hal+json")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Nintendo"));
    }
}