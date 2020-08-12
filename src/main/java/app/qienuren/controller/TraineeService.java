package app.qienuren.controller;

import app.qienuren.model.Bedrijf;
import app.qienuren.model.KlantContactPersoon;
import app.qienuren.model.Trainee;
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

    public Trainee addTrainee(Trainee trainee) {
        System.out.println("trainee aangemaakt");
        return traineeRepository.save(trainee);
    }

    public Iterable<Trainee> getAllTrainees() {
        System.out.println("Alle trainees opgevraagd");
        return traineeRepository.findAll();
    }

    public Trainee bedrijfToevoegenTrainee(long traineeID, long bedrijfID) {
        Trainee tijdelijkTrainee = traineeRepository.findById(traineeID).get();
        Bedrijf tijdelijkBedrijf = bedrijfRepository.findById(bedrijfID).get();
        tijdelijkTrainee.koppelBedrijf(tijdelijkBedrijf);
        System.out.println("Bedrijf gekoppeld aan Trainee");
        return traineeRepository.save(tijdelijkTrainee);

    }

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


//    public Trainee updateTrainee(long id) {
//        System.out.println("trainee updaten");
//        Trainee traineetijdelijk = traineeRepository.findById(id).get();
//        traineetijdelijk.setLeidingGevende();


    }

