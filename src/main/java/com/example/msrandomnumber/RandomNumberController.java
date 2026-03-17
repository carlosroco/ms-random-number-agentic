package com.example.msrandomnumber;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controlador REST que expone el endpoint para obtener un número aleatorio.
 */
@RestController
@RequestMapping("/api")
public class RandomNumberController {

    private final RandomNumberService randomNumberService;

    public RandomNumberController(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    /**
     * GET /api/random
     * Retorna un número aleatorio entre 1 y 9.
     *
     * @return JSON con el número aleatorio: { "numero": N }
     */
    @GetMapping("/random")
    public ResponseEntity<Map<String, Integer>> getRandomNumber() {
        int numero = randomNumberService.getRandomNumber();
        return ResponseEntity.ok(Map.of("numero", numero));
    }
}
