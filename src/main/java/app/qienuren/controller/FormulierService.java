package app.qienuren.controller;

import app.qienuren.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class FormulierService {

    @Autowired
    FormulierRepository formulierRepository;

    @Autowired
    WerkDagRepository werkDagRepository;

    public Formulier updateFormulier(Formulier nieuwF) {
        // oude formulier ophalen
        Formulier oudF = formulierRepository.findById(nieuwF.getId()).get();

        List<WerkDag> nieuweWerkDagen = nieuwF.getWerkDagen();
        List<WerkDag> oudeWerkDagen = oudF.getWerkDagen();

        for (int i = 0; i < nieuweWerkDagen.size(); i++) {
            if (nieuweWerkDagen.get(i).getOpdrachtUren() != 0) {
                oudeWerkDagen.get(i).setOpdrachtUren(nieuweWerkDagen.get(i).getOpdrachtUren());
            }
            if (nieuweWerkDagen.get(i).getOverwerkUren() != 0) {
                oudeWerkDagen.get(i).setOverwerkUren(nieuweWerkDagen.get(i).getOverwerkUren());
            }
            if (nieuweWerkDagen.get(i).getVerlofUren() != 0) {
                oudeWerkDagen.get(i).setVerlofUren(nieuweWerkDagen.get(i).getVerlofUren());
            }
            if (nieuweWerkDagen.get(i).getZiekteUren() != 0) {
                oudeWerkDagen.get(i).setZiekteUren(nieuweWerkDagen.get(i).getZiekteUren());
            }
            if (nieuweWerkDagen.get(i).getTrainingsUren() != 0) {
                oudeWerkDagen.get(i).setTrainingsUren(nieuweWerkDagen.get(i).getTrainingsUren());
            }
            if (nieuweWerkDagen.get(i).getOverigeUren() != 0) {
                oudeWerkDagen.get(i).setOverigeUren(nieuweWerkDagen.get(i).getOverigeUren());
            }
            if (nieuweWerkDagen.get(i).getOverigeUrenUitleg() != "" || !(nieuweWerkDagen.get(i).getOverigeUrenUitleg().isEmpty())) {
                oudeWerkDagen.get(i).setOverigeUrenUitleg(nieuweWerkDagen.get(i).getOverigeUrenUitleg());
            }
        }

        oudF.setIngezondenFormulier(nieuwF.isIngezondenFormulier());

        System.out.println("Oud TF: " + oudF.getWerkDagen().get(0).getOpdrachtUren());
        System.out.println("nieuw TF: " + nieuwF.getWerkDagen().get(0).getOpdrachtUren());
        System.out.println("Oud F:" + oudF.isIngezondenFormulier());
        System.out.println("nieuw F: " + nieuwF.isIngezondenFormulier());
        return formulierRepository.save(oudF);
    }

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
