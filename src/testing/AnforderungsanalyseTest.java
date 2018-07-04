package testing;

import static org.junit.Assert.*;

import model.Produktdaten;
import org.junit.Ignore;
import org.junit.Test;
import model.Anforderungsanalyse_I;
import model.Anforderungsanalyse;
import model.Produktfunktion;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;

public class AnforderungsanalyseTest {

    @Test
    public void aufwandsabschaetzungTest(){

        Anforderungsanalyse afaly = new Anforderungsanalyse();
        assertEquals( -3, afaly.aufwandsabschaetzung(), 0);

        Produktfunktion produktfunktion = new Produktfunktion();
        List<Produktfunktion> produktfunktionen = new ArrayList<Produktfunktion>();
        produktfunktionen.add(produktfunktion);
        afaly.setProduktfunktionen(produktfunktionen);
        assertEquals( -4, afaly.aufwandsabschaetzung(), 0);

        Produktdaten produktdaten = new Produktdaten();
        List<Produktdaten> produktdatens = new ArrayList<Produktdaten>();
        produktdatens.add(produktdaten);
        afaly.setProduktdaten(produktdatens);
        assertEquals(-1, afaly.aufwandsabschaetzung(), 0);

    }



}
