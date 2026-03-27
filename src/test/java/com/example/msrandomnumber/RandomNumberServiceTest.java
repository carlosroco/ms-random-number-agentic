package com.example.msrandomnumber;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberServiceTest {

    private final RandomNumberService service = new RandomNumberService();

    @Test
    void getRandomNumber_debeRetornarValorEntre1y9() {
        int resultado = service.getRandomNumber();
        assertThat(resultado).isBetween(1, 9);
    }

    @RepeatedTest(50)
    void getRandomNumber_siempreEntre1y9() {
        int resultado = service.getRandomNumber();
        assertThat(resultado).isBetween(1, 9);
    }
}
