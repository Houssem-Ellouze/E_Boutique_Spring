package tn.esprit.e_boutique_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class EBoutiqueSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run ( EBoutiqueSpringApplication.class, args );
    }

}
