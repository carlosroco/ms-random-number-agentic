package com.example.msrandomnumber.controller;

import com.example.msrandomnumber.service.RandomNumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controlador REST que expone el endpoint de generación de números aleatorios.
 * Delega la lógica de negocio a {@link RandomNumberService} (arquitectura en capas).
 */
@RestController
@RequestMapping("/api")
public class RandomNumberController {

    private final RandomNumberService randomNumberService;

    /**
     * Inyección de dependencia por constructor (buena práctica: facilita testing y es inmutable).
     *
     * @param randomNumberService servicio que genera el número aleatorio
     */
    public RandomNumberController(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    /**
     * GET /api/random
     * Devuelve un número aleatorio entre 1 y 9 en formato JSON: {"number": X}.
     *
     * @return ResponseEntity con cuerpo JSON y estado HTTP 200 OK
     */
    @GetMapping("/random")
    public ResponseEntity<Map<String, Integer>> getRandomNumber() {
        int number = randomNumberService.getRandomNumber();
        // Map.of genera un mapa inmutable con clave "number" para el JSON de respuesta
        return ResponseEntity.ok(Map.of("number", number));
    }
}
