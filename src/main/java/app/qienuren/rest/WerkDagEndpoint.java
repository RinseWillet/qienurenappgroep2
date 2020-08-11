package app.qienuren.rest;

import app.qienuren.controller.WerkDagService;
import app.qienuren.model.WerkDag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/werkdag")
public class WerkDagEndpoint {

    @Autowired
    WerkDagService werkdagservice;

    @PostMapping("/nieuw")
    public WerkDag nieuwWerkDag(@RequestBody WerkDag werkdag) {
        return werkdagservice.addNieuwWerkDag(werkdag);
    }

    @GetMapping("/all")
    public Iterable<WerkDag> alleWerkDagen(){
        return werkdagservice.alleWerkDagen();
    }

    @DeleteMapping("/verwijder")
    public void removeWerkDagen(){
        werkdagservice.removeWerkDagen();
    }

}
