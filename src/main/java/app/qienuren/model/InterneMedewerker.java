package app.qienuren.model;

import javax.persistence.Entity;

@Entity
public class InterneMedewerker extends Medewerker{

    private MedewerkerType type = MedewerkerType.InterneMedewerker;


    public MedewerkerType getType() {
        return type;
    }

    public void setType(MedewerkerType type) {
        this.type = type;
    }

    public InterneMedewerker() {
        this.setRoles("ROLE_INTERNEMEDEWERKER");
    }

}
