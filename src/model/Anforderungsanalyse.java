package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
// Singleton
public class Anforderungsanalyse implements Serializable {

    // Kein Interface arghh. Dein Ernst
    private static Anforderungsanalyse anforderungsanalyse;
    private List<Produktfunktion> produktfunktionen;
    private List<Produktdaten> produktdaten;
    private Faktoren userfaktoren;
    private Faktoren sollfaktoren;
    private Optimieren_I optimieren;
    private FunctionPoints fp;
    private Zielbestimmung zielbestimmung;
    private Produktumgebung produktumgebung;
    private Produkteinsatz produkteinsatz;
    private Faktoren faktoren;
    private Konfiguration_I config;
    private List<Fabrik_I> nachkalfabrik; //Liste für Fabriken für die Algo der Nachkalkulation

    private Anforderungsanalyse() {
        produktfunktionen = new ArrayList<Produktfunktion>();
        produktdaten = new ArrayList<Produktdaten>();
        zielbestimmung = new Zielbestimmung();
        produktumgebung = new Produktumgebung();
        produkteinsatz = new Produkteinsatz();
        faktoren = new Faktoren();
        fp= new FunctionPoints(new Konfiguration(), new DefaultOptimierung()); // Default immer der eigene Algo
        config= new Konfiguration();
        nachkalfabrik= new ArrayList<>();
        nachkalfabrik.add(new DefaultFabrik());
    }



    public static Anforderungsanalyse getInstance() {
        if (anforderungsanalyse == null) {
            anforderungsanalyse = new Anforderungsanalyse();
        }
        return anforderungsanalyse;
    }
    /**
     *
     * @return -1 Produktfunktion ist invalid, -2 Produktdaten invalid, -3 Produktfunktionen nicht vorhanden, -4 Produktdaten nicht vorhanden
     */
    public double aufwandsabschaetzung(){
        int unbewerteFP = 0;
        Produktfunktion currentFkt;
        Produktdaten currentDa;
        ListIterator<Produktfunktion> iteratorFkt = this.produktfunktionen.listIterator();
        if(this.produktfunktionen.isEmpty()){
            return -3;
        }
        if(this.produktdaten.isEmpty()){
            return -4;
        }
        while (iteratorFkt.hasNext()) {
            currentFkt = iteratorFkt.next();
            if (currentFkt.isvalid()) {
                unbewerteFP += currentFkt.calcFp(config.getHashMapFunktion());
            }
            else{
                return -1;
            }

        }
        ListIterator<Produktdaten>iteratorda=this.produktdaten.listIterator();
        while(iteratorda.hasNext()){
            currentDa = iteratorda.next();
            if (currentDa.isValid()) {
                unbewerteFP += currentDa.calcFP(config.getHashMapDaten());
            }
            else{
                return -2;
            }
        }
        System.out.println(unbewerteFP);
        this.fp.setIstfp(this.faktoren.calcbewertetefp(unbewerteFP));
        return fp.getCalcMannmonate();

    }
    //Um die Methode ausführen zu können, muss der user eingeben wie lange das Projekt wirklich gedauert hat und davor die
    // Aufwandsabschätzung durchgeführt haben
    public Faktoren selbstoptimierung(double mannmonate) throws SelbstoptiException{
        Double result=this.aufwandsabschaetzung();
        switch (result.intValue()){
            case -1: throw new SelbstoptiException("Produktfunktionen nicht vollständig", -1);
            case -2: throw new SelbstoptiException("Produktdaten nicht vollständig",-2);
            case -3: throw new SelbstoptiException("Produktfunktionen nicht vorhanden",-3);
            case -4: throw new SelbstoptiException("Produktdaten nicht vorhanden",-4);
        }
        this.sollfaktoren=fp.selbstoptimierung(mannmonate, faktoren.getFaktoren());
        return this.sollfaktoren;
    }
    //Diese Methode soll aufgerufen werden, wenn der User einer anderen
    //ALgo für die selbstoptimierte Nachkalkulation haben will. Es kann ein Algo aus der Liste ausgewählt werden
    public void setFpOpti(int pos){
        fp.setOpti(this.nachkalfabrik.get(pos).create());
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

    @Override
    public String toString() {
        return "Anforderungsanalyse{" +
                "produktfunktionen=" + produktfunktionen +
                ", produktdaten=" + produktdaten +
                ", userfaktoren=" + userfaktoren +
                ", sollfaktoren=" + sollfaktoren +
                ", optimieren=" + optimieren +
                ", fp=" + fp +
                ", zielbestimmung=" + zielbestimmung +
                ", produktumgebung=" + produktumgebung +
                ", produkteinsatz=" + produkteinsatz +
                ", faktoren=" + faktoren +
                ", config=" + config +
                '}';
    }
}
