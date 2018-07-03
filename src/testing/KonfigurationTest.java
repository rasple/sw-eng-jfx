package testing;

import static org.junit.Assert.*;

import org.junit.Ignore;
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

    @Ignore
    public void evaluateCalcMannMonate(){

        Konfiguration config = new Konfiguration();
        assertEquals(0, config.calcmannmonate(0), 0);
        assertEquals(0, config.calcmannmonate(50), 0);
        assertEquals(76, config.calcmannmonate(1000), 0);
        assertEquals(112, config.calcmannmonate(1400), 0);
        assertEquals(142, config.calcmannmonate(1700), 0);
        assertEquals(175, config.calcmannmonate(2000), 0);
        assertEquals(201, config.calcmannmonate(2200), 0);
        assertEquals(245, config.calcmannmonate(2500), 0);
        assertEquals(267, config.calcmannmonate(2600), 0);
        assertEquals(284, config.calcmannmonate(2700), 0);
        assertEquals(287, config.calcmannmonate(2800), 0);
        assertEquals(341, config.calcmannmonate(2900), 0);
        assertEquals(341, config.calcmannmonate(3000), 0);
    }

    @Test
    public void evaluateCalcFP(){

        Konfiguration config = new Konfiguration();
        assertEquals(0, config.calcfp(0), 0);
        assertEquals(0, config.calcfp(50), 0);
        assertEquals(12048, config.calcfp(1000), 0);
        assertEquals(15554, config.calcfp(1400), 0);
        assertEquals(17280, config.calcfp(1700), 0);
        assertEquals(18405, config.calcfp(2000), 0);
        assertEquals(15995, config.calcfp(2200), 0);
        assertEquals(15780, config.calcfp(2500), 0);
        assertEquals(70125, config.calcfp(2600), 0);
        assertEquals(11932, config.calcfp(2700), 0);
        assertEquals(12628, config.calcfp(2800), 0);
        assertEquals(7090, config.calcfp(2900), 0);
        assertEquals(0, config.calcfp(3000), 0);
    }

    @Test
    public void evaluateToString(){

        Konfiguration config = new Konfiguration();
        assertTrue(config.toString().matches("Konfiguration\\{kompILF(.*), kompEIF(.*), kompEI(.*), kompEO(.*), kompEQ(.*), HashMapFunktion(.*), HashMapDaten(.*)\\}"));

    }
}
