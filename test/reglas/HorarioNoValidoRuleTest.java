package reglas;

import excepciones.CitaValidationException;
import excepciones.HorarioNoValidoException;
import java.time.DayOfWeek;
import modelo.CitaMedica;
import modelo.Paciente;
import modelo.DatosContacto;
import modelo.Apoderado;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class HorarioNoValidoRuleTest {

    private HorarioNoValidoRule rule;

    @Before
    public void setUp() {
        rule = new HorarioNoValidoRule();
    }

    @Test(expected = HorarioNoValidoException.class)
    public void testCitaAntesDeHorario() throws HorarioNoValidoException, CitaValidationException {
        // Este test asume que la cita es en un día laboral cualquiera que no sea viernes.
        LocalDate diaLaboral = LocalDate.now().with(DayOfWeek.THURSDAY);
        LocalTime horaAntesDeInicio = HorarioNoValidoRule.INICIO_JORNADA.minusHours(1);
    
        verificarCita("idPaciente", diaLaboral.toString(), horaAntesDeInicio.toString());
    }

    @Test(expected = HorarioNoValidoException.class)
    public void testCitaDespuesDeHorario() throws HorarioNoValidoException, CitaValidationException {
        // Este test asume que la cita es en un día laboral cualquiera que no sea viernes.
        LocalDate diaLaboral = LocalDate.now().with(DayOfWeek.THURSDAY);
        LocalTime horaDespuesDeCierre = HorarioNoValidoRule.FIN_JORNADA.plusHours(1);

        verificarCita("idPaciente", diaLaboral.toString(), horaDespuesDeCierre.toString());
    }

    @Test(expected = HorarioNoValidoException.class)
    public void testCitaDespuesDeHorarioEnViernes() throws HorarioNoValidoException, CitaValidationException {
        LocalDate viernes = LocalDate.now().with(DayOfWeek.FRIDAY);
        LocalTime horaDespuesDeCierreViernes = HorarioNoValidoRule.FIN_JORNADA_VIERNES.plusHours(1);

        verificarCita("idPaciente", viernes.toString(), horaDespuesDeCierreViernes.toString());
    }

    @Test
    public void testCitaDentroDeHorario() throws CitaValidationException {
        // Este test asume que la cita es en un día laboral cualquiera que no sea viernes.
        LocalDate diaLaboral = LocalDate.now().with(DayOfWeek.THURSDAY);
        LocalTime horaDentroDeJornada = HorarioNoValidoRule.INICIO_JORNADA.plusHours(1);

        try {
            verificarCita("idPaciente", diaLaboral.toString(), horaDentroDeJornada.toString());
        } catch (HorarioNoValidoException e) {
            fail("No debería haber lanzado HorarioNoValidoException para una cita dentro del horario de atención.");
        }
    }

    private void verificarCita(String idPaciente, String fecha, String hora) throws HorarioNoValidoException, CitaValidationException {
        DatosContacto datosContacto = new DatosContacto("098746782", "juanvelasquez@hotmail.com");
        Apoderado apoderado = new Apoderado("idApoderado", "Nombre Apoderado", "Apellido Apoderado", "1970-01-01", datosContacto);
        Paciente paciente = new Paciente(idPaciente, "Nombre Paciente", "Apellido Paciente", "2005-01-01", datosContacto, apoderado);

        CitaMedica cita = new CitaMedica(fecha, hora, "GENERAL", "Medicina General", paciente, false);
        rule.validate(cita);
    }
}
