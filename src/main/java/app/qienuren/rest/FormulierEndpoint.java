package app.qienuren.rest;

import app.qienuren.controller.FormulierService;
import app.qienuren.controller.PersoonService;
import app.qienuren.model.Formulier;
import app.qienuren.model.Persoon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/formulier")
public class FormulierEndpoint {

    @Autowired
    FormulierService formulierService;

    @Autowired
    PersoonService persoonService;

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
    public Iterable<Formulier> alleFormulieren() {
        return formulierService.getalleFormulieren();
    }

    @GetMapping("/{id}")
    public Formulier getFormulierById(@PathVariable(value = "id") long id) {
        return formulierService.getById(id);
    }

    @DeleteMapping("/verwijderen/{id}")
    public void verwijderFormulier(@PathVariable(value = "id") long id) {
        formulierService.verwijderFormulier(id);
    }

    @GetMapping("/exportCSV/{formid}/{persoonid}")
    public void Export(@PathVariable(value = "formid") long formId, @PathVariable(value = "persoonid") long persoonId) {
        Formulier formulierExport = getFormulierById(formId);
        Persoon persoonExport = persoonService.getById(persoonId);
        try {
            formulierService.exportCSV(formulierExport, persoonExport);
            System.out.println("dit ging goed");
        } catch (IOException e) {
            System.out.println("er ging iets fout");
        }
    }
}
