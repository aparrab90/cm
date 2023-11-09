package fabrica;

import modelo.CitaMedica;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SimpleCitaMedicaFactoryTest {

    private SimpleCitaMedicaFactory factory;

    @Before
    public void setUp() {
        factory = new SimpleCitaMedicaFactory();
    }

    @Test
    public void testCreateCitaMedicaWithValidData() {
        // Supongamos que los datos necesarios para crear una CitaMedica son fecha, hora, tipo, y médico.
        String[] data = {"2023-11-10", "15:00", "Consulta General", "Dr. Perez"};

        CitaMedica cita = factory.createCitaMedica(data);

        assertNotNull("CitaMedica should not be null", cita);
        assertEquals("The date should match the input", "2023-11-10", cita.getFecha());
        assertEquals("The time should match the input", "15:00", cita.getHora());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateCitaMedicaWithInvalidData() {
        // Datos inválidos que deberían lanzar una excepción al intentar crear una CitaMedica
        String[] data = {"invalid-date", "25:61", "Consulta General", "Dr. Perez"};

        factory.createCitaMedica(data);
    }
}