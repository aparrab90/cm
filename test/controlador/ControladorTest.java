package controlador;

import excepciones.*;
import fabrica.CitaMedicaFactory;
import fabrica.SimpleCitaMedicaFactory;
import impresora.ConsoleCitasPrinter;
import modelo.CitaMedica;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import org.junit.After;

import static org.junit.Assert.*;

public class ControladorTest {

    private Controlador controlador;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        // Redireccionar salida estándar al stream de salida para pruebas.
        System.setOut(new PrintStream(outContent));

        // Aquí se instancian las dependencias de Controlador y luego el Controlador mismo.
        CitaMedicaFactory factory = new SimpleCitaMedicaFactory();
        ConsoleCitasPrinter printer = new ConsoleCitasPrinter();
        controlador = new Controlador(factory, printer);
    }

    @Test
    public void agregarCitaYVerificarMapa() throws CitaValidationException {
        // Creamos una cita médica de prueba (los parámetros deben ser válidos para las reglas de validación)
        CitaMedica cita = new CitaMedica("2023-11-08", "10:00", "CONSULTA", "Proctólogo", null, false);

        // Verificar y agregar la cita
        controlador.verificarYAgregarCita(cita);

        // Obtener el mapa de citas del controlador
        Map<LocalDate, LinkedList<CitaMedica>> mapaCitas = controlador.getMapaCitas();

        // Verificar si el mapa contiene la fecha de la cit
        assertTrue("El mapa debe contener la fecha de la cita", mapaCitas.containsKey(LocalDate.of(2023, 11, 8)));

        // Verificar si la cita ha sido agregada correctamente
        assertTrue("La lista de citas para la fecha debe contener la cita creada", 
            mapaCitas.get(LocalDate.of(2023, 11, 8)).contains(cita));
    }

    @Test(expected = FinDeSemanaException.class)
    public void agregarCitaEnFinDeSemanaDebeFallar() throws CitaValidationException {
        // Intentar agregar una cita en un día del fin de semana para forzar la excepción
        CitaMedica cita = new CitaMedica("2023-11-11", "10:00", "CONSULTA", "Dermatologo", null, false);

        // Esto debe lanzar FinDeSemanaException
        controlador.verificarYAgregarCita(cita);
    }
        
    // Limpiamos las pruebas
    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
