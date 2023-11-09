package excepciones;

import controlador.Controlador;
import fabrica.CitaMedicaFactory;
import impresora.ConsoleCitasPrinter;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import modelo.CitaMedica;
import modelo.Paciente;
import modelo.DatosContacto;

public class CitaSinAnticipacionExceptionTest {

    private Controlador controlador;

    @Before
    public void setUp() {
        controlador = new Controlador(new CitaMedicaFactory() {
            @Override
            public CitaMedica createCitaMedica(String[] parts) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        }, new ConsoleCitasPrinter());
    }

    @Test(expected = CitaSinAnticipacionException.class)
    public void testAgregarCitaSinAnticipacionSuficiente() throws CitaValidationException {
        // Crear una cita médica para el mismo día, lo que debería lanzar CitaSinAnticipacionException
        String fechaCitaHoy = LocalDate.now().toString();
        CitaMedica citaHoy = new CitaMedica(fechaCitaHoy, "09:00", "Consulta general", "Dr. Perez", new Paciente("123", "Juan", "Pérez", "1980-01-01", new DatosContacto("123456789", "juan@example.com"), null), false);
        // Intentar agregar la cita sin la anticipación necesaria
        controlador.verificarYAgregarCita(citaHoy);
    }
}
