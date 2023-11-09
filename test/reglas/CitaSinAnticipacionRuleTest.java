package reglas;

import modelo.CitaMedica;
import org.junit.Test;
import static org.junit.Assert.*;

public class CitaSinAnticipacionRuleTest {
    
    public CitaSinAnticipacionRuleTest() {
    }

    @Test
    public void testValidate() throws Exception {
        System.out.println("validate");
        CitaMedica cita = null;
        CitaSinAnticipacionRule instance = new CitaSinAnticipacionRule();
        instance.validate(cita);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
