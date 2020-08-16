package app.qienuren.controller;

import app.qienuren.model.KlantContactPersoon;
import app.qienuren.model.Persoon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class PersoonService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    PersoonRepository persoonRepository;

    public Iterable<Persoon> getAllMedewerkers() {
        System.out.println("Alle medewerkers opgevraagd");
        ArrayList<Persoon> prullenBak = (ArrayList) persoonRepository.findAll();
        ArrayList<Persoon> tempList = new ArrayList<>();
        for (Persoon p : prullenBak) {
            if (!(p instanceof KlantContactPersoon)) {
                tempList.add(p);
            }
        }
        return tempList;
    }

    public Persoon addPersoon(Persoon persoon) {
        System.out.println("User aangemaakt");
        persoon.setPassword(passwordEncoder.encode(persoon.getPassword()));
        return persoonRepository.save(persoon);
    }
}
