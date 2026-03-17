package com.example.msrandomnumber.service;

import com.example.msrandomnumber.service.impl.RandomNumberServiceImpl;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.random.RandomGenerator;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RandomNumberServiceImplTest {

    @RepeatedTest(50)
    void debeRetornarNumeroEnRango1a9() {
        // Arrange: usar RandomGenerator real
        RandomNumberServiceImpl service =
                new RandomNumberServiceImpl(RandomGenerator.getDefault());

        // Act
        int result = service.getRandomNumber();

        // Assert: el resultado debe estar en el rango [1, 9]
        assertThat(result).isBetween(1, 9);
    }

    @Test
    void debeRetornar1CuandoRandomGeneratorRetorna0() {
        // Arrange: mock con valor controlado
        RandomGenerator mockGen = mock(RandomGenerator.class);
        when(mockGen.nextInt(9)).thenReturn(0);
        RandomNumberServiceImpl service = new RandomNumberServiceImpl(mockGen);

        // Act + Assert
        assertThat(service.getRandomNumber()).isEqualTo(1);
    }

    @Test
    void debeRetornar9CuandoRandomGeneratorRetorna8() {
        // Arrange: mock con valor máximo
        RandomGenerator mockGen = mock(RandomGenerator.class);
        when(mockGen.nextInt(9)).thenReturn(8);
        RandomNumberServiceImpl service = new RandomNumberServiceImpl(mockGen);

        // Act + Assert
        assertThat(service.getRandomNumber()).isEqualTo(9);
    }
}
