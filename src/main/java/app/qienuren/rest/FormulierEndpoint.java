package app.qienuren.rest;

import app.qienuren.controller.FormulierService;
import app.qienuren.model.Formulier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/formulier")
public class FormulierEndpoint {

    @Autowired
    FormulierService formulierService;

    @PostMapping("/nieuw")
    public Formulier nieuwFormulier(@RequestBody Formulier formulier) {
        return formulierService.addNieuwFormulier(formulier);
    }
}
