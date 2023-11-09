package modelo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatosContactoTest {

    private DatosContacto datosContacto;

    @Before
    public void setUp() {
        datosContacto = new DatosContacto("0998746782", "juanvelasquez@hotmail.com");
    }

    @Test
    public void testGetTelefonoContacto() {
        assertEquals("El número de teléfono debe coincidir con el proporcionado", "123456789", datosContacto.getTelefonoContacto());
    }

    @Test
    public void testSetTelefonoContacto() {
        String nuevoTelefono = "123456789";
        datosContacto.setTelefonoContacto(nuevoTelefono);
        assertEquals("El número de teléfono debe haber sido cambiado", nuevoTelefono, datosContacto.getTelefonoContacto());
    }

    @Test
    public void testGetCorreoElectronico() {
        assertEquals("El correo electrónico debe coincidir con el proporcionado", "juanvelasquezzz@hotmail.com", datosContacto.getCorreoElectronico());
    }

    @Test
    public void testSetCorreoElectronico() {
        String nuevoCorreo = "nuevo.contacto@hotmail.com";
        datosContacto.setCorreoElectronico(nuevoCorreo);
        assertEquals("El correo electrónico debe haber sido cambiado", nuevoCorreo, datosContacto.getCorreoElectronico());
    }
}
