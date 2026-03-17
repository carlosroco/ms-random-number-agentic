package com.example.msrandomnumber.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Servicio encargado de la lógica de negocio para generar números aleatorios.
 * Se utiliza ThreadLocalRandom por ser thread-safe y más eficiente que
 * java.util.Random en entornos concurrentes.
 */
@Service
public class RandomNumberService {

    /**
     * Genera un número entero aleatorio entre 1 y 9, ambos inclusive.
     * ThreadLocalRandom.nextInt(origin, bound) genera valores en [origin, bound),
     * por lo tanto se usa nextInt(1, 10) para obtener el rango [1, 9].
     *
     * @return número entero aleatorio entre 1 y 9 (inclusive)
     */
    public int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(1, 10);
    }
}
