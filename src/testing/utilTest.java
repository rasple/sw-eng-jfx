package testing;

import static org.junit.Assert.*;

import org.junit.Test;
import utils.*;
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



    @Test(expected = StackOverflowError.class)
    public void ConvertTest(){

        Anforderungsanalyse anforderungsanalyse = new Anforderungsanalyse();
        String conversion = Convert.ObjectToXML(anforderungsanalyse);
        String toMatch = new String("{\"produkteinsatz\":{\"text\":\"\"},\"faktoren\":{\"faktoren\":[0,0,0,0,0,0,0,0,0,0],\"kontrollverfahren\":0,\"logik\":0,\"transaktionsrate\":0,\"rechenoperationen\":0,\"wiederverwendbarkeit\":0,\"ausnahmeregelung\":0,\"anpassbarkeit\":0,\"verfechtung\":0,\"datenbestandskonvertierung\":0,\"dezentraleDaten\":0},\"produktdaten\":[],\"produktfunktionen\":[],\"zielbestimmung\":{\"text\":\"\"},\"produktumgebung\":{\"text\":\"\"},\"functionPoints\":{\"istfp\":0,\"sollfp\":0,\"calcMannmonate\":0},\"config\":{\"hashMapFunktion\":{\"EI\":[[3,3,4],[3,4,6],[4,6,6]],\"EQ\":[[3,3,4],[3,4,6],[4,6,6]],\"EO\":[[4,4,5],[4,5,7],[5,7,7]]},\"hashMapDaten\":{\"ILF\":[[7,7,10],[7,10,15],[10,15,15]],\"EIF\":[[5,5,7],[5,7,10],[7,10,10]]}}}");

        assertEquals(toMatch.toString(), conversion.toString());

    }


}
