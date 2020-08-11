package app.qienuren.rest;

import app.qienuren.controller.FormulierService;
import app.qienuren.controller.WerkDagService;
import app.qienuren.model.Formulier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/formulier")
public class FormulierEndpoint {

    @Autowired
    FormulierService formulierService;
    @Autowired
    WerkDagService werkDagService;

    @PostMapping("/nieuw")
    public Formulier nieuwFormulier(@RequestBody Formulier formulier) {
        return formulierService.addNieuwFormulier(formulier);
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
