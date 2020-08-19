package app.qienuren.controller;

import app.qienuren.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MedewerkerService {

    @Autowired
    TraineeService ts;

    @Autowired
    InterneMedewerkerService ims;

    @Autowired
    TijdelijkFormulierService tfs;

    @Autowired
    TraineeRepository traineeRepository;

    private List<Medewerker> medewerkers;
    private List<Trainee> trainees;
    private List<InterneMedewerker> interneMedewerkers;

    // lijst met medewerkers

    public ArrayList<Medewerker> voegTraineesEnInterneMedewerkersSamen() {
        medewerkers = new ArrayList<>();
        trainees = (List)ts.getAllTrainees();
        interneMedewerkers = (List)ims.getAllInterneMedewerkers();

        for (Trainee t : trainees) {
            medewerkers.add(t);
        }
        for (InterneMedewerker i : interneMedewerkers) {
            if (!(i.getType() == MedewerkerType.Admin)) {
                medewerkers.add(i);
            }
        }

        return (ArrayList<Medewerker>)medewerkers;
    }

    // loop over medewerkers en geef ze een leeg formulier

    public void genereerLeegFormulier() {
        ArrayList<Medewerker> deMedewerkers = voegTraineesEnInterneMedewerkersSamen();
        for (Medewerker m : deMedewerkers) {
            m.voegTijdelijkFormulierToe(tfs.addNieuwTijdelijkFormulier(new TijdelijkFormulier(LocalDate.now().getMonthValue(), LocalDate.now().getYear())));
        }
    }

    @Scheduled(cron = "0 0 0 1 1/1 ? *")
    public void maakMaandelijksFormulier() {

        long now = System.currentTimeMillis() / 1000;
        System.out.println(
                "schedule tasks using cron jobs - " + now);
    }

}
