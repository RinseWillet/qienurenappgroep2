package app.qienuren.controller;

import app.qienuren.model.InterneMedewerker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class InterneMedewerkerService {

    @Autowired
    InterneMedewerkerRepository interneMedewerkerRepository;

    public InterneMedewerker addInterneMederwerker(InterneMedewerker interneMedewerker) {
        System.out.println("Interne medewerker aangemaakt");
        return interneMedewerkerRepository.save(interneMedewerker);
    }

    public Iterable<InterneMedewerker> getAllInterneMedewerkers() {
        System.out.println("Alle interne medewerkers opgevraagd");
        return interneMedewerkerRepository.findAll();
    }
}