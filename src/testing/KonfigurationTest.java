package testing;

import static org.junit.Assert.*;

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

    @Test
    public void evaluateCalcMannMonate(){

        Konfiguration_I config = new Konfiguration();
        int[] testValues = new int[]{0, 50, 1000, 1400, 1700, 2000, 2200, 2500, 2600, 2700, 2800, 2900, 3000};
        int [] expectedValues = new int[]{0, 0, 76, 112, 142, 175, 201, 245, 263, 284, 287, 341, 341};

        for (int index=0; index < testValues.length; index++) {
            assertEquals(expectedValues[index], config.calcmannmonate(testValues[index]), 0);
        }

        assert(config.calcmannmonate(-1)==0);
        
    }

    @Test
    public void evaluateCalcFP(){

        Konfiguration_I config = new Konfiguration();
        int[] testValues = new int[]{0, 50, 1000, 1400, 1700, 2000, 2200, 2500, 2600, 2700, 2800, 2900, 3000};
        int [] expectedValues = new int[]{0, 0, 12048, 15554, 17280, 18405, 15995, 15780, 70125, 11932, 12628, 7090, 0};

        for (int index=0; index < testValues.length; index++) {
            assertEquals(expectedValues[index], config.calcfp(testValues[index]), 0);
        }

        assert(config.calcfp(-1)==0);

    }

}
