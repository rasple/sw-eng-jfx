package testing;

import static org.junit.Assert.*;
import org.junit.Test;
import model.Konfiguration;

import java.util.HashMap;

public class KonfigurationTest {

    @Test
    public void evaluateHashMapFunktion(){

       Konfiguration konfiguration = new Konfiguration();

       HashMap<?,?> HMFunktion = konfiguration.getHashMapFunktion();

       assertFalse(HMFunktion.isEmpty());
       assertEquals(3, HMFunktion.size());
       assertNotNull(HMFunktion.hashCode());
       assertEquals(java.util.HashMap.class, HMFunktion.getClass());
    }

    @Test
    public void evaluateHashMapDaten(){

        Konfiguration konfiguration = new Konfiguration();

        HashMap<?,?> HMDaten = konfiguration.getHashMapDaten();

        assertFalse(HMDaten.isEmpty());
        assertEquals(2, HMDaten.size());
        assertNotNull(HMDaten.hashCode());
        assertEquals(HashMap.class, HMDaten.getClass());
    }

}
