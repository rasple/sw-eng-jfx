package testing;

import static org.junit.Assert.*;

import model.Konfiguration;
import model.Produktdaten;
import org.junit.Ignore;
import org.junit.Test;

import model.Produktdaten_I;
import model.Konfiguration_I;

import java.util.HashMap;

public class ProduktdatenTest {

    @Test
    public void calcFpTest(){

        Konfiguration config = new Konfiguration();
        Produktdaten produktdaten = new Produktdaten("Test", "test", 1, 1, "EI");
        assertEquals(3, produktdaten.calcFp(config.getHashMapFunktion()));

        produktdaten.setType("EO");
        assertEquals(4, produktdaten.calcFp(config.getHashMapFunktion()));

        produktdaten.setType("EQ");
        assertEquals(3, produktdaten.calcFp(config.getHashMapFunktion()));

    }

    @Test
    public void isValidTest(){

        Produktdaten produktdaten = new Produktdaten("Test", "test", 1, 1, "EI");
        assertTrue(produktdaten.isValid());

        produktdaten = new Produktdaten();
        assertFalse(produktdaten.isValid());

        produktdaten = new Produktdaten();
        produktdaten.setRet(1);
        produktdaten.setDet(1);
        assertFalse(produktdaten.isValid());

        produktdaten = new Produktdaten();
        produktdaten.setType("EO");
        produktdaten.setRet(-1);
        produktdaten.setDet(0);
        assertFalse(produktdaten.isValid());

    }

}
