package app.qienuren.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Trainee extends Medewerker {

    private MedewerkerType type = MedewerkerType.Trainee;

    @ManyToOne(cascade = CascadeType.ALL)
    //@JsonBackReference (value="opdrachtgever")
    @JoinColumn(name = "bedrijf_id")
    private Bedrijf opdrachtgever;


    @ManyToOne
    @JsonBackReference(value = "KCP")
    @JoinColumn(name = "KCP_id")
    private KlantContactPersoon leidingGevende;

    public Trainee() {
        this.setRoles("ROLE_TRAINEE");
        this.setActive(true);
    }

    public Bedrijf getOpdrachtgever() {
        return opdrachtgever;
    }

    public void setOpdrachtgever(Bedrijf opdrachtgever) {
        this.opdrachtgever = opdrachtgever;
    }

    public KlantContactPersoon getLeidingGevende() {
        return leidingGevende;
    }

    public void setLeidingGevende(KlantContactPersoon leidingGevende) {
        this.leidingGevende = leidingGevende;
    }

    public void koppelBedrijf(Bedrijf bedrijf) {
        this.opdrachtgever = bedrijf;
    }

    public void koppelKlantContactPersoon(KlantContactPersoon kcp) {
        this.leidingGevende = kcp;
    }

    public MedewerkerType getType() {
        return type;
    }

    public void setType(MedewerkerType type) {
        this.type = type;
    }

}