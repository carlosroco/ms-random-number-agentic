package com.example.msrandomnumber.controller;

import com.example.msrandomnumber.service.RandomNumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/random")
public class RandomNumberController {

    private final RandomNumberService randomNumberService;

    // Inyección por constructor (recomendada sobre @Autowired en campos)
    public RandomNumberController(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    @GetMapping
    public ResponseEntity<Integer> getRandomNumber() {
        return ResponseEntity.ok(randomNumberService.getRandomNumber());
    }
}
