package excepciones;

import modelo.CitaMedica;
import modelo.DatosContacto;
import modelo.Paciente;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class SinDisponibilidadExceptionTest {

    private Paciente paciente;
    private DateTimeFormatter formatter;
    private Map<LocalDate, LinkedList<CitaMedica>> mapaCitas;

    @Before
    public void setUp() {
        // Inicializar datos para la prueba
        DatosContacto datosContacto = new DatosContacto("999999999", "paciente@example.com");
        paciente = new Paciente("12345678A", "Juan", "Perez", "1985-04-16", datosContacto, null);
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        mapaCitas = new HashMap<>();
    }

    @Test(expected = SinDisponibilidadException.class)
    public void testAgregarCitaCuandoNoHayDisponibilidad() throws SinDisponibilidadException {
        // Configurar una fecha y hora específica
        LocalDate fecha = LocalDate.parse("2023-11-15", formatter);
        String hora = "10:00";

        // Agregar una cita en la fecha y hora especificada
        CitaMedica citaExistente = new CitaMedica(fecha.format(formatter), hora, "Consulta general", "Dr. Garcia", paciente, false);
        agregarCita(citaExistente);

        // Intentar agregar otra cita en la misma fecha y hora
        CitaMedica nuevaCita = new CitaMedica(fecha.format(formatter), hora, "Revisión anual", "Dr. Lopez", paciente, false);
        agregarCita(nuevaCita); // Esto debería lanzar la excepción
    }

    private void agregarCita(CitaMedica cita) throws SinDisponibilidadException {
        LocalDate fechaCita = LocalDate.parse(cita.getFecha(), formatter);
        LinkedList<CitaMedica> citasDelDia = mapaCitas.computeIfAbsent(fechaCita, k -> new LinkedList<>());

        for (CitaMedica citaExistente : citasDelDia) {
            if (citaExistente.getHora().equals(cita.getHora())) {
                throw new SinDisponibilidadException("Ya existe una cita para la fecha y hora seleccionadas.");
            }
        }
        citasDelDia.add(cita);
    }
}