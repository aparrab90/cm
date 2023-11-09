package modelo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CitaMedicaTest {

    private CitaMedica citaMedica;
    private Paciente paciente;
    private DatosContacto datosContacto;

    @Before
    public void setUp() {
        datosContacto = new DatosContacto("correo@example.com", "555-5555");
        paciente = new Paciente("ID12345", "Juan", "Perez", "1990-01-01", datosContacto, null);
        citaMedica = new CitaMedica("2023-11-08", "08:00", "General", "Cardiología", paciente, true);
    }

    @Test
    public void testGetFecha() {
        assertEquals("2023-11-08", citaMedica.getFecha());
    }

    @Test
    public void testGetHora() {
        assertEquals("08:00", citaMedica.getHora());
    }

    @Test
    public void testGetTipo() {
        assertEquals("General", citaMedica.getTipo());
    }

    @Test
    public void testGetEspecialidad() {
        assertEquals("Cardiología", citaMedica.getEspecialidad());
    }

    @Test
    public void testGetPaciente() {
        assertEquals(paciente, citaMedica.getPaciente());
    }

    @Test
    public void testToString() {
        String expected = "CitaMedica{fecha=2023-11-08, hora=08:00, tipo=General, especialidad=Cardiología, paciente=" + paciente.toString() + ", nuevaCita=true}";
        assertEquals(expected, citaMedica.toString());
    }
}
