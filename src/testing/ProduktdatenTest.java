package testing;

import static org.junit.Assert.*;

import model.Konfiguration;
import model.Produktdaten;
import org.junit.Test;

public class ProduktdatenTest {

    @Test
    public void calcFpTest(){

        Konfiguration config = new Konfiguration();
        Produktdaten produktdaten = new Produktdaten("Test", "test", 1, 1, "ILF");
        assertEquals(7, produktdaten.calcFp(config.getHashMapDaten()));
        produktdaten.setDet(20);
        assertEquals(7, produktdaten.calcFp(config.getHashMapDaten()));
        produktdaten.setDet(51);
        assertEquals(10, produktdaten.calcFp(config.getHashMapDaten()));

        produktdaten.setRet(2);
        produktdaten.setDet(19);
        assertEquals(7, produktdaten.calcFp(config.getHashMapDaten()));
        produktdaten.setRet(3);
        produktdaten.setDet(50);
        assertEquals(10, produktdaten.calcFp(config.getHashMapDaten()));
        produktdaten.setDet(57);
        assertEquals(15, produktdaten.calcFp(config.getHashMapDaten()));

        produktdaten.setRet(6);
        produktdaten.setDet(15);
        assertEquals(10, produktdaten.calcFp(config.getHashMapDaten()));
        produktdaten.setDet(25);
        assertEquals(15, produktdaten.calcFp(config.getHashMapDaten()));
        produktdaten.setDet(70);
        assertEquals(15, produktdaten.calcFp(config.getHashMapDaten()));

        produktdaten.setType("EIF");
        produktdaten.setRet(1);
        produktdaten.setDet(1);
        assertEquals(5, produktdaten.calcFp(config.getHashMapDaten()));
        produktdaten.setDet(20);
        assertEquals(5, produktdaten.calcFp(config.getHashMapDaten()));
        produktdaten.setDet(51);
        assertEquals(7, produktdaten.calcFp(config.getHashMapDaten()));

        produktdaten.setRet(2);
        produktdaten.setDet(19);
        assertEquals(5, produktdaten.calcFp(config.getHashMapDaten()));
        produktdaten.setRet(3);
        produktdaten.setDet(50);
        assertEquals(7, produktdaten.calcFp(config.getHashMapDaten()));
        produktdaten.setDet(57);
        assertEquals(10, produktdaten.calcFp(config.getHashMapDaten()));

        produktdaten.setRet(6);
        produktdaten.setDet(15);
        assertEquals(7, produktdaten.calcFp(config.getHashMapDaten()));
        produktdaten.setDet(25);
        assertEquals(10, produktdaten.calcFp(config.getHashMapDaten()));
        produktdaten.setRet(8);
        produktdaten.setDet(70);
        assertEquals(10, produktdaten.calcFp(config.getHashMapDaten()));


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
