package app.qienuren.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Formulier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Persoon medewerker;
    private boolean goedKeuringKlant;
    private boolean goedkeuringAdmin;

    @OneToMany
    private List<WerkDag> werkDagen;


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
}
