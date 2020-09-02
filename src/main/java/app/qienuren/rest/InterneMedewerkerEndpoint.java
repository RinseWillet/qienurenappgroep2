package app.qienuren.rest;

import app.qienuren.controller.FormulierService;
import app.qienuren.controller.InterneMedewerkerService;
import app.qienuren.model.Formulier;
import app.qienuren.model.InterneMedewerker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/internemedewerker")
public class InterneMedewerkerEndpoint {


    @Autowired
    InterneMedewerkerService interneMedewerkerService;

    @Autowired
    FormulierService formulierService;

    @GetMapping("/{id}")
    public InterneMedewerker getInterneMedewerkerById(@PathVariable(value = "id") long id) {
        return interneMedewerkerService.getInterneMedewerkerById(id);
    }

    @GetMapping("/formulier/{medewerkerid}/{formulierId}")
    public Formulier getFormulier(@PathVariable(value = "medewerkerid") long medewerkerid, @PathVariable(value = "formulierId") long formulierId) {
        InterneMedewerker im = interneMedewerkerService.getInterneMedewerkerById(medewerkerid);
        Iterable<Formulier> formulieren = im.getTijdelijkeFormulieren();
        for (Formulier f : formulieren) {
            if (f.getId() == formulierId) {
                return f;
            }
        }
        return null;
    }

    @PutMapping("/formulier/update/{formulierid}")
    public Formulier updateFormulier(@RequestBody Formulier tf) {
        return formulierService.updateFormulier(tf);
    }
}
