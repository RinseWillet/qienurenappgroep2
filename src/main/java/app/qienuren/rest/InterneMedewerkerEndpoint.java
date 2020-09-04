package app.qienuren.rest;

import app.qienuren.controller.FormulierService;
import app.qienuren.controller.InterneMedewerkerService;
import app.qienuren.controller.TijdelijkeMedewerkerService;
import app.qienuren.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/internemedewerker")
public class InterneMedewerkerEndpoint {


    @Autowired
    InterneMedewerkerService interneMedewerkerService;

    @Autowired
    FormulierService formulierService;

    @Autowired
    TijdelijkeMedewerkerService tijdelijkeMedewerkerService;

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
    @PutMapping("/wachtwoordwijzigen/{id}")
    public void internemedewerkerWachtwoordWijzigen(@RequestBody InterneMedewerker interneMedewerker, @PathVariable(value = "id") long id) {
        interneMedewerkerService.internemedewerkerWachtwoordWijzigen(id,interneMedewerker);
    }

    @PutMapping("/formulier/update/{formulierid}")
    public Formulier updateFormulier(@RequestBody Formulier tf) {
        return formulierService.updateFormulier(tf);
    }

    @PostMapping("/nieuwegegevens/{id}")
    public TijdelijkeMedewerker addTijdelijkeMedewerker(@PathVariable(value = "id") long id, @RequestBody TijdelijkeMedewerker medewerker) {
        return tijdelijkeMedewerkerService.addTijdelijkeMedewerker(id, medewerker);
    }

    @GetMapping("/tijdelijketrainee/tijdelijketraineeid/{tijdelijketraineeid}")
    public TijdelijkeMedewerker getTijdelijkeMedewerkerById(@PathVariable(value = "tijdelijketraineeid") long tijdelijkeTraineeId) {
        return tijdelijkeMedewerkerService.getTijdelijkeMedewerkerById(tijdelijkeTraineeId);
    }

    @GetMapping("/tijdelijketrainee/oorspronkelijketraineeid/{oorspronkelijketraineeid}")
    public TijdelijkeMedewerker getTijdelijkeMedewerkerByOorspronkelijkeId(@PathVariable(value = "oorspronkelijketraineeid") long oorspronkelijkeId) {
        return tijdelijkeMedewerkerService.getTijdelijkeMedewerkerByOorspronkelijkeId(oorspronkelijkeId);
    }


}
