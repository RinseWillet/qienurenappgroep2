package app.qienuren.controller;

import app.qienuren.model.Bedrijf;
import app.qienuren.model.Formulier;
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
    @Autowired
    FormulierRepository formulierRepository;

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

    public Trainee wijzigGegevens(long traineeID, Trainee trainee) {
        System.out.println("Verzoek gegevens wijzigen ontvangen");
        Trainee traineetemp = traineeRepository.findById(traineeID).get();
        traineetemp.setNaam(trainee.getNaam());
        traineetemp.setEmail(trainee.getEmail());
        traineetemp.setTelefoonnr(trainee.getTelefoonnr());
        traineetemp.setPostcode(trainee.getPostcode());
        traineetemp.setStraatNaamNr(trainee.getStraatNaamNr());
        traineetemp.setWoonplaats(trainee.getWoonplaats());
        return traineeRepository.save(traineetemp);
    }

//
//    public Employee changeSalary(long id, Employee e) {
//        System.out.println("Request received to update salary");
//        Employee emp = employeerepository.findById(id).get();
//        emp.setSalary(e.getSalary());
//        employeerepository.save(emp);
//        return emp;
//    }

//    public Trainee updateTrainee(long id) {
//        System.out.println("trainee updaten");
//        Trainee traineetijdelijk = traineeRepository.findById(id).get();
//        traineetijdelijk.setLeidingGevende();


    }

