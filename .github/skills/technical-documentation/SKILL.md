---
name: technical-documentation
description: Genera la documentación técnica del microservicio en forma de README.md. Úsalo cuando necesites documentar el uso, el endpoint disponible y cómo ejecutar el proyecto.
---

Cuando se use este skill, genera un `README.md` para el microservicio `ms-random-number` con las siguientes secciones:

### `README.md`

```markdown
# ms-random-number

Microservicio Spring Boot que expone un endpoint REST para obtener un número aleatorio entre 1 y 9.

## Tecnologías

- Java 17
- Spring Boot 3.x
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
```
