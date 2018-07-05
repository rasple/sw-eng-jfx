package testing;

import static org.junit.Assert.*;

import model.Faktoren;
import org.junit.Test;

public class FaktorenTest {

    @Test
    public void getFaktorenTest(){

        Faktoren faktoren = new Faktoren();
        double[] fakt0ren = faktoren.getFaktoren();
        for(double faktor : fakt0ren){

            assertEquals(0, faktor, 0);
        }

        faktoren.setLogik(8);
        fakt0ren = faktoren.getFaktoren();
        assertNotEquals(0, fakt0ren[6]);

        fakt0ren = new double[]{3, 0.3, 5, 1.89724, 4.701, 4.444, 3, 1, 0.001, 2};
        faktoren = new Faktoren(fakt0ren);
        fakt0ren = faktoren.getFaktoren();
        for(double faktor : fakt0ren){
            assertNotEquals(0, faktor);
        }

        Faktoren faktoren2 = new Faktoren(faktoren);
        assertTrue(faktoren2.equals(faktoren));

    }

    @Test
    public void calcUnbewerteteFpTest(){

        double[] bewerteteFp = new double[]{5, 0, 1.23, 15, 42, 4.73468, 22, 1};

        double[] faktoren = new double[]{3, 0.3, 5, 1.89724, 4.701, 4.444, 3, 1, 0.001, 2};

        double[] expectedUFP = new double[]{5, 0, 1, 16, 44, 5, 23, 1};

        for(int index = 0; index<bewerteteFp.length; index++){

            double unbewerteteFp = Faktoren.calcunbewertefp(bewerteteFp[index], faktoren);
            assertEquals(expectedUFP[index] ,unbewerteteFp, 0.5);
        }
    }

    @Test
    public void calcBewerteteFpTest(){

        double[] unbewerteteFp = new double[]{5, 0, 1, 15, 42, 468, 22, 1};

        double[] faktoren = new double[]{3, 0.3, 5, 1.89724, 4.701, 4.444, 3, 1, 0.001, 2};

        double[] expectedBFP = new double[]{4.767162, 0.0, 0.9534324, 14.301486, 40.044161, 446.2063632, 20.9755128, 0.9534324};

        for(int index = 0; index<unbewerteteFp.length; index++){

            double bewerteteFp = Faktoren.calcbewertefp(unbewerteteFp[index], faktoren);
            assertEquals(expectedBFP[index] , bewerteteFp, 0.0001);
        }
    }

    @Test
    public void calcFacTest(){

        double[][] testFaktoren = new double[][]{{3, 0.3, 5, 1.89724, 4.701, 4.444, 3, 1, 0.001, 2},
                {4, 1.37, 4.98, 1.645624, 4.5401, 3.524, 3, 1.54, 0.4640041, 2.5579874},
                {0, 0.3, 5, 1.89724, 4.701, 4.444, 3, 1, 0.001, 2},
                {3.54, 2.456, 0.728, 1.89724, 4.701, 5, 3, 1, 0.001, 2},
                {1.5412, 0.64356, 4.25, 0, 0.701, 2.424, 2, 2, 1, 0}};

        double[] expected = new double[]{0.9534324, 0.976217155, 0.9234324, 0.9432324, 0.8455976};

        for(int index = 0; index<testFaktoren.length; index++){

            double result = Faktoren.calcfac(testFaktoren[index]);

            assertEquals(expected[index], result, 0.0001);
        }
    }

    @Test
    public void userAusgabeTest(){

        Faktoren faktoren = new Faktoren();
        String expected = "Verfechtung: 0.0\n" +
                "Dezentrale Daten: 0.0\n" +
                "Transaktionsrate: 0.0\n" +
                "Rechenoperationen: 0.0\n" +
                "Kontrollverfahren: 0.0\n" +
                "Ausnahmeregelung: 0.0\n" +
                "Logik: 0.0\n" +
                "Wiederverwendbarkeit: 0.0\n" +
                "Datenbestandskonvertierung: 0.0\n" +
                "Anpassbarkeit: 0.0\n" +
                "Bemerkung: ";
        assertEquals(expected, faktoren.Userausgabe());
    }

}
