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
        Produktfunktion produktfunktion = new Produktfunktion();
        assertEquals(3, produktfunktion.calcFp(config.getHashMapDaten()));
        //assertEquals(3, produktdaten.calcFp(config.getHashMapFunktion()));

       // produktdaten.setType("EO");
       // assertEquals(4, produktdaten.calcFp(config.getHashMapFunktion()));

      //  produktdaten.setType("EQ");
       // assertEquals(3, produktdaten.calcFp(config.getHashMapFunktion()));

    }
}
