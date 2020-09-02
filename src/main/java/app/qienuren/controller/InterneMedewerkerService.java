package app.qienuren.controller;

import app.qienuren.model.InterneMedewerker;
import app.qienuren.security.RandomPasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
@Transactional
public class InterneMedewerkerService {

    @Autowired
    InterneMedewerkerRepository interneMedewerkerRepository;
    @Autowired
    RandomPasswordGenerator randomPasswordGenerator;

    public InterneMedewerker addInterneMederwerker(InterneMedewerker interneMedewerker) {
        if (interneMedewerkerRepository.findByEmail(interneMedewerker.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "email bestaat al");
        }
        interneMedewerker.setPassword(randomPasswordGenerator.generatePassayPassword());
        System.out.println(interneMedewerker.getPassword());
        System.out.println("Interne medewerker aangemaakt");
        return interneMedewerkerRepository.save(interneMedewerker);
    }

    public Iterable<InterneMedewerker> getAllInterneMedewerkers() {
        System.out.println("Alle interne medewerkers opgevraagd");
        return interneMedewerkerRepository.findAll();
    }
}