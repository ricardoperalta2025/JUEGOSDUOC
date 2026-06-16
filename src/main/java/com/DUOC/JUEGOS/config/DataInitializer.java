package com.DUOC.JUEGOS.config;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.DUOC.JUEGOS.model.Compania;
import com.DUOC.JUEGOS.model.Genero;
import com.DUOC.JUEGOS.model.Juego;
import com.DUOC.JUEGOS.model.Plataforma;
import com.DUOC.JUEGOS.repository.CompaniaRepository;
import com.DUOC.JUEGOS.repository.GeneroRepository;
import com.DUOC.JUEGOS.repository.JuegoRepository;
import com.DUOC.JUEGOS.repository.PlataformaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CompaniaRepository companiaRepository;
    private final GeneroRepository generoRepository;
    private final PlataformaRepository plataformaRepository;
    private final JuegoRepository juegoRepository;

    @Override
    public void run(String... args) {

        if (juegoRepository.count() > 0) {
            log.info(">>> La base de datos ya tiene videojuegos insertados.");
            return;
        }
        log.info(">>> Iniciando carga de videojuegos...");
        
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
        
        juegoRepository.save(new Juego(null, "Yu-Gi-Oh! Master Duel", 2022, "Simulador competitivo del popular juego de cartas.", new BigDecimal("0.00"), 4, konami, cartas, pc));
        juegoRepository.save(new Juego(null, "Microsoft Flight Simulator 2024", 2024, "El simulador de aviación comercial y general más avanzado.", new BigDecimal("69.99"), 5, microsoft, simulacion, pc));
        juegoRepository.save(new Juego(null, "Elden Ring", 2022, "Aventura de rol en un inmenso y oscuro mundo abierto.", new BigDecimal("59.99"), 5, fromSoftware, rpg, ps5));
        juegoRepository.save(new Juego(null, "Super Mario Odyssey", 2017, "El plomero explora reinos 3D con la ayuda de su sombrero.", new BigDecimal("59.99"), 5, nintendo, plataformas, switchConsole));
        juegoRepository.save(new Juego(null, "Forza Horizon 5", 2021, "Conducción en un vibrante mundo abierto en México.", new BigDecimal("59.99"), 4, microsoft, simulacion, xbox));
        juegoRepository.save(new Juego(null, "Dark Souls III", 2016, "El final de la desafiante saga de fuego y cenizas.", new BigDecimal("39.99"), 4, fromSoftware, rpg, pc));
        juegoRepository.save(new Juego(null, "The Legend of Zelda: Tears of the Kingdom", 2023, "Secuela de Breath of the Wild con nuevas mecánicas de construcción.", new BigDecimal("69.99"), 5, nintendo, rpg, switchConsole));
        juegoRepository.save(new Juego(null, "Silent Hill 2", 2024, "Remake del clásico juego de terror psicológico.", new BigDecimal("69.99"), 4, konami, rpg, ps5));
        juegoRepository.save(new Juego(null, "Halo Infinite", 2021, "El regreso del Jefe Maestro con un nuevo anillo que explorar.", new BigDecimal("59.99"), 3, microsoft, rpg, xbox));
        juegoRepository.save(new Juego(null, "Animal Crossing: New Horizons", 2020, "Crea tu propia isla paradisíaca y convive con vecinos.", new BigDecimal("59.99"), 4, nintendo, simulacion, switchConsole));
        juegoRepository.save(new Juego(null, "Genshin Impact", 2020, "Viaja por el mundo mágico de Teyvat en busca de tu hermano/a.", new BigDecimal("0.00"), 5, hoyoverse, accionRpg, movil));
        juegoRepository.save(new Juego(null, "Honkai: Star Rail", 2023, "Súbete al Expreso Astral en esta odisea de combate por turnos.", new BigDecimal("0.00"), 5, hoyoverse, rpg, pc));
        juegoRepository.save(new Juego(null, "Zenless Zone Zero", 2024, "Explora Nueva Eridu y sobrevive a las misteriosas Cavidades.", new BigDecimal("0.00"), 4, hoyoverse, accionRpg, pc));
        juegoRepository.save(new Juego(null, "The Legend of Zelda: Ocarina of Time", 1998, "El Héroe del Tiempo viaja para detener al malvado Ganondorf.", new BigDecimal("49.99"), 5, nintendo, aventura, n64));
        juegoRepository.save(new Juego(null, "Klifur", 2024, "Juego de rompecabezas minimalista basado en físicas de escalada.", new BigDecimal("4.99"), 4, torfi, puzzle, pc));
        juegoRepository.save(new Juego(null, "Euro Truck Simulator 2", 2012, "Viaja a través de Europa entregando mercancías en tu camión.", new BigDecimal("19.99"), 5, scs, simulacion, pc));
        juegoRepository.save(new Juego(null, "God of War Ragnarök", 2022, "Kratos y Atreus enfrentan el inminente fin del mundo nórdico.", new BigDecimal("69.99"), 5, sony, aventura, ps5));
        juegoRepository.save(new Juego(null, "The Last of Us Part I", 2013, "Joel y Ellie cruzan un EE.UU. devastado por una infección.", new BigDecimal("69.99"), 5, sony, aventura, ps5));
        juegoRepository.save(new Juego(null, "Horizon Forbidden West", 2022, "Aloy explora un majestuoso y peligroso oeste postapocalíptico.", new BigDecimal("59.99"), 4, sony, accionRpg, ps5));
        juegoRepository.save(new Juego(null, "Marvel's Spider-Man 2", 2023, "Peter Parker y Miles Morales se enfrentan a Kraven y Venom.", new BigDecimal("69.99"), 5, sony, aventura, ps5));
        juegoRepository.save(new Juego(null, "Bloodborne", 2015, "Sobrevive a la cacería bestial en la pesadillesca ciudad de Yharnam.", new BigDecimal("19.99"), 5, sony, accionRpg, ps4));
        juegoRepository.save(new Juego(null, "Ghost of Tsushima", 2020, "Conviértete en el Fantasma para liberar tu hogar del imperio mongol.", new BigDecimal("59.99"), 5, sony, aventura, ps4));
        juegoRepository.save(new Juego(null, "Uncharted 4: El Desenlace del Ladrón", 2016, "La aventura definitiva de Nathan Drake.", new BigDecimal("19.99"), 5, sony, aventura, ps4));
        juegoRepository.save(new Juego(null, "Grand Theft Auto V", 2013, "Tres criminales planean grandes atracos en Los Santos.", new BigDecimal("29.99"), 5, rockstar, aventura, ps5));
        juegoRepository.save(new Juego(null, "Red Dead Redemption 2", 2018, "La épica y trágica historia de Arthur Morgan en el salvaje oeste.", new BigDecimal("59.99"), 5, rockstar, aventura, xbox));
        juegoRepository.save(new Juego(null, "The Witcher 3: Wild Hunt", 2015, "Geralt de Rivia busca a su hija adoptiva en un continente devastado.", new BigDecimal("39.99"), 5, cdprojekt, accionRpg, pc));
        juegoRepository.save(new Juego(null, "Cyberpunk 2077", 2020, "Un mercenario ambicioso busca la clave de la inmortalidad.", new BigDecimal("59.99"), 4, cdprojekt, accionRpg, pc));
        juegoRepository.save(new Juego(null, "Resident Evil 4 Remake", 2023, "Leon S. Kennedy viaja a Europa para rescatar a la hija del presidente.", new BigDecimal("59.99"), 5, capcom, aventura, ps5));
        juegoRepository.save(new Juego(null, "Monster Hunter: World", 2018, "Caza monstruos gigantescos en ecosistemas vivos y dinámicos.", new BigDecimal("29.99"), 5, capcom, accionRpg, pc));
        juegoRepository.save(new Juego(null, "Street Fighter 6", 2023, "El retorno del rey de los juegos de lucha con nuevas mecánicas.", new BigDecimal("59.99"), 4, capcom, lucha, ps5));
        juegoRepository.save(new Juego(null, "Devil May Cry 5", 2019, "Caza demonios ejecutando combos impecables.", new BigDecimal("29.99"), 5, capcom, accionRpg, xbox));
        juegoRepository.save(new Juego(null, "Final Fantasy VII Remake", 2020, "Cloud Strife se une a una eco-resistencia para luchar en Midgar.", new BigDecimal("69.99"), 5, squareEnix, accionRpg, ps5));
        juegoRepository.save(new Juego(null, "NieR:Automata", 2017, "Androides luchan en una guerra interminable por la Tierra.", new BigDecimal("39.99"), 5, squareEnix, accionRpg, pc));
        juegoRepository.save(new Juego(null, "Kingdom Hearts III", 2019, "Sora, Donald y Goofy viajan por los mágicos mundos de Disney.", new BigDecimal("59.99"), 4, squareEnix, accionRpg, ps4));
        juegoRepository.save(new Juego(null, "Super Smash Bros. Ultimate", 2018, "El mayor crossover de la historia en un solo título de peleas.", new BigDecimal("59.99"), 5, nintendo, lucha, switchConsole));
        juegoRepository.save(new Juego(null, "Mario Kart 8 Deluxe", 2017, "Frenéticas carreras antigravedad.", new BigDecimal("59.99"), 5, nintendo, deportes, switchConsole));
        juegoRepository.save(new Juego(null, "Metroid Dread", 2021, "Samus Aran explora el laberíntico y misterioso planeta ZDR.", new BigDecimal("59.99"), 4, nintendo, metroidvania, switchConsole));
        juegoRepository.save(new Juego(null, "Half-Life 2", 2004, "Gordon Freeman lidera la resistencia contra los Combine.", new BigDecimal("9.99"), 5, valve, shooter, pc));
        juegoRepository.save(new Juego(null, "Portal 2", 2011, "Resuelve letales puzles físicos usando portales.", new BigDecimal("9.99"), 5, valve, puzzle, pc));
        juegoRepository.save(new Juego(null, "Persona 5 Royal", 2019, "Sé un estudiante de día y un ladrón de corazones de noche.", new BigDecimal("59.99"), 5, sega, rpg, ps5));
        juegoRepository.save(new Juego(null, "Yakuza: Like a Dragon", 2020, "Un yakuza traicionado se convierte en un héroe de RPG.", new BigDecimal("59.99"), 4, sega, rpg, xbox));
        juegoRepository.save(new Juego(null, "Minecraft", 2011, "Explora, extrae recursos y construye en un mundo infinito.", new BigDecimal("29.99"), 5, microsoft, simulacion, pc));
        juegoRepository.save(new Juego(null, "Doom Eternal", 2020, "Desata tu furia contra los ejércitos del infierno.", new BigDecimal("39.99"), 5, microsoft, shooter, pc));
        juegoRepository.save(new Juego(null, "Overwatch 2", 2022, "Hero shooter competitivo por equipos.", new BigDecimal("0.00"), 3, microsoft, shooter, pc));
        juegoRepository.save(new Juego(null, "Hades", 2020, "Intenta escapar del Inframundo griego.", new BigDecimal("24.99"), 5, indie, accionRpg, pc));
        juegoRepository.save(new Juego(null, "Stardew Valley", 2016, "Restaura la granja de tu abuelo y vive una vida pacífica.", new BigDecimal("14.99"), 5, indie, simulacion, pc));
        juegoRepository.save(new Juego(null, "Hollow Knight", 2017, "Desciende a las ruinas de un oscuro reino de insectos.", new BigDecimal("14.99"), 5, indie, metroidvania, pc));
        juegoRepository.save(new Juego(null, "Celeste", 2018, "Ayuda a Madeline a sobrevivir a la escalada de una montaña.", new BigDecimal("19.99"), 5, indie, plataformas, pc));
        juegoRepository.save(new Juego(null, "Sekiro: Shadows Die Twice", 2019, "Venganza y honor en el Japón de la era Sengoku.", new BigDecimal("59.99"), 5, fromSoftware, aventura, ps4));
        juegoRepository.save(new Juego(null, "Ragnarok Online", 2002, "Mítico MMORPG basado en la mitología nórdica y gráficos anime.", new BigDecimal("0.00"), 5, gravity, mmorpg, pc));
        juegoRepository.save(new Juego(null, "World of Warcraft", 2004, "Explora Azeroth en el MMORPG más influyente de todos los tiempos.", new BigDecimal("14.99"), 5, blizzard, mmorpg, pc));
        juegoRepository.save(new Juego(null, "Super Smash Bros.", 1999, "El inicio del torneo donde los personajes de Nintendo se enfrentan.", new BigDecimal("39.99"), 4, nintendo, lucha, n64));
        juegoRepository.save(new Juego(null, "Super Smash Bros. Melee", 2001, "Aclamada secuela con un ritmo de combate rápido y técnico.", new BigDecimal("49.99"), 5, nintendo, lucha, gameCube));
        juegoRepository.save(new Juego(null, "Super Smash Bros. Brawl", 2008, "Incluye el modo historia Emisario Subespacial y personajes de terceros.", new BigDecimal("39.99"), 4, nintendo, lucha, wii));
        juegoRepository.save(new Juego(null, "Pokémon Stadium", 2000, "Batallas Pokémon en 3D completas conectando tus cartuchos de Game Boy.", new BigDecimal("29.99"), 4, nintendo, rpg, n64));
        juegoRepository.save(new Juego(null, "Pokémon Edición Roja", 1996, "El inicio de la leyenda. Atrapa a los 151 originales en Kanto.", new BigDecimal("9.99"), 5, gameFreak, rpg, gameBoy));
        juegoRepository.save(new Juego(null, "Pokémon Edición Plata", 1999, "Viaja por Johto y descubre 100 nuevas especies de Pokémon.", new BigDecimal("9.99"), 5, gameFreak, rpg, gameBoy));
        juegoRepository.save(new Juego(null, "Pokémon Edición Esmeralda", 2004, "Enfrenta al Equipo Magma y Aqua en la soleada región de Hoenn.", new BigDecimal("14.99"), 5, gameFreak, rpg, gba));
        juegoRepository.save(new Juego(null, "The King of Fighters '98", 1998, "El 'Dream Match' definitivo de la era dorada de los arcades de lucha.", new BigDecimal("14.99"), 5, snk, lucha, arcade));
        juegoRepository.save(new Juego(null, "The King of Fighters 2002", 2002, "Clásico juego de lucha 3v3 sin historia canónica, enfocado en puro combate.", new BigDecimal("14.99"), 5, snk, lucha, arcade));
        juegoRepository.save(new Juego(null, "The King of Fighters XV", 2022, "El regreso de la franquicia con nuevas mecánicas y gráficos 3D.", new BigDecimal("59.99"), 4, snk, lucha, pc));
        juegoRepository.save(new Juego(null, "Duolingo", 2011, "Aprende nuevos idiomas a través de lecciones cortas y gamificadas.", new BigDecimal("0.00"), 5, duolingoInc, educacion, movil));
        juegoRepository.save(new Juego(null, "Kahoot!", 2013, "Plataforma de aprendizaje basada en divertidos cuestionarios grupales.", new BigDecimal("0.00"), 4, indie, educacion, movil));
        juegoRepository.save(new Juego(null, "Math Blaster", 1983, "Clásico juego educativo para aprender matemáticas en el espacio.", new BigDecimal("5.99"), 4, indie, educacion, pc));
        juegoRepository.save(new Juego(null, "Chrono Trigger", 1995, "Obra maestra de los RPGs donde viajas en el tiempo para salvar al mundo.", new BigDecimal("14.99"), 5, squareEnix, rpg, snes));
        juegoRepository.save(new Juego(null, "The Legend of Zelda: A Link to the Past", 1991, "Link explora el Mundo de la Luz y de la Oscuridad.", new BigDecimal("19.99"), 5, nintendo, aventura, snes));
        juegoRepository.save(new Juego(null, "Super Mario World", 1990, "Aventura de Mario en Dinosaur Land y la primera aparición de Yoshi.", new BigDecimal("19.99"), 5, nintendo, plataformas, snes));
        juegoRepository.save(new Juego(null, "Castlevania: Symphony of the Night", 1997, "Alucard explora el castillo de Drácula, definiendo el género Metroidvania.", new BigDecimal("9.99"), 5, konami, metroidvania, ps1));
        juegoRepository.save(new Juego(null, "Metal Gear Solid", 1998, "Solid Snake se infiltra en Shadow Moses redefiniendo los juegos de sigilo.", new BigDecimal("9.99"), 5, konami, aventura, ps1));
        juegoRepository.save(new Juego(null, "Final Fantasy VII", 1997, "El RPG clásico original que popularizó el género en occidente.", new BigDecimal("11.99"), 5, squareEnix, rpg, ps1));
        juegoRepository.save(new Juego(null, "Crash Bandicoot", 1996, "El marsupial gira y salta para detener al malvado Dr. Neo Cortex.", new BigDecimal("9.99"), 4, sony, plataformas, ps1));
        juegoRepository.save(new Juego(null, "Tetris", 1989, "El adictivo juego de encajar bloques que revolucionó las portátiles.", new BigDecimal("4.99"), 5, nintendo, puzzle, gameBoy));
        juegoRepository.save(new Juego(null, "Pac-Man", 1980, "Come píldoras y huye de los fantasmas en el clásico laberinto.", new BigDecimal("2.99"), 5, indie, puzzle, arcade));
        juegoRepository.save(new Juego(null, "Street Fighter II", 1991, "El padre de los juegos de lucha competitivos modernos.", new BigDecimal("4.99"), 5, capcom, lucha, arcade));
        juegoRepository.save(new Juego(null, "Diablo II", 2000, "Corta y raja a través de hordas de demonios en este clásico RPG de acción.", new BigDecimal("19.99"), 5, blizzard, accionRpg, pc));
        juegoRepository.save(new Juego(null, "StarCraft", 1998, "Estrategia en tiempo real en una guerra intergaláctica entre 3 facciones.", new BigDecimal("14.99"), 5, blizzard, puzzle, pc));
        juegoRepository.save(new Juego(null, "League of Legends", 2009, "El MOBA más jugado del mundo con constantes actualizaciones.", new BigDecimal("0.00"), 4, riot, moba, pc));
        juegoRepository.save(new Juego(null, "Valorant", 2020, "Shooter táctico por equipos combinando precisión y habilidades.", new BigDecimal("0.00"), 4, riot, shooter, pc));
        juegoRepository.save(new Juego(null, "Super Mario 64", 1996, "El salto de Mario a las 3 dimensiones que cambió la industria.", new BigDecimal("9.99"), 5, nintendo, plataformas, n64));
        juegoRepository.save(new Juego(null, "GoldenEye 007", 1997, "El shooter en primera persona que revolucionó el multijugador de sofá.", new BigDecimal("9.99"), 5, nintendo, shooter, n64));
        juegoRepository.save(new Juego(null, "Tomb Raider", 1996, "Las primeras aventuras arqueológicas de Lara Croft en 3D.", new BigDecimal("6.99"), 4, indie, aventura, ps1));
        juegoRepository.save(new Juego(null, "Silent Hill", 1999, "Un padre busca a su hija en un terrorífico pueblo envuelto en niebla.", new BigDecimal("9.99"), 5, konami, aventura, ps1));
        juegoRepository.save(new Juego(null, "Resident Evil 2", 1998, "Leon y Claire intentan escapar de Raccoon City en pleno brote zombie.", new BigDecimal("9.99"), 5, capcom, aventura, ps1));
        juegoRepository.save(new Juego(null, "Gran Turismo", 1997, "El simulador de conducción que exprimió la potencia de la PS1.", new BigDecimal("9.99"), 5, sony, simulacion, ps1));
        juegoRepository.save(new Juego(null, "Yu-Gi-Oh! Forbidden Memories", 1999, "Duelos de cartas y fusión mágica en el antiguo Egipto.", new BigDecimal("29.99"), 4, konami, cartas, ps1));
        juegoRepository.save(new Juego(null, "Pro Evolution Soccer 6", 2006, "El simulador de fútbol definitivo de su generación.", new BigDecimal("19.99"), 5, konami, deportes, pc));
        juegoRepository.save(new Juego(null, "Kerbal Space Program", 2015, "Construye naves y domina la física orbital y aerodinámica.", new BigDecimal("39.99"), 5, indie, simulacion, pc));
        juegoRepository.save(new Juego(null, "Rocksmith 2014", 2013, "Aprende a tocar la guitarra real con tus bandas de rock y metal favoritas.", new BigDecimal("29.99"), 5, indie, educacion, pc));
        juegoRepository.save(new Juego(null, "Age of Empires II: Definitive Edition", 2019, "Lidera civilizaciones históricas en tiempo real.", new BigDecimal("19.99"), 5, microsoft, simulacion, pc));
        juegoRepository.save(new Juego(null, "Tony Hawk's Pro Skater 2", 2000, "Realiza trucos increíbles al ritmo de una legendaria banda sonora de rock.", new BigDecimal("19.99"), 5, indie, deportes, ps1));
        juegoRepository.save(new Juego(null, "Fallout: New Vegas", 2010, "Sobrevive y elige tu bando en un desierto postapocalíptico.", new BigDecimal("9.99"), 5, microsoft, rpg, pc));
        juegoRepository.save(new Juego(null, "The Elder Scrolls V: Skyrim", 2011, "Derrota a los dragones en el inmenso mundo abierto de Tamriel.", new BigDecimal("39.99"), 5, microsoft, rpg, pc));
        juegoRepository.save(new Juego(null, "Left 4 Dead 2", 2009, "Sobrevive al apocalipsis zombie cooperando con tus amigos.", new BigDecimal("9.99"), 5, valve, shooter, pc));
        juegoRepository.save(new Juego(null, "Among Us", 2018, "Descubre al impostor en tu nave espacial antes de que sea tarde.", new BigDecimal("4.99"), 4, indie, puzzle, movil));
        juegoRepository.save(new Juego(null, "Terraria", 2011, "Explora, cava y lucha en un mundo 2D generado proceduralmente.", new BigDecimal("9.99"), 5, indie, aventura, pc));
        juegoRepository.save(new Juego(null, "Wii Sports", 2006, "Compite en tenis, bolos y béisbol moviendo tu propio cuerpo.", new BigDecimal("49.99"), 5, nintendo, deportes, wii));
        juegoRepository.save(new Juego(null, "Cuphead", 2017, "Supera desafiantes batallas con una animación clásica de los años 30.", new BigDecimal("19.99"), 5, indie, plataformas, pc));
        juegoRepository.save(new Juego(null, "Tekken 3", 1997, "El Torneo del Rey del Puño de Hierro entra en su era 3D.", new BigDecimal("14.99"), 5, indie, lucha, ps1));
        juegoRepository.save(new Juego(null, "Garry's Mod", 2006, "Un sandbox de físicas sin objetivos donde la imaginación es el límite.", new BigDecimal("9.99"), 5, valve, simulacion, pc));
        juegoRepository.save(new Juego(null, "Sonic the Hedgehog", 1991, "Corre a velocidad sónica para detener al malvado Dr. Robotnik.", new BigDecimal("4.99"), 5, sega, plataformas, arcade));
        juegoRepository.save(new Juego(null, "Legends of Runeterra", 2020, "Juego de cartas estratégico ambientado en el universo de League of Legends.", new BigDecimal("0.00"), 5, riot, cartas, pc));
        juegoRepository.save(new Juego(null, "Tanto Cuore", 2010, "Juego de construcción de mazos con temática de sirvientas japonesas.", new BigDecimal("19.99"), 4, indie, cartas, pc));
        juegoRepository.save(new Juego(null, "Hearthstone", 2014, "El exitoso juego de cartas coleccionables basado en el universo de Warcraft.", new BigDecimal("0.00"), 5, blizzard, cartas, pc));
        juegoRepository.save(new Juego(null, "Slay the Spire", 2019, "Fusiona juegos de cartas y roguelikes en una aventura de escalada única.", new BigDecimal("24.99"), 5, indie, cartas, pc));
        juegoRepository.save(new Juego(null, "Balatro", 2024, "Adictivo deckbuilder roguelike basado en mecánicas de póker.", new BigDecimal("14.99"), 5, indie, cartas, pc));
        juegoRepository.save(new Juego(null, "Gwent: The Witcher Card Game", 2018, "El juego de cartas favorito de Geralt de Rivia, ahora independiente.", new BigDecimal("0.00"), 4, cdprojekt, cartas, pc));
        juegoRepository.save(new Juego(null, "Marvel Snap", 2022, "Batallas de cartas rápidas y dinámicas con los héroes y villanos de Marvel.", new BigDecimal("0.00"), 5, indie, cartas, movil));
        juegoRepository.save(new Juego(null, "Inscryption", 2021, "Una odisea basada en cartas que mezcla deckbuilding con terror psicológico.", new BigDecimal("19.99"), 5, indie, cartas, pc));
        juegoRepository.save(new Juego(null, "Magic: The Gathering Arena", 2019, "La versión digital definitiva del pionero de los juegos de cartas.", new BigDecimal("0.00"), 4, indie, cartas, pc));
        juegoRepository.save(new Juego(null, "Thronebreaker: The Witcher Tales", 2018, "RPG de un jugador donde los combates se resuelven jugando Gwent.", new BigDecimal("19.99"), 4, cdprojekt, cartas, pc));
        juegoRepository.save(new Juego(null, "Shadowverse", 2016, "Juego de cartas digital con fuerte estilo visual de anime japonés.", new BigDecimal("0.00"), 4, indie, cartas, movil));
        juegoRepository.save(new Juego(null, "Pokémon TCG Live", 2023, "La plataforma oficial para jugar al Juego de Cartas Coleccionables Pokémon.", new BigDecimal("0.00"), 3, gameFreak, cartas, movil));
        juegoRepository.save(new Juego(null, "Dota 2", 2013, "El titán de los MOBA que revolucionó los deportes electrónicos.", new BigDecimal("0.00"), 5, valve, moba, pc));
        juegoRepository.save(new Juego(null, "Smite", 2014, "MOBA en tercera persona donde controlas a dioses mitológicos.", new BigDecimal("0.00"), 4, indie, moba, pc));
        juegoRepository.save(new Juego(null, "Heroes of the Storm", 2015, "Combates frenéticos juntando a los héroes de todos los universos de Blizzard.", new BigDecimal("0.00"), 4, blizzard, moba, pc));
        juegoRepository.save(new Juego(null, "Pokémon UNITE", 2021, "Batallas estratégicas por equipos 5v5 usando a tus Pokémon favoritos.", new BigDecimal("0.00"), 4, gameFreak, moba, switchConsole));
        juegoRepository.save(new Juego(null, "Mobile Legends: Bang Bang", 2016, "El MOBA más popular diseñado específicamente para dispositivos móviles.", new BigDecimal("0.00"), 4, indie, moba, movil));
        juegoRepository.save(new Juego(null, "Arena of Valor", 2016, "Batallas épicas 5v5 con controles optimizados para la pantalla táctil.", new BigDecimal("0.00"), 4, indie, moba, movil));
        juegoRepository.save(new Juego(null, "League of Legends: Wild Rift", 2020, "La experiencia completa de LoR reconstruida para móviles y consolas.", new BigDecimal("0.00"), 5, riot, moba, movil));
        juegoRepository.save(new Juego(null, "Battlerite", 2017, "Brawler de arena (Team Arena Brawler) enfocado puramente en el combate.", new BigDecimal("0.00"), 4, indie, moba, pc));
        juegoRepository.save(new Juego(null, "Warcraft III: Reign of Chaos", 2002, "El clásico juego de estrategia que sentó las bases para el género MOBA.", new BigDecimal("19.99"), 5, blizzard, aventura, pc));
        juegoRepository.save(new Juego(null, "Warcraft III: The Frozen Throne", 2003, "La legendaria expansión que culmina la historia de Arthas.", new BigDecimal("19.99"), 5, blizzard, aventura, pc));
        juegoRepository.save(new Juego(null, "World of Warcraft: Wrath of the Lich King", 2008, "La expansión más aclamada, llevando a los jugadores a Rasganorte.", new BigDecimal("39.99"), 5, blizzard, mmorpg, pc));
        juegoRepository.save(new Juego(null, "World of Warcraft: Legion", 2016, "El retorno de la Legión Ardiente y los Cazadores de Demonios.", new BigDecimal("39.99"), 4, blizzard, mmorpg, pc));
        juegoRepository.save(new Juego(null, "Final Fantasy XIV: Endwalker", 2021, "La épica conclusión de la saga de Hydaelyn y Zodiark.", new BigDecimal("39.99"), 5, squareEnix, mmorpg, pc));
        juegoRepository.save(new Juego(null, "Guild Wars 2", 2012, "MMORPG sin cuotas mensuales y eventos dinámicos en un mundo vivo.", new BigDecimal("0.00"), 5, indie, mmorpg, pc));
        juegoRepository.save(new Juego(null, "Black Desert Online", 2014, "MMORPG coreano conocido por su espectacular sistema de combate y gráficos.", new BigDecimal("9.99"), 4, indie, mmorpg, pc));
        juegoRepository.save(new Juego(null, "RuneScape", 2001, "El icónico MMORPG de fantasía que ha evolucionado durante dos décadas.", new BigDecimal("0.00"), 4, indie, mmorpg, pc));
        juegoRepository.save(new Juego(null, "Monster Hunter Rise", 2021, "Caza monstruos con extrema agilidad gracias a los cordópteros.", new BigDecimal("39.99"), 5, capcom, accionRpg, switchConsole));
        juegoRepository.save(new Juego(null, "Monster Hunter Generations Ultimate", 2018, "El homenaje masivo a toda la franquicia clásica de cazadores.", new BigDecimal("39.99"), 4, capcom, accionRpg, switchConsole));
        juegoRepository.save(new Juego(null, "Monster Hunter 3 Ultimate", 2013, "Introduce combates submarinos y una ecología rica en detalles.", new BigDecimal("19.99"), 4, capcom, accionRpg, wii));
        juegoRepository.save(new Juego(null, "Monster Hunter Freedom Unite", 2008, "El título portátil que popularizó la saga en todo el mundo.", new BigDecimal("9.99"), 5, capcom, accionRpg, pc));
        juegoRepository.save(new Juego(null, "Bloodborne: The Old Hunters", 2015, "Una terrorífica expansión que revela los oscuros secretos de Yharnam.", new BigDecimal("19.99"), 5, sony, accionRpg, ps4));
        juegoRepository.save(new Juego(null, "Demon's Souls Remake", 2020, "El espectacular renacimiento del juego que inició el género Souls.", new BigDecimal("69.99"), 5, sony, accionRpg, ps5));
        juegoRepository.save(new Juego(null, "Dark Souls Remastered", 2018, "Toca la campana del despertar en la versión definitiva de Lordran.", new BigDecimal("39.99"), 5, fromSoftware, accionRpg, pc));
        juegoRepository.save(new Juego(null, "Dark Souls II: Scholar of the First Sin", 2015, "La edición completa y rediseñada del desafiante viaje a Drangleic.", new BigDecimal("39.99"), 4, fromSoftware, accionRpg, pc));
        juegoRepository.save(new Juego(null, "Armored Core VI: Fires of Rubicon", 2023, "Ensambla tu mecha y sobrevive a misiones de altísima intensidad.", new BigDecimal("59.99"), 5, fromSoftware, accionRpg, ps5));
        juegoRepository.save(new Juego(null, "Nioh", 2017, "Un samurái occidental lucha contra demonios en el Japón del siglo XVII.", new BigDecimal("19.99"), 4, sony, accionRpg, ps4));
        juegoRepository.save(new Juego(null, "Nioh 2", 2020, "Desata tus poderes Yokai en esta desafiante precuela de acción.", new BigDecimal("39.99"), 5, sony, accionRpg, ps4));
        juegoRepository.save(new Juego(null, "Dragon Quest XI: Ecos de un Pasado Perdido", 2017, "La cumbre del JRPG clásico con gráficos hermosos y una historia épica.", new BigDecimal("39.99"), 5, squareEnix, rpg, ps4));
        juegoRepository.save(new Juego(null, "Final Fantasy VIII", 1999, "Squall Leonhart lidera a mercenarios SeeD en un conflicto global.", new BigDecimal("11.99"), 4, squareEnix, rpg, ps1));
        juegoRepository.save(new Juego(null, "Final Fantasy IX", 2000, "Un nostálgico retorno a las raíces de fantasía pura de la saga.", new BigDecimal("11.99"), 5, squareEnix, rpg, ps1));
        juegoRepository.save(new Juego(null, "Final Fantasy X", 2001, "Tidus y Yuna viajan por Spira para derrotar a la colosal amenaza de Sinh.", new BigDecimal("19.99"), 5, squareEnix, rpg, ps4));
        juegoRepository.save(new Juego(null, "Final Fantasy XVI", 2023, "Oscura fantasía medieval enfocada en la acción pura de los Eikons.", new BigDecimal("69.99"), 4, squareEnix, accionRpg, ps5));
        juegoRepository.save(new Juego(null, "Chrono Cross", 1999, "Viaja entre mundos paralelos en esta obra maestra de 32 bits.", new BigDecimal("9.99"), 5, squareEnix, rpg, ps1));
        juegoRepository.save(new Juego(null, "Suikoden II", 1998, "Recluta a 108 Estrellas del Destino en uno de los mejores RPGs de la historia.", new BigDecimal("9.99"), 5, konami, rpg, ps1));
        juegoRepository.save(new Juego(null, "Xenoblade Chronicles", 2010, "Aventura masiva explorando los cuerpos petrificados de dos titanes.", new BigDecimal("39.99"), 5, nintendo, rpg, wii));
        juegoRepository.save(new Juego(null, "Xenoblade Chronicles 2", 2017, "Rex busca el paraíso de Elysium junto a la legendaria Égida.", new BigDecimal("59.99"), 4, nintendo, rpg, switchConsole));
        juegoRepository.save(new Juego(null, "Xenoblade Chronicles 3", 2022, "Dos naciones en guerra deben unirse para romper un ciclo interminable.", new BigDecimal("59.99"), 5, nintendo, rpg, switchConsole));
        juegoRepository.save(new Juego(null, "EarthBound", 1994, "Ness y sus amigos luchan contra aliens usando bates de béisbol y poderes PSI.", new BigDecimal("9.99"), 5, nintendo, rpg, snes));
        juegoRepository.save(new Juego(null, "Super Mario RPG: Legend of the Seven Stars", 1996, "Mario une fuerzas con Bowser para recuperar los fragmentos de estrella.", new BigDecimal("9.99"), 5, nintendo, rpg, snes));
        juegoRepository.save(new Juego(null, "Baldur's Gate 3", 2023, "La experiencia definitiva de rol de mesa llevada al formato digital.", new BigDecimal("59.99"), 5, indie, rpg, pc));
        juegoRepository.save(new Juego(null, "Divinity: Original Sin 2", 2017, "Libertad total y combate por turnos profundo en el mundo de Rivellon.", new BigDecimal("44.99"), 5, indie, rpg, pc));
        juegoRepository.save(new Juego(null, "Mass Effect Legendary Edition", 2021, "La épica trilogía de rol y ciencia ficción del Comandante Shepard.", new BigDecimal("59.99"), 5, indie, rpg, pc));
        juegoRepository.save(new Juego(null, "Fallout 3", 2008, "Sobrevive a las ruinas irradiadas de Washington D.C.", new BigDecimal("9.99"), 4, microsoft, rpg, pc));
        juegoRepository.save(new Juego(null, "Fallout 4", 2015, "Emerge del Refugio 111 y reconstruye el yermo de la Commonwealth.", new BigDecimal("19.99"), 4, microsoft, rpg, ps4));
        juegoRepository.save(new Juego(null, "The Elder Scrolls IV: Oblivion", 2006, "Cierra las puertas del infierno que amenazan a la provincia de Cyrodiil.", new BigDecimal("9.99"), 5, microsoft, rpg, pc));
        juegoRepository.save(new Juego(null, "Starfield", 2023, "El primer universo nuevo de Bethesda en 25 años. Explora mil planetas.", new BigDecimal("69.99"), 3, microsoft, rpg, xbox));
        juegoRepository.save(new Juego(null, "Ori and the Blind Forest", 2015, "Plataformas fluidas y una historia emotiva con un apartado visual increíble.", new BigDecimal("19.99"), 5, microsoft, metroidvania, pc));
        juegoRepository.save(new Juego(null, "Ori and the Will of the Wisps", 2020, "Secuela que mejora cada aspecto, añadiendo combate profundo y jefes épicos.", new BigDecimal("29.99"), 5, microsoft, metroidvania, xbox));
        juegoRepository.save(new Juego(null, "Super Metroid", 1994, "El pináculo del diseño de niveles que definió todo un género.", new BigDecimal("9.99"), 5, nintendo, metroidvania, snes));
        juegoRepository.save(new Juego(null, "Castlevania: Aria of Sorrow", 2003, "Absorbe las almas de tus enemigos en el castillo de Drácula.", new BigDecimal("9.99"), 5, konami, metroidvania, gba));
        juegoRepository.save(new Juego(null, "Blasphemous", 2019, "Un castigo oscuro y sangriento inspirado en el folclore del sur de España.", new BigDecimal("24.99"), 4, indie, metroidvania, pc));
        juegoRepository.save(new Juego(null, "Dead Cells", 2018, "Acción roguelike trepidante de tipo metroidvania, sin puntos de control.", new BigDecimal("24.99"), 5, indie, metroidvania, pc));
        juegoRepository.save(new Juego(null, "Guacamelee!", 2013, "Luchador enmascarado pelea por amor y honor en un mundo de vivos y muertos.", new BigDecimal("14.99"), 4, indie, metroidvania, pc));
        juegoRepository.save(new Juego(null, "Bloodstained: Ritual of the Night", 2019, "El sucesor espiritual de Symphony of the Night.", new BigDecimal("39.99"), 4, indie, metroidvania, pc));
        juegoRepository.save(new Juego(null, "Ender Lilies: Quietus of the Knights", 2021, "Fantasía oscura con un apartado sonoro y visual melancólico.", new BigDecimal("24.99"), 4, indie, metroidvania, pc));
        juegoRepository.save(new Juego(null, "Axiom Verge", 2015, "Homenaje de ciencia ficción a la era de los 8 bits cargado de secretos.", new BigDecimal("19.99"), 4, indie, metroidvania, pc));
        juegoRepository.save(new Juego(null, "Tekken 8", 2024, "El Torneo del Rey del Puño de Hierro entra a la nueva generación.", new BigDecimal("69.99"), 5, indie, lucha, ps5));
        juegoRepository.save(new Juego(null, "Mortal Kombat 1", 2023, "Un nuevo universo forjado por Liu Kang, manteniendo los brutales fatalities.", new BigDecimal("69.99"), 4, indie, lucha, ps5));
        juegoRepository.save(new Juego(null, "Guilty Gear -Strive-", 2021, "Lucha 2D con los gráficos cel-shading más impresionantes de la industria.", new BigDecimal("39.99"), 5, indie, lucha, ps5));
        juegoRepository.save(new Juego(null, "Dragon Ball FighterZ", 2018, "Batallas por equipos 3v3 frenéticas con la fidelidad del anime.", new BigDecimal("59.99"), 5, indie, lucha, ps4));
        juegoRepository.save(new Juego(null, "The King of Fighters '97", 1997, "Concluye la épica saga de Orochi en este clásico de los salones recreativos.", new BigDecimal("7.99"), 5, snk, lucha, arcade));
        juegoRepository.save(new Juego(null, "The King of Fighters 2000", 2000, "Introduce el dinámico sistema de Strikers activos a la franquicia.", new BigDecimal("7.99"), 4, snk, lucha, arcade));
        juegoRepository.save(new Juego(null, "Samurai Shodown", 2019, "Combate basado en armas donde un solo corte puede cambiar el destino.", new BigDecimal("39.99"), 4, snk, lucha, ps4));
        juegoRepository.save(new Juego(null, "Fatal Fury Special", 1993, "El clásico que cimentó la rivalidad entre Terry Bogard y Geese Howard.", new BigDecimal("7.99"), 4, snk, lucha, arcade));
        juegoRepository.save(new Juego(null, "Capcom vs. SNK 2", 2001, "El crossover definitivo entre dos gigantes de los juegos de pelea.", new BigDecimal("14.99"), 5, capcom, lucha, arcade));
        juegoRepository.save(new Juego(null, "Marvel vs. Capcom 2", 2000, "I wanna take you for a ride! El caótico y querido juego de lucha 3v3.", new BigDecimal("19.99"), 5, capcom, lucha, arcade));
        juegoRepository.save(new Juego(null, "The Witness", 2016, "Explora una isla desierta llena de paneles con rompecabezas lógicos.", new BigDecimal("39.99"), 5, indie, puzzle, pc));
        juegoRepository.save(new Juego(null, "Baba Is You", 2019, "Las reglas del juego están presentes como bloques, altéralas para ganar.", new BigDecimal("14.99"), 5, indie, puzzle, pc));
        juegoRepository.save(new Juego(null, "Monument Valley", 2014, "Guía a una princesa a través de arquitecturas imposibles e ilusiones ópticas.", new BigDecimal("3.99"), 5, indie, puzzle, movil));
        juegoRepository.save(new Juego(null, "Puyo Puyo Tetris", 2017, "Dos titanes de los puzles colisionan en un juego altamente competitivo.", new BigDecimal("19.99"), 4, sega, puzzle, switchConsole));
        juegoRepository.save(new Juego(null, "Catherine: Full Body", 2019, "Sube torres de bloques en las pesadillas de un hombre con problemas amorosos.", new BigDecimal("29.99"), 4, sega, puzzle, ps4));
        juegoRepository.save(new Juego(null, "Tetris Effect: Connected", 2020, "Una experiencia sinestésica que eleva el clásico Tetris a otro nivel.", new BigDecimal("39.99"), 5, indie, puzzle, ps5));
        juegoRepository.save(new Juego(null, "Peggle", 2007, "Apunta y dispara para eliminar bloques naranjas y convertirte en maestro.", new BigDecimal("4.99"), 5, indie, puzzle, pc));
        juegoRepository.save(new Juego(null, "Braid", 2008, "Manipula el flujo del tiempo para resolver desafiantes puzles de plataformas.", new BigDecimal("14.99"), 5, indie, puzzle, pc));
        juegoRepository.save(new Juego(null, "Big Brain Academy: Batalla de ingenios", 2021, "Juegos mentales rápidos para estimular tu cerebro en familia.", new BigDecimal("29.99"), 4, nintendo, educacion, switchConsole));
        juegoRepository.save(new Juego(null, "PC Building Simulator", 2019, "Aprende a diagnosticar, ensamblar y reparar computadores reales.", new BigDecimal("19.99"), 4, indie, simulacion, pc));
        juegoRepository.save(new Juego(null, "Animal Crossing: City Folk", 2008, "Vida de pueblo pacífica con eventos vinculados a la fecha y hora reales.", new BigDecimal("19.99"), 4, nintendo, simulacion, wii));
        juegoRepository.save(new Juego(null, "The Sims 4", 2014, "Crea y controla personas, dales un hogar y domina sus vidas cotidianas.", new BigDecimal("0.00"), 4, indie, simulacion, pc));
        juegoRepository.save(new Juego(null, "Planet Coaster", 2016, "Construye y administra el parque de diversiones de tus sueños.", new BigDecimal("44.99"), 4, indie, simulacion, pc));
        juegoRepository.save(new Juego(null, "Cities: Skylines", 2015, "El estándar de oro moderno para simuladores de construcción de ciudades.", new BigDecimal("29.99"), 5, indie, simulacion, pc));
        juegoRepository.save(new Juego(null, "Microsoft Flight Simulator X", 2006, "El simulador que mantuvo viva a la comunidad aérea virtual por años.", new BigDecimal("24.99"), 4, microsoft, simulacion, pc));
        juegoRepository.save(new Juego(null, "Farming Simulator 22", 2021, "Gestiona tu granja moderna, cultiva la tierra y cría ganado.", new BigDecimal("29.99"), 4, indie, simulacion, pc));
        juegoRepository.save(new Juego(null, "Gran Turismo 7", 2022, "Tributo máximo a la cultura del automóvil con un realismo impecable.", new BigDecimal("69.99"), 5, sony, simulacion, ps5));
        juegoRepository.save(new Juego(null, "Assassin's Creed II", 2009, "La épica venganza de Ezio Auditore en la Italia del Renacimiento.", new BigDecimal("19.99"), 5, indie, aventura, ps4));
        juegoRepository.save(new Juego(null, "Uncharted 2: El reino de los ladrones", 2009, "Nathan Drake busca la mística ciudad de Shambhala.", new BigDecimal("14.99"), 5, sony, aventura, ps4));
        juegoRepository.save(new Juego(null, "Candy Crush Saga", 2012, "El puzzle match-3 que conquistó el mundo de los dispositivos móviles.", new BigDecimal("0.00"), 4, indie, puzzle, movil));
        juegoRepository.save(new Juego(null, "Stellar Blade", 2024, "Combate vertiginoso en un espectacular mundo postapocalíptico de ciencia ficción.", new BigDecimal("69.99"), 4, sony, accionRpg, ps5));
        juegoRepository.save(new Juego(null, "Vampire Survivors", 2021, "Sobrevive a hordas infinitas de monstruos en este adictivo roguelite minimalista.", new BigDecimal("4.99"), 5, indie, accionRpg, pc));

        log.info(">>> Carga finalizada exitosamente. Resumen de la Base de Datos: {} Compañías, {} Géneros, {} Plataformas y {} Juegos.", 
        companiaRepository.count(), 
        generoRepository.count(), 
        plataformaRepository.count(), 
        juegoRepository.count());
    }

}

//db_videojuegos_vm
