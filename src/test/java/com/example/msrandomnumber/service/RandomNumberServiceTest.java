package com.example.msrandomnumber.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para RandomNumberService.
 * Verifica que los números generados siempre estén en el rango [1, 9].
 */
class RandomNumberServiceTest {

    private RandomNumberService service;

    @BeforeEach
    void setUp() {
        // Instanciación directa sin contexto Spring para pruebas unitarias puras
        service = new RandomNumberService();
    }

    @Test
    @DisplayName("getRandomNumber debe retornar un número entre 1 y 9 en 100 iteraciones")
    void getRandomNumber_shouldReturnNumberBetween1And9() {
        // Ejecutamos 100 veces para reducir la probabilidad de falsos positivos estadísticos
        for (int i = 0; i < 100; i++) {
            int result = service.getRandomNumber();
            assertTrue(
                result >= 1 && result <= 9,
                "El número debe estar entre 1 y 9, pero fue: " + result
            );
        }
    }
}
