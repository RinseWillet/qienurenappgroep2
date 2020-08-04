package app.qienuren.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Formulier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long jaar;
    private long maand;

    @ManyToOne
    private Persoon medewerker;
    private boolean goedKeuringKlant;
    private boolean goedkeuringAdmin;

    @OneToMany
    private List<WerkDag> werkDagen = new ArrayList<>();


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

    public long getJaar() {
        return jaar;
    }

    public void setJaar(long jaar) {
        this.jaar = jaar;
    }

    public long getMaand() {
        return maand;
    }

    public void setMaand(long maand) {
        this.maand = maand;
    }

    public List<WerkDag> getWerkDagen() {
        return werkDagen;
    }

    public void setWerkDagen(List<WerkDag> werkDagen) {
        this.werkDagen = werkDagen;
    }
}
