package testing;

import static org.junit.Assert.*;

import model.Optimieren_I;
import org.junit.Ignore;
import org.junit.Test;
import model.Fabrik_I;
import model.DefaultOptimierung;
import model.DefaultFabrik;
import static org.hamcrest.CoreMatchers.*;

public class FabrikTest {

    @Test
    public void createTest(){

        Fabrik_I fab = new DefaultFabrik();
        Optimieren_I opti = fab.create();
        assertThat(opti, instanceOf(DefaultOptimierung.class));
    }

}
