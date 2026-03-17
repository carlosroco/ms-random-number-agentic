---
name: java-testing-junit5
description: Genera tests unitarios y de integración con JUnit 5 para un microservicio Spring Boot. Úsalo cuando necesites crear pruebas para la capa de servicio o el controlador REST.
---

Cuando se use este skill, genera los tests de JUnit 5 para el microservicio `ms-random-number`. Los tests deben validar que el número retornado esté entre 1 y 9 (inclusive).

### `src/test/java/com/example/msrandomnumber/service/RandomNumberServiceTest.java`

Test unitario que crea directamente una instancia de `RandomNumberServiceImpl` y verifica 100 veces que el resultado de `getRandomNumber()` esté en el rango `[1, 9]`.

```java
package com.example.msrandomnumber.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class RandomNumberServiceTest {

    private final RandomNumberService service = new RandomNumberServiceImpl();

    @Test
    void getRandomNumber_shouldReturnValueBetween1And9() {
        for (int i = 0; i < 100; i++) {
            int result = service.getRandomNumber();
            assertTrue(result >= 1 && result <= 9,
                "El número debe estar entre 1 y 9 (inclusive), pero fue: " + result);
        }
    }
}
```

### `src/test/java/com/example/msrandomnumber/controller/RandomNumberControllerTest.java`

Test de integración con `@SpringBootTest` y `@AutoConfigureMockMvc` que realiza un `GET /api/random`, verifica que el status sea 200 OK y que el campo `$.number` del JSON de respuesta esté en el rango `[1, 9]`.

```java
package com.example.msrandomnumber.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RandomNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getRandom_shouldReturn200WithNumberBetween1And9() throws Exception {
        mockMvc.perform(get("/api/random"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.number").exists())
            .andExpect(jsonPath("$.number").value(
                allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(9))
            ));
    }
}
```
