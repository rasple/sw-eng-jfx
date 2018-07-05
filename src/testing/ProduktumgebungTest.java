package testing;

import static org.junit.Assert.*;

import model.Produktumgebung;
import org.junit.Test;

public class ProduktumgebungTest {

    @Test
    public void produktumgebungTest(){

        Produktumgebung produktumgebung = new Produktumgebung();
        assertTrue(produktumgebung.getText().isEmpty());

        produktumgebung.setText("test12");
        assertFalse(produktumgebung.getText().isEmpty());
        assertEquals("test12", produktumgebung.getText());

        Produktumgebung p2 = new Produktumgebung(produktumgebung);
        assertEquals(produktumgebung.getText(), p2.getText());

        String text = "String to test";
        produktumgebung = new Produktumgebung(text);
        assertEquals(text, produktumgebung.getText());
    }
}
