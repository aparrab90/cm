package excepciones;

import modelo.CitaMedica;
import modelo.DatosContacto;
import modelo.Paciente;
import org.junit.Before;
import org.junit.Test;

public class HorarioNoValidoExceptionTest {

    private CitaMedica citaMedica;

    @Before
    public void setUp() {
        // Preparar datos para la prueba
        Paciente paciente = new Paciente("12345678X", "Ana", "Lopez", "1990-05-15", new DatosContacto("999888777", "ana.lopez@example.com"), null);
        citaMedica = new CitaMedica("2023-07-15", "17:00", "Revision General", "Dr. Sanchez", paciente, false);
    }

    @Test(expected = HorarioNoValidoException.class)
    public void testHorarioNoValidoLanzaExcepcion() throws HorarioNoValidoException {
        // Intenta crear una cita en un horario no permitido
        validarHorario(citaMedica);
    }

    // Método de ejemplo que representa la validación de horario en el negocio
    private void validarHorario(CitaMedica cita) throws HorarioNoValidoException {
        String horario = cita.getHora();
        // Suponemos que el horario válido es de 08:00 a 16:00
        if (horario.compareTo("08:00") < 0 || horario.compareTo("16:00") > 0) {
            throw new HorarioNoValidoException("El horario de la cita " + horario + " está fuera del horario permitido.");
        }
    }
}