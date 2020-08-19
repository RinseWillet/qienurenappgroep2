package app.qienuren.controller;

import app.qienuren.model.InterneMedewerker;
import app.qienuren.model.Medewerker;
import app.qienuren.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MedewerkerService {

    @Autowired
    TraineeService ts;

    @Autowired
    InterneMedewerkerService ims = new InterneMedewerkerService();

    @Autowired
    TraineeRepository traineeRepository;

    private Iterable<Medewerker> medewerkers;
    private Iterable<Trainee> trainees;
    private Iterable<InterneMedewerker> interneMedewerkers;

    public void voegTraineesEnInterneMedewerkersSamen() {
        System.out.println("hoi");
        trainees = ts.getAllTrainees();
        interneMedewerkers = ims.getAllInterneMedewerkers();
        System.out.println(trainees);
        System.out.println(interneMedewerkers);
    }

    @Scheduled(cron = "0 0 0 1 1/1 ? *")
    public void maakMaandelijksFormulier() {

        long now = System.currentTimeMillis() / 1000;
        System.out.println(
                "schedule tasks using cron jobs - " + now);
    }

}
