package impresora;

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
import java.util.HashMap;

import static org.junit.Assert.*;

public class ConsoleCitasPrinterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testPrintCitas() {
        // Crear un mapa de citas de prueba
        Map<LocalDate, LinkedList<CitaMedica>> citasMap = new HashMap<>();
        LinkedList<CitaMedica> citas = new LinkedList<>();
        Paciente paciente = new Paciente("123456789", "John", "Doe", "Dolor de cabeza", new DatosContacto("555-1234", "johndoe@example.com"), null);
        CitaMedica cita = new CitaMedica("2023-11-08", "10:00", "General", "Medicina", paciente, false);
        citas.add(cita);
        citasMap.put(LocalDate.of(2023, 11, 8), citas);

        // Crear instancia de ConsoleCitasPrinter
        ConsoleCitasPrinter printer = new ConsoleCitasPrinter();

        // Llamar al método printCitas
        printer.printCitas(citasMap);

        // Verificar si la salida contiene los datos esperados
        String expectedOutput = "Fecha: 2023-11-08\n" +
                                "Hora: 10:00\n" +
                                "Tipo: General\n" +
                                "Especialidad: Medicina\n" +
                                "Paciente: John Doe\n\n"; // Ajustar según el formato real de ConsoleCitasPrinter
        assertEquals("La salida no coincide con la esperada", expectedOutput, outContent.toString());
    }
}