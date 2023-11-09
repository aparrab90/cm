package reglas;

import modelo.CitaMedica;
import org.junit.Test;
import static org.junit.Assert.*;

public class HorarioNoValidoRuleTest {
    
    public HorarioNoValidoRuleTest() {
    }

    @Test
    public void testValidate() throws Exception {
        System.out.println("validate");
        CitaMedica cita = null;
        HorarioNoValidoRule instance = new HorarioNoValidoRule();
        instance.validate(cita);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
