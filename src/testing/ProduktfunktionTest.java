package testing;


import static org.junit.Assert.*;

import model.Konfiguration;
import org.junit.Test;

import model.Produktfunktion;
import model.Konfiguration_I;

public class ProduktfunktionTest {

    @Test
    public void calcFpTest(){

        Konfiguration_I config = new Konfiguration();
        Produktfunktion produktfunktion = new Produktfunktion("Test", "test", 0, 1, "EI");
        assertEquals(3, produktfunktion.calcFp(config.getHashMapFunktion()));
        produktfunktion.setDet(6);
        assertEquals(3, produktfunktion.calcFp(config.getHashMapFunktion()));
        produktfunktion.setDet(18);
        assertEquals(4, produktfunktion.calcFp(config.getHashMapFunktion()));

        produktfunktion.setFtr(2);
        produktfunktion.setDet(2);
        assertEquals(3, produktfunktion.calcFp(config.getHashMapFunktion()));
        produktfunktion.setDet(10);
        assertEquals(4, produktfunktion.calcFp(config.getHashMapFunktion()));
        produktfunktion.setDet(16);
        assertEquals(6, produktfunktion.calcFp(config.getHashMapFunktion()));

        produktfunktion.setFtr(3);
        produktfunktion.setDet(3);
        assertEquals(4, produktfunktion.calcFp(config.getHashMapFunktion()));
        produktfunktion.setDet(12);
        assertEquals(6, produktfunktion.calcFp(config.getHashMapFunktion()));
        produktfunktion.setDet(23);
        assertEquals(6, produktfunktion.calcFp(config.getHashMapFunktion()));

        produktfunktion.setType("EO");
        produktfunktion.setFtr(1);
        produktfunktion.setDet(4);
        assertEquals(4, produktfunktion.calcFp(config.getHashMapFunktion()));
        produktfunktion.setFtr(0);
        produktfunktion.setDet(15);
        assertEquals(4, produktfunktion.calcFp(config.getHashMapFunktion()));
        produktfunktion.setFtr(1);
        produktfunktion.setDet(20);
        assertEquals(5, produktfunktion.calcFp(config.getHashMapFunktion()));

        produktfunktion.setFtr(2);
        produktfunktion.setDet(3);
        assertEquals(4, produktfunktion.calcFp(config.getHashMapFunktion()));
        produktfunktion.setFtr(3);
        produktfunktion.setDet(6);
        assertEquals(5, produktfunktion.calcFp(config.getHashMapFunktion()));
        produktfunktion.setFtr(2);
        produktfunktion.setDet(25);
        assertEquals(7, produktfunktion.calcFp(config.getHashMapFunktion()));

        produktfunktion.setFtr(4);
        produktfunktion.setDet(2);
        assertEquals(5, produktfunktion.calcFp(config.getHashMapFunktion()));
        produktfunktion.setFtr(10);
        produktfunktion.setDet(19);
        assertEquals(7, produktfunktion.calcFp(config.getHashMapFunktion()));
        produktfunktion.setFtr(5);
        produktfunktion.setDet(25);
        assertEquals(7, produktfunktion.calcFp(config.getHashMapFunktion()));

        produktfunktion.setType("EQ");
        produktfunktion.setFtr(0);
        produktfunktion.setDet(1);
        assertEquals(3, produktfunktion.calcFp(config.getHashMapFunktion()));
        produktfunktion.setFtr(1);
        produktfunktion.setDet(19);
        assertEquals(3, produktfunktion.calcFp(config.getHashMapFunktion()));
        produktfunktion.setFtr(1);
        produktfunktion.setDet(20);
        assertEquals(4, produktfunktion.calcFp(config.getHashMapFunktion()));

        produktfunktion.setFtr(2);
        produktfunktion.setDet(5);
        assertEquals(3, produktfunktion.calcFp(config.getHashMapFunktion()));
        produktfunktion.setFtr(3);
        produktfunktion.setDet(6);
        assertEquals(4, produktfunktion.calcFp(config.getHashMapFunktion()));
        produktfunktion.setFtr(2);
        produktfunktion.setDet(25);
        assertEquals(6, produktfunktion.calcFp(config.getHashMapFunktion()));

        produktfunktion.setFtr(4);
        produktfunktion.setDet(2);
        assertEquals(4, produktfunktion.calcFp(config.getHashMapFunktion()));
        produktfunktion.setFtr(10);
        produktfunktion.setDet(19);
        assertEquals(6, produktfunktion.calcFp(config.getHashMapFunktion()));
        produktfunktion.setFtr(5);
        produktfunktion.setDet(25);
        assertEquals(6, produktfunktion.calcFp(config.getHashMapFunktion()));

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
