package app.qienuren.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Medewerker extends Persoon {

    private String straatNaamNr;
    private String postcode;
    private String woonplaats;
    private LocalDate startDatum;
    private LocalDate eindDatum;
    @OneToMany
    private List<Formulier> archief;

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

    public LocalDate getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(LocalDate startDatum) {
        this.startDatum = startDatum;
    }

    public LocalDate getEindDatum() {
        return eindDatum;
    }

    public void setEindDatum(LocalDate eindDatum) {
        this.eindDatum = eindDatum;
    }

    public List<Formulier> getArchief() {
        return archief;
    }

    public void setArchief(List<Formulier> archief) {
        this.archief = archief;
    }
}
