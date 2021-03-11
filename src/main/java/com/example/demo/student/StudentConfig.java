package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student patrick = new Student(
                    "Patrick",
                    "PatrickNovak213l@gmail.com",
                    LocalDate.of(2000, JANUARY, 5)
            );

            Student aleksiej = new Student(
                    "Aleksiej",
                    "alexiej69@gmail.com",
                    LocalDate.of(1996, FEBRUARY, 5)
            );
            repository.saveAll(
                    List.of(patrick, aleksiej)
            );
        };
    }
}
