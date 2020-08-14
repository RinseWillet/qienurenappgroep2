package app.qienuren.rest;

import app.qienuren.controller.FormulierService;
import app.qienuren.model.Formulier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/opdrachtgever")
public class OpdrachtgeverEndpoint {

    @Autowired
    FormulierService formulierService;

    @PutMapping("/update/statusgoed/{id}")
    public Formulier updateFormulierStatusGoed(@PathVariable(value = "id")long id){
        return formulierService.OpdrachtgeverStatusGoed(id);
    }

    @PutMapping("/update/statusfout/{id}")
    public Formulier updateFormulierStatusFout(@PathVariable(value = "id")long id){
        return formulierService.OpdrachtgeverStatusFout(id);
    }


}
