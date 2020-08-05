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

    @Autowired
    FormulierService formulierService;

    @PostMapping("/nieuw")
    public Formulier nieuwFormulier(@RequestBody Formulier formulier) {

        /*System.out.println("<<<<<FORMULIER ID: " + formulier.getId() + ">>>>>");
        for (WerkDag w : formulier.getWerkDagen()) {
            System.out.println("Datum: " + w.getDatum());
            System.out.println("OpdrachtUren: " + w.getOpdrachtUren());
            System.out.println("OverwerkUren: " + w.getOverwerkUren());
            System.out.println("TrainingsUren: " + w.getTrainingsUren());
            System.out.println("VerlofUren: " + w.getVerlofUren());
            System.out.println("ZiekteUren: " + w.getZiekteUren());
            System.out.println("OverigeUren: " + w.getOverigeUren());
            System.out.println("OverigeUrenUitleg: " + w.getOverigeUrenUitleg());
        }*/

        return formulierService.addNieuwFormulier(formulier);
        //return null;
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
