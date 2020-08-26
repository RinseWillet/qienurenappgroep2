package app.qienuren.controller;

import app.qienuren.model.TijdelijkeTrainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TijdelijkeTraineeService {

    @Autowired
    TijdelijkeTraineeRepository tijdelijketraineeRepository;
    @Autowired
    TraineeRepository traineeRepository;


    public TijdelijkeTrainee addTijdelijkeTrainee(long traineeID, TijdelijkeTrainee tijdtrainee) {
        tijdtrainee.setOorspronkelijkeId(traineeRepository.findById(traineeID).get().getId());
        System.out.println("tijdelijke trainee aangemaakt");
        return tijdelijketraineeRepository.save(tijdtrainee);
    }

    public Iterable<TijdelijkeTrainee> getAllTijdelijkeTrainee() {
        System.out.println("alle tijdelijke trainees opgevraags");
        return tijdelijketraineeRepository.findAll();
    }
}
