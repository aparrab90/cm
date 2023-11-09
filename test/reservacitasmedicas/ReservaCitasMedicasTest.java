package reservacitasmedicas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertTrue;

public class ReservaCitasMedicasTest {

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
    public void testMain() throws Exception {
        // Preparar el entorno de prueba
        String[] args = {"src\\resources\\med_input.txt"};
        
        // Llamar al método main
        ReservaCitasMedicas.main(args);
        
        // Por ejemplo, puedes verificar que se imprimió la palabra 'Fecha:'
        String output = outContent.toString();
        assertTrue("Debe imprimir la palabra 'Fecha:'", output.contains("Fecha:"));
    }
}
