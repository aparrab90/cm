package excepciones;

import org.junit.Test;
import static org.junit.Assert.*;

public class CitaValidationExceptionTest {

    @Test
    public void testExceptionMessage() {
        String expectedMessage = "Error de validación de la cita.";
        CitaValidationException exception = new CitaValidationException(expectedMessage);
        
        assertEquals("El mensaje de la excepción debe ser igual al esperado.", expectedMessage, exception.getMessage());
    }
    
    @Test(expected = CitaValidationException.class)
    public void testExceptionIsThrown() throws CitaValidationException {
        throw new CitaValidationException("Error de validación de la cita.");
    }
}
