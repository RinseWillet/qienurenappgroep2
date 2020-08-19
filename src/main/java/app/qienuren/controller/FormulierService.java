package app.qienuren.controller;

import app.qienuren.model.Formulier;
import app.qienuren.model.AdminStatus;
import app.qienuren.model.OpdrachtgeverStatus;
import app.qienuren.model.TijdelijkFormulier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

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
        Iterable<Formulier> formulieren = formulierRepository.findAll();
        ArrayList<Formulier> teVerzendenFormulieren = new ArrayList<>();
        for (Formulier f : formulieren) {
            if (!(f instanceof TijdelijkFormulier)) {
                teVerzendenFormulieren.add(f);
            }
        }
        return teVerzendenFormulieren;
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

    public Formulier getById(long id) {
        return formulierRepository.findById(id).get();
    }

    public Formulier AdminStatusGoed(long id) {
        System.out.println("hij doet updaten");
        Formulier formuliertijdelijk = formulierRepository.findById(id).get();
        formuliertijdelijk.setAdminStatus(AdminStatus.GOEDGEKEURD);
        return formulierRepository.save(formuliertijdelijk);
    }

    public Formulier AdminStatusFout(long id) {
        System.out.println("hij doet fout updaten");
        Formulier formuliertijdelijk = formulierRepository.findById(id).get();
        formuliertijdelijk.setAdminStatus(AdminStatus.AFGEKEURD);
        return formulierRepository.save(formuliertijdelijk);
    }

    public Formulier OpdrachtgeverStatusGoed(long id) {
        System.out.println("hij doet updaten");
        Formulier formuliertijdelijk = formulierRepository.findById(id).get();
        formuliertijdelijk.setOpdrachtgeverStatus(OpdrachtgeverStatus.GOEDGEKEURD);
        return formulierRepository.save(formuliertijdelijk);
    }

    public Formulier OpdrachtgeverStatusFout(long id) {
        System.out.println("hij doet fout updaten");
        Formulier formuliertijdelijk = formulierRepository.findById(id).get();
        formuliertijdelijk.setOpdrachtgeverStatus(OpdrachtgeverStatus.AFGEKEURD);
        return formulierRepository.save(formuliertijdelijk);
    }
}
