package app.qienuren.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class KlantContactPersoon extends Persoon{

    @ManyToOne
    private Bedrijf bedrijf;

    //Een Contactpersoon kan meerdere trainees onder zich hebben
    @OneToMany(cascade = CascadeType.ALL)
    private List<Trainee> trainees = new ArrayList<>();

    @JsonIgnore
    public Bedrijf getCompany() {
        return bedrijf;
    }

    public void setCompany(Bedrijf bedrijf) {
        this.bedrijf = bedrijf;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(List<Trainee> trainees) {
        this.trainees = trainees;
    }

    public void koppelBedrijf(Bedrijf bedrijf) {
        this.bedrijf = bedrijf;
    }

    public void koppelTrainee(Trainee trainee) {
        this.trainees.add(trainee);
    }
}
