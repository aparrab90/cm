package modelo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonaTest {

    private Persona persona;
    private DatosContacto datosContacto;

    @Before
    public void setUp() {
        datosContacto = new DatosContacto("5551234", "juanvelasquez@hotmail.com");
        persona = new Persona("123456789", "PersonaNombre", "PersonaApellido", "1990-01-01", datosContacto);
    }

    @Test
    public void testConstructorWithArgs() {
        assertNotNull("El objeto persona no debe ser null", persona);
        assertEquals("La identificación debe coincidir", "123456789", persona.getIdentificacion());
        assertEquals("Los nombres deben coincidir", "PersonaNombre", persona.getNombres());
        assertEquals("Los apellidos deben coincidir", "PersonaApellido", persona.getApellidos());
        assertEquals("La fecha de nacimiento debe coincidir", "1990-01-01", persona.getFechaNacimiento());
        assertEquals("Los datos de contacto deben coincidir", datosContacto, persona.getDatosContacto());
    }

    @Test
    public void testDefaultConstructor() {
        Persona nuevaPersona = new Persona();
        assertNotNull("El objeto persona no debe ser null", nuevaPersona);
    }

    @Test
    public void testSetIdentificacion() {
        persona.setIdentificacion("987654321");
        assertEquals("La identificación debe ser actualizada", "987654321", persona.getIdentificacion());
    }

    @Test
    public void testSetNombres() {
        persona.setNombres("NuevoNombre");
        assertEquals("Los nombres deben ser actualizados", "NuevoNombre", persona.getNombres());
    }

    @Test
    public void testSetApellidos() {
        persona.setApellidos("NuevoApellido");
        assertEquals("Los apellidos deben ser actualizados", "NuevoApellido", persona.getApellidos());
    }

    @Test
    public void testSetFechaNacimiento() {
        persona.setFechaNacimiento("2000-01-01");
        assertEquals("La fecha de nacimiento debe ser actualizada", "2000-01-01", persona.getFechaNacimiento());
    }

    @Test
    public void testToString() {
        String expected = "Persona{identificacion='123456789', nombres='PersonaNombre', apellidos='PersonaApellido', fechaNacimiento='1990-01-01'}";
        assertEquals("La representación String debe ser la esperada", expected, persona.toString());
    }
}
