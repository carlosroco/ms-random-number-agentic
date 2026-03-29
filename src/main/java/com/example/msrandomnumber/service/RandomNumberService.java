package com.example.msrandomnumber.service;

import org.springframework.stereotype.Service;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Servicio de lógica de negocio para la generación de números aleatorios.
 * Encapsula la generación del número para mantener separación de responsabilidades.
 */
@Service
public class RandomNumberService {

    /**
     * Genera un número entero aleatorio en el rango [1, 9] (ambos inclusive).
     * Usa ThreadLocalRandom para garantizar seguridad en entornos concurrentes.
     *
     * @return número aleatorio entre 1 y 9
     */
    public int getRandomNumber() {
        // nextInt(9) retorna [0, 8], sumamos 1 para obtener [1, 9]
        return ThreadLocalRandom.current().nextInt(9) + 1;
    }
}
