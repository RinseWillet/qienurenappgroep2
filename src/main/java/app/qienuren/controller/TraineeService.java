package app.qienuren.controller;

import app.qienuren.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TraineeService {

    @Autowired
    TraineeRepository traineeRepository;
    @Autowired
    BedrijfRepository bedrijfRepository;
    @Autowired
    KlantContactPersoonRepository kcpRepository;
    @Autowired
    FormulierRepository formulierRepository;
    @Autowired
    TijdelijkeTraineeRepository tijdelijkeTraineeRepository;

    public Trainee addTrainee(Trainee trainee) {
        System.out.println("trainee aangemaakt");
        return traineeRepository.save(trainee);
    }

    public Iterable<Trainee> getAllTrainees() {
        System.out.println("Alle trainees opgevraagd");
        return traineeRepository.findAll();
    }

   /* public Trainee bedrijfToevoegenTrainee(long traineeID, long bedrijfID) {
        Trainee tijdelijkTrainee = traineeRepository.findById(traineeID).get();
        Bedrijf tijdelijkBedrijf = bedrijfRepository.findById(bedrijfID).get();
       tijdelijkTrainee.koppelBedrijf(tijdelijkBedrijf);
        System.out.println("Bedrijf gekoppeld aan Trainee");
        return traineeRepository.save(tijdelijkTrainee);
    }*/

    public Trainee traineeKoppelContactPersoon(long traineeID, long kcpID) {
        System.out.println("Trainee gekoppeld aan Bedrijf");
        KlantContactPersoon tijdelijkKCP = kcpRepository.findById(kcpID).get();
        Trainee tijdelijkTrainee = traineeRepository.findById(traineeID).get();

        tijdelijkTrainee.koppelKlantContactPersoon(tijdelijkKCP);
        tijdelijkKCP.koppelTrainee(tijdelijkTrainee);

        kcpRepository.save(tijdelijkKCP);

        return traineeRepository.save(tijdelijkTrainee);
    }

    public Trainee getTraineeById(long id) {
        System.out.println("Trainee opgehaald");
        return traineeRepository.findById(id).get();
    }

    public Trainee traineeKoppelformulier(long traineeID, long formulierid) {
        System.out.println("Trainee aan formulier gekoppeld");
        Formulier formulierTijdelijk = formulierRepository.findById(formulierid).get();
        Trainee traineeTijdelijk = traineeRepository.findById(traineeID).get();

        traineeTijdelijk.koppelFormulier(formulierTijdelijk);

        return traineeRepository.save(traineeTijdelijk);
    }

    public Trainee wijzigGegevens(long oorspronkelijkeId, long id) {
        System.out.println("Verzoek gegevens wijzigen ontvangen");
        //tijdelijke trainee wordt opgehaald
        TijdelijkeTrainee tijdtrainee = tijdelijkeTraineeRepository.findById(id).get();
        //echte trainee wordt opgehaald
        Trainee trainee = traineeRepository.findById(oorspronkelijkeId).get();
        //echte trainee krijgt waardes van de tijdelijke trainee
        trainee.setNaam(tijdtrainee.getNaam());
        trainee.setEmail(tijdtrainee.getEmail());
        trainee.setTelefoonnr(tijdtrainee.getTelefoonnr());
        trainee.setPostcode(tijdtrainee.getPostcode());
        trainee.setStraatNaamNr(tijdtrainee.getStraatNaamNr());
        trainee.setWoonplaats(tijdtrainee.getWoonplaats());
        //aangepaste gegevens worden opgeslagen in de database
        return traineeRepository.save(trainee);
    }



//    public Trainee updateTrainee(long id) {
//        System.out.println("trainee updaten");
//        Trainee traineetijdelijk = traineeRepository.findById(id).get();
//        traineetijdelijk.setLeidingGevende();


    }

