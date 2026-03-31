package com.example.msrandomnumber.controller;

import com.example.msrandomnumber.service.RandomNumberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RandomNumberController.class)
class RandomNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RandomNumberService randomNumberService;

    @Test
    void getRandom_debeRetornar200ConNumeroEnCuerpo() throws Exception {
        // Arrange
        when(randomNumberService.getRandomNumber()).thenReturn(5);

        // Act + Assert
        mockMvc.perform(get("/api/random"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.number").value(5));
    }

    @Test
    void getRandom_debeRetornarJsonConCampoNumber() throws Exception {
        // Arrange
        when(randomNumberService.getRandomNumber()).thenReturn(3);

        // Act + Assert
        mockMvc.perform(get("/api/random"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value(3));
    }
}
