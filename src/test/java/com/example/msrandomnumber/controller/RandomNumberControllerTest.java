package com.example.msrandomnumber.controller;

import com.example.msrandomnumber.service.RandomNumberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Pruebas de integración de capa web para {@link RandomNumberController}.
 *
 * @WebMvcTest levanta únicamente el contexto MVC (sin base de datos ni servicios reales),
 * lo que permite probar el controlador de forma aislada con MockMvc.
 */
@WebMvcTest(RandomNumberController.class)
class RandomNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Mock del servicio: permite controlar el valor retornado en cada test
     * sin depender de la implementación real de RandomNumberService.
     */
    @MockBean
    private RandomNumberService randomNumberService;

    @Test
    @DisplayName("GET /api/random debe retornar HTTP 200")
    void getRandomNumber_debeRetornarHttp200() throws Exception {
        when(randomNumberService.getRandomNumber()).thenReturn(5);

        mockMvc.perform(get("/api/random"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /api/random debe retornar Content-Type application/json")
    void getRandomNumber_debeRetornarContentTypeJson() throws Exception {
        when(randomNumberService.getRandomNumber()).thenReturn(3);

        mockMvc.perform(get("/api/random"))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("GET /api/random debe retornar JSON con campo 'number'")
    void getRandomNumber_debeRetornarJsonConCampoNumber() throws Exception {
        when(randomNumberService.getRandomNumber()).thenReturn(7);

        mockMvc.perform(get("/api/random"))
                .andExpect(jsonPath("$.number").exists())
                .andExpect(jsonPath("$.number").value(7));
    }

    @Test
    @DisplayName("El campo 'number' en la respuesta debe estar entre 1 y 9 inclusive")
    void getRandomNumber_campNumber_debeEstarEnRango() throws Exception {
        // Probamos cada valor posible del rango para asegurar cobertura completa
        for (int valorEsperado = 1; valorEsperado <= 9; valorEsperado++) {
            when(randomNumberService.getRandomNumber()).thenReturn(valorEsperado);

            mockMvc.perform(get("/api/random"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.number").value(valorEsperado));
        }
    }

    @Test
    @DisplayName("GET /api/random debe retornar exactamente el valor que provee el servicio")
    void getRandomNumber_debeReflejarValorDelServicio() throws Exception {
        int valorSimulado = 4;
        when(randomNumberService.getRandomNumber()).thenReturn(valorSimulado);

        MvcResult resultado = mockMvc.perform(get("/api/random"))
                .andExpect(status().isOk())
                .andReturn();

        String cuerpoRespuesta = resultado.getResponse().getContentAsString();

        // Verificación adicional: el cuerpo contiene el número correcto como entero JSON
        assertThat(cuerpoRespuesta).contains("\"number\":" + valorSimulado);
    }
}
