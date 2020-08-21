package app.qienuren.rest;

import app.qienuren.controller.TijdelijkeTraineeService;
import app.qienuren.controller.TraineeService;
import app.qienuren.model.TijdelijkeTrainee;
import app.qienuren.controller.FormulierService;
import app.qienuren.model.Formulier;
import app.qienuren.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trainee")
public class TraineeEndpoint {


    @Autowired
    FormulierService formulierService;

    @Autowired
    TraineeService traineeService;


    @Autowired
    TijdelijkeTraineeService tijdelijkeTraineeService;

    @GetMapping("/{id}")
    public Trainee getTraineeById(@PathVariable(value = "id") long id){
        return traineeService.getTraineeById(id);
    }

    @PutMapping("/trainee/koppelFormulier/{id}/{formulierid}")
    public void traineeKoppelFormulier(@PathVariable(value = "id") long traineeID, @PathVariable(value = "formulierid") long formulierid){
        traineeService.traineeKoppelformulier(traineeID, formulierid);
    }

    @PostMapping("/nieuwegegevens/{id}")
   public TijdelijkeTrainee addTijdelijkeTrainee(@PathVariable(value = "id") long traineeID, @RequestBody TijdelijkeTrainee tijdtrainee){
        return tijdelijkeTraineeService.addTijdelijkeTrainee(traineeID, tijdtrainee); }


    @PutMapping("/formulier/update/{formulierid}")
    public Formulier updateFormulier(@RequestBody Formulier tf) {
        return formulierService.updateFormulier(tf);
    }

    @GetMapping("/tijdelijkeformulieren/{id}")
    public Iterable<Formulier> getTijdelijkeFormulierenByTraineeId(@PathVariable(value = "id") long id) {
        Trainee t = traineeService.getTraineeById(id);
        return t.getTijdelijkeFormulieren();
    }


}
