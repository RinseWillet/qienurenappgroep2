package app.qienuren.model;

import javax.persistence.*;

@Entity
public class Trainee extends Medewerker {

    @OneToOne
    private Bedrijf opdrachtgever;
    @ManyToOne
    private KlantContactPersoon leidingGevende;

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
}
