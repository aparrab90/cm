package reglas;

import excepciones.CitaValidationException;
import excepciones.SinDisponibilidadException;
import modelo.CitaMedica;
import modelo.Paciente;
import modelo.DatosContacto;
import modelo.Apoderado;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SinDisponibilidadRuleTest {

    private SinDisponibilidadRule rule;
    private Map<LocalDate, LinkedList<CitaMedica>> mapaCitas;
    private final LocalDate fechaPrueba = LocalDate.now();

    @Before
    public void setUp() {
        mapaCitas = new HashMap<>();
        rule = new SinDisponibilidadRule(mapaCitas);
    }

    @Test(expected = SinDisponibilidadException.class)
    public void testSinDisponibilidadEspecialista() throws SinDisponibilidadException, CitaValidationException {
        llenarCitas("ESPECIALISTA", SinDisponibilidadRule.MAX_ESPECIALISTAS);
        verificarCita("ESPECIALISTA", "idPacienteNuevo");
    }

    @Test(expected = SinDisponibilidadException.class)
    public void testSinDisponibilidadGeneral() throws SinDisponibilidadException, CitaValidationException {
        llenarCitas("GENERAL", SinDisponibilidadRule.MAX_GENERALES);
        verificarCita("GENERAL", "idPacienteNuevo");
    }

    @Test
    public void testConDisponibilidadEspecialista() throws CitaValidationException {
        llenarCitas("ESPECIALISTA", SinDisponibilidadRule.MAX_ESPECIALISTAS - 1);
        try {
            verificarCita("ESPECIALISTA", "idPacienteNuevo");
        } catch (SinDisponibilidadException e) {
            fail("No debería haber lanzado SinDisponibilidadException para una cita con disponibilidad.");
        }
    }

    @Test
    public void testConDisponibilidadGeneral() throws CitaValidationException {
        llenarCitas("GENERAL", SinDisponibilidadRule.MAX_GENERALES - 1);
        try {
            verificarCita("GENERAL", "idPacienteNuevo");
        } catch (SinDisponibilidadException e) {
            fail("No debería haber lanzado SinDisponibilidadException para una cita con disponibilidad.");
        }
    }

    private void llenarCitas(String tipo, int cantidad) {
        LinkedList<CitaMedica> citas = mapaCitas.computeIfAbsent(fechaPrueba, k -> new LinkedList<>());
        for (int i = 0; i < cantidad; i++) {
            citas.add(crearCita(tipo, "idPaciente" + i));
        }
    }

    private CitaMedica crearCita(String tipo, String idPaciente) {
        DatosContacto datosContacto = new DatosContacto("098746782", "juanvelasquez@hotmail.com");
        Apoderado apoderado = new Apoderado("idApoderado", "Nombre Apoderado", "Apellido Apoderado", "1970-01-01", datosContacto);
        Paciente paciente = new Paciente(idPaciente, "Nombre Paciente", "Apellido Paciente", "2005-01-01", datosContacto, apoderado);

        return new CitaMedica(fechaPrueba.toString(), "09:00", tipo, "Medicina General", paciente, false);
    }

    private void verificarCita(String tipo, String idPaciente) throws SinDisponibilidadException, CitaValidationException {
        CitaMedica cita = crearCita(tipo, idPaciente);
        rule.validate(cita);
    }
}
