package model;

import java.util.ArrayList;
import java.util.List;

// Singleton
public class Anforderungsanalyse {

    private List<Produktfunktion> produktfunktionen;

    private static Anforderungsanalyse anforderungsanalyse;

    private Anforderungsanalyse() {
        produktfunktionen = new ArrayList<Produktfunktion>();
    }

    public List<Produktfunktion> getProduktfunktionen() {
        return produktfunktionen;
    }

    public static Anforderungsanalyse getInstance() {
        if (anforderungsanalyse == null) {
            anforderungsanalyse = new Anforderungsanalyse();
        }
        return anforderungsanalyse;
    }

    public void setProduktfunktionen(List<Produktfunktion> produktfunktionen) {
        this.produktfunktionen = produktfunktionen;
    }
}
