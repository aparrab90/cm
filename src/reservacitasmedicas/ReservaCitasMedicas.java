
package reservacitasmedicas;

import controlador.Controlador;
import excepciones.CitaValidationException;
import fabrica.*;
import impresora.ConsoleCitasPrinter;
import java.io.IOException;
import servicios.CitaLoader;

public class ReservaCitasMedicas {

    public static void main(String[] args) throws IOException, ClassNotFoundException, CitaValidationException {
        String filePath = "src\\resources\\med_input.txt"; // Reemplaza con la ruta real de tu archiv
           CitaMedicaFactory factory = new SimpleCitaMedicaFactory();
        ConsoleCitasPrinter printer = new ConsoleCitasPrinter();
        Controlador controlador = new Controlador(factory, printer);
        CitaLoader  citaLoader = new CitaLoader (factory, controlador);
        citaLoader.cargarCitasMedicas(filePath);
        controlador.imprimirCitas();
    }

}
