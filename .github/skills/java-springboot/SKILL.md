---
name: java-springboot
description: Genera la estructura completa de un microservicio Java Spring Boot 3.x con Maven. Úsalo cuando necesites crear el proyecto base (pom.xml, clase principal), la capa de servicio (interfaz + implementación) o el controlador REST.
---

Cuando se use este skill, genera los archivos de un microservicio Spring Boot 3.2.0 con Java 17 y Maven, siguiendo la estructura de paquete `com.example.msrandomnumber`.

## [Setup] — Estructura inicial y configuración del proyecto

Genera los siguientes archivos:

### `pom.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.2.0</version>
    <relativePath/>
  </parent>

  <groupId>com.example</groupId>
  <artifactId>ms-random-number</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <name>ms-random-number</name>
  <description>Microservicio que retorna un número aleatorio del 1 al 9</description>

  <properties>
    <java.version>17</java.version>
  </properties>

  <dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
    </plugins>
  </build>
</project>
```

### `src/main/java/com/example/msrandomnumber/MsRandomNumberApplication.java`

```java
package com.example.msrandomnumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsRandomNumberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsRandomNumberApplication.class, args);
    }
}
```

## [Service] — Capa de servicio

Genera los siguientes archivos:

### `src/main/java/com/example/msrandomnumber/service/RandomNumberService.java`

```java
package com.example.msrandomnumber.service;

public interface RandomNumberService {

    int getRandomNumber();
}
```

### `src/main/java/com/example/msrandomnumber/service/RandomNumberServiceImpl.java`

```java
package com.example.msrandomnumber.service;

import org.springframework.stereotype.Service;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class RandomNumberServiceImpl implements RandomNumberService {

    @Override
    public int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(1, 10);
    }
}
```

## [Controller] — Controlador REST

Genera el siguiente archivo:

### `src/main/java/com/example/msrandomnumber/controller/RandomNumberController.java`

```java
package com.example.msrandomnumber.controller;

import com.example.msrandomnumber.service.RandomNumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RandomNumberController {

    private final RandomNumberService randomNumberService;

    public RandomNumberController(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    @GetMapping("/random")
    public ResponseEntity<Map<String, Integer>> getRandom() {
        int number = randomNumberService.getRandomNumber();
        return ResponseEntity.ok(Map.of("number", number));
    }
}
```
