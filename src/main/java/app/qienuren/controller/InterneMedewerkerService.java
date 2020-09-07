package app.qienuren.controller;

import app.qienuren.model.*;
import app.qienuren.security.RandomPasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
@Transactional
public class InterneMedewerkerService {

    @Autowired
    InterneMedewerkerRepository interneMedewerkerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    RandomPasswordGenerator randomPasswordGenerator;
    @Autowired
    TijdelijkeMedewerkerRepository tijdelijkeMedewerkerRepository;
    @Autowired
    EmailService emailService;

    public InterneMedewerker wijzigGegevens(long oorspronkelijkeId, long id) {
        System.out.println("Verzoek gegevens wijzigen ontvangen");
        //tijdelijke trainee wordt opgehaald
        TijdelijkeMedewerker tijdelijkeMedewerker = tijdelijkeMedewerkerRepository.findById(id).get();
        //echte trainee wordt opgehaald
        InterneMedewerker interneMedewerker = interneMedewerkerRepository.findById(oorspronkelijkeId).get();

//        System.out.println("voor: tijdTrainee>>> " + tijdtrainee.getNaam());
//        System.out.println("voor: tijdTrainee>>> " + tijdtrainee.getTelefoonnr());
//
//        System.out.println("voor: trainee>>> " + trainee.getNaam());
//        System.out.println("voor: trainee>>> " + trainee.getTelefoonnr());

        //echte trainee krijgt waardes van de tijdelijke trainee, tenzij niets is ingevuld
        if (tijdelijkeMedewerker.getNaam().isEmpty()) {
            interneMedewerker.setNaam(interneMedewerker.getNaam());
        } else {
            interneMedewerker.setNaam(tijdelijkeMedewerker.getNaam());
        }
        if (tijdelijkeMedewerker.getEmail().isEmpty()) {
            interneMedewerker.setEmail(interneMedewerker.getEmail());
        } else {
            interneMedewerker.setEmail(tijdelijkeMedewerker.getEmail());

        }
        if (tijdelijkeMedewerker.getTelefoonnr().isEmpty()) {
            interneMedewerker.setTelefoonnr(interneMedewerker.getTelefoonnr());
        } else {
            interneMedewerker.setTelefoonnr(tijdelijkeMedewerker.getTelefoonnr());

        } if (tijdelijkeMedewerker.getPostcode().isEmpty()) {
            interneMedewerker.setPostcode(interneMedewerker.getPostcode());
        } else {
            interneMedewerker.setPostcode(tijdelijkeMedewerker.getPostcode());

        }
        if (tijdelijkeMedewerker.getStraatNaamNr().isEmpty()) {
            interneMedewerker.setStraatNaamNr(tijdelijkeMedewerker.getStraatNaamNr());
        } else {
            interneMedewerker.setStraatNaamNr(tijdelijkeMedewerker.getStraatNaamNr());

        }
        if (tijdelijkeMedewerker.getWoonplaats().isEmpty()) {
            interneMedewerker.setWoonplaats(interneMedewerker.getWoonplaats());
        } else {
            interneMedewerker.setWoonplaats(tijdelijkeMedewerker.getWoonplaats());
        }

//        System.out.println("na: tijdTrainee>>> " + tijdtrainee.getNaam());
//        System.out.println("na: tijdTrainee>>> " + tijdtrainee.getTelefoonnr());
//
//        System.out.println("na: trainee>>> " + trainee.getNaam());
//        System.out.println("na: trainee>>> " + trainee.getTelefoonnr());

        //aangepaste gegevens worden opgeslagen in de database
        return interneMedewerkerRepository.save(interneMedewerker);
    }



    public InterneMedewerker addInterneMederwerker(InterneMedewerker interneMedewerker) {
        if (interneMedewerkerRepository.findByEmail(interneMedewerker.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "email bestaat al");
        }
        interneMedewerker.setPassword(randomPasswordGenerator.generatePassayPassword());
        String nonEncodedPassword = interneMedewerker.getPassword();
        System.out.println(interneMedewerker.getPassword());
        interneMedewerker.setPassword(passwordEncoder.encode(interneMedewerker.getPassword()));
        System.out.println(interneMedewerker.getPassword());
        System.out.println("Interne medewerker aangemaakt");

        //Send email
        //Arguments: InterneMedewerker, Subject, Message(templated?)
        //InterneMedewerker fields nodig: Name, Username, Password
        emailService.sendWithAccountTemplate(interneMedewerker, nonEncodedPassword);

        return interneMedewerkerRepository.save(interneMedewerker);
    }

    public Iterable<InterneMedewerker> getAllInterneMedewerkers() {
        System.out.println("Alle interne medewerkers opgevraagd");
        return interneMedewerkerRepository.findAll();
    }

    public InterneMedewerker getInterneMedewerkerById(long id) {
        System.out.println("Interne medewerker opgehaald");
        return interneMedewerkerRepository.findById(id).get();
    }


    public InterneMedewerker internemedewerkerWachtwoordWijzigen(long id, InterneMedewerker interneMedewerker) {
        InterneMedewerker interneMedewerker1 = interneMedewerkerRepository.findById(id).get();
        if(interneMedewerker.getPassword() != null && !interneMedewerker.getPassword().equals("")){
            interneMedewerker1.setPassword(passwordEncoder.encode(interneMedewerker.getPassword()));
        }
        return interneMedewerkerRepository.save(interneMedewerker1);
    }


}