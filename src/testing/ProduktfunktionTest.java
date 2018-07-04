package testing;

import static org.junit.Assert.*;

import model.Konfiguration;
import model.Konfiguration_I;
import org.junit.Ignore;
import org.junit.Test;

import model.Produktfunktion;
public class ProduktfunktionTest {
Konfiguration_I config = new Konfiguration();
   //Und das jetzt für den jeden Typen und jede mögliche Positioen, gleich nochmals für die Datentypen
    @Test
    public void testEI(){
        Produktfunktion funktioneEI = new Produktfunktion("test", "1", 1,1,"EI");
        assertEquals(3, funktioneEI.calcFp(config.getHashMapFunktion()));

    }

}
