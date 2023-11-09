package excepciones;

import org.junit.Test;
import static org.junit.Assert.*;

public class FinDeSemanaExceptionTest {

    @Test
    public void testExceptionMessage() {
        String expectedMessage = "No se puede agendar citas en fines de semana.";
        FinDeSemanaException exception = new FinDeSemanaException(expectedMessage);
        
        assertEquals("El mensaje de la excepción debe ser igual al esperado.", expectedMessage, exception.getMessage());
    }
    
    @Test(expected = FinDeSemanaException.class)
    public void testExceptionIsThrown() throws FinDeSemanaException {
        throw new FinDeSemanaException("No se puede agendar citas en fines de semana.");
    }
}