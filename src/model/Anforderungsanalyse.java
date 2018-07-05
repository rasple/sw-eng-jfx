package model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;


// Singleton
public class Anforderungsanalyse implements Serializable, Cloneable, Anforderungsanalyse_I {

    private static Anforderungsanalyse anforderungsanalyse;
    private List<Produktfunktion> produktfunktionen;
    private List<Produktdaten> produktdaten;
    private Faktoren userfaktoren;
    private Faktoren sollFaktoren;
    private FunctionPoints functionPoints;
    private Zielbestimmung zielbestimmung;
    private Produktumgebung produktumgebung;
    private Produkteinsatz produkteinsatz;
    private Faktoren faktoren;
    private Konfiguration_I config;
    private List<Optimieren_I> nachkal; //Liste für die Algorithmen der Nachkalkulation


    public static Anforderungsanalyse clone(Anforderungsanalyse anfOld) {
        Anforderungsanalyse anfNew = new Anforderungsanalyse();
        anfNew.setProduktfunktionen(new ArrayList<Produktfunktion>(anfOld.produktfunktionen));
        anfNew.setProduktdaten(new ArrayList<Produktdaten>(anfOld.produktdaten));
        anfNew.setUserfaktoren(new Faktoren(anfOld.userfaktoren));
        anfNew.setSollFaktoren(new Faktoren(anfOld.sollFaktoren));
        anfNew.setFunctionPoints(new FunctionPoints(new Konfiguration(), new DefaultFabrik().create()));
        anfNew.setZielbestimmung(new Zielbestimmung(anfOld.zielbestimmung));
        anfNew.setProduktumgebung(new Produktumgebung(anfOld.produktumgebung));
        anfNew.setProdukteinsatz(new Produkteinsatz(anfOld.produkteinsatz));
        anfNew.setFaktoren(new Faktoren(anfOld.faktoren));
        anfNew.setConfig(new Konfiguration());
        anfNew.setNachkal(new ArrayList<Optimieren_I>(anfOld.nachkal));
        return anfNew;
    }

    // Wichtig für Serialisierung von Singleton fürs Speichern
    public Anforderungsanalyse getCopyOfCurrentAnforderungsanalyse() {
        try {
            return (Anforderungsanalyse) anforderungsanalyse.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Anforderungsanalyse.class.getName()).log(Level.SEVERE, "", ex);
            return null;
        }
    }

    public void resetAnforderungsanalyse() {
        anforderungsanalyse = null;
    }

    public Anforderungsanalyse() {
        produktfunktionen = new ArrayList<Produktfunktion>();
        produktdaten = new ArrayList<Produktdaten>();
        zielbestimmung = new Zielbestimmung();
        produktumgebung = new Produktumgebung();
        produkteinsatz = new Produkteinsatz();
        faktoren = new Faktoren();
        functionPoints = new FunctionPoints(new Konfiguration(), new DefaultFabrik().create()); // Default immer der eigene Algo
        config= new Konfiguration();
        nachkal=new ArrayList<>();
        nachkal.add(new DefaultFabrik().create()); //An dieser Stelle können weiter Algorithmen hinzugefügt werden
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
            if (currentFkt.isValid()) {
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
                unbewerteFP += currentDa.calcFp(config.getHashMapDaten());
            }
            else{
                return -2;
            }
        }
        this.functionPoints.setIstfp(this.faktoren.calcbewertetefp(unbewerteFP));
        return functionPoints.getCalcMannmonate();
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
        this.sollFaktoren = functionPoints.selbstoptimierung(mannmonate, faktoren.getFaktoren());
        return this.sollFaktoren;
    }

    //Diese Methode soll aufgerufen werden, wenn der User einer anderen
    //ALgo für die selbstoptimierte Nachkalkulation haben will. Es kann ein Algo aus der Liste ausgewählt werden
    public void setFpOpti(int position) {
        functionPoints.setOpti(this.nachkal.get(position));
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

    public Faktoren getSollFaktoren() {
        return sollFaktoren;
    }

    public Faktoren getUserfaktoren() {
        return userfaktoren;
    }

    public void setSollFaktoren(Faktoren sollFaktoren) {
        this.sollFaktoren = sollFaktoren;
    }

    public FunctionPoints getFunctionPoints() {
        return functionPoints;
    }

    public void setFunctionPoints(FunctionPoints functionPoints) {
        this.functionPoints = functionPoints;
    }

    public static void setAnforderungsanalyse(Anforderungsanalyse anforderungsanalyse) {
        Anforderungsanalyse.anforderungsanalyse = anforderungsanalyse;
    }

    public Konfiguration_I getConfig() {
        return config;
    }

    public void setConfig(Konfiguration_I config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return "Anforderungsanalyse{" +
                "produktfunktionen=" + produktfunktionen +
                ", produktdaten=" + produktdaten +
                ", userfaktoren=" + userfaktoren +
                ", sollFaktoren=" + sollFaktoren +
                ", functionPoints=" + functionPoints +
                ", zielbestimmung=" + zielbestimmung +
                ", produktumgebung=" + produktumgebung +
                ", produkteinsatz=" + produkteinsatz +
                ", faktoren=" + faktoren +
                ", config=" + config +
                '}';
    }

    public void setUserfaktoren(Faktoren userfaktoren) {
        this.userfaktoren = userfaktoren;
    }

    public void setNachkal(List<Optimieren_I> nachkal){
        this.nachkal=nachkal;
    }

    public List<Optimieren_I> getNachkal() {
        return this.nachkal;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj instanceof Anforderungsanalyse) {
            Anforderungsanalyse other = (Anforderungsanalyse) obj;

            if(!this.produktfunktionen.equals(other.produktfunktionen)) {return false;}
            if(!this.produktdaten.equals(other.produktdaten)) {return false;}
            if(!this.userfaktoren.equals(other.userfaktoren)) {return false;}
            if(!this.sollFaktoren.equals(other.sollFaktoren)) {return false;}
            if(!this.functionPoints.equals(other.functionPoints)) {return false;}
            if(!this.zielbestimmung.equals(other.zielbestimmung)) {return false;}
            if(!this.produktumgebung.equals(other.produktumgebung)) {return false;}
            if(!this.produkteinsatz.equals(other.produkteinsatz)) {return false;}
            if(!this.faktoren.equals(other.faktoren)) {return false;}
            if(!this.config.equals(other.config)) {return false;}
            if(!this.nachkal.equals(other.nachkal)) {return false;}


            return true;
        }
        return false;
    }

}
