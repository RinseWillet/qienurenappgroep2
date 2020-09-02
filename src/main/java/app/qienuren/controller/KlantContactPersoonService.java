package app.qienuren.controller;

import app.qienuren.model.KlantContactPersoon;
import app.qienuren.model.Trainee;
import app.qienuren.security.RandomPasswordGenerator;
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
    @Autowired
    RandomPasswordGenerator randomPasswordGenerator;


    public KlantContactPersoon addKlantContactPersoon(KlantContactPersoon klantContactPersoon) {
        if (klantContactPersoonRepository.findByEmail(klantContactPersoon.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "email bestaat al");
        }
        klantContactPersoon.setPassword(randomPasswordGenerator.generatePassayPassword());
        System.out.println(klantContactPersoon.getPassword());
        System.out.println("Klant Contact Persoon aangemaakt");
        return klantContactPersoonRepository.save(klantContactPersoon);
    }

    public Iterable<KlantContactPersoon> getAllKlantContactPersoon() {
        System.out.println("alle klant contact personen verzamelen!");
        return klantContactPersoonRepository.findAll();
    }

    public KlantContactPersoon getKCPById(long id) {
       return klantContactPersoonRepository.findById(id).get();
    }

    public KlantContactPersoon kcpWachtwoordWijzigen(long id, KlantContactPersoon kcp) {
        KlantContactPersoon kcp2 = klantContactPersoonRepository.findById(id).get();
        if(kcp.getPassword() != null && !kcp.getPassword().equals("")){
            kcp2.setPassword(kcp.getPassword());
        }
        return klantContactPersoonRepository.save(kcp2);
    }

//    public void bedrijfToevoegenKlantContactPersoon(long kcpID, long bedrijfID) {
//    }
//
//    public void traineeKoppelContactPersoon(long traineeID, long kcpID) {
//    }
}
