package reservacitasmedicas;

import excepciones.CitaValidationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ReservaCitasMedicasTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testMain() {
        try {
            // Ruta al archivo de prueba
            String testFilePath = "test\\resources\\med_input_ok.txt";

            // Verificar que el archivo de prueba exista
            File file = new File(testFilePath);
            assertTrue("El archivo de prueba debe existir", file.exists() && file.isFile());

            // Ejecutar el método principal
            String[] args = {testFilePath};
            ReservaCitasMedicas.main(args);

            // Verificar que la salida contenga información esperada
            String output = outContent.toString();
            assertTrue("La salida debe contener información de las citas", output.contains("2023-11-14 ") || output.contains("MARIA"));

        } catch (CitaValidationException | IOException | ClassNotFoundException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}