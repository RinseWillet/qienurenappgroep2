package app.qienuren.controller;

import app.qienuren.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;


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

    //kijkt eerst of het emailadres al in de database staat.
    public Trainee addTrainee(Trainee trainee){
        if(traineeRepository.findByEmail(trainee.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "email bestaat al");
        }
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

        System.out.println("voor: tijdTrainee>>> " + tijdtrainee.getNaam());
        System.out.println("voor: tijdTrainee>>> " + tijdtrainee.getTelefoonnr());

        System.out.println("voor: trainee>>> " + trainee.getNaam());
        System.out.println("voor: trainee>>> " + trainee.getTelefoonnr());

        //echte trainee krijgt waardes van de tijdelijke trainee, tenzij niets is ingevuld
        if (tijdtrainee.getNaam().isEmpty()) {
            trainee.setNaam(trainee.getNaam());
        }
        if (tijdtrainee.getEmail().isEmpty()) {
            trainee.setEmail(trainee.getEmail());
        }
        if (tijdtrainee.getTelefoonnr().isEmpty()) {
            trainee.setTelefoonnr(trainee.getTelefoonnr());
        }
        if (tijdtrainee.getPostcode().isEmpty()) {
            trainee.setPostcode(trainee.getPostcode());
        }
        if (tijdtrainee.getStraatNaamNr().isEmpty()) {
            trainee.setStraatNaamNr(trainee.getStraatNaamNr());
        }
        if (tijdtrainee.getWoonplaats().isEmpty()) {
            trainee.setWoonplaats(trainee.getWoonplaats());
        }

        System.out.println("na: tijdTrainee>>> " + tijdtrainee.getNaam());
        System.out.println("na: tijdTrainee>>> " + tijdtrainee.getTelefoonnr());

        System.out.println("na: trainee>>> " + trainee.getNaam());
        System.out.println("na: trainee>>> " + trainee.getTelefoonnr());

        //aangepaste gegevens worden opgeslagen in de database
        return traineeRepository.save(trainee);
    }

    public Iterable<Trainee> getTraineesByKCPId(long kcpId) {
        Iterable<Trainee> trainees = traineeRepository.findAll();
        ArrayList<Trainee> traineesBehorendAanKCP = new ArrayList<>();
        for (Trainee t : trainees) {
            if (t.getLeidingGevende() != null) {
                if (t.getLeidingGevende().getId() == kcpId) {
                    traineesBehorendAanKCP.add(t);
                }
            }
        }
        return traineesBehorendAanKCP;
    }



//    public Trainee updateTrainee(long id) {
//        System.out.println("trainee updaten");
//        Trainee traineetijdelijk = traineeRepository.findById(id).get();
//        traineetijdelijk.setLeidingGevende();


    }

