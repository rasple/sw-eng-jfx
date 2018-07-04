package testing;

import static org.junit.Assert.*;

import model.Produkteinsatz;
import org.junit.Ignore;
import org.junit.Test;

public class ProdukteinsatzTest {
    
    @Test
    public void produkteinsatzTest(){

        Produkteinsatz produkteinsatz = new Produkteinsatz();
        assertTrue(produkteinsatz.getText().isEmpty());

        produkteinsatz.setText("test12");
        assertFalse(produkteinsatz.getText().isEmpty());
        assertEquals("test12", produkteinsatz.getText());

        Produkteinsatz p2 = new Produkteinsatz(produkteinsatz);
        assertEquals(produkteinsatz.getText(), p2.getText());
    }
}
