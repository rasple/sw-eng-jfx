package model;

import java.util.ArrayList;
import java.util.List;
// Singleton
public class Anforderungsanalyse {
    
    // Kein Interface arghh. Dein Ernst
    private List<Produktfunktion> produktfunktionen;
    private List<Produktdaten> produktdaten;
    private Faktoren userfaktoren;
    private Faktoren sollfaktoren;
    private Optimieren_I optimieren;
    private FunctionPoints fp;
    private static Anforderungsanalyse anforderungsanalyse;
    private Zielbestimmung zielbestimmung;
    private Produktumgebung produktumgebung;
    private Produkteinsatz produkteinsatz;
    private Faktoren faktoren;

    private Anforderungsanalyse() {
        produktfunktionen = new ArrayList<Produktfunktion>();
        produktdaten = new ArrayList<Produktdaten>();
        zielbestimmung = new Zielbestimmung();
        produktumgebung = new Produktumgebung();
        produkteinsatz = new Produkteinsatz();
        faktoren = new Faktoren();
    }



    public static Anforderungsanalyse getInstance() {
        if (anforderungsanalyse == null) {
            anforderungsanalyse = new Anforderungsanalyse();
        }
        return anforderungsanalyse;
    }

    public List<Produktfunktion> getProduktfunktionen() {
        return produktfunktionen;
    }
    public void setProduktfunktionen(List<Produktfunktion> produktfunktionen) {
        this.produktfunktionen = produktfunktionen;
    }

    public List<Produktdaten> getProduktdaten() {
        return produktdaten;
    }

    public void setProduktdaten(List<Produktdaten> produktdaten) {
        this.produktdaten = produktdaten;
    }
    
    //Um die Methode ausführen zu können, muss der user eingeben wie lange das Projekt wirklich gedauert hat und davor die 
    // Aufwandsabschätzung durchgeführt haben
    public void selbstoptimierung(double mannmonate){
        fp.setMannmonate(mannmonate);
        this.sollfaktoren = this.optimieren.optimieren(this.fp.getIstfp(), this.fp.getSollfp(), this.userfaktoren.getFaktoren());
    
    }

    public Produkteinsatz getProdukteinsatz() {
        return produkteinsatz;
    }

    public void setProdukteinsatz(Produkteinsatz produkteinsatz) {
        this.produkteinsatz = produkteinsatz;
    }

    public Produktumgebung getProduktumgebung() {
        return produktumgebung;
    }

    public void setProduktumgebung(Produktumgebung produktumgebung) {
        this.produktumgebung = produktumgebung;
    }

    public Zielbestimmung getZielbestimmung() {
        return zielbestimmung;
    }

    public void setZielbestimmung(Zielbestimmung zielbestimmung) {
        this.zielbestimmung = zielbestimmung;
    }

    public Faktoren getFaktoren() {
        return faktoren;
    }

    public void setFaktoren(Faktoren faktoren) {
        this.faktoren = faktoren;
    }
}
