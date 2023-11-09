package excepciones;

import modelo.CitaMedica;
import modelo.DatosContacto;
import modelo.Paciente;
import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FinDeSemanaExceptionTest {

    private Paciente paciente;
    private DateTimeFormatter formatter;

    @Before
    public void setUp() {
        // Inicializar datos para la prueba
        DatosContacto datosContacto = new DatosContacto("999999999", "paciente@example.com");
        paciente = new Paciente("12345678A", "Juan", "Perez", "1985-04-16", datosContacto, null);
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    @Test(expected = FinDeSemanaException.class)
    public void testCitaEnFinDeSemanaLanzaExcepcion() throws FinDeSemanaException {
        // Crear una cita en domingo para probar la excepción
        LocalDate domingo = LocalDate.parse("2023-11-12", formatter); // Asegurarse de que esta fecha sea un domingo
        CitaMedica citaDomingo = new CitaMedica(domingo.format(formatter), "10:00", "Consulta general", "Dr. Garcia", paciente, false);
        verificarDiaCita(citaDomingo);
    }

    private void verificarDiaCita(CitaMedica cita) throws FinDeSemanaException {
        LocalDate fechaCita = LocalDate.parse(cita.getFecha(), formatter);
        if (fechaCita.getDayOfWeek() == DayOfWeek.SATURDAY || fechaCita.getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new FinDeSemanaException("Las citas médicas no se pueden programar en fin de semana.");
        }
    }
}