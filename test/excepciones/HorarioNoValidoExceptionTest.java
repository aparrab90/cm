package excepciones;

import org.junit.Test;
import static org.junit.Assert.*;

public class HorarioNoValidoExceptionTest {

    @Test
    public void testExceptionMessage() {
        String expectedMessage = "La cita está fuera del horario de atención.";
        HorarioNoValidoException exception = new HorarioNoValidoException(expectedMessage);
        
        assertEquals("El mensaje de la excepción debe ser igual al esperado.", expectedMessage, exception.getMessage());
    }
    
    @Test(expected = HorarioNoValidoException.class)
    public void testExceptionIsThrown() throws HorarioNoValidoException {
        throw new HorarioNoValidoException("La cita está fuera del horario de atención.");
    }
}