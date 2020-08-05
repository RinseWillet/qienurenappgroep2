package app.qienuren.controller;

import app.qienuren.model.Formulier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional

public class FormulierService {

    @Autowired
    FormulierRepository formulierRepository;

    @Autowired
    WerkDagRepository werkDagRepository;

    public Formulier addNieuwFormulier(Formulier formulier) {
        System.out.println("formulier aangemaakt");
        return formulierRepository.save(formulier);
    }

    public Iterable<Formulier> getalleFormulieren() {
        return formulierRepository.findAll();
    }

//    public Formulier updateFormulier(Formulier formulier, long id) {
//        Formulier nieuwFormulier = formulierRepository.findById(id).get();
//        nieuwFormulier.setOpdrachtUren(formulier.getOpdrachtUren());
//        nieuwFormulier.setOverwerkUren(formulier.getOverwerkUren());
//        nieuwFormulier.setOverigeUren(formulier.getOverigeUren());
//        return formulierRepository.save(nieuwFormulier);
//    }

    public void verwijderFormulier(long id) {
        System.out.println("Het formulier is verwijderd");
        formulierRepository.deleteById(id);
    }
}
