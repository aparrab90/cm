package fabrica;

import modelo.CitaMedica;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CitaMedicaFactoryTest {

    private CitaMedicaFactory factory;

    @Before
    public void setUp() {
        factory = new SimpleCitaMedicaFactory();
    }

    @Test
    public void testCreateCitaMedica() {
        String[] parts = {"2023-11-08", "15:00", "General", "Dermatología", "1", "false"};
        CitaMedica citaMedica = factory.createCitaMedica(parts);

        assertNotNull("La cita médica no debería ser null", citaMedica);
        assertEquals("La fecha no coincide", "2023-11-08", citaMedica.getFecha());
        assertEquals("La hora no coincide", "15:00", citaMedica.getHora());
        assertEquals("El tipo no coincide", "General", citaMedica.getTipo());
        assertEquals("La especialidad no coincide", "Dermatología", citaMedica.getEspecialidad());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateCitaMedicaWithInvalidData() {
        String[] invalidParts = {"2023-11-08", "15:00"}; // Datos insuficientes para crear una cita médica
        factory.createCitaMedica(invalidParts);
    }
}
