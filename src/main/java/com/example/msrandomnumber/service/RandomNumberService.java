package com.example.msrandomnumber.service;

import org.springframework.stereotype.Service;
import java.util.Random;

/**
 * Servicio de lógica de negocio para la generación de números aleatorios.
 * Encapsula la generación del número para mantener separación de responsabilidades.
 */
@Service
public class RandomNumberService {

    // Instancia de Random reutilizada para evitar crear objetos innecesarios
    private final Random random = new Random();

    /**
     * Genera un número entero aleatorio en el rango [1, 9] (ambos inclusive).
     *
     * @return número aleatorio entre 1 y 9
     */
    public int getRandomNumber() {
        // nextInt(9) retorna [0, 8], sumamos 1 para obtener [1, 9]
        return random.nextInt(9) + 1;
    }
}
