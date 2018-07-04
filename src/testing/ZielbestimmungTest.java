package testing;

import static org.junit.Assert.*;

import model.Zielbestimmung;
import org.junit.Ignore;
import org.junit.Test;

public class ZielbestimmungTest {

    @Test
    public void zielbestimmungTest(){

        Zielbestimmung zielbestimmung = new Zielbestimmung();
        assertTrue(zielbestimmung.getText().isEmpty());

        zielbestimmung.setText("test12");
        assertFalse(zielbestimmung.getText().isEmpty());
        assertEquals("test12", zielbestimmung.getText());

        Zielbestimmung z2 = new Zielbestimmung(zielbestimmung);
        assertEquals(zielbestimmung.getText(), z2.getText());

    }

}
