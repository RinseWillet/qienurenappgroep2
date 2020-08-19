package app.qienuren.controller;

import app.qienuren.model.TijdelijkFormulier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TijdelijkFormulierService {

    @Autowired
    TijdelijkFormulierRepository tijdelijkFormulierRepository;

    public TijdelijkFormulier addNieuwTijdelijkFormulier(TijdelijkFormulier tf) {
        System.out.println("Tijdelijk formulier aangemaakt");
        return tijdelijkFormulierRepository.save(tf);
    }

    public Iterable<TijdelijkFormulier> getalleTijdelijkeFormulieren() {
        return tijdelijkFormulierRepository.findAll();
    }

    public TijdelijkFormulier updateTijdelijkFormulier(TijdelijkFormulier oudTf, long id) {
        TijdelijkFormulier nieuwTf = tijdelijkFormulierRepository.findById(id).get();
        System.out.println("binnenkomend TF: " + oudTf);
        System.out.println("uitgaand TF: " + nieuwTf);
        return tijdelijkFormulierRepository.save(nieuwTf);
    }

    public void verwijderTijdelijkFormulier(long id) {
        System.out.println("Het tijdelijke formulier is verwijderd");
        tijdelijkFormulierRepository.deleteById(id);
    }

}
