package controlador;

import fabrica.CitaMedicaFactory;
import fabrica.SimpleCitaMedicaFactory;
import impresora.ConsoleCitasPrinter;
import modelo.CitaMedica;
import modelo.Paciente;
import modelo.DatosContacto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.Assert.*;

public class ControladorTest {

    private Controlador controlador;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        CitaMedicaFactory factory = new SimpleCitaMedicaFactory();
        ConsoleCitasPrinter printer = new ConsoleCitasPrinter();
        controlador = new Controlador(factory, printer);
    }

    @Test
    public void testAgregarYImprimirCitas() {
        DatosContacto contacto = new DatosContacto("555-1234", "paciente@example.com");
        Paciente paciente = new Paciente("123", "Nombre", "Apellido", "1990-01-01", contacto, null);
        CitaMedica cita = new CitaMedica("2023-11-08", "09:00", "General", "Medicina", paciente, true);

        // Agregar cita
        controlador.agregarCita(cita);

        // Verificar que la cita se haya agregado correctamente
        Map<LocalDate, LinkedList<CitaMedica>> mapaCitas = controlador.getMapaCitas();
        assertTrue("El mapa debe contener la fecha de la cita", mapaCitas.containsKey(LocalDate.of(2023, 11, 8)));
        assertTrue("La lista de citas debe contener la cita agregada", mapaCitas.get(LocalDate.of(2023, 11, 8)).contains(cita));

        // Imprimir citas y verificar la salida
        controlador.imprimirCitas();
        String output = outContent.toString();
        assertTrue("La salida impresa debe contener la información de la cita", output.contains("Fecha: 2023-11-08") && output.contains("09:00") && output.contains("General") && output.contains("Medicina"));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}