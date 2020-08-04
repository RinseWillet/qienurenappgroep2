package app.qienuren.model;

import java.time.LocalDate;


public class WerkDag {

    private LocalDate datum;
    private double opdrachtUren;
    private double overwerkUren;
    private double verlofUren;
    private double ziekteUren;
    private double trainingsUren;
    private double overigeUren;
    private String overigeUrenUitleg;

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
}
