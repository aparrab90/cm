package PruebasUnitariasFuncionales;

import excepciones.CitaValidationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import reservacitasmedicas.ReservaCitasMedicas;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class PacienteMenorEdad {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testPacienteMenorEdad() {
        try {
            String testFilePath = "test\\resources\\med_input_PacienteMenorEdad.txt";

            File file = new File(testFilePath);
            assertTrue("El archivo de prueba debe existir", file.exists() && file.isFile());

            String[] args = {testFilePath};
            ReservaCitasMedicas.main(args);

            String output = outContent.toString();
            assertTrue("Debe contener mensaje de error", 
                       output.contains("Apoderado inválido para la cita"));
            assertTrue("Debe contener mensaje de error", 
                       output.contains("Apoderado menor de edad para la cita"));

        } catch (CitaValidationException | IOException | ClassNotFoundException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}