package controlador;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import modelo.CitaMedica;
import excepciones.*;
import fabrica.CitaMedicaFactory;
import impresora.ConsoleCitasPrinter;

import java.time.LocalDate;
import modelo.DatosContacto;
import modelo.Paciente;

public class ControladorTest {

    private Controlador controlador;
    private ConsoleCitasPrinter citasPrinter; // Esta podría ser una versión stub si es necesario

    @Before
    public void setUp() {
        controlador = new Controlador(new CitaMedicaFactory() {
            @Override
            public CitaMedica createCitaMedica(String[] parts) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        }, new ConsoleCitasPrinter());
    }

    @Test
    public void testAgregarCitaValida() throws CitaValidationException {
        // Crear una cita médica de prueba
        CitaMedica cita = new CitaMedica("2023-11-10", "09:00", "Consulta general", "Dr. Perez", new Paciente("123", "Juan", "Pérez", "1980-01-01", new DatosContacto("123456789", "juan@example.com"), null), false);
        
        // Agregar cita
        controlador.verificarYAgregarCita(cita);
        
        // Verificar que la cita se agregó al mapa de citas
        Assert.assertTrue("La cita debe agregarse al mapa de citas",
                controlador.getMapaCitas().containsKey(LocalDate.parse("2023-11-10")) &&
                controlador.getMapaCitas().get(LocalDate.parse("2023-11-10")).contains(cita));
    }

    @Test(expected = FinDeSemanaException.class)
    public void testAgregarCitaEnFinDeSemana() throws CitaValidationException {
        // Crear una cita médica de prueba en fin de semana
        CitaMedica cita = new CitaMedica("2023-11-11", "09:00", "Consulta general", "Dr. Perez", new Paciente("123", "Juan", "Pérez", "1980-01-01", new DatosContacto("123456789", "juan@example.com"), null), false);
        
        // Intentar agregar la cita
        controlador.verificarYAgregarCita(cita);
        
    }
}
