package testing;

import static org.junit.Assert.*;

import model.SelbstoptiException;
import org.junit.Test;

public class SelbstoptiExceptionTest {

    @Test
    public void selbstoptiExceptionTest(){

        int reasons[] = new int[]{-5, 4, 0, 3, -2};
        String[] messages = new String[]{"Message1", "high exception" , "ßget", "23", ""};

        for(int index = 0; index < reasons.length; index++){
            try{
                throw new SelbstoptiException(messages[index], reasons[index]);
            } catch(SelbstoptiException se) {
                assertEquals(reasons[index], se.getReason());
                assertEquals(messages[index], se.getMessage());
            } catch(Exception e) {
                throw new AssertionError("Unexpected exception thrown");
            }
        }

    }
}
