package com.DUOC.JUEGOS; // Ajusta el package si lo pones en otro lado

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.DUOC.JUEGOS.model.Compania;
import com.DUOC.JUEGOS.model.Genero;
import com.DUOC.JUEGOS.model.Juego;
import com.DUOC.JUEGOS.model.Plataforma;
import com.DUOC.JUEGOS.repository.CompaniaRepository;
import com.DUOC.JUEGOS.repository.GeneroRepository;
import com.DUOC.JUEGOS.repository.JuegoRepository;
import com.DUOC.JUEGOS.repository.PlataformaRepository;

import net.datafaker.Faker;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired private CompaniaRepository companiaRepository;
    @Autowired private GeneroRepository generoRepository;
    @Autowired private PlataformaRepository plataformaRepository;
    @Autowired private JuegoRepository juegoRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();

        // 1. Generar 5 Compañías falsas
        for (int i = 0; i < 5; i++) {
            Compania compania = new Compania();
            compania.setNombre(faker.company().name());
            companiaRepository.save(compania);
        }

        // 2. Generar 5 Géneros falsos
        for (int i = 0; i < 5; i++) {
            Genero genero = new Genero();
            genero.setNombre(faker.videoGame().genre());
            generoRepository.save(genero);
        }

        // 3. Generar 5 Plataformas falsas
        for (int i = 0; i < 5; i++) {
            Plataforma plataforma = new Plataforma();
            plataforma.setNombre(faker.videoGame().platform());
            plataformaRepository.save(plataforma);
        }

        List<Compania> companias = companiaRepository.findAll();
        List<Genero> generos = generoRepository.findAll();
        List<Plataforma> plataformas = plataformaRepository.findAll();

        // 4. Generar 15 Videojuegos falsos
        for (int i = 0; i < 15; i++) {
            Juego juego = new Juego();
            juego.setTitulo(faker.videoGame().title());
            juego.setAnioPublicacion(faker.number().numberBetween(1990, 2024));
            juego.setSinopsis(faker.lorem().sentence(10));
            juego.setPrecioMercado(BigDecimal.valueOf(faker.number().randomDouble(2, 5, 70)));
            juego.setValoracion(faker.number().numberBetween(1, 6));
            
            // Asignar relaciones aleatorias
            juego.setCompania(companias.get(random.nextInt(companias.size())));
            juego.setGenero(generos.get(random.nextInt(generos.size())));
            juego.setPlataforma(plataformas.get(random.nextInt(plataformas.size())));

            juegoRepository.save(juego);
        }

        System.out.println("====== DATOS FALSOS CARGADOS CON DATAAFAKER ======");
    }
}