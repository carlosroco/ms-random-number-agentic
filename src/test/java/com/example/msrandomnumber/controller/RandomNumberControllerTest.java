package com.example.msrandomnumber.controller;

import com.example.msrandomnumber.service.RandomNumberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Pruebas de integración de la capa web para RandomNumberController.
 * Usa @WebMvcTest para cargar únicamente el contexto MVC sin iniciar servidor real.
 */
@WebMvcTest(RandomNumberController.class)
class RandomNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // MockBean reemplaza el servicio real con un mock de Mockito en el contexto Spring
    @MockBean
    private RandomNumberService randomNumberService;

    @Test
    @DisplayName("GET /api/random debe retornar HTTP 200 y JSON con campo 'number'")
    void getRandomNumber_shouldReturn200WithNumber() throws Exception {
        // Configuramos el mock para retornar un valor determinista
        when(randomNumberService.getRandomNumber()).thenReturn(5);

        mockMvc.perform(get("/api/random"))
                .andExpect(status().isOk())                    // HTTP 200
                .andExpect(content().contentType("application/json")) // Content-Type correcto
                .andExpect(jsonPath("$.number").value(5));     // Campo "number" con valor 5
    }
}
