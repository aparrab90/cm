package modelo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PacienteTest {

    private Paciente paciente;
    private Apoderado apoderado;
    private DatosContacto datosContacto;

    @Before
    public void setUp() {
        datosContacto = new DatosContacto("5551234", "juanvelasquez@hotmail.com");
        apoderado = new Apoderado("1717937849", "ApoderadoNombre", "ApoderadoApellido", "1980-01-01", datosContacto);
        paciente = new Paciente("1717937848", "PacienteNombre", "PacienteApellido", "2000-01-01", datosContacto, apoderado);
    }

    @Test
    public void testGetIdentificacion() {
        assertEquals("La identificación debe coincidir con la proporcionada", "123456789", paciente.getIdentificacion());
    }

    @Test
    public void testGetNombres() {
        assertEquals("Los nombres deben coincidir con los proporcionados", "PacienteNombre", paciente.getNombres());
    }

    @Test
    public void testGetApellidos() {
        assertEquals("Los apellidos deben coincidir con los proporcionados", "PacienteApellido", paciente.getApellidos());
    }

    @Test
    public void testGetFechaNacimiento() {
        assertEquals("La fecha de nacimiento debe coincidir con la proporcionada", "2000-01-01", paciente.getFechaNacimiento());
    }

    @Test
    public void testGetDatosContacto() {
        assertEquals("Los datos de contacto deben coincidir con los proporcionados", datosContacto, paciente.getDatosContacto());
    }

    @Test
    public void testGetApoderado() {
        assertEquals("El apoderado debe coincidir con el proporcionado", apoderado, paciente.getApoderado());
    }

    @Test
    public void testSetApoderado() {
        Apoderado nuevoApoderado = new Apoderado("123456789", "NuevoApoderadoNombre", "NuevoApoderadoApellido", "1975-01-01", datosContacto);
        paciente.setApoderado(nuevoApoderado);
        assertEquals("El apoderado debe haber sido cambiado", nuevoApoderado, paciente.getApoderado());
    }

    @Test
    public void testToString() {
        String expected = "Persona{identificacion='123456789', nombres='PacienteNombre', apellidos='PacienteApellido', fechaNacimiento='2000-01-01', datosContacto=DatosContacto{telefonoContacto='5551234', correoElectronico='juanvelasquez@hotmail.com'}}Paciente{apoderado=" + apoderado.toString() + "}";
        assertEquals("La representación String debe ser la esperada", expected, paciente.toString());
    }
}