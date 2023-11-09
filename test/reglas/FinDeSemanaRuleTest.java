package reglas;

import excepciones.CitaValidationException;
import excepciones.FinDeSemanaException;
import java.time.DayOfWeek;
import modelo.CitaMedica;
import modelo.Paciente;
import modelo.DatosContacto;
import modelo.Apoderado;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class FinDeSemanaRuleTest {

    private FinDeSemanaRule rule;

    @Before
    public void setUp() {
        rule = new FinDeSemanaRule();
    }

    @Test(expected = FinDeSemanaException.class)
    public void testCitaEnSabado() throws FinDeSemanaException, CitaValidationException {
        DatosContacto datosContacto = new DatosContacto("5551234", "juanvelasquez@hotmail.com");
        Apoderado apoderado = new Apoderado("idApoderado", "Nombre Apoderado", "Apellido Apoderado", "1970-01-01", datosContacto);
        Paciente paciente = new Paciente("idPaciente", "Nombre Paciente", "Apellido Paciente", "2005-01-01", datosContacto, apoderado);
    
        // Asumiendo que se prueba en un día que no es sábado, obtenemos el próximo sábado.
        LocalDate proximoSabado = LocalDate.now().with(DayOfWeek.SATURDAY);

        CitaMedica cita = new CitaMedica(proximoSabado.toString(), "10:00", "GENERAL", "Medicina General", paciente, false);
        rule.validate(cita);
    }

    @Test(expected = FinDeSemanaException.class)
    public void testCitaEnDomingo() throws FinDeSemanaException, CitaValidationException {
        DatosContacto datosContacto = new DatosContacto("098746782", "juanvelasquezz@hotmail.com");
        Apoderado apoderado = new Apoderado("idApoderado", "Nombre Apoderado", "Apellido Apoderado", "1970-01-01", datosContacto);
        Paciente paciente = new Paciente("idPaciente", "Nombre Paciente", "Apellido Paciente", "2005-01-01", datosContacto, apoderado);
        
        // Asumiendo que se prueba en un día que no es domingo, obtenemos el próximo domingo.
        LocalDate proximoDomingo = LocalDate.now().with(DayOfWeek.SUNDAY);

        CitaMedica cita = new CitaMedica(proximoDomingo.toString(), "10:00", "GENERAL", "Medicina General", paciente, false);
        rule.validate(cita);
    }

    @Test
    public void testCitaEnDiaDeSemana() throws CitaValidationException {
        DatosContacto datosContacto = new DatosContacto("098746783", "juanvelasquezz@hotmail.com");
        Apoderado apoderado = new Apoderado("idApoderado", "Nombre Apoderado", "Apellido Apoderado", "1970-01-01", datosContacto);
        Paciente paciente = new Paciente("idPaciente", "Nombre Paciente", "Apellido Paciente", "2005-01-01", datosContacto, apoderado);
        
        // Asumiendo que se prueba en un día que no es de fin de semana, obtenemos el próximo lunes.
        LocalDate proximoLunes = LocalDate.now().with(DayOfWeek.MONDAY);

        CitaMedica cita = new CitaMedica(proximoLunes.toString(), "10:00", "GENERAL", "Medicina General", paciente, false);
        try {
            rule.validate(cita);
        } catch (FinDeSemanaException e) {
            fail("No debería haber lanzado FinDeSemanaException para citas en días de semana.");
        }
    }
}
