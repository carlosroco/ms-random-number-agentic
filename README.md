---
name: readme
description: Archivo principal del repositorio que contiene información sobre el microservicio de números aleatorios agentico
---

# ms-random-number-agentic

Microservicio REST desarrollado en Spring Boot 3.x que expone un endpoint para obtener un número aleatorio entre 1 y 9.

## 🚀 Tecnologías

- Java 17
- Spring Boot 3.4.3
- Spring Web
- JUnit 5 + Mockito

## 📋 Requisitos previos

- Java 17+
- Maven 3.6+

## 🔧 Instalación y ejecución

```bash
# Clonar el repositorio
git clone https://github.com/carlosroco/ms-random-number-agentic.git
cd ms-random-number-agentic

# Compilar el proyecto
mvn clean install

# Ejecutar el microservicio
mvn spring-boot:run
```

El servicio estará disponible en `http://localhost:8080`

## 🌐 Endpoints

### GET /api/random

Retorna un número entero aleatorio entre 1 y 9 (inclusive).

**Request:**
```
GET http://localhost:8080/api/random
```

**Response:**
```json
{
  "number": 7
}
```

**Ejemplo con curl:**
```bash
curl -s http://localhost:8080/api/random
# Respuesta: {"number":7}
```

## 🧪 Tests

```bash
# Ejecutar todos los tests
mvn test
```

Los tests incluyen:
- **Tests unitarios**: Verifica que el servicio retorna valores en el rango [1, 9]
- **Tests de integración**: Verifica el endpoint REST con MockMvc