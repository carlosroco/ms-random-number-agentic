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
 * Tests de integración del controlador usando @WebMvcTest.
 * Solo se carga el contexto web (controlador + MVC), el servicio se mockea
 * para aislar la capa de presentación de la lógica de negocio.
 */
@WebMvcTest(RandomNumberController.class)
class RandomNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Mock del servicio para controlar el valor retornado en cada test
    @MockBean
    private RandomNumberService randomNumberService;

    @Test
    @DisplayName("GET /random debe retornar HTTP 200 OK")
    void getRandomNumber_debeRetornarStatus200() throws Exception {
        // Dado que el servicio retorna 5
        when(randomNumberService.getRandomNumber()).thenReturn(5);

        // Cuando se llama GET /random, entonces el status debe ser 200
        mockMvc.perform(get("/random").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /random debe retornar JSON con la clave 'number'")
    void getRandomNumber_debeRetornarJsonConClaveNumber() throws Exception {
        // Dado que el servicio retorna 7
        when(randomNumberService.getRandomNumber()).thenReturn(7);

        // Cuando se llama GET /random, entonces el JSON debe contener la clave "number"
        mockMvc.perform(get("/random").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.number").exists());
    }

    @Test
    @DisplayName("GET /random debe retornar número entre 1 y 9 (inclusive)")
    void getRandomNumber_debeRetornarNumeroDentroDelRango() throws Exception {
        // Verificamos el rango con varios valores límite y uno del medio
        int[] valoresDeTest = {1, 5, 9};

        for (int valor : valoresDeTest) {
            // Dado que el servicio retorna el valor de prueba
            when(randomNumberService.getRandomNumber()).thenReturn(valor);

            // Cuando se llama GET /random
            MvcResult resultado = mockMvc.perform(get("/random").accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.number").value(valor))
                    .andReturn();

            // Entonces el cuerpo de la respuesta contiene el valor correcto
            String cuerpoRespuesta = resultado.getResponse().getContentAsString();
            assertThat(cuerpoRespuesta).contains("\"number\":" + valor);
        }
    }

    @Test
    @DisplayName("GET /random debe retornar Content-Type application/json")
    void getRandomNumber_debeRetornarContentTypeJson() throws Exception {
        when(randomNumberService.getRandomNumber()).thenReturn(3);

        mockMvc.perform(get("/random").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}
