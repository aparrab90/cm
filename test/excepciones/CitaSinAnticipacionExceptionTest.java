package excepciones;

import org.junit.Test;
import static org.junit.Assert.*;

public class CitaSinAnticipacionExceptionTest {

    @Test
    public void testExceptionMessage() {
        String expectedMessage = "La cita debe ser agendada con al menos 24 horas de anticipación.";
        CitaSinAnticipacionException exception = new CitaSinAnticipacionException(expectedMessage);
        
        assertEquals("El mensaje de la excepción debe coincidir con el esperado.", expectedMessage, exception.getMessage());
    }
    
    @Test(expected = CitaSinAnticipacionException.class)
    public void testExceptionThrowing() throws CitaSinAnticipacionException {
        throw new CitaSinAnticipacionException("La cita debe ser agendada con al menos 24 horas de anticipación.");
    }
}
