package app.qienuren.controller;

import app.qienuren.model.TijdelijkeTrainee;
import app.qienuren.model.Trainee;
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
}
