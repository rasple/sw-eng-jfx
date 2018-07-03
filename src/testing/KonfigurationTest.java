package testing;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import model.Konfiguration;
import model.Konfiguration_I;

import java.util.HashMap;

public class KonfigurationTest {

    @Test
    public void evaluateHashMapFunktion(){

       Konfiguration_I konfiguration = new Konfiguration();

       HashMap<?,?> HMFunktion = konfiguration.getHashMapFunktion();

       assertFalse(HMFunktion.isEmpty());
       assertEquals(3, HMFunktion.size());
       assertNotNull(HMFunktion.hashCode());
       assertEquals(java.util.HashMap.class, HMFunktion.getClass());
    }

    @Test
    public void evaluateHashMapDaten(){

        Konfiguration_I konfiguration = new Konfiguration();

        HashMap<?,?> HMDaten = konfiguration.getHashMapDaten();

        assertFalse(HMDaten.isEmpty());
        assertEquals(2, HMDaten.size());
        assertNotNull(HMDaten.hashCode());
        assertEquals(HashMap.class, HMDaten.getClass());
    }

    @Ignore
    public void evaluateCalcMannMonate(){

        Konfiguration_I config = new Konfiguration();
        int[] testValues = new int[]{0, 50, 1000, 1400, 1700, 2000, 2200, 2500, 2600, 2700, 2800, 2900, 3000};

        for (double value : testValues) {
            assert(config.calcmannmonate(value)>=0);
        }
        
    }

    @Test
    public void evaluateCalcFP(){

        Konfiguration_I config = new Konfiguration();
        int[] testValues = new int[]{0, 50, 1000, 1400, 1700, 2000, 2200, 2500, 2600, 2700, 2800, 2900, 3000};

        for (double value : testValues) {
            assert(config.calcfp(value)>=0);
        }

    }

}
