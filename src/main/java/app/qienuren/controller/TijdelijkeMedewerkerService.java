package app.qienuren.controller;


import app.qienuren.model.TijdelijkeMedewerker;
import app.qienuren.model.TijdelijkeTrainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class TijdelijkeMedewerkerService {

    @Autowired
    TijdelijkeMedewerkerRepository tijdelijkeMedewerkerRepository;
    @Autowired
    InterneMedewerkerRepository interneMedewerkerRepository;


    public TijdelijkeMedewerker addTijdelijkeMedewerker(long id, TijdelijkeMedewerker tijdelijkeMedewerker) {
        tijdelijkeMedewerker.setOorspronkelijkeId(interneMedewerkerRepository.findById(id).get().getId());
        System.out.println("tijdelijke trainee aangemaakt");
        return tijdelijkeMedewerkerRepository.save(tijdelijkeMedewerker);
    }

    public Iterable<TijdelijkeMedewerker> getallTijdelijkeMedewerkers() {
        System.out.println("alle tijdelijke medewerkers opgevraagd");
        return tijdelijkeMedewerkerRepository.findAll();
    }

    public TijdelijkeMedewerker getTijdelijkeMedewerker(long id) {
        return tijdelijkeMedewerkerRepository.findById(id).get();
    }

    public TijdelijkeMedewerker getTijdelijkeMedewerkerByOorspronkelijkeId(long oorspronkelijkeId) {
        ArrayList<TijdelijkeMedewerker> alleTijdelijkeMedewerkers = (ArrayList<TijdelijkeMedewerker>)tijdelijkeMedewerkerRepository.findAll();
        TijdelijkeMedewerker terugTeSturenTijdelijkeMedewerker = null;
        for (TijdelijkeMedewerker tt : alleTijdelijkeMedewerkers) {
            if (tt.getOorspronkelijkeId() == oorspronkelijkeId) {
                terugTeSturenTijdelijkeMedewerker = tt;
            }
        }
        return terugTeSturenTijdelijkeMedewerker;
    }

}

