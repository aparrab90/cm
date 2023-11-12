package impresora;

import static org.junit.Assert.assertTrue;

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
        // Crear instancia de ConsoleCitasPrinter
        ConsoleCitasPrinter printer = new ConsoleCitasPrinter();

        // Crear datos de prueba
        LocalDate date = LocalDate.of(2023, 11, 8);
        CitaMedica citaMedica = new CitaMedica("2023-11-08", "15:00", "General", "Dermatología", new Paciente(), true);
        LinkedList<CitaMedica> citasList = new LinkedList<>();
        citasList.add(citaMedica);

        Map<LocalDate, LinkedList<CitaMedica>> mapaCitas = new HashMap<>();
        mapaCitas.put(date, citasList);

        // Ejecutar método que se está probando
        printer.printCitas(mapaCitas);

        // Crear el String esperado
        String expectedOutput = "Fecha: " + date + System.lineSeparator() +
                "\tCitaMedica{fecha=" + citaMedica.getFecha() + ", hora=" + citaMedica.getHora() + ", tipo=" + citaMedica.getTipo() +
                ", especialidad=" + citaMedica.getEspecialidad() + ", paciente=" + citaMedica.getPaciente().toString() + ", nuevacita=" + citaMedica.isNuevacita() + "}" + System.lineSeparator();

        // Verificar que la salida capturada contiene el String esperado
        assertTrue("La salida impresa no coincide con el formato esperado.", outContent.toString().contains(expectedOutput));
    }
}