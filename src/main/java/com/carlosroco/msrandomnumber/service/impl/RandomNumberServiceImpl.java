package com.carlosroco.msrandomnumber.service.impl;

import com.carlosroco.msrandomnumber.service.RandomNumberService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Implementación del servicio de números aleatorios.
 * Utiliza ThreadLocalRandom para generar números de forma segura en entornos concurrentes.
 */
@Service
public class RandomNumberServiceImpl implements RandomNumberService {

    /**
     * Genera un número aleatorio entre 1 y 9 inclusive.
     * ThreadLocalRandom.nextInt(1, 10) retorna valores en el rango [1, 10) → [1..9]
     *
     * @return número entero aleatorio en el rango [1, 9]
     */
    @Override
    public int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(1, 10);
    }
}
