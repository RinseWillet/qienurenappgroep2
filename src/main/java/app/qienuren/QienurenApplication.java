package app.qienuren;

import app.qienuren.controller.UserRepository;
import app.qienuren.model.Formulier;
import app.qienuren.model.WerkDag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class) //weet niet of dit nodig is
public class QienurenApplication {

    public static void main(String[] args) {
        SpringApplication.run(QienurenApplication.class, args);
        //regel hieronder niet aanpassen aub
        System.out.println("Uren App groep 2. It's Alive!");
    }

}
