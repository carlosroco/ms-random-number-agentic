package com.example.msrandomnumber.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Pruebas unitarias para {@link RandomNumberService}.
 * No levanta contexto de Spring para mantener ejecución rápida (prueba unitaria pura).
 */
class RandomNumberServiceTest {

    private RandomNumberService randomNumberService;

    @BeforeEach
    void setUp() {
        // Instanciación directa: sin contexto Spring, prueba unitaria ligera
        randomNumberService = new RandomNumberService();
    }

    @Test
    @DisplayName("getRandomNumber() debe retornar un valor entre 1 y 9 inclusive")
    void getRandomNumber_debeRetornarValorEnRangoCorrecto() {
        int resultado = randomNumberService.getRandomNumber();

        assertThat(resultado)
                .as("El número aleatorio debe estar en el rango [1, 9]")
                .isGreaterThanOrEqualTo(1)
                .isLessThanOrEqualTo(9);
    }

    /**
     * Prueba repetida 50 veces para validar estadísticamente que el rango
     * siempre se respeta, independientemente del valor generado por ThreadLocalRandom.
     */
    @RepeatedTest(value = 50, name = "Iteración {currentRepetition}/{totalRepetitions}")
    @DisplayName("getRandomNumber() debe respetar el rango en múltiples invocaciones")
    void getRandomNumber_debeRespetar_rangoEnMultiplesInvocaciones() {
        int resultado = randomNumberService.getRandomNumber();

        assertThat(resultado)
                .isGreaterThanOrEqualTo(1)
                .isLessThanOrEqualTo(9);
    }

    @Test
    @DisplayName("getRandomNumber() nunca debe retornar 0")
    void getRandomNumber_nuncaDebeRetornarCero() {
        // Verificación explícita del límite inferior exclusivo
        for (int i = 0; i < 100; i++) {
            assertThat(randomNumberService.getRandomNumber()).isNotEqualTo(0);
        }
    }

    @Test
    @DisplayName("getRandomNumber() nunca debe retornar 10 ni mayor")
    void getRandomNumber_nuncaDebeRetornarDiezOMayor() {
        // Verificación explícita del límite superior exclusivo
        for (int i = 0; i < 100; i++) {
            assertThat(randomNumberService.getRandomNumber()).isLessThan(10);
        }
    }
}
