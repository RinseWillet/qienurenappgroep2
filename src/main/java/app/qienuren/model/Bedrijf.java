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
    private String emailadres;
    private String telefoonnr;
    private String straatNaamNr;
    private String postcode;
    private String woonplaats;


    @OneToMany(cascade = CascadeType.ALL)
    //@JsonManagedReference(value="opdrachtgever")
    private List<Trainee> trainees = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getEmailadres() {
        return emailadres;
    }

    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }

    public String getTelefoonnr() {
        return telefoonnr;
    }

    public void setTelefoonnr(String telefoonnr) {
        this.telefoonnr = telefoonnr;
    }

    public String getStraatNaamNr() {
        return straatNaamNr;
    }

    public void setStraatNaamNr(String straatNaamNr) {
        this.straatNaamNr = straatNaamNr;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

//    public String getNAWgegevens() {
//        return NAWgegevens;
//    }
//
//    public void setNAWgegevens(String NAWgegevens) {
//        this.NAWgegevens = NAWgegevens;
//    }

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