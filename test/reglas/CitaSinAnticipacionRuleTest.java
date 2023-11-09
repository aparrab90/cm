package reglas;

import excepciones.CitaSinAnticipacionException;
import excepciones.CitaValidationException;
import modelo.CitaMedica;
import modelo.Paciente;
import modelo.DatosContacto;
import modelo.Apoderado;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

import static org.junit.Assert.fail;

public class CitaSinAnticipacionRuleTest {

    private CitaSinAnticipacionRule rule;

    @Before
    public void setUp() {
        rule = new CitaSinAnticipacionRule();
    }

    @Test(expected = CitaSinAnticipacionException.class)
    public void testCitaEspecialistaSinAnticipacion() throws CitaSinAnticipacionException, CitaValidationException {
        DatosContacto datosContacto = new DatosContacto("098746782", "juanvelasquez@hotmail.com");
        Apoderado apoderado = new Apoderado("idApoderado", "Nombre Apoderado", "Apellido Apoderado", "1970-01-01", datosContacto);
        Paciente paciente = new Paciente("idPaciente", "Nombre Paciente", "Apellido Paciente", "2005-01-01", datosContacto, apoderado);
    
        // Crear una cita con la fecha de mañana para especialista, lo que debería lanzar la excepción.
        CitaMedica citaEspecialista = new CitaMedica(LocalDate.now().plusDays(1).toString(), "10:00", "ESPECIALISTA", "Cardiología", paciente, false);
        rule.validate(citaEspecialista);
    }

    @Test
    public void testCitaEspecialistaConAnticipacion() throws CitaValidationException {
        DatosContacto datosContacto = new DatosContacto("0998746783", "juanvelasquezz@hotmail.com");
        Apoderado apoderado = new Apoderado("idApoderado", "Nombre Apoderado", "Apellido Apoderado", "1970-01-01", datosContacto);
        Paciente paciente = new Paciente("idPaciente", "Nombre Paciente", "Apellido Paciente", "2005-01-01", datosContacto, apoderado);

        // Configurar una cita con más de 24 horas de anticipación para especialista.
        CitaMedica citaConAnticipacion = new CitaMedica(LocalDate.now().plusDays(2).toString(), "10:00", "ESPECIALISTA", "Cardiología", paciente, false);
        try {
            rule.validate(citaConAnticipacion);
        } catch (CitaSinAnticipacionException e) {
            fail("No debería haber lanzado CitaSinAnticipacionException porque la cita tiene la anticipación adecuada.");
        }
    }

    @Test
    public void testCitaNoEspecialista() throws CitaValidationException {
        DatosContacto datosContacto = new DatosContacto("0998746780", "juanvelasquezzz@hotmail.com");
        Apoderado apoderado = new Apoderado("idApoderado", "Nombre Apoderado", "Apellido Apoderado", "1970-01-01", datosContacto);
        Paciente paciente = new Paciente("idPaciente", "Nombre Paciente", "Apellido Paciente", "2005-01-01", datosContacto, apoderado);

        // Crear una cita que no sea de tipo ESPECIALISTA para asegurarse de que la regla no se aplica incorrectamente.
        CitaMedica citaGeneral = new CitaMedica(LocalDate.now().plusDays(1).toString(), "10:00", "GENERAL", "Medicina General", paciente, false);
        try {
            rule.validate(citaGeneral);
            // La validación pasó correctamente sin lanzar excepción.
        } catch (CitaSinAnticipacionException e) {
            fail("No debería haber lanzado CitaSinAnticipacionException para citas que no son de especialistas.");
        }
    }
}
