---
name: readme
description: Archivo principal del repositorio que contiene información sobre el microservicio de números aleatorios agentico
---

# ms-random-number-agentic

Microservicio Spring Boot que expone un endpoint REST para obtener un número aleatorio entre 1 y 9.

## Requisitos

- Java 17+
- Maven 3.6+

## Ejecución

```bash
mvn spring-boot:run
```

El servidor arranca en el puerto `8080`.

## Endpoint

| Método | URL | Descripción |
|--------|-----|-------------|
| `GET` | `/api/random` | Retorna un número aleatorio entre 1 y 9 |

### Ejemplo de respuesta

```json
{
  "number": 7
}
```

## Tests

```bash
mvn clean test
```