package app.qienuren.model;

import javax.persistence.*;

@Entity
public class KlantContactPersoon extends Persoon{

    @ManyToOne
    private Bedrijf company;

    public Bedrijf getCompany() {
        return company;
    }

    public void setCompany(Bedrijf company) {
        this.company = company;
    }
}
