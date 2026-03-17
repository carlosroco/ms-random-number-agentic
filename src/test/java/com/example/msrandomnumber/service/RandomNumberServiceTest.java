package com.example.msrandomnumber.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests unitarios del servicio RandomNumberService.
 * Se instancia directamente el servicio (sin contexto Spring) para
 * validar exclusivamente la lógica de generación del número aleatorio.
 */
class RandomNumberServiceTest {

    private RandomNumberService randomNumberService;

    @BeforeEach
    void setUp() {
        // Instanciación directa: no se necesita contexto Spring para este test
        randomNumberService = new RandomNumberService();
    }

    @Test
    @DisplayName("getRandomNumber() debe retornar un número mayor o igual a 1")
    void getRandomNumber_debeSerMayorOIgualAUno() {
        int numero = randomNumberService.getRandomNumber();

        assertThat(numero)
                .as("El número aleatorio debe ser mayor o igual a 1")
                .isGreaterThanOrEqualTo(1);
    }

    @Test
    @DisplayName("getRandomNumber() debe retornar un número menor o igual a 9")
    void getRandomNumber_debeSerMenorOIgualANueve() {
        int numero = randomNumberService.getRandomNumber();

        assertThat(numero)
                .as("El número aleatorio debe ser menor o igual a 9")
                .isLessThanOrEqualTo(9);
    }

    @Test
    @DisplayName("getRandomNumber() debe retornar un número dentro del rango [1, 9]")
    void getRandomNumber_debeEstarDentroDelRango() {
        int numero = randomNumberService.getRandomNumber();

        assertThat(numero)
                .as("El número aleatorio debe estar en el rango [1, 9]")
                .isBetween(1, 9);
    }

    /**
     * Test repetido 50 veces para verificar estadísticamente que el rango
     * se respeta en múltiples invocaciones (cubre valores aleatorios distintos).
     */
    @RepeatedTest(50)
    @DisplayName("getRandomNumber() debe mantenerse en [1, 9] en múltiples ejecuciones")
    void getRandomNumber_debeEstarDentroDelRangoEnMultiplesEjecuciones() {
        int numero = randomNumberService.getRandomNumber();

        assertThat(numero)
                .as("El número aleatorio debe estar en el rango [1, 9] en cada ejecución")
                .isBetween(1, 9);
    }

    @Test
    @DisplayName("getRandomNumber() no debe retornar el mismo valor siempre (aleatoriedad básica)")
    void getRandomNumber_debeGenerarValoresDiferentes() {
        // Con 20 llamadas, la probabilidad de que todos sean iguales es (1/9)^19 ≈ 0
        // lo que valida que el generador no es determinista
        boolean hayDiferencias = false;
        int primerValor = randomNumberService.getRandomNumber();

        for (int i = 0; i < 20; i++) {
            if (randomNumberService.getRandomNumber() != primerValor) {
                hayDiferencias = true;
                break;
            }
        }

        assertThat(hayDiferencias)
                .as("El generador debe producir valores distintos en múltiples llamadas")
                .isTrue();
    }
}
