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
        
 // ── 1. COMPAÑÍAS 

        Compania konami = companiaRepository.save(new Compania(null, "Konami", "Japón", "www.konami.com"));
        Compania microsoft = companiaRepository.save(new Compania(null, "Xbox Game Studios", "EE.UU.", "www.xbox.com"));
        Compania fromSoftware = companiaRepository.save(new Compania(null, "FromSoftware", "Japón", "www.fromsoftware.jp"));
        Compania nintendo = companiaRepository.save(new Compania(null, "Nintendo", "Japón", "www.nintendo.com"));
        Compania hoyoverse = companiaRepository.save(new Compania(null, "HoYoverse", "China", "www.hoyoverse.com"));
        Compania torfi = companiaRepository.save(new Compania(null, "Torfi", "Islandia", "torfi.itch.io"));
        Compania scs = companiaRepository.save(new Compania(null, "SCS Software", "República Checa", "www.scssoft.com"));
        Compania sony = companiaRepository.save(new Compania(null, "Sony Interactive Entertainment", "Japón", "www.playstation.com"));
        Compania rockstar = companiaRepository.save(new Compania(null, "Rockstar Games", "EE.UU.", "www.rockstargames.com"));
        Compania cdprojekt = companiaRepository.save(new Compania(null, "CD Projekt Red", "Polonia", "www.cdprojektred.com"));
        Compania squareEnix = companiaRepository.save(new Compania(null, "Square Enix", "Japón", "www.square-enix.com"));
        Compania capcom = companiaRepository.save(new Compania(null, "Capcom", "Japón", "www.capcom.com"));
        Compania valve = companiaRepository.save(new Compania(null, "Valve", "EE.UU.", "www.valvesoftware.com"));
        Compania sega = companiaRepository.save(new Compania(null, "SEGA", "Japón", "www.sega.com"));
        Compania gravity = companiaRepository.save(new Compania(null, "Gravity", "Corea del Sur", "www.gravity.co.kr"));
        Compania blizzard = companiaRepository.save(new Compania(null, "Blizzard Entertainment", "EE.UU.", "www.blizzard.com"));
        Compania snk = companiaRepository.save(new Compania(null, "SNK", "Japón", "www.snk-corp.co.jp"));
        Compania gameFreak = companiaRepository.save(new Compania(null, "Game Freak", "Japón", "www.gamefreak.co.jp"));
        Compania duolingoInc = companiaRepository.save(new Compania(null, "Duolingo Inc.", "EE.UU.", "www.duolingo.com"));
        Compania riot = companiaRepository.save(new Compania(null, "Riot Games", "EE.UU.", "www.riotgames.com"));
        Compania indie = companiaRepository.save(new Compania(null, "Estudios Independientes", "Global", "N/A"));

        // ── 2. GÉNEROS 

        Genero cartas = generoRepository.save(new Genero(null, "Cartas", "Juegos de cartas coleccionables y estrategia"));
        Genero simulacion = generoRepository.save(new Genero(null, "Simulación", "Simuladores realistas de distintas disciplinas"));
        Genero rpg = generoRepository.save(new Genero(null, "RPG", "Juegos de rol y desarrollo de personajes"));
        Genero plataformas = generoRepository.save(new Genero(null, "Plataformas", "Aventuras de saltos y obstáculos"));
        Genero accionRpg = generoRepository.save(new Genero(null, "Action RPG", "Combates dinámicos en tiempo real"));
        Genero aventura = generoRepository.save(new Genero(null, "Aventura", "Fuerte enfoque en la narrativa y exploración"));
        Genero shooter = generoRepository.save(new Genero(null, "Shooter", "Juegos de acción basados en proyectiles"));
        Genero puzzle = generoRepository.save(new Genero(null, "Puzzle", "Resolución de acertijos y lógica"));
        Genero lucha = generoRepository.save(new Genero(null, "Lucha", "Combates competitivos cuerpo a cuerpo"));
        Genero deportes = generoRepository.save(new Genero(null, "Deportes", "Simulación de disciplinas competitivas"));
        Genero metroidvania = generoRepository.save(new Genero(null, "Metroidvania", "Exploración no lineal"));
        Genero mmorpg = generoRepository.save(new Genero(null, "MMORPG", "Rol multijugador masivo en línea"));
        Genero educacion = generoRepository.save(new Genero(null, "Educación", "Aplicaciones gamificadas para el aprendizaje"));
        Genero moba = generoRepository.save(new Genero(null, "MOBA", "Batallas tácticas en arenas multijugador"));

        // ── 3. PLATAFORMAS 
        
        Plataforma pc = plataformaRepository.save(new Plataforma(null, "PC"));
        Plataforma ps5 = plataformaRepository.save(new Plataforma(null, "PlayStation 5"));
        Plataforma xbox = plataformaRepository.save(new Plataforma(null, "Xbox Series X|S"));
        Plataforma switchConsole = plataformaRepository.save(new Plataforma(null, "Nintendo Switch"));
        Plataforma movil = plataformaRepository.save(new Plataforma(null, "Móviles (iOS/Android)"));
        Plataforma ps4 = plataformaRepository.save(new Plataforma(null, "PlayStation 4"));
        Plataforma n64 = plataformaRepository.save(new Plataforma(null, "Nintendo 64"));
        Plataforma snes = plataformaRepository.save(new Plataforma(null, "Super Nintendo (SNES)"));
        Plataforma ps1 = plataformaRepository.save(new Plataforma(null, "PlayStation 1"));
        Plataforma gameBoy = plataformaRepository.save(new Plataforma(null, "Game Boy / GBC"));
        Plataforma gba = plataformaRepository.save(new Plataforma(null, "Game Boy Advance"));
        Plataforma gameCube = plataformaRepository.save(new Plataforma(null, "Nintendo GameCube"));
        Plataforma wii = plataformaRepository.save(new Plataforma(null, "Nintendo Wii"));
        Plataforma arcade = plataformaRepository.save(new Plataforma(null, "Máquinas Arcade"));

        // ── 4. VIDEOJUEGOS (100 JUEGOS EN TOTAL) 
        
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
        videojuegoRepository.save(new Videojuego(null, "Genshin Impact", 2020, "Viaja por el mundo mágico de Teyvat en busca de tu hermano/a.", new BigDecimal("0.00"), 5, hoyoverse, accionRpg, movil));
        videojuegoRepository.save(new Videojuego(null, "Honkai: Star Rail", 2023, "Súbete al Expreso Astral en esta odisea de combate por turnos.", new BigDecimal("0.00"), 5, hoyoverse, rpg, pc));
        videojuegoRepository.save(new Videojuego(null, "Zenless Zone Zero", 2024, "Explora Nueva Eridu y sobrevive a las misteriosas Cavidades.", new BigDecimal("0.00"), 4, hoyoverse, accionRpg, pc));
        videojuegoRepository.save(new Videojuego(null, "The Legend of Zelda: Ocarina of Time", 1998, "El Héroe del Tiempo viaja para detener al malvado Ganondorf.", new BigDecimal("49.99"), 5, nintendo, aventura, n64));
        videojuegoRepository.save(new Videojuego(null, "Klifur", 2024, "Juego de rompecabezas minimalista basado en físicas de escalada.", new BigDecimal("4.99"), 4, torfi, puzzle, pc));
        videojuegoRepository.save(new Videojuego(null, "Euro Truck Simulator 2", 2012, "Viaja a través de Europa entregando mercancías en tu camión.", new BigDecimal("19.99"), 5, scs, simulacion, pc));
        videojuegoRepository.save(new Videojuego(null, "God of War Ragnarök", 2022, "Kratos y Atreus enfrentan el inminente fin del mundo nórdico.", new BigDecimal("69.99"), 5, sony, aventura, ps5));
        videojuegoRepository.save(new Videojuego(null, "The Last of Us Part I", 2013, "Joel y Ellie cruzan un EE.UU. devastado por una infección.", new BigDecimal("69.99"), 5, sony, aventura, ps5));
        videojuegoRepository.save(new Videojuego(null, "Horizon Forbidden West", 2022, "Aloy explora un majestuoso y peligroso oeste postapocalíptico.", new BigDecimal("59.99"), 4, sony, accionRpg, ps5));
        videojuegoRepository.save(new Videojuego(null, "Marvel's Spider-Man 2", 2023, "Peter Parker y Miles Morales se enfrentan a Kraven y Venom.", new BigDecimal("69.99"), 5, sony, aventura, ps5));
        videojuegoRepository.save(new Videojuego(null, "Bloodborne", 2015, "Sobrevive a la cacería bestial en la pesadillesca ciudad de Yharnam.", new BigDecimal("19.99"), 5, sony, accionRpg, ps4));
        videojuegoRepository.save(new Videojuego(null, "Ghost of Tsushima", 2020, "Conviértete en el Fantasma para liberar tu hogar del imperio mongol.", new BigDecimal("59.99"), 5, sony, aventura, ps4));
        videojuegoRepository.save(new Videojuego(null, "Uncharted 4: El Desenlace del Ladrón", 2016, "La aventura definitiva de Nathan Drake.", new BigDecimal("19.99"), 5, sony, aventura, ps4));
        videojuegoRepository.save(new Videojuego(null, "Grand Theft Auto V", 2013, "Tres criminales planean grandes atracos en Los Santos.", new BigDecimal("29.99"), 5, rockstar, aventura, ps5));
        videojuegoRepository.save(new Videojuego(null, "Red Dead Redemption 2", 2018, "La épica y trágica historia de Arthur Morgan en el salvaje oeste.", new BigDecimal("59.99"), 5, rockstar, aventura, xbox));
        videojuegoRepository.save(new Videojuego(null, "The Witcher 3: Wild Hunt", 2015, "Geralt de Rivia busca a su hija adoptiva en un continente devastado.", new BigDecimal("39.99"), 5, cdprojekt, accionRpg, pc));
        videojuegoRepository.save(new Videojuego(null, "Cyberpunk 2077", 2020, "Un mercenario ambicioso busca la clave de la inmortalidad.", new BigDecimal("59.99"), 4, cdprojekt, accionRpg, pc));
        videojuegoRepository.save(new Videojuego(null, "Resident Evil 4 Remake", 2023, "Leon S. Kennedy viaja a Europa para rescatar a la hija del presidente.", new BigDecimal("59.99"), 5, capcom, aventura, ps5));
        videojuegoRepository.save(new Videojuego(null, "Monster Hunter: World", 2018, "Caza monstruos gigantescos en ecosistemas vivos y dinámicos.", new BigDecimal("29.99"), 5, capcom, accionRpg, pc));
        videojuegoRepository.save(new Videojuego(null, "Street Fighter 6", 2023, "El retorno del rey de los juegos de lucha con nuevas mecánicas.", new BigDecimal("59.99"), 4, capcom, lucha, ps5));
        videojuegoRepository.save(new Videojuego(null, "Devil May Cry 5", 2019, "Caza demonios ejecutando combos impecables.", new BigDecimal("29.99"), 5, capcom, accionRpg, xbox));
        videojuegoRepository.save(new Videojuego(null, "Final Fantasy VII Remake", 2020, "Cloud Strife se une a una eco-resistencia para luchar en Midgar.", new BigDecimal("69.99"), 5, squareEnix, accionRpg, ps5));
        videojuegoRepository.save(new Videojuego(null, "NieR:Automata", 2017, "Androides luchan en una guerra interminable por la Tierra.", new BigDecimal("39.99"), 5, squareEnix, accionRpg, pc));
        videojuegoRepository.save(new Videojuego(null, "Kingdom Hearts III", 2019, "Sora, Donald y Goofy viajan por los mágicos mundos de Disney.", new BigDecimal("59.99"), 4, squareEnix, accionRpg, ps4));
        videojuegoRepository.save(new Videojuego(null, "Super Smash Bros. Ultimate", 2018, "El mayor crossover de la historia en un solo título de peleas.", new BigDecimal("59.99"), 5, nintendo, lucha, switchConsole));
        videojuegoRepository.save(new Videojuego(null, "Mario Kart 8 Deluxe", 2017, "Frenéticas carreras antigravedad.", new BigDecimal("59.99"), 5, nintendo, deportes, switchConsole));
        videojuegoRepository.save(new Videojuego(null, "Metroid Dread", 2021, "Samus Aran explora el laberíntico y misterioso planeta ZDR.", new BigDecimal("59.99"), 4, nintendo, metroidvania, switchConsole));
        videojuegoRepository.save(new Videojuego(null, "Half-Life 2", 2004, "Gordon Freeman lidera la resistencia contra los Combine.", new BigDecimal("9.99"), 5, valve, shooter, pc));
        videojuegoRepository.save(new Videojuego(null, "Portal 2", 2011, "Resuelve letales puzles físicos usando portales.", new BigDecimal("9.99"), 5, valve, puzzle, pc));
        videojuegoRepository.save(new Videojuego(null, "Persona 5 Royal", 2019, "Sé un estudiante de día y un ladrón de corazones de noche.", new BigDecimal("59.99"), 5, sega, rpg, ps5));
        videojuegoRepository.save(new Videojuego(null, "Yakuza: Like a Dragon", 2020, "Un yakuza traicionado se convierte en un héroe de RPG.", new BigDecimal("59.99"), 4, sega, rpg, xbox));
        videojuegoRepository.save(new Videojuego(null, "Minecraft", 2011, "Explora, extrae recursos y construye en un mundo infinito.", new BigDecimal("29.99"), 5, microsoft, simulacion, pc));
        videojuegoRepository.save(new Videojuego(null, "Doom Eternal", 2020, "Desata tu furia contra los ejércitos del infierno.", new BigDecimal("39.99"), 5, microsoft, shooter, pc));
        videojuegoRepository.save(new Videojuego(null, "Overwatch 2", 2022, "Hero shooter competitivo por equipos.", new BigDecimal("0.00"), 3, microsoft, shooter, pc));
        videojuegoRepository.save(new Videojuego(null, "Hades", 2020, "Intenta escapar del Inframundo griego.", new BigDecimal("24.99"), 5, indie, accionRpg, pc));
        videojuegoRepository.save(new Videojuego(null, "Stardew Valley", 2016, "Restaura la granja de tu abuelo y vive una vida pacífica.", new BigDecimal("14.99"), 5, indie, simulacion, pc));
        videojuegoRepository.save(new Videojuego(null, "Hollow Knight", 2017, "Desciende a las ruinas de un oscuro reino de insectos.", new BigDecimal("14.99"), 5, indie, metroidvania, pc));
        videojuegoRepository.save(new Videojuego(null, "Celeste", 2018, "Ayuda a Madeline a sobrevivir a la escalada de una montaña.", new BigDecimal("19.99"), 5, indie, plataformas, pc));
        videojuegoRepository.save(new Videojuego(null, "Sekiro: Shadows Die Twice", 2019, "Venganza y honor en el Japón de la era Sengoku.", new BigDecimal("59.99"), 5, fromSoftware, aventura, ps4));
        videojuegoRepository.save(new Videojuego(null, "Ragnarok Online", 2002, "Mítico MMORPG basado en la mitología nórdica y gráficos anime.", new BigDecimal("0.00"), 5, gravity, mmorpg, pc));
        videojuegoRepository.save(new Videojuego(null, "World of Warcraft", 2004, "Explora Azeroth en el MMORPG más influyente de todos los tiempos.", new BigDecimal("14.99"), 5, blizzard, mmorpg, pc));
        videojuegoRepository.save(new Videojuego(null, "Super Smash Bros.", 1999, "El inicio del torneo donde los personajes de Nintendo se enfrentan.", new BigDecimal("39.99"), 4, nintendo, lucha, n64));
        videojuegoRepository.save(new Videojuego(null, "Super Smash Bros. Melee", 2001, "Aclamada secuela con un ritmo de combate rápido y técnico.", new BigDecimal("49.99"), 5, nintendo, lucha, gameCube));
        videojuegoRepository.save(new Videojuego(null, "Super Smash Bros. Brawl", 2008, "Incluye el modo historia Emisario Subespacial y personajes de terceros.", new BigDecimal("39.99"), 4, nintendo, lucha, wii));
        videojuegoRepository.save(new Videojuego(null, "Pokémon Stadium", 2000, "Batallas Pokémon en 3D completas conectando tus cartuchos de Game Boy.", new BigDecimal("29.99"), 4, nintendo, rpg, n64));
        videojuegoRepository.save(new Videojuego(null, "Pokémon Edición Roja", 1996, "El inicio de la leyenda. Atrapa a los 151 originales en Kanto.", new BigDecimal("9.99"), 5, gameFreak, rpg, gameBoy));
        videojuegoRepository.save(new Videojuego(null, "Pokémon Edición Plata", 1999, "Viaja por Johto y descubre 100 nuevas especies de Pokémon.", new BigDecimal("9.99"), 5, gameFreak, rpg, gameBoy));
        videojuegoRepository.save(new Videojuego(null, "Pokémon Edición Esmeralda", 2004, "Enfrenta al Equipo Magma y Aqua en la soleada región de Hoenn.", new BigDecimal("14.99"), 5, gameFreak, rpg, gba));
        videojuegoRepository.save(new Videojuego(null, "The King of Fighters '98", 1998, "El 'Dream Match' definitivo de la era dorada de los arcades de lucha.", new BigDecimal("14.99"), 5, snk, lucha, arcade));
        videojuegoRepository.save(new Videojuego(null, "The King of Fighters 2002", 2002, "Clásico juego de lucha 3v3 sin historia canónica, enfocado en puro combate.", new BigDecimal("14.99"), 5, snk, lucha, arcade));
        videojuegoRepository.save(new Videojuego(null, "The King of Fighters XV", 2022, "El regreso de la franquicia con nuevas mecánicas y gráficos 3D.", new BigDecimal("59.99"), 4, snk, lucha, pc));
        videojuegoRepository.save(new Videojuego(null, "Duolingo", 2011, "Aprende nuevos idiomas a través de lecciones cortas y gamificadas.", new BigDecimal("0.00"), 5, duolingoInc, educacion, movil));
        videojuegoRepository.save(new Videojuego(null, "Kahoot!", 2013, "Plataforma de aprendizaje basada en divertidos cuestionarios grupales.", new BigDecimal("0.00"), 4, indie, educacion, movil));
        videojuegoRepository.save(new Videojuego(null, "Math Blaster", 1983, "Clásico juego educativo para aprender matemáticas en el espacio.", new BigDecimal("5.99"), 4, indie, educacion, pc));
        videojuegoRepository.save(new Videojuego(null, "Chrono Trigger", 1995, "Obra maestra de los RPGs donde viajas en el tiempo para salvar al mundo.", new BigDecimal("14.99"), 5, squareEnix, rpg, snes));
        videojuegoRepository.save(new Videojuego(null, "The Legend of Zelda: A Link to the Past", 1991, "Link explora el Mundo de la Luz y de la Oscuridad.", new BigDecimal("19.99"), 5, nintendo, aventura, snes));
        videojuegoRepository.save(new Videojuego(null, "Super Mario World", 1990, "Aventura de Mario en Dinosaur Land y la primera aparición de Yoshi.", new BigDecimal("19.99"), 5, nintendo, plataformas, snes));
        videojuegoRepository.save(new Videojuego(null, "Castlevania: Symphony of the Night", 1997, "Alucard explora el castillo de Drácula, definiendo el género Metroidvania.", new BigDecimal("9.99"), 5, konami, metroidvania, ps1));
        videojuegoRepository.save(new Videojuego(null, "Metal Gear Solid", 1998, "Solid Snake se infiltra en Shadow Moses redefiniendo los juegos de sigilo.", new BigDecimal("9.99"), 5, konami, aventura, ps1));
        videojuegoRepository.save(new Videojuego(null, "Final Fantasy VII", 1997, "El RPG clásico original que popularizó el género en occidente.", new BigDecimal("11.99"), 5, squareEnix, rpg, ps1));
        videojuegoRepository.save(new Videojuego(null, "Crash Bandicoot", 1996, "El marsupial gira y salta para detener al malvado Dr. Neo Cortex.", new BigDecimal("9.99"), 4, sony, plataformas, ps1));
        videojuegoRepository.save(new Videojuego(null, "Tetris", 1989, "El adictivo juego de encajar bloques que revolucionó las portátiles.", new BigDecimal("4.99"), 5, nintendo, puzzle, gameBoy));
        videojuegoRepository.save(new Videojuego(null, "Pac-Man", 1980, "Come píldoras y huye de los fantasmas en el clásico laberinto.", new BigDecimal("2.99"), 5, indie, puzzle, arcade));
        videojuegoRepository.save(new Videojuego(null, "Street Fighter II", 1991, "El padre de los juegos de lucha competitivos modernos.", new BigDecimal("4.99"), 5, capcom, lucha, arcade));
        videojuegoRepository.save(new Videojuego(null, "Diablo II", 2000, "Corta y raja a través de hordas de demonios en este clásico RPG de acción.", new BigDecimal("19.99"), 5, blizzard, accionRpg, pc));
        videojuegoRepository.save(new Videojuego(null, "StarCraft", 1998, "Estrategia en tiempo real en una guerra intergaláctica entre 3 facciones.", new BigDecimal("14.99"), 5, blizzard, puzzle, pc));
        videojuegoRepository.save(new Videojuego(null, "League of Legends", 2009, "El MOBA más jugado del mundo con constantes actualizaciones.", new BigDecimal("0.00"), 4, riot, moba, pc));
        videojuegoRepository.save(new Videojuego(null, "Valorant", 2020, "Shooter táctico por equipos combinando precisión y habilidades.", new BigDecimal("0.00"), 4, riot, shooter, pc));
        videojuegoRepository.save(new Videojuego(null, "Super Mario 64", 1996, "El salto de Mario a las 3 dimensiones que cambió la industria.", new BigDecimal("9.99"), 5, nintendo, plataformas, n64));
        videojuegoRepository.save(new Videojuego(null, "GoldenEye 007", 1997, "El shooter en primera persona que revolucionó el multijugador de sofá.", new BigDecimal("9.99"), 5, nintendo, shooter, n64));
        videojuegoRepository.save(new Videojuego(null, "Tomb Raider", 1996, "Las primeras aventuras arqueológicas de Lara Croft en 3D.", new BigDecimal("6.99"), 4, indie, aventura, ps1));
        videojuegoRepository.save(new Videojuego(null, "Silent Hill", 1999, "Un padre busca a su hija en un terrorífico pueblo envuelto en niebla.", new BigDecimal("9.99"), 5, konami, aventura, ps1));
        videojuegoRepository.save(new Videojuego(null, "Resident Evil 2", 1998, "Leon y Claire intentan escapar de Raccoon City en pleno brote zombie.", new BigDecimal("9.99"), 5, capcom, aventura, ps1));
        videojuegoRepository.save(new Videojuego(null, "Gran Turismo", 1997, "El simulador de conducción que exprimió la potencia de la PS1.", new BigDecimal("9.99"), 5, sony, simulacion, ps1));
        videojuegoRepository.save(new Videojuego(null, "Yu-Gi-Oh! Forbidden Memories", 1999, "Duelos de cartas y fusión mágica en el antiguo Egipto.", new BigDecimal("29.99"), 4, konami, cartas, ps1));
        videojuegoRepository.save(new Videojuego(null, "Pro Evolution Soccer 6", 2006, "El simulador de fútbol definitivo de su generación.", new BigDecimal("19.99"), 5, konami, deportes, pc));
        videojuegoRepository.save(new Videojuego(null, "Kerbal Space Program", 2015, "Construye naves y domina la física orbital y aerodinámica.", new BigDecimal("39.99"), 5, indie, simulacion, pc));
        videojuegoRepository.save(new Videojuego(null, "Rocksmith 2014", 2013, "Aprende a tocar la guitarra real con tus bandas de rock y metal favoritas.", new BigDecimal("29.99"), 5, indie, educacion, pc));
        videojuegoRepository.save(new Videojuego(null, "Age of Empires II: Definitive Edition", 2019, "Lidera civilizaciones históricas en tiempo real.", new BigDecimal("19.99"), 5, microsoft, simulacion, pc));
        videojuegoRepository.save(new Videojuego(null, "Tony Hawk's Pro Skater 2", 2000, "Realiza trucos increíbles al ritmo de una legendaria banda sonora de rock.", new BigDecimal("19.99"), 5, indie, deportes, ps1));
        videojuegoRepository.save(new Videojuego(null, "Fallout: New Vegas", 2010, "Sobrevive y elige tu bando en un desierto postapocalíptico.", new BigDecimal("9.99"), 5, microsoft, rpg, pc));
        videojuegoRepository.save(new Videojuego(null, "The Elder Scrolls V: Skyrim", 2011, "Derrota a los dragones en el inmenso mundo abierto de Tamriel.", new BigDecimal("39.99"), 5, microsoft, rpg, pc));
        videojuegoRepository.save(new Videojuego(null, "Left 4 Dead 2", 2009, "Sobrevive al apocalipsis zombie cooperando con tus amigos.", new BigDecimal("9.99"), 5, valve, shooter, pc));
        videojuegoRepository.save(new Videojuego(null, "Among Us", 2018, "Descubre al impostor en tu nave espacial antes de que sea tarde.", new BigDecimal("4.99"), 4, indie, puzzle, movil));
        videojuegoRepository.save(new Videojuego(null, "Terraria", 2011, "Explora, cava y lucha en un mundo 2D generado proceduralmente.", new BigDecimal("9.99"), 5, indie, aventura, pc));
        videojuegoRepository.save(new Videojuego(null, "Wii Sports", 2006, "Compite en tenis, bolos y béisbol moviendo tu propio cuerpo.", new BigDecimal("49.99"), 5, nintendo, deportes, wii));
        videojuegoRepository.save(new Videojuego(null, "Cuphead", 2017, "Supera desafiantes batallas con una animación clásica de los años 30.", new BigDecimal("19.99"), 5, indie, plataformas, pc));
        videojuegoRepository.save(new Videojuego(null, "Tekken 3", 1997, "El Torneo del Rey del Puño de Hierro entra en su era 3D.", new BigDecimal("14.99"), 5, indie, lucha, ps1));
        videojuegoRepository.save(new Videojuego(null, "Garry's Mod", 2006, "Un sandbox de físicas sin objetivos donde la imaginación es el límite.", new BigDecimal("9.99"), 5, valve, simulacion, pc));
        videojuegoRepository.save(new Videojuego(null, "Sonic the Hedgehog", 1991, "Corre a velocidad sónica para detener al malvado Dr. Robotnik.", new BigDecimal("4.99"), 5, sega, plataformas, arcade));

        log.info(">>> Carga finalizada exitosamente. Resumen de la Base de Datos: {} Compañías, {} Géneros, {} Plataformas y {} Videojuegos.", 
        companiaRepository.count(), 
        generoRepository.count(), 
        plataformaRepository.count(), 
        videojuegoRepository.count());

    }

}


//db_videojuegos_vm