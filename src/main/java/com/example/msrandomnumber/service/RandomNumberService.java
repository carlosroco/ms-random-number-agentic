package com.example.msrandomnumber.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Servicio responsable de la lógica de negocio para generación de números aleatorios.
 * Usa ThreadLocalRandom para obtener rendimiento óptimo en entornos multihilo,
 * evitando la contención que tendría java.util.Random compartido.
 */
@Service
public class RandomNumberService {

    /**
     * Genera un número entero aleatorio en el rango [1, 9] (ambos extremos inclusivos).
     *
     * @return entero aleatorio entre 1 y 9 inclusive
     */
    public int getRandomNumber() {
        // nextInt(origin, bound) genera en [origin, bound), por eso bound = 10
        return ThreadLocalRandom.current().nextInt(1, 10);
    }
}
