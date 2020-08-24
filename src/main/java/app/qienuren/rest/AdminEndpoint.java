package app.qienuren.rest;

import app.qienuren.controller.*;
import app.qienuren.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")

public class AdminEndpoint {

    // Alle Autowireds
    @Autowired
    AdminService adminService;
    @Autowired
    TraineeService traineeService;
    @Autowired
    InterneMedewerkerService interneMedewerkerService;
    @Autowired
    BedrijfService bedrijfService;
    @Autowired
    KlantContactPersoonService klantContactPersoonService;
    @Autowired
    PersoonService persoonService;
    @Autowired
    FormulierService formulierService;


    // Alle Post Mapping om nieuwe Entiteiten aan te maken

    @PostMapping("/trainee/nieuw")
    public Trainee newTrainee(@RequestBody Trainee trainee) {
        return traineeService.addTrainee(trainee);
    }
    @PostMapping("/internemedewerker/nieuw")
    public InterneMedewerker newInterneMedewerker(@RequestBody InterneMedewerker interneMedewerker) {
        return interneMedewerkerService.addInterneMederwerker(interneMedewerker);
    }
    @PostMapping("/bedrijf/nieuw")
    public Bedrijf newBedrijf(@RequestBody Bedrijf bedrijf) {
        return bedrijfService.addBedrijf(bedrijf);
    }
    @PostMapping("klantcontactpersoon/nieuw")
    public KlantContactPersoon newKlantContactPersoon(@RequestBody KlantContactPersoon klantContactPersoon) {
        return klantContactPersoonService.addKlantContactPersoon(klantContactPersoon);
    }

    // Alle Get Mapping om van een Entiteit alle data op te vragen

    @GetMapping("/trainee/all")
    public Iterable<Trainee> alleTrainees() {
        return traineeService.getAllTrainees();
    }
    @GetMapping("internemedewerker/all")
    public Iterable<InterneMedewerker> getAllInterneMederwerkers() {
        return interneMedewerkerService.getAllInterneMedewerkers();
    }
    @GetMapping("bedrijf/all")
    public Iterable<Bedrijf> getAllBedrijf() {
        return bedrijfService.getAllBedrijf();
    }

    @GetMapping("klantcontactpersoon/all")
    public Iterable<KlantContactPersoon> getAllKlantContactPersoon() {
        return klantContactPersoonService.getAllKlantContactPersoon();
    }
    @GetMapping("/medewerker/all")
    public Iterable<Persoon> getAllMedewerkers() {
        return persoonService.getAllMedewerkers();
    }

    @GetMapping("/formulieren/ingezonden")
    public Iterable<Formulier> alleFormulieren() {
        return formulierService.getAlleFormulierenVoorAdmin();
    }



    // Alle Put Mapping om van een Entiteit de data up te daten


   /* @PutMapping("/trainee/koppelbedrijf/{id}/{bedrijfid}")
    public void traineeToevoegenBedrijf(@PathVariable(value = "id") long traineeID, @PathVariable(value = "bedrijfid") long bedrijfID){
        bedrijfService.traineeToevoegenBedrijf(traineeID, bedrijfID);
    }*/

    @PutMapping("/klantcontactpersoon/koppelbedrijf/{id}/{bedrijfid}")
    public void klantContactPersoonToevoegenBedrijf(@PathVariable(value = "id") long kcpID, @PathVariable(value = "bedrijfid") long bedrijfID){
        bedrijfService.klantContactPersoonToevoegenBedrijf(kcpID, bedrijfID);
    }

    @PutMapping("/trainee/koppelContactPersoon/{id}/{bedrijfid}")
    public void traineeKoppelKlantContactPersoon(@PathVariable(value = "id") long traineeID, @PathVariable(value = "bedrijfid") long kcpID){
        traineeService.traineeKoppelContactPersoon(traineeID, kcpID);
    }
//    @PutMapping("/trainee/update/{id}")
//        public Trainee updateTrainee(@PathVariable(value = "id") long id, @RequestBody Trainee trainee) {
//        return traineeService.updateTrainee(id);
//    }

    // Endpoints voor goed- of afkeuren formulier door Admin
    @PutMapping("/update/statusgoed/{formulierid}/{medewerkerid}")
    public Formulier updateFormulierStatusGoed(@PathVariable(value = "formulierid")long formulierid, @PathVariable(value = "medewerkerid") long medewerkerid){
        return formulierService.AdminStatusGoed(formulierid, medewerkerid);
    }
    @PutMapping("/update/statusfout/{id}")
    public Formulier updateFormulierStatusFout(@PathVariable(value = "id")long id){
        return formulierService.AdminStatusFout(id);
    }

    //goedkeuren wijzigen gegevens trainee
    @PutMapping("/goedkeurengegevens/{oorspronkelijkeId}/{id}")
    public Trainee goedkeurenGegevensWijziging(@PathVariable(value = "oorspronkelijkeId")long oorspronkelijkeId, @PathVariable(value = "id") long id){
        return traineeService.wijzigGegevens(oorspronkelijkeId, id);
    }
}

