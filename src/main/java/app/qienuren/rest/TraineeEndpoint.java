package app.qienuren.rest;

import app.qienuren.controller.TraineeService;
import app.qienuren.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trainee")
public class TraineeEndpoint {

    @Autowired
    TraineeService traineeService;

    @GetMapping("/{id}")
    public Trainee getTraineeById(@PathVariable(value = "id") long id){
        return traineeService.getTraineeById(id);
    }

    @PutMapping("/trainee/koppelFormulier/{id}/{formulierid}")
    public void traineeKoppelFormulier(@PathVariable(value = "id") long traineeID, @PathVariable(value = "formulierid") long formulierid){
        traineeService.traineeKoppelformulier(traineeID, formulierid);
    }

    @PutMapping("/wijziggegevens/{id}")
    public Trainee traineeWijzigGegevens(@PathVariable(value = "id") long traineeID, @RequestBody Trainee trainee){
        return traineeService.wijzigGegevens(traineeID, trainee);
    }

}
