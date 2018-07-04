package testing;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import model.Optimieren_I;
import model.DefaultOptimierung;
import model.Faktoren;
import static org.hamcrest.CoreMatchers.*;

public class OptimierenTest {

    @Test
    public void kleinerOptimieren(){

        double[] testIstFp = new double[]{1, 5, 10, 50, 100};
        double[] testSollFp = new double[]{0, 3, 7.4, 2, 85};
        double[][] testFactors = new double[][]{{9, 0},{1},{},{80, 0, 7.2},{3.5, 4}};

        Optimieren_I opti = new DefaultOptimierung();


        for(int index = 0; index < 5; index++){
            Faktoren factors = opti.optimieren(testIstFp[index], testSollFp[index], testFactors[index]);

            double[] fact0rs = factors.getFaktoren();

            for(Object factor : fact0rs){

                assertThat(factor, instanceOf(double.class));
                assert((double) factor >= 0);
                assert((double) factor <= 5);
            }
        }
    }

    @Test
    public void gleichOptimieren(){

        double[] testIstFp = new double[]{0, 5, 7.4, 50, 100};
        double[] testSollFp = new double[]{0, 5, 7.4, 50, 100};
        double[][] testFactors = new double[][]{{9, 0},{1},{},{80, 0, 7.2},{3.5, 4}};

        Optimieren_I opti = new DefaultOptimierung();


        for(int index = 0; index < 5; index++){
            Faktoren factors = opti.optimieren(testIstFp[index], testSollFp[index], testFactors[index]);

            double[] fact0rs = factors.getFaktoren();

            for(Object factor : fact0rs){

                assertThat(factor, instanceOf(double.class));
                assert((double) factor >= 0);
                assert((double) factor <= 5);
            }
        }
    }

    @Test
    public void groesserOptimieren(){

        double[] testIstFp = new double[]{1, 5, 7.4, 50, 100};
        double[] testSollFp = new double[]{81, 9, 17, 100, 140.8};
        double[][] testFactors = new double[][]{{9, 0},{1},{},{80, 0, 7.2},{3.5, 4}};

        Optimieren_I opti = new DefaultOptimierung();


        for(int index = 0; index < 5; index++){

            Faktoren factors = opti.optimieren(testIstFp[index], testSollFp[index], testFactors[index]);

            double[] fact0rs = factors.getFaktoren();

            for(Object factor : fact0rs){

                assertThat(factor, instanceOf(double.class));
                assert((double) factor >= 0);
                assert((double) factor <= 5);
            }
        }
    }

}
