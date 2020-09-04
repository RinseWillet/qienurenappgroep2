package app.qienuren.rest;

import app.qienuren.controller.FormulierService;
import app.qienuren.controller.PersoonService;
import app.qienuren.model.Formulier;
import app.qienuren.model.Persoon;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
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

    @GetMapping("/export-users/")
    public void exportCSV(HttpServletResponse response) throws Exception {

        //set file name and content type
        String fileName = "users.csv";

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + fileName;

        response.setContentType("text/csv");
        response.setHeader(headerKey, headerValue);

        //create a csv writer
        CSVWriter writer = new CSVWriter(response.getWriter());

        String[] header = new String[]{"datum", "opdracht", "overwerk", "verlof", "ziek", "training", "overig", "verklaring m.b.t. tot overig"};

        writer.writeNext(header);

        writer.close();

    }
}
