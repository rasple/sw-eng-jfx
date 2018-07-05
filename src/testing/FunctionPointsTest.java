package testing;

import static org.junit.Assert.*;

import org.junit.Test;
import model.DefaultOptimierung;
import model.Faktoren;

import  model.FunctionPoints;

public class FunctionPointsTest {

    @Test
    public void selbstoptimierungTest(){

        FunctionPoints fp = new FunctionPoints();
        double[] testMannMonate = new double[]{0, 50, 1000, 1400, 1700, 2000, 2200, 2500, 2600, 2700, 2800, 2900, 3000};
        double[] testUserFaktoren = new Faktoren().getFaktoren();

        fp.setOpti(new DefaultOptimierung());

        for(double mannMonate : testMannMonate) {

            Faktoren faktoren = fp.selbstoptimierung(mannMonate, testUserFaktoren);

            double[] fakt0ren = faktoren.getFaktoren();

            for(double faktor : fakt0ren){
                assertTrue(faktor >= 0);
                assertTrue(faktor <= 5);
            }
        }

    }

}
