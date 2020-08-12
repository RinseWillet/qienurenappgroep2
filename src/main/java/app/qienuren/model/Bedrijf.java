package app.qienuren.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bedrijf {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private KlantContactPersoon contactPersoon;
    private String naam;
    private String NAWgegevens;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Trainee> trainees = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonIgnore
    public KlantContactPersoon getContactPersoon() {
        return contactPersoon;
    }

    public void setContactPersoon(KlantContactPersoon contactPersoon) {
        this.contactPersoon = contactPersoon;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNAWgegevens() {
        return NAWgegevens;
    }

    public void setNAWgegevens(String NAWgegevens) {
        this.NAWgegevens = NAWgegevens;
    }

    @JsonIgnore
    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(List<Trainee> trainees) {
        this.trainees = trainees;
    }

    public void koppelTrainee (Trainee trainee) {
        this.trainees.add(trainee);
    }

    public void koppelContactPersoon(KlantContactPersoon klantContactPersoon) {
        this.contactPersoon = klantContactPersoon;
    }
}
