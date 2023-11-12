package servicios;

import controlador.Controlador;
import fabrica.SimpleCitaMedicaFactory;
import impresora.ConsoleCitasPrinter;
import modelo.CitaMedica;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.Assert.*;

public class CitaLoaderTest {

    private Controlador controlador;
    private CitaLoader citaLoader;
    private String testFilePath = "test_med_input.txt";

    @Before
    public void setUp() throws IOException {
        // Crear un archivo de prueba
        crearArchivoDePrueba(testFilePath);

        // Configurar el Controlador y el CitaLoader
        controlador = new Controlador(new SimpleCitaMedicaFactory(), new ConsoleCitasPrinter());
        citaLoader = new CitaLoader(new SimpleCitaMedicaFactory(), controlador);
    }

    @Test
    public void testCargarCitasMedicas() throws Exception {
        // Cargar citas desde el archivo de prueba
        citaLoader.cargarCitasMedicas(testFilePath);

        // Verificar que las citas se han cargado correctamente
        Map<LocalDate, LinkedList<CitaMedica>> mapaCitas = controlador.getMapaCitas();
        assertFalse("El mapa de citas no debe estar vacío", mapaCitas.isEmpty());
    }

    private void crearArchivoDePrueba(String filePath) throws IOException {
        File file = new File(filePath);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("2023-11-08\n");
            writer.write("08:00|GENERAL|Dermatología|Juan Pérez|ADULTO|C|0101010101|0990000001|1986-01-01|\n");
        }
    }

    // Limpiar después de las pruebas
    @org.junit.After
    public void tearDown() {
        new File(testFilePath).delete();
    }
}