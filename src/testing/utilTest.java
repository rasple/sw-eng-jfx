package testing;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;
import utils.*;
import org.junit.rules.TemporaryFolder;
import model.Anforderungsanalyse;

import java.io.File;

public class utilTest {

    @Test
    public void IOTest(){

        Anforderungsanalyse originalAnforderungsanalyse = new Anforderungsanalyse();
        File file = new File("./temp.klaus");
        IO.fSave(originalAnforderungsanalyse, file);

        Anforderungsanalyse loadedAnforderungsanalyse = (Anforderungsanalyse) IO.fLoad(file);
        file.delete();

        double[] originalFaktoren = originalAnforderungsanalyse.getFaktoren().getFaktoren();
        double[] loadedFaktoren = loadedAnforderungsanalyse.getFaktoren().getFaktoren();

        for(int index=0; index < originalFaktoren.length; index++){

            assertEquals(originalFaktoren[index], loadedFaktoren[index], 0);
        }

    }

    /*
    @Test
    public void ConvertTest(){

        Anforderungsanalyse original = new Anforderungsanalyse();
        String conversion = Convert.ObjectToXML(original);
        JSONObject actual = (JSONObject) Convert.XMLToObject(conversion);

        JSONObject expected = new JSONObject(Convert.toJSON(original));

        assertNotEquals(expected.toString(), actual.toString());

    }
    */
}
