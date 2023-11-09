package reglas;

import modelo.CitaMedica;
import org.junit.Test;
import static org.junit.Assert.*;

public class FinDeSemanaRuleTest {
    
    public FinDeSemanaRuleTest() {
    }

    /**
     * Test of validate method, of class FinDeSemanaRule.
     */
    @Test
    public void testValidate() throws Exception {
        System.out.println("validate");
        CitaMedica cita = null;
        FinDeSemanaRule instance = new FinDeSemanaRule();
        instance.validate(cita);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
