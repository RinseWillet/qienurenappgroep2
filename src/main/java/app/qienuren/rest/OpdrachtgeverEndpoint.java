package app.qienuren.rest;

import app.qienuren.controller.FormulierService;
import app.qienuren.controller.PersoonService;
import app.qienuren.controller.TraineeService;
import app.qienuren.model.Formulier;
import app.qienuren.model.Persoon;
import app.qienuren.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/opdrachtgever")
public class OpdrachtgeverEndpoint {

    @Autowired
    FormulierService formulierService;

    @Autowired
    TraineeService traineeService;

    @PutMapping("/update/statusgoed/{id}")
    public Formulier updateFormulierStatusGoed(@PathVariable(value = "id")long id){
        return formulierService.OpdrachtgeverStatusGoed(id);
    }

    @PutMapping("/update/statusfout/{id}")
    public Formulier updateFormulierStatusFout(@PathVariable(value = "id")long id){
        return formulierService.OpdrachtgeverStatusFout(id);
    }

    @GetMapping("/formulieren/all")
    public Iterable<Formulier> alleFormulieren() {
        return formulierService.getAlleFormulierenVoorOpdrachtGever();
    }

    @GetMapping("/trainees/{kcpid}")
    public Iterable<Trainee> getAllTrainees(@PathVariable(value = "kcpid") long id) {
        return traineeService.getTraineesByKCPId(id);
    }
}
