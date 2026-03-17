package com.example.msrandomnumber.controller;

import com.example.msrandomnumber.model.RandomNumberResponse;
import com.example.msrandomnumber.service.RandomNumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RandomNumberController {

    private final RandomNumberService randomNumberService;

    public RandomNumberController(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    /**
     * GET /api/random
     *
     * @return 200 OK con JSON { "number": N } donde N está en el rango [1, 9]
     */
    @GetMapping("/random")
    public ResponseEntity<RandomNumberResponse> getRandom() {
        int number = randomNumberService.getRandomNumber();
        return ResponseEntity.ok(new RandomNumberResponse(number));
    }
}
