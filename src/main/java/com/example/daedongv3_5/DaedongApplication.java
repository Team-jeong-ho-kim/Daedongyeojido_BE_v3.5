package com.example.daedongv3_5;

import jakarta.persistence.EntityListeners;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DaedongApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaedongApplication.class, args);
    }

}
