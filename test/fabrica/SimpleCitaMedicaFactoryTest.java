package fabrica;

import modelo.CitaMedica;
import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleCitaMedicaFactoryTest {

    @Test
    public void testCreateCitaMedica() {
        SimpleCitaMedicaFactory factory = new SimpleCitaMedicaFactory();

        // Datos simulados
        String[] parts = {"2023-11-08", "15:00", "General", "Dermatología"};

        // Creación de la cita médica utilizando la fábrica
        CitaMedica citaMedica = factory.createCitaMedica(parts);

        // Comprobar que los datos de la cita médica son correctos
        assertNotNull("La cita médica no debería ser null", citaMedica);
        assertEquals("La fecha no coincide", "2023-11-08", citaMedica.getFecha());
        assertEquals("La hora no coincide", "15:00", citaMedica.getHora());
        assertEquals("El tipo no coincide", "General", citaMedica.getTipo());
        assertEquals("La especialidad no coincide", "Dermatología", citaMedica.getEspecialidad());
        assertNotNull("El paciente no debería ser null", citaMedica.getPaciente());
        assertTrue("La cita debería ser marcada como nueva", citaMedica.isNuevacita());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testCreateCitaMedicaWithInsufficientData() {
        SimpleCitaMedicaFactory factory = new SimpleCitaMedicaFactory();

        // Datos insuficientes para crear una cita médica
        String[] insufficientParts = {"2023-11-08", "15:00"};

        // Intento de creación de la cita médica que debería lanzar una excepción
        factory.createCitaMedica(insufficientParts);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateCitaMedicaWithNullData() {
        SimpleCitaMedicaFactory factory = new SimpleCitaMedicaFactory();

        // Pasar null debería lanzar una excepción
        factory.createCitaMedica(null);
    }
}