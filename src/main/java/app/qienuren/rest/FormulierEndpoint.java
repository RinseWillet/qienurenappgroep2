package app.qienuren.rest;

import app.qienuren.controller.FormulierService;
import app.qienuren.model.Formulier;
import app.qienuren.model.WerkDag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/formulier")
public class FormulierEndpoint {

//    @Autowired
    FormulierService formulierService;

    @PostMapping("/nieuw")
    public Formulier nieuwFormulier(@RequestBody Formulier formulier) {
        System.out.println(formulier.getMaand());
        System.out.println(formulier.getJaar());
        System.out.println(formulier.getWerkDagen().toString());
        //return formulierService.addNieuwFormulier(formulier);
        return null;
    }

    @GetMapping("/all")
    public Iterable<Formulier> alleFormulieren(){
        return formulierService.getalleFormulieren();
    }

//    @PutMapping("/update/{id}")
//    public Formulier updateFormulier(@RequestBody Formulier formulier, @PathVariable(value = "id")long id){
//        return formulierService.updateFormulier(formulier, id);
//    }

    @DeleteMapping("/verwijderen/{id}")
    public void verwijderFormulier(@PathVariable(value = "id")long id){
        formulierService.verwijderFormulier(id);
    }

}
