# ACME Learning Center Platform

ACME Learning Center Platform es una aplicación para gestionar perfiles de usuarios en un centro de aprendizaje.

## Requisitos Previos

- Java 21
- Maven
- PostgreSQL

## Instalación

1. Clona el repositorio:
    ```sh
    git clone https://github.com/IanMQ/learning-center-platform.git
    ```
2. Navega al directorio del proyecto:
    ```sh
    cd learning-center-platform
    ```
3. Configura la base de datos PostgreSQL en `src/main/resources/application.properties`:
    ```ini
    spring.datasource.url=jdbc:postgresql://localhost:5432/acme_learning_center
    spring.datasource.username=postgres
    spring.datasource.password=12345678
    spring.datasource.driver-class-name=org.postgresql.Driver
    ```
4. Compila y ejecuta la aplicación:
    ```sh
    mvn clean install
    mvn spring-boot:run
    ```

## Uso

Puedes probar los endpoints REST usando herramientas como Postman o cURL.

### Crear un Perfil

```sh
curl -X POST http://localhost:8080/profiles \
-H "Content-Type: application/json" \
-d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "street": "123 Main St",
    "number": "456",
    "city": "Anytown",
    "postalCode": "12345",
    "country": "USA"
}'
```

Author: [Ian Macavilca](ianmacavilca@gmail.com)