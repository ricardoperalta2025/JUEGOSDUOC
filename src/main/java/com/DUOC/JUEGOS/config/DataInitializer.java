package com.DUOC.JUEGOS.config;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.DUOC.JUEGOS.model.Compania;
import com.DUOC.JUEGOS.model.Genero;
import com.DUOC.JUEGOS.model.Plataforma;
import com.DUOC.JUEGOS.model.Videojuego;
import com.DUOC.JUEGOS.repository.CompaniaRepository;
import com.DUOC.JUEGOS.repository.GeneroRepository;
import com.DUOC.JUEGOS.repository.PlataformaRepository;
import com.DUOC.JUEGOS.repository.VideojuegoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CompaniaRepository companiaRepository;
    private final GeneroRepository generoRepository;
    private final PlataformaRepository plataformaRepository;
    private final VideojuegoRepository videojuegoRepository;

    @Override
    public void run(String... args) {

        if (videojuegoRepository.count() > 0) {
            log.info(">>> La base de datos ya tiene videojuegos insertados.");
            return;
        }
        log.info(">>> Iniciando carga de videojuegos...");


        /*
        
                Categoria prog = categoriaRepository.save(
                new Categoria(null, "Programación", "Libros de lenguajes y frameworks"));
        Categoria bd = categoriaRepository.save(
                new Categoria(null, "Bases de Datos", "SQL, NoSQL y diseño de datos"));
        
        */
        Compania konami = companiaRepository.save(new Compania(null, "Konami", "Japón", "www.konami.com"));
        Compania microsoft = companiaRepository.save(new Compania(null, "Xbox Game Studios", "EE.UU.", "www.xbox.com"));
        Compania fromSoftware = companiaRepository.save(new Compania(null, "FromSoftware", "Japón", "www.fromsoftware.jp"));
        Compania nintendo = companiaRepository.save(new Compania(null, "Nintendo", "Japón", "www.nintendo.com"));
        

        Genero cartas = generoRepository.save(new Genero(null, "Cartas", "Juegos de cartas coleccionables y estrategia"));
        Genero simulacion = generoRepository.save(new Genero(null, "Simulación", "Simuladores realistas de distintas disciplinas"));
        Genero rpg = generoRepository.save(new Genero(null, "RPG", "Juegos de rol y desarrollo de personajes"));
        Genero plataformas = generoRepository.save(new Genero(null, "Plataformas", "Aventuras de saltos y obstáculos"));

        Plataforma pc = plataformaRepository.save(new Plataforma(null, "PC"));
        Plataforma ps5 = plataformaRepository.save(new Plataforma(null, "PlayStation 5"));
        Plataforma xbox = plataformaRepository.save(new Plataforma(null, "Xbox Series X|S"));
        Plataforma switchConsole = plataformaRepository.save(new Plataforma(null, "Nintendo Switch"));

        videojuegoRepository.save(new Videojuego(null, "Yu-Gi-Oh! Master Duel", 2022, "Simulador competitivo del popular juego de cartas.", new BigDecimal("0.00"), 4, konami, cartas, pc));
        videojuegoRepository.save(new Videojuego(null, "Microsoft Flight Simulator 2024", 2024, "El simulador de aviación comercial y general más avanzado.", new BigDecimal("69.99"), 5, microsoft, simulacion, pc));
        videojuegoRepository.save(new Videojuego(null, "Elden Ring", 2022, "Aventura de rol en un inmenso y oscuro mundo abierto.", new BigDecimal("59.99"), 5, fromSoftware, rpg, ps5));
        videojuegoRepository.save(new Videojuego(null, "Super Mario Odyssey", 2017, "El plomero explora reinos 3D con la ayuda de su sombrero.", new BigDecimal("59.99"), 5, nintendo, plataformas, switchConsole));
        videojuegoRepository.save(new Videojuego(null, "Forza Horizon 5", 2021, "Conducción en un vibrante mundo abierto en México.", new BigDecimal("59.99"), 4, microsoft, simulacion, xbox));
        videojuegoRepository.save(new Videojuego(null, "Dark Souls III", 2016, "El final de la desafiante saga de fuego y cenizas.", new BigDecimal("39.99"), 4, fromSoftware, rpg, pc));
        videojuegoRepository.save(new Videojuego(null, "The Legend of Zelda: Tears of the Kingdom", 2023, "Secuela de Breath of the Wild con nuevas mecánicas de construcción.", new BigDecimal("69.99"), 5, nintendo, rpg, switchConsole));
        videojuegoRepository.save(new Videojuego(null, "Silent Hill 2", 2024, "Remake del clásico juego de terror psicológico.", new BigDecimal("69.99"), 4, konami, rpg, ps5));
        videojuegoRepository.save(new Videojuego(null, "Halo Infinite", 2021, "El regreso del Jefe Maestro con un nuevo anillo que explorar.", new BigDecimal("59.99"), 3, microsoft, rpg, xbox));
        videojuegoRepository.save(new Videojuego(null, "Animal Crossing: New Horizons", 2020, "Crea tu propia isla paradisíaca y convive con vecinos.", new BigDecimal("59.99"), 4, nintendo, simulacion, switchConsole));

        log.info(">>> Carga finalizada: videojuegos insertados exitosamente.");

    }


}
