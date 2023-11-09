package reglas;

import modelo.CitaMedica;
import org.junit.Test;
import static org.junit.Assert.*;

public class SinDisponibilidadRuleTest {
    
    public SinDisponibilidadRuleTest() {
    }

    @Test
    public void testValidate() throws Exception {
        System.out.println("validate");
        CitaMedica cita = null;
        SinDisponibilidadRule instance = null;
        instance.validate(cita);
        fail("The test case is a prototype.");
    }
    
}
