package com.DUOC.JUEGOS.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.DUOC.JUEGOS.assembler.JuegoModelAssembler;
import com.DUOC.JUEGOS.dto.JuegoRequestDTO;
import com.DUOC.JUEGOS.dto.JuegoResponseDTO;
import com.DUOC.JUEGOS.service.JuegoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(JuegoController.class)
public class JuegoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private JuegoService juegoService;

    @MockitoBean
    private JuegoModelAssembler juegoModelAssembler;

    private ObjectMapper objectMapper = new ObjectMapper();

    private JuegoResponseDTO responseDTO;
    private JuegoRequestDTO requestDTO;

    @BeforeEach
    void setUp() {
        responseDTO = new JuegoResponseDTO(
            1L, "Persona 3 Reload", 2024, "Sinopsis", BigDecimal.valueOf(69.99), 5, "SEGA", "RPG", "PC"
        );

        requestDTO = new JuegoRequestDTO();
        requestDTO.setTitulo("Persona 3 Reload");
        requestDTO.setAnioPublicacion(2024);
        requestDTO.setSinopsis("Sinopsis");
        requestDTO.setPrecioMercado(BigDecimal.valueOf(69.99));
        requestDTO.setValoracion(5);
        requestDTO.setCompaniaId(1L);
        requestDTO.setGeneroId(1L);
        requestDTO.setPlataformaId(1L);
    }

    
    @Test
    public void testObtenerTodosVideojuegos() throws Exception {
        when(juegoService.obtenerTodos()).thenReturn(List.of(responseDTO));
        when(juegoModelAssembler.toModel(any(JuegoResponseDTO.class))).thenReturn(EntityModel.of(responseDTO));
        mockMvc.perform(get("/api/juegos")).andExpect(status().isOk());
    }

    @Test
    public void testObtenerVideojuegoPorId() throws Exception {
        when(juegoService.obtenerPorId(1L)).thenReturn(Optional.of(responseDTO));
        when(juegoModelAssembler.toModel(any(JuegoResponseDTO.class))).thenReturn(EntityModel.of(responseDTO));
        mockMvc.perform(get("/api/juegos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.titulo").value("Persona 3 Reload"));
    }

    @Test
    public void testGuardar() throws Exception {
        when(juegoService.guardar(any(JuegoRequestDTO.class))).thenReturn(responseDTO);
        when(juegoModelAssembler.toModel(any(JuegoResponseDTO.class))).thenReturn(EntityModel.of(responseDTO));
        mockMvc.perform(post("/api/juegos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void testActualizar() throws Exception {
        when(juegoService.actualizar(eq(1L), any(JuegoRequestDTO.class))).thenReturn(Optional.of(responseDTO));
        when(juegoModelAssembler.toModel(any(JuegoResponseDTO.class))).thenReturn(EntityModel.of(responseDTO));
        mockMvc.perform(put("/api/juegos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void testEliminar() throws Exception {
        when(juegoService.obtenerPorId(1L)).thenReturn(Optional.of(responseDTO));
        doNothing().when(juegoService).eliminar(1L);
        mockMvc.perform(delete("/api/juegos/eliminar/1")).andExpect(status().isNoContent());
        verify(juegoService, times(1)).eliminar(1L);
    }

   
    @Test
    public void testBuscarPorCompania() throws Exception {
        when(juegoService.buscarPorCompania(1L)).thenReturn(List.of(responseDTO));
        when(juegoModelAssembler.toModel(any())).thenReturn(EntityModel.of(responseDTO));
        mockMvc.perform(get("/api/juegos/compania/1")).andExpect(status().isOk());
    }

    @Test
    public void testBuscarPorNombreCompania() throws Exception {
        when(juegoService.buscarPorNombreCompania("SEGA")).thenReturn(List.of(responseDTO));
        when(juegoModelAssembler.toModel(any())).thenReturn(EntityModel.of(responseDTO));
        mockMvc.perform(get("/api/juegos/compania").param("nombre", "SEGA")).andExpect(status().isOk());
    }

    @Test
    public void testBuscarPorPlataforma() throws Exception {
        when(juegoService.buscarPorPlataforma(1L)).thenReturn(List.of(responseDTO));
        when(juegoModelAssembler.toModel(any())).thenReturn(EntityModel.of(responseDTO));
        mockMvc.perform(get("/api/juegos/plataforma/1")).andExpect(status().isOk());
    }

    @Test
    public void testBuscarPorNombrePlataforma() throws Exception {
        when(juegoService.buscarPorNombrePlataforma("PC")).thenReturn(List.of(responseDTO));
        when(juegoModelAssembler.toModel(any())).thenReturn(EntityModel.of(responseDTO));
        mockMvc.perform(get("/api/juegos/plataforma").param("nombre", "PC")).andExpect(status().isOk());
    }

    @Test
    public void testBuscarPorGenero() throws Exception {
        when(juegoService.buscarPorGenero(1L)).thenReturn(List.of(responseDTO));
        when(juegoModelAssembler.toModel(any())).thenReturn(EntityModel.of(responseDTO));
        mockMvc.perform(get("/api/juegos/genero/1")).andExpect(status().isOk());
    }

    @Test
    public void testBuscarPorNombreGenero() throws Exception {
        when(juegoService.buscarPorNombreGenero("RPG")).thenReturn(List.of(responseDTO));
        when(juegoModelAssembler.toModel(any())).thenReturn(EntityModel.of(responseDTO));
        mockMvc.perform(get("/api/juegos/genero").param("nombre", "RPG")).andExpect(status().isOk());
    }

    @Test
    public void testBuscarPorPrecioMenor() throws Exception {
        when(juegoService.buscarPorPrecioMenor(any())).thenReturn(List.of(responseDTO));
        when(juegoModelAssembler.toModel(any())).thenReturn(EntityModel.of(responseDTO));
        mockMvc.perform(get("/api/juegos/precio-menor").param("precio", "70.00")).andExpect(status().isOk());
    }

    @Test
    public void testBuscarPorPrecioOrdenado() throws Exception {
        when(juegoService.buscarPorPrecioOrdenado(any())).thenReturn(List.of(responseDTO));
        when(juegoModelAssembler.toModel(any())).thenReturn(EntityModel.of(responseDTO));
        mockMvc.perform(get("/api/juegos/precio-menor-ordenado").param("precio", "70.00")).andExpect(status().isOk());
    }

    @Test
    public void testBuscarPorTitulo() throws Exception {
        when(juegoService.buscarPorTitulo("Persona")).thenReturn(List.of(responseDTO));
        when(juegoModelAssembler.toModel(any())).thenReturn(EntityModel.of(responseDTO));
        mockMvc.perform(get("/api/juegos/titulo").param("titulo", "Persona")).andExpect(status().isOk());
    }

    @Test
    public void testOrdenarPorPrecio() throws Exception {
        when(juegoService.ordenarPorPrecio()).thenReturn(List.of(responseDTO));
        when(juegoModelAssembler.toModel(any())).thenReturn(EntityModel.of(responseDTO));
        mockMvc.perform(get("/api/juegos/ordenar-precio")).andExpect(status().isOk());
    }

    @Test
    public void testOrdenarPorTituloAsc() throws Exception {
        when(juegoService.ordenarPorTituloAsc()).thenReturn(List.of(responseDTO));
        when(juegoModelAssembler.toModel(any())).thenReturn(EntityModel.of(responseDTO));
        mockMvc.perform(get("/api/juegos/ordenar-titulo-asc")).andExpect(status().isOk());
    }

    @Test
    public void testOrdenarPorTituloDesc() throws Exception {
        when(juegoService.ordenarPorTituloDesc()).thenReturn(List.of(responseDTO));
        when(juegoModelAssembler.toModel(any())).thenReturn(EntityModel.of(responseDTO));
        mockMvc.perform(get("/api/juegos/ordenar-titulo-desc")).andExpect(status().isOk());
    }

    @Test
    public void testOrdenarPorValoracionDesc() throws Exception {
        when(juegoService.ordenarPorValoracionDesc()).thenReturn(List.of(responseDTO));
        when(juegoModelAssembler.toModel(any())).thenReturn(EntityModel.of(responseDTO));
        mockMvc.perform(get("/api/juegos/ordenar-valoracion-desc")).andExpect(status().isOk());
    }

    @Test
    public void testOrdenarPorValoracionAsc() throws Exception {
        when(juegoService.ordenarPorValoracionAsc()).thenReturn(List.of(responseDTO));
        when(juegoModelAssembler.toModel(any())).thenReturn(EntityModel.of(responseDTO));
        mockMvc.perform(get("/api/juegos/ordenar-valoracion-asc")).andExpect(status().isOk());
    }

    @Test
    public void testOrdenarPorAnioPublicacionDesc() throws Exception {
        when(juegoService.ordenarPorAnioPublicacionDesc()).thenReturn(List.of(responseDTO));
        when(juegoModelAssembler.toModel(any())).thenReturn(EntityModel.of(responseDTO));
        mockMvc.perform(get("/api/juegos/ordenar-anio-desc")).andExpect(status().isOk());
    }

    @Test
    public void testOrdenarPorAnioPublicacionAsc() throws Exception {
        when(juegoService.ordenarPorAnioPublicacionAsc()).thenReturn(List.of(responseDTO));
        when(juegoModelAssembler.toModel(any())).thenReturn(EntityModel.of(responseDTO));
        mockMvc.perform(get("/api/juegos/ordenar-anio-asc")).andExpect(status().isOk());
    }
}