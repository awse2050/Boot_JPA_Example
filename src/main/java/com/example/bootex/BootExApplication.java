package com.example.bootex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BootExApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootExApplication.class, args);
    }

}
