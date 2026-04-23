package com.example.msrandomnumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de arranque del microservicio ms-random-number.
 * La anotación @SpringBootApplication habilita la autoconfiguración,
 * el escaneo de componentes y la configuración de Spring Boot.
 */
@SpringBootApplication
public class MsRandomNumberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsRandomNumberApplication.class, args);
    }
}
