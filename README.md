# 🎮 Proyecto Catálogo de Videojuegos - API REST
**Proyecto de Integración · Duoc UC**

## 📝 Descripción del Proyecto
Este proyecto surgió con la idea de desarrollar el backend para una página web o plataforma informativa de videojuegos. Diseñamos y programamos una API RESTful completa utilizando **Java 21** y **Spring Boot**, cuyo objetivo es gestionar toda la información de un catálogo de videojuegos mediante el nombre, año de publicación, sinopsis, entre otras características.

Para almacenar los datos de manera persistente y segura, conectamos el sistema a una base de datos relacional **MySQL**, gestionando las consultas y las relaciones lógicas de las tablas a través de **Spring Data JPA**.

## 👥 Integrantes del Equipo
* Nicolás Aballais
* Ricardo Peralta

## 🚀 Funcionalidades Implementadas
Nuestro enfoque principal fue armar un sistema dinámico donde la información no fuera estática. Implementamos las siguientes características:

* **Mantenimiento Completo (CRUD):** El sistema permite crear nuevos videojuegos, listar los existentes, editar sus detalles y eliminarlos a través de peticiones HTTP.
* **Carga Automática de Datos:** Configuramos un componente `DataInitializer` para que, apenas se levante la aplicación, se inyecte automáticamente una base de datos inicial de 200 juegos distribuidos en distintas compañías, géneros y plataformas.
* **Buscador con Criterios Flexibles:** Programamos métodos de búsqueda para filtrar los juegos por términos parciales en sus títulos, por rango de precio menor a un presupuesto, o buscando directamente por el nombre de su género, plataforma o compañía creadora.
* **Módulos de Ordenamiento:** Añadimos endpoints específicos para organizar las listas de respuesta de forma alfabética (A-Z y Z-A), por el año en que salieron los juegos, por el precio del mercado o por su valoración (de 1 a 5 estrellas).

## ⚙️ Pasos para Ejecutar nuestro Proyecto

### 1. Entorno Requerido
* Tener instalado **Java 21** (JDK).
* Contar con **Visual Studio Code** (con las extensiones de Java y Spring instaladas).
* Tener activo un servidor local de MySQL (**Laragon**).

### 2. Preparación de la Base de Datos
1. Iniciar los servicios de MySQL en Laragon.
2. Entrar al gestor de base de datos y crear un esquema vacío llamado exactamente:
   `db_videojuegos_vm`

### 3. Despliegue de la Aplicación
1. Descargar o clonar este repositorio en tu equipo.
2. Abrir la carpeta raíz del proyecto dentro de Visual Studio Code.
3. Revisar el archivo `src/main/resources/application.properties` para confirmar que el usuario y la contraseña de la base de datos coincidan con la configuración de tu MySQL local.
4. Buscar la clase `JuegosApplication.java` dentro del código y presionar el botón **Run**.
5. Al iniciar por primera vez, las tablas se crearán solas y se poblarán con los 200 videojuegos de prueba. La API quedará escuchando peticiones en:
   `http://localhost:8080/api/juegos`
