package com.example.msrandomnumber.controller;

import com.example.msrandomnumber.service.RandomNumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controlador REST que expone el endpoint para obtener un número aleatorio.
 * Inyección de dependencias por constructor para facilitar pruebas unitarias.
 */
@RestController
@RequestMapping("/api")
public class RandomNumberController {

    private final RandomNumberService randomNumberService;

    // Inyección por constructor: práctica recomendada por Spring para dependencias obligatorias
    public RandomNumberController(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    /**
     * GET /api/random
     * Retorna un número aleatorio entre 1 y 9 en formato JSON.
     *
     * @return ResponseEntity con cuerpo JSON { "number": N }
     */
    @GetMapping("/random")
    public ResponseEntity<Map<String, Integer>> getRandomNumber() {
        int number = randomNumberService.getRandomNumber();
        // Map.of() crea un mapa inmutable con la clave "number" y el valor generado
        return ResponseEntity.ok(Map.of("number", number));
    }
}
