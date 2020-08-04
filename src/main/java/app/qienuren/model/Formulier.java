package app.qienuren.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Formulier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Persoon medewerker;
    private LocalDate datum;
    private double opdrachtUren;
    private double overwerkUren;
    private double verlofUren;
    private double ziekteUren;
    private double trainingsUren;
    private double overigeUren;
    private String overigeUrenUitleg;
    private boolean goedKeuringKlant;
    private boolean goedkeuringAdmin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Persoon getMedewerker() {
        return medewerker;
    }

    public void setMedewerker(Persoon medewerker) {
        this.medewerker = medewerker;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public double getOpdrachtUren() {
        return opdrachtUren;
    }

    public void setOpdrachtUren(double opdrachtUren) {
        this.opdrachtUren = opdrachtUren;
    }

    public double getOverwerkUren() {
        return overwerkUren;
    }

    public void setOverwerkUren(double overwerkUren) {
        this.overwerkUren = overwerkUren;
    }

    public double getVerlofUren() {
        return verlofUren;
    }

    public void setVerlofUren(double verlofUren) {
        this.verlofUren = verlofUren;
    }

    public double getZiekteUren() {
        return ziekteUren;
    }

    public void setZiekteUren(double ziekteUren) {
        this.ziekteUren = ziekteUren;
    }

    public double getTrainingsUren() {
        return trainingsUren;
    }

    public void setTrainingsUren(double trainingsUren) {
        this.trainingsUren = trainingsUren;
    }

    public double getOverigeUren() {
        return overigeUren;
    }

    public void setOverigeUren(double overigeUren) {
        this.overigeUren = overigeUren;
    }

    public String getOverigeUrenUitleg() {
        return overigeUrenUitleg;
    }

    public void setOverigeUrenUitleg(String overigeUrenUitleg) {
        this.overigeUrenUitleg = overigeUrenUitleg;
    }

    public boolean isGoedKeuringKlant() {
        return goedKeuringKlant;
    }

    public void setGoedKeuringKlant(boolean goedKeuringKlant) {
        this.goedKeuringKlant = goedKeuringKlant;
    }

    public boolean isGoedkeuringAdmin() {
        return goedkeuringAdmin;
    }

    public void setGoedkeuringAdmin(boolean goedkeuringAdmin) {
        this.goedkeuringAdmin = goedkeuringAdmin;
    }
}
