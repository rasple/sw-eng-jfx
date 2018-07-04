package testing;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import utils.*;
import org.junit.rules.TemporaryFolder;
import model.Anforderungsanalyse;

public class utilTest {

    @Test
    public void IOTest(){

        Anforderungsanalyse aly = new Anforderungsanalyse();
        //empty for now

    }

    @Test
    public void ConvertTest(){

        Anforderungsanalyse original = new Anforderungsanalyse();
        String conversion = Convert.ObjectToXML(original);
        Anforderungsanalyse toCompare = (Anforderungsanalyse) Convert.XMLToObject(conversion);

        assertEquals(original.getClass(), toCompare.getClass());
        assertEquals(original.getFaktoren(), toCompare.getFaktoren());

    }

}
