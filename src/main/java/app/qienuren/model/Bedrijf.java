package app.qienuren.model;

import javax.persistence.*;

@Entity
public class Bedrijf {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private KlantContactPersoon contactPersoon;
    private String naam;
    private String NAWgegevens;

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

    public String getNAWgegevens() {
        return NAWgegevens;
    }

    public void setNAWgegevens(String NAWgegevens) {
        this.NAWgegevens = NAWgegevens;
    }
}
