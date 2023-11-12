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

public class HorariosFuturos {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testHorariosFuturos() {
        try {
            String testFilePath = "test\\resources\\med_input_HorarioFuturo.txt";

            File file = new File(testFilePath);
            assertTrue("El archivo de prueba debe existir", file.exists() && file.isFile());

            String[] args = {testFilePath};
            ReservaCitasMedicas.main(args);

            String output = outContent.toString();
            assertTrue("Debe contener mensaje de error", 
                       output.contains("Las citas deben ser programadas para el futuro"));

        } catch (CitaValidationException | IOException | ClassNotFoundException e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}