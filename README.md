---
name: readme
description: Archivo principal del repositorio que contiene información sobre el microservicio de números aleatorios agentico
---

# ms-random-number

Microservicio Spring Boot que expone un endpoint REST para obtener un número aleatorio entre 1 y 9.

## Tecnologías

- Java 17
- Spring Boot 3.2.0
- Maven

## Endpoint

```
GET /api/random
Response: {"number": N}  donde N es un entero entre 1 y 9
```

## Cómo ejecutar

```bash
./mvnw spring-boot:run
```

## Ejemplo con curl

```bash
curl http://localhost:8080/api/random
# {"number": 7}
```

## Tests

```bash
./mvnw test
```