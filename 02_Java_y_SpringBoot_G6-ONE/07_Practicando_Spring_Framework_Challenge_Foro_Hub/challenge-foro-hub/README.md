# Foro Hub

Foro Hub es una aplicación web de foro desarrollada con Spring Boot, diseñada para gestionar tópicos de discusión. Esta aplicación incluye funcionalidades CRUD (Crear, Leer, Actualizar, Eliminar) y utiliza JWT para autenticación y autorización.

## Características

- **CRUD de Tópicos**: Crear, leer, actualizar y eliminar tópicos.
- **Autenticación y Autorización**: Implementada con JWT.
- **Validaciones**: Validaciones de entrada de datos utilizando Jakarta Bean Validation.
- **Swagger**: Documentación de la API generada automáticamente.

## Dependencias Utilizadas

- Swagger
- Lombok
- Spring Web
- Spring Boot DevTools
- Spring Data JPA
- Flyway Migration
- MySQL Driver
- Validation
- Spring Security

## Requisitos Previos

- JDK 17 o superior
- Maven 3.8.1 o superior
- MySQL 8.0 o superior


## Ejecución del Proyecto

1. Compila y ejecuta la aplicación con Maven:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

2. La aplicación estará disponible en `http://localhost:8080`.

## Uso de la API

### Autenticación

Para autenticarte, envía una solicitud POST a `/login` con las credenciales del usuario. Esto devolverá un token JWT que debe incluirse en el encabezado de autorización para todas las solicitudes posteriores.

### Endpoints Principales

- **POST /topicos**: Crea un nuevo tópico.
- **GET /topicos**: Obtiene la lista de tópicos.
- **PUT /topicos/{id}**: Actualiza un tópico existente.
- **DELETE /topicos/{id}**: Elimina un tópico de la base de datos.

## Documentación de la API

La documentación de la API generada por Swagger está disponible en `http://localhost:8080/swagger-ui.html`.
