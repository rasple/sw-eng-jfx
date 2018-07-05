package testing;

import static org.junit.Assert.*;

import model.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class AnforderungsanalyseTest {

    @Test
    public void getCopyOfCurrentAnforderungsanalyseTest(){

        Anforderungsanalyse original = Anforderungsanalyse.getInstance();
        Anforderungsanalyse copy = original.getCopyOfCurrentAnforderungsanalyse();
        assertEquals(original.toString(), copy.toString());
    }

    @Test(expected = NullPointerException.class)
    public void resetAnforderungsanalyseTest(){

        Anforderungsanalyse anforderungsanalyse = new Anforderungsanalyse();
        anforderungsanalyse.resetAnforderungsanalyse();
        anforderungsanalyse.getCopyOfCurrentAnforderungsanalyse();
    }

    @Test
    public void aufwandsabschaetzungTest(){

        Anforderungsanalyse anforderungsanalyse = new Anforderungsanalyse();
        assertEquals( -3, anforderungsanalyse.aufwandsabschaetzung(), 0);

        Produktfunktion produktfunktion = new Produktfunktion();
        List<Produktfunktion> produktfunktionen = new ArrayList<Produktfunktion>();
        produktfunktionen.add(produktfunktion);
        anforderungsanalyse.setProduktfunktionen(produktfunktionen);
        assertEquals( -4, anforderungsanalyse.aufwandsabschaetzung(), 0);

        Produktdaten produktdaten = new Produktdaten();
        List<Produktdaten> produktdatens = new ArrayList<Produktdaten>();
        produktdatens.add(produktdaten);
        anforderungsanalyse.setProduktdaten(produktdatens);
        assertEquals(-1, anforderungsanalyse.aufwandsabschaetzung(), 0);

        produktfunktionen.remove(0);
        produktfunktion.setType("EI");
        produktfunktion.setDet(1);
        produktfunktion.setFtr(1);
        produktfunktionen.add(produktfunktion);
        anforderungsanalyse.setProduktfunktionen(produktfunktionen);
        assertEquals(-2, anforderungsanalyse.aufwandsabschaetzung(), 0);

        produktdatens.remove(0);
        produktdaten.setType("ILF");
        produktdaten.setDet(1);
        produktdaten.setRet(1);
        produktdatens.add(produktdaten);
        anforderungsanalyse.setProduktdaten(produktdatens);
        assertEquals(0.7, anforderungsanalyse.aufwandsabschaetzung(), 0);
    }
    @Test
    public void aufwandsabschaetzunglongtest() {
        Anforderungsanalyse anforderungsanalyse = new Anforderungsanalyse();
        List<Produktfunktion> produktfunktionen = new ArrayList<Produktfunktion>();
        produktfunktionen.add(new Produktfunktion("test1", "1", 2, 16, "EI")); //6 fp
        produktfunktionen.add(new Produktfunktion("test2", "2", 0, 5, "EI")); //3 fp
        produktfunktionen.add(new Produktfunktion("test3", "3", 3, 3, "EI")); //4 fp

        produktfunktionen.add(new Produktfunktion("test4", "4", 2, 20, "EO")); //7 fp
        produktfunktionen.add(new Produktfunktion("test5", "5", 1, 5, "EO")); //4 fp
        produktfunktionen.add(new Produktfunktion("test6", "6", 4, 3, "EO")); //5 fp

        produktfunktionen.add(new Produktfunktion("test7", "7", 2, 20, "EQ")); //6 fp
        produktfunktionen.add(new Produktfunktion("test8", "8", 0, 15, "EQ")); //3 fp
        produktfunktionen.add(new Produktfunktion("test9", "9", 5, 4, "EQ")); //4 fp
        anforderungsanalyse.setProduktfunktionen(produktfunktionen);

        List<Produktdaten> produktdaten = new ArrayList<>();
        produktdaten.add(new Produktdaten("test1", "1", 1, 1, "ILF")); //7fp
        produktdaten.add(new Produktdaten("test2", "2", 3, 30, "ILF")); //10fp
        produktdaten.add(new Produktdaten("test3", "3", 6, 51, "ILF")); //15fp

        produktdaten.add(new Produktdaten("test1", "1", 1, 1, "EIF")); //5fp
        produktdaten.add(new Produktdaten("test2", "2", 3, 30, "EIF")); //7fp
        produktdaten.add(new Produktdaten("test3", "3", 6, 51, "EIF")); //10fp //96 total
        anforderungsanalyse.setProduktdaten(produktdaten);
        double[] factor = new double[]{0.5, 1, 1.5, 2, 2.5, 3, 3.5, 4, 4.5, 5}; //bewertete 93,6
        anforderungsanalyse.setFaktoren(new Faktoren(factor));
        assertEquals(7.716, anforderungsanalyse.aufwandsabschaetzung(), 0.2);

        double[] expectedfactors1= new double[]{5.0,5.0,5.0,5.0,2.7,3.0,3.5,4.0,4.5,5.0};
        double[] expectedfactors2= new double[]{0,0,0,0,0,0,0,3.2,4.5,5};
        try{
        Faktoren sollfaktoren =anforderungsanalyse.selbstoptimierung(8.5);
        for(int i=0; i<10;i++)
        {
            assertEquals(expectedfactors1[i],sollfaktoren.getFaktoren()[i], 0.1 );
        }
        sollfaktoren= anforderungsanalyse.selbstoptimierung(7.5);
            for(int i=0; i<10;i++)
            {
                assertEquals(expectedfactors2[i],sollfaktoren.getFaktoren()[i], 0.1 );
            }
        } catch (SelbstoptiException e){
        //can not happen
        }
    }
    @Test
    public void selbstoptimierungTest(){

        Anforderungsanalyse anforderungsanalyse = new Anforderungsanalyse();

        try {
            anforderungsanalyse.selbstoptimierung(0);
            throw new AssertionError("No Exception thrown");
        } catch(Exception e) {
            assertEquals(e.getClass(), model.SelbstoptiException.class);
            assertEquals("Produktfunktionen nicht vorhanden", e.getMessage());
        }

        Produktfunktion produktfunktion = new Produktfunktion();
        List<Produktfunktion> produktfunktionen = new ArrayList<Produktfunktion>();
        produktfunktionen.add(produktfunktion);
        anforderungsanalyse.setProduktfunktionen(produktfunktionen);

        try {
            anforderungsanalyse.selbstoptimierung(0);
            throw new AssertionError("No Exception thrown");
        } catch(Exception e) {
            assertEquals(e.getClass(), model.SelbstoptiException.class);
            assertEquals("Produktdaten nicht vorhanden", e.getMessage());
        }

        Produktdaten produktdaten = new Produktdaten();
        List<Produktdaten> produktdatens = new ArrayList<Produktdaten>();
        produktdatens.add(produktdaten);
        anforderungsanalyse.setProduktdaten(produktdatens);

        try {
            anforderungsanalyse.selbstoptimierung(0);
            throw new AssertionError("No Exception thrown");
        } catch(Exception e) {
            assertEquals(e.getClass(), model.SelbstoptiException.class);
            assertEquals("Produktfunktionen nicht vollständig", e.getMessage());
        }

        produktfunktionen.remove(0);
        produktfunktion.setType("EI");
        produktfunktion.setDet(1);
        produktfunktion.setFtr(1);
        produktfunktionen.add(produktfunktion);
        anforderungsanalyse.setProduktfunktionen(produktfunktionen);

        try {
            anforderungsanalyse.selbstoptimierung(0);
            throw new AssertionError("No Exception thrown");
        } catch(Exception e) {
            assertEquals(e.getClass(), model.SelbstoptiException.class);
            assertEquals("Produktdaten nicht vollständig", e.getMessage());
        }

        produktdatens.remove(0);
        produktdaten.setType("ILF");
        produktdaten.setDet(1);
        produktdaten.setRet(1);
        produktdatens.add(produktdaten);
        anforderungsanalyse.setProduktdaten(produktdatens);

        double[] faktoren;

        try{
            faktoren = anforderungsanalyse.selbstoptimierung(0).getFaktoren();
            for(double faktor : faktoren){
                assertEquals(0, faktor, 0);
            }
        } catch(Exception e) {
            throw new AssertionError("Unexpected Exception thrown");
        }

    }

    @Test
    public void cloneTest(){

        Anforderungsanalyse anforderungsanalyse = Anforderungsanalyse.getInstance();
        Faktoren faktoren = new Faktoren();
        anforderungsanalyse.setFaktoren(faktoren);
        anforderungsanalyse.setUserfaktoren(faktoren);
        anforderungsanalyse.setSollFaktoren(faktoren);
        Anforderungsanalyse a2 = Anforderungsanalyse.clone(anforderungsanalyse);
        assertTrue(a2.equals(anforderungsanalyse));
    }

}
