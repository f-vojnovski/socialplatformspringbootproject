package mk.finki.ukim.mk.lab.model;

import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(PizzaRepository.class, args);
    }

}
