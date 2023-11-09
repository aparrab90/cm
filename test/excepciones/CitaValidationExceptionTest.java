package excepciones;

import controlador.Controlador;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import modelo.CitaMedica;
import modelo.Paciente;
import modelo.DatosContacto;
import fabrica.CitaMedicaFactory;
import impresora.ConsoleCitasPrinter;
import java.time.LocalDate;

public class CitaValidationExceptionTest {

    private Controlador controlador;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        controlador = new Controlador((String[] parts) -> {
            throw new UnsupportedOperationException("Not supported yet.");
        }, new ConsoleCitasPrinter());
    }

    @Test
    public void testFinDeSemanaException() throws CitaValidationException {
        thrown.expect(FinDeSemanaException.class);
        // Configurar la cita para un día del fin de semana y comprobar que se lanza la excepción
        // Ejemplo con un sábado
        CitaMedica cita = new CitaMedica("2023-06-03", "10:00", "Consulta general", "Dr. Perez", 
                                          new Paciente("123", "Juan", "Pérez", "1980-01-01", 
                                          new DatosContacto("123456789", "juan@example.com"), null), false);
        controlador.verificarYAgregarCita(cita);
    }

    @Test
    public void testHorarioNoValidoException() throws CitaValidationException {
        thrown.expect(HorarioNoValidoException.class);
        // Configurar una cita fuera del horario de atención y comprobar que se lanza la excepción
        CitaMedica cita = new CitaMedica("2023-06-05", "22:00", "Consulta general", "Dr. Perez", 
                                          new Paciente("123", "Juan", "Pérez", "1980-01-01", 
                                          new DatosContacto("123456789", "juan@example.com"), null), false);
        controlador.verificarYAgregarCita(cita);
    }

    @Test
    public void testCitaSinAnticipacionException() throws CitaValidationException {
        thrown.expect(CitaSinAnticipacionException.class);
        // Configurar una cita sin la anticipación requerida y comprobar que se lanza la excepción
        String fechaCitaHoy = LocalDate.now().toString();
        CitaMedica cita = new CitaMedica(fechaCitaHoy, "10:00", "Consulta general", "Dr. Perez", 
                                          new Paciente("123", "Juan", "Pérez", "1980-01-01", 
                                          new DatosContacto("123456789", "juan@example.com"), null), false);
        controlador.verificarYAgregarCita(cita);
    }

    @Test
    public void testSinDisponibilidadException() throws CitaValidationException {
        thrown.expect(SinDisponibilidadException.class);
        // Configurar una cita en una fecha y hora donde ya no hay disponibilidad y comprobar que se lanza la excepción
        // Esta prueba puede ser más compleja porque requiere configurar el estado de 'mapaCitas' para simular que no hay disponibilidad.
        CitaMedica cita = new CitaMedica("2023-06-05", "10:00", "Consulta general", "Dr. Perez", 
                                          new Paciente("123", "Juan", "Pérez", "1980-01-01", 
                                          new DatosContacto("123456789", "juan@example.com"), null), false);
        // Aquí se simularía que ya hay una cita para esa fecha y hora en el 'mapaCitas' del controlador.
        controlador.verificarYAgregarCita(cita);
    }
}
