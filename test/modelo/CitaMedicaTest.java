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
        // Datos de prueba
        String fecha = "2023-11-08";
        String hora = "14:00";
        String tipo = "GENERAL";
        String especialidad = "Medicina General";
        boolean nuevaCita = true;

        // Configurar datos de contacto y paciente
        datosContacto = new DatosContacto("0998746782", "juanvelasquez@hotmail.com");
        paciente = new Paciente("1717937849", "Juan", "Velásquez", "1989-05-20", datosContacto, null);

        // Crear la cita médica con los datos de prueba
        citaMedica = new CitaMedica(fecha, hora, tipo, especialidad, paciente, nuevaCita);
    }

    @Test
    public void testIsNuevaCita() {
        assertTrue("El valor de nueva cita debería ser verdadero", citaMedica.isNuevacita());
    }

    @Test
    public void testGetPaciente() {
        assertEquals("Los objetos paciente deben ser iguales", paciente, citaMedica.getPaciente());
    }

    @Test
    public void testGetFecha() {
        assertEquals("Las fechas deben coincidir", "2023-11-08", citaMedica.getFecha());
    }

    @Test
    public void testGetHora() {
        assertEquals("Las horas deben coincidir", "14:00", citaMedica.getHora());
    }

    @Test
    public void testGetTipo() {
        assertEquals("Los tipos deben coincidir", "GENERAL", citaMedica.getTipo());
    }

    @Test
    public void testGetEspecialidad() {
        assertEquals("Las especialidades deben coincidir", "Medicina General", citaMedica.getEspecialidad());
    }
}
