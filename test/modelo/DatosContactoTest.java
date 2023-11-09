package modelo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatosContactoTest {

    private DatosContacto datosContacto;

    @Before
    public void setUp() {
        datosContacto = new DatosContacto("correo@example.com", "555-5555");
    }

    @Test
    public void testGetCorreoElectronico() {
        assertEquals("correo@example.com", datosContacto.getCorreoElectronico());
    }

    @Test
    public void testGetTelefono() {
        assertEquals("555-5555", datosContacto.getTelefono());
    }

    @Test
    public void testToString() {
        String expected = "DatosContacto{correoElectronico=correo@example.com, telefono=555-5555}";
        assertEquals(expected, datosContacto.toString());
    }
}
