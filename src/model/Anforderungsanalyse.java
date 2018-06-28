package model;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
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
    private Konfiguration_I config;

    private Anforderungsanalyse() {
        produktfunktionen = new ArrayList<Produktfunktion>();
        produktdaten = new ArrayList<Produktdaten>();
        zielbestimmung = new Zielbestimmung();
        produktumgebung = new Produktumgebung();
        produkteinsatz = new Produkteinsatz();
        faktoren = new Faktoren();
        fp= new FunctionPoints(new Konfiguration(), new DefaultOptimierung()); // Default immer der eigene Algo
        config= new Konfiguration();
    }



    public static Anforderungsanalyse getInstance() {
        if (anforderungsanalyse == null) {
            anforderungsanalyse = new Anforderungsanalyse();
        }
        return anforderungsanalyse;
    }
    /**
     *
     * @return -1 Produktfunktion ist invalid, -2 Produktdaten invalid
     */
    public double aufwandsabschaetzung(){
        int unbewertefp=0;
        Produktfunktion currentfkt;
        Produktdaten currentda;
        ListIterator<Produktfunktion> iteratorfkt= this.produktfunktionen.listIterator();
        while(iteratorfkt.hasNext()){
            currentfkt= iteratorfkt.next();
            if(currentfkt.isvalid()){
                unbewertefp+=currentfkt.calcFp(config.getHashMapFunktion());
            }
            else{
                return -1;
            }

        }
        ListIterator<Produktdaten>iteratorda=this.produktdaten.listIterator();
        while(iteratorda.hasNext()){
            currentda=iteratorda.next();
            if(currentda.isValid()){
                unbewertefp+=currentda.calcFP(config.getHashMapDaten());
            }
            else{
                return -2;
            }
        }
        System.out.println(unbewertefp);
        this.fp.setIstfp(this.faktoren.calcbewertetefp(unbewertefp));
        return fp.getCalcMannmonate();

    }
    //Um die Methode ausführen zu können, muss der user eingeben wie lange das Projekt wirklich gedauert hat und davor die
    // Aufwandsabschätzung durchgeführt haben
    public Faktoren selbstoptimierung(double mannmonate){
        this.aufwandsabschaetzung();
        this.sollfaktoren=fp.selbstoptimierung(mannmonate, userfaktoren.getFaktoren());
        return this.sollfaktoren;
    }
    //Diese Methode soll aufgerufen werden, wenn der User einer anderen
    //ALgo für die selbstoptimierte Nachkalkulation haben will
    public void setFpOpti(Fabrik_I fabrik){
        fp.setOpti(fabrik.create());
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

    public static void setAnforderungsanalyse(Anforderungsanalyse anforderungsanalyse) {
        Anforderungsanalyse.anforderungsanalyse = anforderungsanalyse;
    }
}
