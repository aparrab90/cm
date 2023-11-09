package modelo;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ApoderadoTest {

    private Apoderado apoderado;
    private DatosContacto datosContacto;

    @Before
    public void setUp() {
        // Configura los datos de contacto y un apoderado para las pruebas
        datosContacto = new DatosContacto("email@example.com", "555-1234");
        // Asume que el apoderado tiene más de 18 años
        apoderado = new Apoderado("12345678X", "Juan", "Pérez", "2000-01-01", datosContacto);
    }

    @Test
    public void testApoderadoEsMayorDeEdad() {
        assertTrue("El apoderado debe ser mayor de edad", apoderado.isMayorEdad());
    }

    @Test
    public void testApoderadoNoEsMayorDeEdad() {
        // Configura un apoderado que sabemos que es menor de edad
        Apoderado apoderadoMenor = new Apoderado("87654321Y", "Ana", "López", LocalDate.now().minusYears(10).toString(), datosContacto);
        assertFalse("El apoderado no debe ser mayor de edad", apoderadoMenor.isMayorEdad());
    }
}
