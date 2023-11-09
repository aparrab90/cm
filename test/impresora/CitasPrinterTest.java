package impresora;

import modelo.CitaMedica;
import modelo.Paciente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class CitasPrinterTest {

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
        // Crear la implementación de CitasPrinter
        CitasPrinter printer = new CitasPrinterImpl();

        // Crear datos de prueba
        LocalDate date = LocalDate.now();
        CitaMedica citaMedica = new CitaMedica("2023-11-08", "15:00", "General", "Dermatología", new Paciente(), true);
        LinkedList<CitaMedica> citasList = new LinkedList<>();
        citasList.add(citaMedica);

        Map<LocalDate, LinkedList<CitaMedica>> mapaCitas = new HashMap<>();
        mapaCitas.put(date, citasList);

        // Llamar al método printCitas
        printer.printCitas(mapaCitas);

        // Verificar que la salida está correcta
        String expectedOutput = "Citas para el día " + date.toString() + ":\n" +
                "[CitaMedica{fecha=2023-11-08, hora=15:00, tipo=General, especialidad=Dermatología, paciente=Paciente{}, nuevacita=true}]\n";
        assertTrue("La impresión de la cita no coincide con lo esperado.", outContent.toString().contains(expectedOutput));
    }

    // Una clase ficticia
    private class CitasPrinterImpl implements CitasPrinter {
        @Override
        public void printCitas(Map<LocalDate, LinkedList<CitaMedica>> mapaCitas) {
            mapaCitas.forEach((date, citas) -> {
                System.out.println("Citas para el día " + date.toString() + ":");
                System.out.println(citas.toString());
            });
        }
    }
}
