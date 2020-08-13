package app.qienuren.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bedrijf {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private long id;
    @OneToOne
    @Getter @Setter
    private KlantContactPersoon contactPersoon;
    @Getter @Setter
    private String naam;
    @Getter @Setter
    private String emailadres;
    @Getter @Setter
    private String telefoonnr;
    @Getter @Setter
    private String straatNaamNr;
    @Getter @Setter
    private String postcode;
    @Getter @Setter
    private String woonplaats;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Trainee> trainees = new ArrayList<>();


    @JsonIgnore
    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void koppelTrainee (Trainee trainee) {
        this.trainees.add(trainee);
    }

    public void koppelContactPersoon(KlantContactPersoon klantContactPersoon) {
        this.contactPersoon = klantContactPersoon;
    }
}
