package com.example.msrandomnumber.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Implementación del servicio de generación de números aleatorios.
 * Utiliza ThreadLocalRandom para generar números de forma eficiente y segura en entornos concurrentes.
 */
@Service
public class RandomNumberServiceImpl implements RandomNumberService {

    /**
     * Retorna un número aleatorio entre 1 y 9 (inclusive).
     * Utiliza ThreadLocalRandom.current().nextInt(1, 10) donde el límite superior es exclusivo.
     *
     * @return número aleatorio entero entre 1 y 9
     */
    @Override
    public int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(1, 10);
    }
}
