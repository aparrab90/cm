package modelo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PersonaTest {

    private Persona persona;
    private DatosContacto datosContacto; // Asumiendo que existe una clase DatosContacto.

    @Before
    public void setUp() {
        datosContacto = new DatosContacto("5551234", "ciudad@ejemplo.com");
        persona = new Persona("12345678A", "Juan", "Pérez", "1980-05-20", datosContacto);
    }

    @Test
    public void testGetIdentificacion() {
        assertEquals("12345678A", persona.getIdentificacion());
    }

    @Test
    public void testSetIdentificacion() {
        persona.setIdentificacion("87654321B");
        assertEquals("87654321B", persona.getIdentificacion());
    }

    @Test
    public void testGetNombres() {
        assertEquals("Juan", persona.getNombres());
    }

    @Test
    public void testSetNombres() {
        persona.setNombres("Carlos");
        assertEquals("Carlos", persona.getNombres());
    }

    @Test
    public void testGetApellidos() {
        assertEquals("Pérez", persona.getApellidos());
    }

    @Test
    public void testSetApellidos() {
        persona.setApellidos("González");
        assertEquals("González", persona.getApellidos());
    }

    @Test
    public void testGetFechaNacimiento() {
        assertEquals("1980-05-20", persona.getFechaNacimiento());
    }

    @Test
    public void testSetFechaNacimiento() {
        persona.setFechaNacimiento("1990-06-15");
        assertEquals("1990-06-15", persona.getFechaNacimiento());
    }

    @Test
    public void testToString() {
        String expectedString = "Persona{" +
                "identificacion=" + persona.getIdentificacion() +
                ", nombres=" + persona.getNombres() +
                ", apellidos=" + persona.getApellidos() +
                ", fechaNacimiento=" + persona.getFechaNacimiento() +
                '}';
        assertEquals(expectedString, persona.toString());
    }
}
