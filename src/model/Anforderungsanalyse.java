package model;

import java.util.ArrayList;
import java.util.List;
import nachkalkulation.*;
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

    private Anforderungsanalyse() {
        produktfunktionen = new ArrayList<Produktfunktion>();
        produktdaten = new ArrayList<Produktdaten>();
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
   
    public void selbstoptimierung(){
        this.sollfaktoren=this.optimieren.optimieren(this.fp.getIstfp(), this.fp.getSollfp, this.userfaktoren.getFaktoren());
    
    }

}
