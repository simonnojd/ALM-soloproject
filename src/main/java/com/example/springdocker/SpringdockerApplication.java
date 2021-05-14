package com.example.springdocker;

import com.example.springdocker.model.Car;
import com.example.springdocker.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringdockerApplication {

    public static void main(String[] args) { SpringApplication.run(SpringdockerApplication.class, args); }
}
