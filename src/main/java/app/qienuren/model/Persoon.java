package app.qienuren.model;

import javax.persistence.*;

@Entity
public class Persoon  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String naam;
    private String email;
    private String telefoonnr;

    private String userName;// = email;
    private String password;

    private String roles; //later aanpassen enum(?)
    private boolean active;

    public String getPassword() {
        return password;
    }

    public void setPassword(String wachtwoord) {
        this.password = wachtwoord;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        this.userName = email;
    }

    public String getTelefoonnr() {
        return telefoonnr;
    }

    public void setTelefoonnr(String telefoonnr) {
        this.telefoonnr = telefoonnr;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }



    public String getUserName() {
        return userName;
    }

//    public void setUserName(String userName) {
//        this.userName = this.getEmail();
//          }


//    public String getGebruikersNaam() {
//        return gebruikersNaam;
//    }
//
//    public void setGebruikersNaam(String gebruikersNaam) {
//        this.gebruikersNaam = gebruikersNaam;
//    }

}
