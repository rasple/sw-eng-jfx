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

        fakt0ren = new double[]{3, 0.3, 8, -1, 70, 5, -9.4, 1, 0.00001, 4};
        faktoren = new Faktoren(fakt0ren);
        fakt0ren = faktoren.getFaktoren();
        for(double faktor : fakt0ren){
            assertNotEquals(0, faktor);
        }

    }

    @Test
    public void calcUnbewerteteFpTest(){

        double[] bewerteteFp = new double[]{-5, 0, 1.23, 15, 42, -4.73468, 22, 1};

        double[] faktoren = new double[]{3, 0.3, 8, -1, 70, 5, -9.4, 1, 0.00001, 4};

        double[] expectedUFP = new double[]{-7.142857142857143, 0.0, 1.7571428571428573, 21.42857142857143, 60.00000000000001, -6.763828571428572, 31.42857142857143,  1.4285714285714286};

        for(int index = 0; index<bewerteteFp.length; index++){

            double unbewerteteFp = Faktoren.calcunbewertefp(bewerteteFp[index], faktoren);
            assertEquals(expectedUFP[index] ,unbewerteteFp, 0.0001);
        }
    }

    @Test
    public void calcBewerteteFpTest(){

        double[] unbewerteteFp = new double[]{-5, 0, 1.23, 15, 42, -4.73468, 22, 1};

        double[] faktoren = new double[]{3, 0.3, 8, -1, 70, 5, -9.4, 1, 0.00001, 4};

        double[] expectedBFP = new double[]{-3.5, 0.0, 0.861, 10.5, 29.4, -3.314276, 15.4, 0.7};

        for(int index = 0; index<unbewerteteFp.length; index++){

            double bewerteteFp = Faktoren.calcbewertefp(unbewerteteFp[index], faktoren);
            assertEquals(expectedBFP[index] , bewerteteFp, 0.0001);
        }
    }

    @Test
    public void calcfacTest(){

        double[][] testFaktoren = new double[][]{{}, {8000}, {235798., 632.78677, 54465}, {-1545, 13.8798}, {0}};

        double[] expected = new double[]{0.7, 80.7, 2908.7, -14.3, 0.7};

        for(int index = 0; index<testFaktoren.length; index++){

            double result = Faktoren.calcfac(testFaktoren[index]);

            assertEquals(expected[index], result, 0.0001);
        }
    }

}
