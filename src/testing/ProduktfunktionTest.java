package testing;


import static org.junit.Assert.*;

import model.Konfiguration;
import org.junit.Ignore;
import org.junit.Test;

import model.Produktfunktion_I;
import model.Produktfunktion;
import model.Konfiguration_I;

import java.util.HashMap;

public class ProduktfunktionTest {

    @Test
    public void calcFpTest(){

        Konfiguration config = new Konfiguration();
        Produktfunktion produktfunktion = new Produktfunktion("Test", "test", 0, 0, "EI");
        assertEquals(3, produktfunktion.calcFp(config.getHashMapFunktion()));

        produktfunktion.setType("EO");
        assertEquals(4, produktfunktion.calcFp(config.getHashMapFunktion()));

        produktfunktion.setType("EQ");
        assertEquals(3, produktfunktion.calcFp(config.getHashMapFunktion()));

    }

    @Test
    public void isValidTest(){

        Produktfunktion produktdaten = new Produktfunktion("Test", "test", 0, 1, "EO");
        assertTrue(produktdaten.isValid());

        produktdaten = new Produktfunktion();
        assertFalse(produktdaten.isValid());

        produktdaten = new Produktfunktion();
        produktdaten.setFtr(0);
        produktdaten.setDet(1);
        assertFalse(produktdaten.isValid());

        produktdaten = new Produktfunktion();
        produktdaten.setType("EIF");
        produktdaten.setFtr(-1);
        produktdaten.setDet(0);
        assertFalse(produktdaten.isValid());

    }

}
