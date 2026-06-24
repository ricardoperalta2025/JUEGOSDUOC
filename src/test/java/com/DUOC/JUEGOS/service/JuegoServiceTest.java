package com.DUOC.JUEGOS.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.DUOC.JUEGOS.dto.JuegoRequestDTO;
import com.DUOC.JUEGOS.dto.JuegoResponseDTO;
import com.DUOC.JUEGOS.model.Compania;
import com.DUOC.JUEGOS.model.Genero;
import com.DUOC.JUEGOS.model.Juego;
import com.DUOC.JUEGOS.model.Plataforma;
import com.DUOC.JUEGOS.repository.CompaniaRepository;
import com.DUOC.JUEGOS.repository.GeneroRepository;
import com.DUOC.JUEGOS.repository.JuegoRepository;
import com.DUOC.JUEGOS.repository.PlataformaRepository;

@SpringBootTest
@ActiveProfiles("test")
public class JuegoServiceTest {

    @Autowired
    private JuegoService juegoService;

    // AHORA USAMOS @MockitoBean
    @MockitoBean private JuegoRepository juegoRepository;
    @MockitoBean private GeneroRepository generoRepository;
    @MockitoBean private CompaniaRepository companiaRepository;
    @MockitoBean private PlataformaRepository plataformaRepository;


    @Test
    public void testObtenerTodos() {
        Juego juego = crearJuego();
        when(juegoRepository.findAll()).thenReturn(List.of(juego));
        List<JuegoResponseDTO> juegos = juegoService.obtenerTodos();
        assertNotNull(juegos);
        assertEquals(1, juegos.size());
    }

    @Test
    public void testObtenerPorId() {
        Juego juego = crearJuego();
        when(juegoRepository.findById(1L)).thenReturn(Optional.of(juego));
        Optional<JuegoResponseDTO> found = juegoService.obtenerPorId(1L);
        assertTrue(found.isPresent());
        assertEquals(1L, found.get().getId());
    }

    @Test
    public void testGuardar() {
        Juego juego = crearJuego();
        JuegoRequestDTO requestDTO = crearJuegoRequestDTO();

        when(companiaRepository.findById(anyLong())).thenReturn(Optional.of(juego.getCompania()));
        when(generoRepository.findById(anyLong())).thenReturn(Optional.of(juego.getGenero()));
        when(plataformaRepository.findById(anyLong())).thenReturn(Optional.of(juego.getPlataforma()));
        when(juegoRepository.save(any(Juego.class))).thenReturn(juego);

        JuegoResponseDTO saved = juegoService.guardar(requestDTO);
        assertNotNull(saved);
        assertEquals("Persona 3 Reload", saved.getTitulo());
    }

    @Test
    public void testActualizar() {
        Juego juego = crearJuego();
        JuegoRequestDTO requestDTO = crearJuegoRequestDTO();

        when(juegoRepository.findById(1L)).thenReturn(Optional.of(juego));
        when(companiaRepository.findById(anyLong())).thenReturn(Optional.of(juego.getCompania()));
        when(generoRepository.findById(anyLong())).thenReturn(Optional.of(juego.getGenero()));
        when(plataformaRepository.findById(anyLong())).thenReturn(Optional.of(juego.getPlataforma()));
        when(juegoRepository.save(any(Juego.class))).thenReturn(juego);

        Optional<JuegoResponseDTO> updated = juegoService.actualizar(1L, requestDTO);
        assertTrue(updated.isPresent());
        assertEquals("Persona 3 Reload", updated.get().getTitulo());
    }

    @Test
    public void testEliminar() {
        doNothing().when(juegoRepository).deleteById(1L);
        juegoService.eliminar(1L);
        verify(juegoRepository, times(1)).deleteById(1L);
    }

  
    @Test
    public void testBuscarPorTitulo() {
        when(juegoRepository.findByTituloContainingIgnoreCase("Persona")).thenReturn(List.of(crearJuego()));
        List<JuegoResponseDTO> res = juegoService.buscarPorTitulo("Persona");
        assertEquals(1, res.size());
    }

    @Test
    public void testBuscarPorGenero() {
        when(juegoRepository.findByGeneroId(1L)).thenReturn(List.of(crearJuego()));
        List<JuegoResponseDTO> res = juegoService.buscarPorGenero(1L);
        assertEquals(1, res.size());
    }

    @Test
    public void testBuscarPorNombreGenero() {
        when(juegoRepository.findByGeneroNombreContainingIgnoreCase("RPG")).thenReturn(List.of(crearJuego()));
        List<JuegoResponseDTO> res = juegoService.buscarPorNombreGenero("RPG");
        assertEquals(1, res.size());
    }

    @Test
    public void testBuscarPorCompania() {
        when(juegoRepository.findByCompaniaId(1L)).thenReturn(List.of(crearJuego()));
        List<JuegoResponseDTO> res = juegoService.buscarPorCompania(1L);
        assertEquals(1, res.size());
    }

    @Test
    public void testBuscarPorNombreCompania() {
        when(juegoRepository.findByCompaniaNombreContainingIgnoreCase("SEGA")).thenReturn(List.of(crearJuego()));
        List<JuegoResponseDTO> res = juegoService.buscarPorNombreCompania("SEGA");
        assertEquals(1, res.size());
    }

    @Test
    public void testBuscarPorPlataforma() {
        when(juegoRepository.findByPlataformaId(1L)).thenReturn(List.of(crearJuego()));
        List<JuegoResponseDTO> res = juegoService.buscarPorPlataforma(1L);
        assertEquals(1, res.size());
    }

    @Test
    public void testBuscarPorNombrePlataforma() {
        when(juegoRepository.findByPlataformaNombreContainingIgnoreCase("PC")).thenReturn(List.of(crearJuego()));
        List<JuegoResponseDTO> res = juegoService.buscarPorNombrePlataforma("PC");
        assertEquals(1, res.size());
    }

    @Test
    public void testBuscarPorPrecioMenor() {
        BigDecimal precio = BigDecimal.valueOf(70.0);
        when(juegoRepository.findByPrecioMercadoLessThan(precio)).thenReturn(List.of(crearJuego()));
        List<JuegoResponseDTO> res = juegoService.buscarPorPrecioMenor(precio);
        assertEquals(1, res.size());
    }

    @Test
    public void testBuscarPorPrecioOrdenado() {
        BigDecimal precio = BigDecimal.valueOf(70.0);
        when(juegoRepository.findJuegoBajoPrecio(precio)).thenReturn(List.of(crearJuego()));
        List<JuegoResponseDTO> res = juegoService.buscarPorPrecioOrdenado(precio);
        assertEquals(1, res.size());
    }

   
    @Test
    public void testOrdenarPorPrecio() {
        when(juegoRepository.OrdenarVideojuegos()).thenReturn(List.of(crearJuego()));
        List<JuegoResponseDTO> res = juegoService.ordenarPorPrecio();
        assertEquals(1, res.size());
    }

    @Test
    public void testOrdenarPorTituloAsc() {
        when(juegoRepository.findAllByOrderByTituloAsc()).thenReturn(List.of(crearJuego()));
        List<JuegoResponseDTO> res = juegoService.ordenarPorTituloAsc();
        assertEquals(1, res.size());
    }

    @Test
    public void testOrdenarPorTituloDesc() {
        when(juegoRepository.findAllByOrderByTituloDesc()).thenReturn(List.of(crearJuego()));
        List<JuegoResponseDTO> res = juegoService.ordenarPorTituloDesc();
        assertEquals(1, res.size());
    }

    @Test
    public void testOrdenarPorValoracion() {
        when(juegoRepository.OrdenarJuegoPorValoracion()).thenReturn(List.of(crearJuego()));
        List<JuegoResponseDTO> res = juegoService.ordenarPorValoracion();
        assertEquals(1, res.size());
    }

    @Test
    public void testOrdenarPorValoracionDesc() {
        when(juegoRepository.findAllByOrderByValoracionDesc()).thenReturn(List.of(crearJuego()));
        List<JuegoResponseDTO> res = juegoService.ordenarPorValoracionDesc();
        assertEquals(1, res.size());
    }

    @Test
    public void testOrdenarPorValoracionAsc() {
        when(juegoRepository.findAllByOrderByValoracionAsc()).thenReturn(List.of(crearJuego()));
        List<JuegoResponseDTO> res = juegoService.ordenarPorValoracionAsc();
        assertEquals(1, res.size());
    }

    @Test
    public void testOrdenarPorAnioPublicacionDesc() {
        when(juegoRepository.findAllByOrderByAnioPublicacionDesc()).thenReturn(List.of(crearJuego()));
        List<JuegoResponseDTO> res = juegoService.ordenarPorAnioPublicacionDesc();
        assertEquals(1, res.size());
    }

    @Test
    public void testOrdenarPorAnioPublicacionAsc() {
        when(juegoRepository.findAllByOrderByAnioPublicacionAsc()).thenReturn(List.of(crearJuego()));
        List<JuegoResponseDTO> res = juegoService.ordenarPorAnioPublicacionAsc();
        assertEquals(1, res.size());
    }

  
    private Juego crearJuego() {
        Compania compania = new Compania(); compania.setId(1L); compania.setNombre("SEGA");
        Genero genero = new Genero(); genero.setId(1L); genero.setNombre("RPG");
        Plataforma plataforma = new Plataforma(); plataforma.setId(1L); plataforma.setNombre("PC");

        Juego juego = new Juego();
        juego.setId(1L);
        juego.setTitulo("Persona 3 Reload");
        juego.setAnioPublicacion(2024);
        juego.setSinopsis("Despierta tu poder");
        juego.setPrecioMercado(BigDecimal.valueOf(69.99));
        juego.setValoracion(5);
        juego.setCompania(compania);
        juego.setGenero(genero);
        juego.setPlataforma(plataforma);
        return juego;
    }

    private JuegoRequestDTO crearJuegoRequestDTO() {
        JuegoRequestDTO dto = new JuegoRequestDTO();
        dto.setTitulo("Persona 3 Reload");
        dto.setAnioPublicacion(2024);
        dto.setSinopsis("Despierta tu poder");
        dto.setPrecioMercado(BigDecimal.valueOf(69.99));
        dto.setValoracion(5);
        dto.setCompaniaId(1L);
        dto.setGeneroId(1L);
        dto.setPlataformaId(1L);
        return dto;
    }
}