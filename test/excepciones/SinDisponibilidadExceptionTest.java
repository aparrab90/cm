package excepciones;

import org.junit.Test;
import static org.junit.Assert.*;

public class SinDisponibilidadExceptionTest {

    @Test
    public void testExceptionMessage() {
        String expectedMessage = "No hay disponibilidad para el profesional seleccionado en ese horario.";
        SinDisponibilidadException exception = new SinDisponibilidadException(expectedMessage);
        
        assertEquals("El mensaje de la excepción debe ser igual al esperado.", expectedMessage, exception.getMessage());
    }
    
    @Test(expected = SinDisponibilidadException.class)
    public void testExceptionIsThrown() throws SinDisponibilidadException {
        throw new SinDisponibilidadException("No hay disponibilidad para el profesional seleccionado en ese horario.");
    }
}