package testing;

import static org.junit.Assert.*;

import model.*;
import org.junit.Test;
import utils.*;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class utilTest {
    /**
     * Es werden Produktdaten und funktionen, Zielbestimmung, Produktumgebung und einsatz und Faktoren einer
     * Anforderungsanalyse hinzugefügt. Diese wird angespeichert und anschließend geladen.
     * Alles Elemente werden auf Gleichheit geprüft
     */
    @Test
    public void IOTest(){


        Anforderungsanalyse original = Anforderungsanalyse.getInstance();
        List<Produktfunktion_I> produktfunktionen = new ArrayList<Produktfunktion_I>();
        produktfunktionen.add(new Produktfunktion("test1", "1", 2, 16, "EI"));
        produktfunktionen.add(new Produktfunktion("test2", "2", 0, 5, "EI"));
        produktfunktionen.add(new Produktfunktion("test3", "3", 3, 3, "EI"));
        produktfunktionen.add(new Produktfunktion("test4", "4", 2, 20, "EO"));
        produktfunktionen.add(new Produktfunktion("test5", "5", 1, 5, "EO"));
        produktfunktionen.add(new Produktfunktion("test6", "6", 4, 3, "EO"));
        produktfunktionen.add(new Produktfunktion("test7", "7", 2, 20, "EQ"));
        produktfunktionen.add(new Produktfunktion("test8", "8", 0, 15, "EQ"));
        produktfunktionen.add(new Produktfunktion("test9", "9", 5, 4, "EQ"));
        original.setProduktfunktionen(produktfunktionen);



        List<Produktdaten_I> produktdaten = new ArrayList<>();
        produktdaten.add(new Produktdaten("test1", "1", 1, 1, "ILF"));
        produktdaten.add(new Produktdaten("test2", "2", 3, 30, "ILF"));
        produktdaten.add(new Produktdaten("test3", "3", 6, 51, "ILF"));
        produktdaten.add(new Produktdaten("test1", "1", 1, 1, "EIF"));
        produktdaten.add(new Produktdaten("test2", "2", 3, 30, "EIF"));
        produktdaten.add(new Produktdaten("test3", "3", 6, 51, "EIF"));
        original.setProduktdaten(produktdaten);

        original.setZielbestimmung(new Zielbestimmung("TestZielbestimmung"));
        original.setProduktumgebung(new Produktumgebung("TestProduktumgebung"));
        original.setProdukteinsatz(new Produkteinsatz("TestProdukteinsatz"));

        double[] factor = new double[]{0.5, 1, 1.5, 2, 2.5, 3, 3.5, 4, 4.5, 5};
        original.setFaktoren(new Faktoren(factor));

        File file = new File("./temp.klaus");
        IO.fSave(original, file);

        Anforderungsanalyse loaded = (Anforderungsanalyse) IO.fLoad(file);
        file.delete();
        for(int i=0; i<10;i++){
            assertEquals(loaded.getFaktoren().getFaktoren()[i], factor[i], 0.1);
        }
        int length= loaded.getProduktdaten().size();
        assertTrue(loaded.getProdukteinsatz().getText().contentEquals("TestProdukteinsatz"));
        assertTrue(loaded.getProduktumgebung().getText().contentEquals( "TestProduktumgebung"));
        assertTrue(loaded.getZielbestimmung().getText().contentEquals("TestZielbestimmung"));
        Produktdaten org, test;
        for(int i=0; i<length;i++){
            org= (Produktdaten) original.getProduktdaten().get(i);
            test= (Produktdaten) loaded.getProduktdaten().get(i);
            assertTrue(org.equals(test));

        }
        length= loaded.getProduktfunktionen().size();
        Produktfunktion org_f, test_f;
        for(int i=0; i<length;i++){
            org_f= (Produktfunktion) original.getProduktfunktionen().get(i);
            test_f= (Produktfunktion) loaded.getProduktfunktionen().get(i);
            assertTrue(org_f.equals(test_f));

        }

        assertTrue(original.getFunctionPoints().equals(loaded.getFunctionPoints()));
        assertTrue(original.getZielbestimmung().equals(loaded.getZielbestimmung()));
        assertTrue(original.getProduktumgebung().equals(loaded.getProduktumgebung()));
        assertTrue(original.getProdukteinsatz().equals(loaded.getProdukteinsatz()));
        assertTrue(original.getFaktoren().equals(loaded.getFaktoren()));
        assertTrue(original.getConfig().equals(loaded.getConfig()));
        assertTrue(original.getNachkal().equals(loaded.getNachkal()));

    }



    @Test(expected = StackOverflowError.class)
    public void ConvertTest(){

        String conversion = Convert.ObjectToXML(Anforderungsanalyse.getInstance());
        String toMatch = new String("{\"produkteinsatz\":{\"text\":\"\"},\"faktoren\":{\"faktoren\":[0,0,0,0,0,0,0,0,0,0],\"kontrollverfahren\":0,\"logik\":0,\"transaktionsrate\":0,\"rechenoperationen\":0,\"wiederverwendbarkeit\":0,\"ausnahmeregelung\":0,\"anpassbarkeit\":0,\"verfechtung\":0,\"datenbestandskonvertierung\":0,\"dezentraleDaten\":0},\"produktdaten\":[],\"produktfunktionen\":[],\"zielbestimmung\":{\"text\":\"\"},\"produktumgebung\":{\"text\":\"\"},\"functionPoints\":{\"istfp\":0,\"sollfp\":0,\"calcMannmonate\":0},\"config\":{\"hashMapFunktion\":{\"EI\":[[3,3,4],[3,4,6],[4,6,6]],\"EQ\":[[3,3,4],[3,4,6],[4,6,6]],\"EO\":[[4,4,5],[4,5,7],[5,7,7]]},\"hashMapDaten\":{\"ILF\":[[7,7,10],[7,10,15],[10,15,15]],\"EIF\":[[5,5,7],[5,7,10],[7,10,10]]}}}");

        assertEquals(toMatch, conversion);

    }


}
