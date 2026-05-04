package com.example.msrandomnumber;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RandomNumberController.class)
class RandomNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RandomNumberService randomNumberService;

    @Test
    void getRandomNumber_retornaJsonConNumero() throws Exception {
        given(randomNumberService.getRandomNumber()).willReturn(7);

        mockMvc.perform(get("/api/random"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.numero").value(7));
    }

    @Test
    void getRandomNumber_retornaJsonConNumeroDiferente() throws Exception {
        given(randomNumberService.getRandomNumber()).willReturn(1);

        mockMvc.perform(get("/api/random"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numero").value(1));
    }
}
