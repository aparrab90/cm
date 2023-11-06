/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reservacitasmedicas;

import controlador.Controlador;
import excepciones.CitaValidationException;
import fabrica.*;
import impresora.ConsoleCitasPrinter;
import java.io.IOException;

/**
 *
 * @author gyecsisap
 */
public class ReservaCitasMedicas {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     * @throws excepciones.CitaValidationException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, CitaValidationException {
        String filePath = "src\\resources\\med_input.txt"; // Reemplaza con la ruta real de tu archiv
           CitaMedicaFactory factory = new SimpleCitaMedicaFactory();
        ConsoleCitasPrinter printer = new ConsoleCitasPrinter();
        Controlador controlador = new Controlador(factory, printer);
        controlador.cargarCitasMedicas(filePath);
        controlador.imprimirCitas();
    }

}
