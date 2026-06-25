🎮 Ecosistema de Microservicios: Catálogo de Videojuegos
Proyecto de Integración · Duoc UC

📝 Descripción del Proyecto
Este proyecto comenzó con la idea de desarrollar el backend para una plataforma de videojuegos. En su evolución, pasó de ser una API RESTful monolítica a convertirse en una Arquitectura de Microservicios robusta y escalable, utilizando Java 21, Spring Boot y herramientas de Spring Cloud.

El sistema gestiona toda la información de un catálogo de videojuegos (nombre, año, sinopsis, precio, valoración), almacenando los datos de manera persistente en una base de datos relacional MySQL a través de Spring Data JPA. Además, implementa patrones profesionales de descubrimiento de servicios, enrutamiento, pruebas unitarias y documentación viva.

👥 Integrantes del Equipo

Nicolás Aballais

Ricardo Peralta

🚀 Funcionalidades Base Implementadas
Mantenimiento Completo (CRUD): Creación, lectura, actualización y eliminación de videojuegos mediante peticiones HTTP.

Carga Automática de Datos: Uso de DataInitializer y DataFaker para inyectar automáticamente una base de datos inicial de 200 juegos distribuidos en distintas compañías, géneros y plataformas.

Buscador con Criterios Flexibles: Filtros dinámicos por términos parciales en títulos, presupuesto máximo, género, plataforma o compañía.

Módulos de Ordenamiento: Endpoints para organizar resultados de forma alfabética, por año de lanzamiento, por precio del mercado o por valoración (1 a 5 estrellas).

🏗️ Arquitectura y Tecnologías Avanzadas
Para acercar el proyecto a estándares de la industria, se incorporaron las siguientes capas tecnológicas:

Spring Cloud Netflix Eureka (Service Discovery): Implementación de un "directorio dinámico" que registra las instancias de los servicios activos, permitiendo el balanceo de carga y eliminando la dependencia de IPs fijas.

Spring Cloud Gateway (WebMVC): Creación de un punto único de entrada (Recepcionista/Enrutador) que centraliza las peticiones del cliente en el puerto 8081 y las redirige internamente usando la información de Eureka.

OpenAPI & Swagger UI: Generación de un "Contrato de API" y una interfaz visual interactiva que documenta todos los endpoints disponibles y permite ejecutarlos directamente desde el navegador.

HATEOAS (Hypermedia): Implementación de enlaces dinámicos en las respuestas JSON (_links), permitiendo la navegabilidad entre recursos sin necesidad de que el cliente conozca las URLs exactas de antemano.

Testing Automatizado (JUnit 5 & Mockito): Cobertura de pruebas unitarias al 100% en las capas de Servicios y Controladores. Se aislaron las pruebas utilizando datos simulados (Mocking) y un perfil específico (test) para garantizar la fiabilidad del código ante futuros cambios.

⚙️ Pasos para Ejecutar la Arquitectura
1. Entorno Requerido
Tener instalado Java 21 (JDK).

Contar con Visual Studio Code o IDE equivalente.

Tener activo un servidor local de MySQL (Laragon/XAMPP).

2. Preparación de la Base de Datos
Iniciar los servicios de MySQL en Laragon.

Entrar al gestor de base de datos y crear un esquema vacío llamado exactamente: db_videojuegos_vm

3. Orden Estricto de Despliegue
Para que los microservicios se comuniquen correctamente, se deben encender de forma individual en el siguiente orden:

Servidor Eureka (Guía Telefónica):

Abrir el proyecto eureka-server, ejecutarlo y esperar a que inicie.

Panel de control disponible en: http://localhost:8761

Microservicio Principal (Juegos):

Abrir el proyecto JUEGOSDUOC, ejecutarlo y esperar a que registre sus 200 juegos iniciales.

Swagger UI disponible en: http://localhost:8080/doc/swagger-ui.html

API Gateway (Enrutador Central):

Abrir el proyecto api-gateway y ejecutarlo. El gateway leerá las rutas y se conectará con Eureka.

4. Cómo Probar el Sistema
Una vez encendidos los tres componentes, todas las peticiones (ya sea desde el navegador, Postman o un Frontend) deben apuntar al puerto del Gateway (8081), el cual hará la redirección de forma transparente hacia el microservicio correspondiente.

Ejemplos de endpoints a través del Gateway (ideales para probar en Postman):

Listar todos los juegos (GET):
http://localhost:8081/api/juegos

Buscar un juego por su ID (GET):
http://localhost:8081/api/juegos/1

Crear un juego nuevo (POST):
http://localhost:8081/api/juegos
(Requiere enviar la estructura del juego en formato JSON a través del Body).

Actualizar un juego (PUT):
http://localhost:8081/api/juegos/1
(Requiere enviar los datos a actualizar en formato JSON a través del Body).

Eliminar un juego (DELETE):
http://localhost:8081/api/juegos/eliminar/2
