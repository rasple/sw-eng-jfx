package testing;

import static org.junit.Assert.*;

import model.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static org.hamcrest.CoreMatchers.*;

public class AnforderungsanalyseTest {

    @Test
    public void aufwandsabschaetzungTest(){

        Anforderungsanalyse anforderungsanalyse = new Anforderungsanalyse();
        assertEquals( -3, anforderungsanalyse.aufwandsabschaetzung(), 0);

        Produktfunktion produktfunktion = new Produktfunktion();
        List<Produktfunktion> produktfunktionen = new ArrayList<Produktfunktion>();
        produktfunktionen.add(produktfunktion);
        anforderungsanalyse.setProduktfunktionen(produktfunktionen);
        assertEquals( -4, anforderungsanalyse.aufwandsabschaetzung(), 0);

        Produktdaten produktdaten = new Produktdaten();
        List<Produktdaten> produktdatens = new ArrayList<Produktdaten>();
        produktdatens.add(produktdaten);
        anforderungsanalyse.setProduktdaten(produktdatens);
        assertEquals(-1, anforderungsanalyse.aufwandsabschaetzung(), 0);

        produktfunktionen.remove(0);
        produktfunktion.setType("EI");
        produktfunktion.setDet(1);
        produktfunktion.setFtr(1);
        produktfunktionen.add(produktfunktion);
        anforderungsanalyse.setProduktfunktionen(produktfunktionen);
        assertEquals(-2, anforderungsanalyse.aufwandsabschaetzung(), 0);

        produktdatens.remove(0);
        produktdaten.setType("ILF");
        produktdaten.setDet(1);
        produktdaten.setRet(1);
        produktdatens.add(produktdaten);
        anforderungsanalyse.setProduktdaten(produktdatens);
        assertEquals(0, anforderungsanalyse.aufwandsabschaetzung(), 0);
    }

    @Test
    public void selbstoptimierungTest(){

        Anforderungsanalyse anforderungsanalyse = new Anforderungsanalyse();

        try {
            anforderungsanalyse.selbstoptimierung(0);
            throw new AssertionError("No Exception thrown");
        } catch(Exception e) {
            assertEquals(e.getClass(), model.SelbstoptiException.class);
            assertEquals("Produktfunktionen nicht vorhanden", e.getMessage());
        }

        Produktfunktion produktfunktion = new Produktfunktion();
        List<Produktfunktion> produktfunktionen = new ArrayList<Produktfunktion>();
        produktfunktionen.add(produktfunktion);
        anforderungsanalyse.setProduktfunktionen(produktfunktionen);

        try {
            anforderungsanalyse.selbstoptimierung(0);
            throw new AssertionError("No Exception thrown");
        } catch(Exception e) {
            assertEquals(e.getClass(), model.SelbstoptiException.class);
            assertEquals("Produktdaten nicht vorhanden", e.getMessage());
        }

        Produktdaten produktdaten = new Produktdaten();
        List<Produktdaten> produktdatens = new ArrayList<Produktdaten>();
        produktdatens.add(produktdaten);
        anforderungsanalyse.setProduktdaten(produktdatens);

        try {
            anforderungsanalyse.selbstoptimierung(0);
            throw new AssertionError("No Exception thrown");
        } catch(Exception e) {
            assertEquals(e.getClass(), model.SelbstoptiException.class);
            assertEquals("Produktfunktionen nicht vollständig", e.getMessage());
        }

        produktfunktionen.remove(0);
        produktfunktion.setType("EI");
        produktfunktion.setDet(1);
        produktfunktion.setFtr(1);
        produktfunktionen.add(produktfunktion);
        anforderungsanalyse.setProduktfunktionen(produktfunktionen);

        try {
            anforderungsanalyse.selbstoptimierung(0);
            throw new AssertionError("No Exception thrown");
        } catch(Exception e) {
            assertEquals(e.getClass(), model.SelbstoptiException.class);
            assertEquals("Produktdaten nicht vollständig", e.getMessage());
        }

        produktdatens.remove(0);
        produktdaten.setType("ILF");
        produktdaten.setDet(1);
        produktdaten.setRet(1);
        produktdatens.add(produktdaten);
        anforderungsanalyse.setProduktdaten(produktdatens);

        double[] faktoren;

        try{
            faktoren = anforderungsanalyse.selbstoptimierung(0).getFaktoren();
            for(double faktor : faktoren){
                assertEquals(0, faktor, 0);
            }
        } catch(Exception e) {
            throw new AssertionError("Unexpected Exception thrown");
        }

    }

}
