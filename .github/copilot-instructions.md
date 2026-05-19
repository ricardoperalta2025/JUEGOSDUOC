# JUEGOSDUOC - AI Coding Agent Instructions

## Project Overview
**JUEGOSDUOC** is a Spring Boot 4.0.6 REST API for a video game catalog system. It manages relationships between video games, development companies, genres, and gaming platforms. The project uses Java 21, Spring Data JPA with MySQL, and follows a layered architecture pattern.

## Architecture

### Core Layers (com.DUOC.JUEGOS)
- **model/** - JPA entities representing database tables
  - `Videojuego` - Core entity with relationships to Compania, Genero, Plataforma
  - `Compania`, `Genero`, `Plataforma` - Reference entities (lookup tables)
  - **Key decision**: Uses `@ManyToOne` for relationships; no cascade operations currently
  
- **repository/** - Spring Data JPA repositories extending `JpaRepository<Entity, Long>`
  - Return `List<JuegoResponseDTO>` instead of raw entities (DTO pattern enforced)
  - Example: `findByTituloContainingIgnoreCase()`, `findByPrecio*()`, `findByCompania()`
  - Repositories: VideojuegoRepository, CompaniaRepository, GeneroRepository, PlataformaRepository

- **dto/** - Data transfer objects for API boundaries
  - `JuegoRequestDTO` - Incoming request validation with `@NotBlank` constraints
  - `JuegoResponseDTO` - Outgoing response format (includes entity objects, not nested DTOs)
  - **Pattern note**: DTOs currently embed full entity objects (not flat/primitive fields)

- **config/** - Application configuration and initialization
  - `DataInitializer` implements `CommandLineRunner` - runs on application startup
  - Seeds database with 10 test video games across 4 companies if table is empty
  - Uses Spanish descriptions ("Japón", "RPG", etc.)
  - Check `videojuegoRepository.count()` before initialization

### Database Configuration
- MySQL 8.0+ on localhost:3306
- Database: `db_videojuegos_vm`
- Credentials: `root` / (empty password)
- **Hibernate DDL**: `spring.jpa.hibernate.ddl-auto=update` (safe for development, auto-creates/updates schema)
- SQL logging enabled: `spring.jpa.show-sql=true` with formatted output

## Key Patterns & Conventions

### Entity Design (Lombok + JPA)
```java
@Data @NoArgsConstructor @AllArgsConstructor  // Lombok shortcuts
@Entity @Table(name="videojuegos")
public class Videojuego {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false, length=200)
    private String titulo;
    
    @ManyToOne @JoinColumn(name="compania_id", nullable=false)
    private Compania compania;
}
```
- **Validation**: Use Jakarta Validation (`@NotBlank`, `@Min`, `@Max`) on DTOs, not entities
- **Precision**: BigDecimal for `precioMercado` (10,2 precision in DB)
- **Constraints**: Videojuego rating ranges 1-5 (@Min/@Max), title max 200 chars

### Repository Query Methods
- Methods must return `List<JuegoResponseDTO>` (type-safe DTO projection expectation)
- Use Spring Data method naming: `findBy*`, `*ContainingIgnoreCase()`, `*LessThan()`
- @Query annotation is imported but not yet used—add custom JPQL queries here as complexity grows

### Test Database Population
- DataInitializer creates exactly 10 game records:
  - 4 companies (Konami, Xbox Game Studios, FromSoftware, Nintendo)
  - 4 genres (Cartas, Simulación, RPG, Plataformas)
  - 4 platforms (PC, PS5, Xbox Series X|S, Nintendo Switch)
- Re-run by clearing the `videojuegos` table; DataInitializer checks table count before seeding

## Build & Deployment

### Maven Workflow
- **Build**: `mvn clean package` (builds to `target/JUEGOS-0.0.1-SNAPSHOT.jar.original`)
- **Run**: `mvn spring-boot:run` or `java -jar target/JUEGOS-0.0.1-SNAPSHOT.jar.original`
- **Test**: `mvn test` (test dependencies included: data-jpa-test, validation-test, webmvc-test)
- **Compiler**: Java 21, Spring Boot Maven Plugin configured with Lombok exclusion

### Application Startup
- Spring Boot auto-initializes DataInitializer on startup (CommandLineRunner)
- Logs indicate success: `">>> Carga finalizada: videojuegos insertados exitosamente."`
- Verify database connectivity in `application.properties` before first run

## Development Workflow

### Adding a New Entity Type
1. Create model class in `model/` with @Entity, @Data, @NoArgsConstructor, @AllArgsConstructor, Lombok annotations
2. Use `@ManyToOne` and `@JoinColumn` for relationships to existing entities
3. Add corresponding Repository interface in `repository/` extending JpaRepository
4. Create DTO classes (Request/Response) in `dto/` with validation annotations
5. Consider updating DataInitializer if static test data needed

### Adding Query Methods
- Add methods to repository interfaces (e.g., `findByTituloContainingIgnoreCase()`)
- Use DTO as return type: `List<JuegoResponseDTO> findBy...`
- For complex queries, use `@Query` annotation with JPQL/HQL in repository

### Future Expansion
- **Controllers** not yet created—REST endpoints will use repositories to query/save data
- **Services** layer optional (can add business logic between controller and repository)
- **Validation** currently on DTOs; consider entity-level validation for persistence rules

## Project Conventions
- **Package naming**: `com.DUOC.JUEGOS` (uppercase, per existing convention)
- **Class naming**: PascalCase for entities (Videojuego), always include "DTO" suffix for transfer objects
- **Database naming**: lowercase with underscores (videojuegos, companias)
- **Spanish terminology**: Domain descriptions and comments use Spanish ("Japón", "Simulación", etc.)
- **Logging**: Slf4j with @Slf4j annotation (used in DataInitializer)

## Common Tasks

### Query a Video Game by Title
Use repository method:
```java
List<JuegoResponseDTO> games = videojuegoRepository.findByTituloContainingIgnoreCase("elden");
```

### Add a New Game
Create Videojuego with required foreign keys to Compania, Genero, Plataforma:
```java
Videojuego game = new Videojuego(null, "Title", 2024, "Description", 
    new BigDecimal("59.99"), 5, compania, genero, plataforma);
videojuegoRepository.save(game);
```

### Reset Database
1. Drop and recreate `db_videojuegos_vm` in MySQL
2. Restart Spring Boot application to trigger DataInitializer seed
