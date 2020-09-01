package app.qienuren.controller;

import app.qienuren.model.KlantContactPersoon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
@Transactional
public class KlantContactPersoonService {

    @Autowired
    KlantContactPersoonRepository klantContactPersoonRepository;

    public KlantContactPersoon addKlantContactPersoon(KlantContactPersoon klantContactPersoon) {
        if (klantContactPersoonRepository.findByEmail(klantContactPersoon.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "email bestaat al");
        }
        System.out.println("Klant Contact Persoon aangemaakt");
        return klantContactPersoonRepository.save(klantContactPersoon);
    }

    public Iterable<KlantContactPersoon> getAllKlantContactPersoon() {
        System.out.println("alle klant contact personen verzamelen!");
        return klantContactPersoonRepository.findAll();
    }

//    public void bedrijfToevoegenKlantContactPersoon(long kcpID, long bedrijfID) {
//    }
//
//    public void traineeKoppelContactPersoon(long traineeID, long kcpID) {
//    }
}