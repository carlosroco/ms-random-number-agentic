package com.example.msrandomnumber.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Implementación del servicio de número aleatorio.
 * Utiliza ThreadLocalRandom para generar números de forma eficiente y thread-safe.
 */
@Service
public class RandomNumberServiceImpl implements RandomNumberService {

    /**
     * Retorna un número aleatorio entre 1 y 9 (inclusive).
     * Se utiliza ThreadLocalRandom.nextInt(1, 10) donde el límite superior es exclusivo.
     *
     * @return número entero aleatorio en el rango [1, 9]
     */
    @Override
    public int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(1, 10);
    }
}
