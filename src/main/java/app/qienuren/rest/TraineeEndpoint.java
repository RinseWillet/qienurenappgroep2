package app.qienuren.rest;

import app.qienuren.controller.TraineeService;
import app.qienuren.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trainee")
public class TraineeEndpoint {

    @Autowired
    TraineeService traineeService;

    @GetMapping("/{id}")
    public Trainee getTraineeById(@PathVariable(value = "id") long id){
        return traineeService.getTraineeById(id);
    }
}
