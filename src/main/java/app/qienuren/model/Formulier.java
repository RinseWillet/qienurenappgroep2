package app.qienuren.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Formulier {

    //fields

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private long maand;
    private long jaar;

    @ManyToOne
    private Persoon medewerker;
    private AdminStatus adminStatus = AdminStatus.OPEN;
    private OpdrachtgeverStatus opdrachtgeverStatus = OpdrachtgeverStatus.OPEN;

    @OneToMany(cascade = CascadeType.ALL)
    private List<WerkDag> werkDagen = new ArrayList<>();


    //methodes

    public AdminStatus getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(AdminStatus adminStatus) {
        this.adminStatus = adminStatus;
    }

    public OpdrachtgeverStatus getOpdrachtgeverStatus() {
        return opdrachtgeverStatus;
    }

    public void setOpdrachtgeverStatus(OpdrachtgeverStatus opdrachtgeverStatus) {
        this.opdrachtgeverStatus = opdrachtgeverStatus;
    }

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

