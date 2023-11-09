package modelo;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

public class ApoderadoTest {

    @Test
    public void testIsMayorEdadTrue() {
        // Establecer una fecha de nacimiento que garantice que el apoderado sea mayor de edad
        String fechaNacimientoMayorEdad = LocalDate.now().minusYears(20).toString();
        DatosContacto datosContacto = new DatosContacto("5551234", "apoderado@example.com");

        Apoderado apoderado = new Apoderado("12345678A", "Juan", "Pérez", fechaNacimientoMayorEdad, datosContacto);

        assertTrue("El apoderado debería ser mayor de edad", apoderado.isMayorEdad());
    }

    @Test
    public void testIsMayorEdadFalse() {
        // Establecer una fecha de nacimiento que garantice que el apoderado NO sea mayor de edad
        String fechaNacimientoMenorEdad = LocalDate.now().minusYears(10).toString();
        DatosContacto datosContacto = new DatosContacto("5554321", "apoderado_joven@example.com");

        Apoderado apoderado = new Apoderado("87654321B", "Laura", "García", fechaNacimientoMenorEdad, datosContacto);

        assertFalse("El apoderado no debería ser mayor de edad", apoderado.isMayorEdad());
    }
}
