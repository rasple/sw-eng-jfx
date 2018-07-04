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
        Produktdaten produktdaten = new Produktdaten("Test", "test", 1, 1, "ILF");
        assertEquals(7, produktdaten.calcFp(config.getHashMapDaten()));

        produktdaten.setType("EIF");
        assertEquals(5, produktdaten.calcFp(config.getHashMapDaten()));

    }

    @Test
    public void isValidTest(){

        Produktdaten produktdaten = new Produktdaten("Test", "test", 1, 1, "ILF");
        assertTrue(produktdaten.isValid());

        produktdaten = new Produktdaten();
        assertFalse(produktdaten.isValid());

        produktdaten = new Produktdaten();
        produktdaten.setRet(1);
        produktdaten.setDet(1);
        assertFalse(produktdaten.isValid());

        produktdaten = new Produktdaten();
        produktdaten.setType("EIF");
        produktdaten.setRet(-1);
        produktdaten.setDet(0);
        assertFalse(produktdaten.isValid());

    }

}
