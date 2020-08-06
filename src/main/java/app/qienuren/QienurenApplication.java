package app.qienuren;

import app.qienuren.model.Formulier;
import app.qienuren.model.WerkDag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class QienurenApplication {

    public static void main(String[] args) {
        SpringApplication.run(QienurenApplication.class, args);
        //regel hieronder niet aanpassen aub
        System.out.println("Uren App groep 2. It's Alive!");
    }

}
