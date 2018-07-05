package testing;

import static org.junit.Assert.*;

import model.Optimieren_I;
import org.junit.Test;
import model.Fabrik_I;
import model.DefaultFabrik;
import static org.hamcrest.CoreMatchers.*;

public class FabrikTest {

    @Test
    public void createTest(){

        Fabrik_I fab = new DefaultFabrik();
        assertThat(fab.create(), instanceOf(Optimieren_I.class));
    }

}
