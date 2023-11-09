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
        // Inicializa DatosContacto y Apoderado para ser usados en el Paciente
        datosContacto = new DatosContacto("email@example.com", "555-1234");
        apoderado = new Apoderado("ID54321", "Jane", "Doe", "1980-02-02", datosContacto);
        
        // Inicializa Paciente con un apoderado
        paciente = new Paciente("ID12345", "John", "Doe", "2005-03-01", datosContacto, apoderado);
    }

    @Test
    public void testGetIdentificacion() {
        assertEquals("ID12345", paciente.getIdentificacion());
    }

    @Test
    public void testGetFechaNacimiento() {
        assertEquals("2005-03-01", paciente.getFechaNacimiento());
    }

    @Test
    public void testGetApoderado() {
        assertEquals(apoderado, paciente.getApoderado());
    }

    @Test
    public void testSetApoderado() {
        Apoderado nuevoApoderado = new Apoderado("ID67890", "Alice", "Smith", "1975-05-05", datosContacto);
        paciente.setApoderado(nuevoApoderado);
        assertEquals(nuevoApoderado, paciente.getApoderado());
    }

    @Test
    public void testToString() {
        String expected = "Persona{" + "identificacion=ID12345, nombres=John, apellidos=Doe, fechaNacimiento=2005-03-01, datosContacto=" + datosContacto.toString() + "}" + "Paciente{" + "apoderado=" + apoderado.toString() + '}';
        assertEquals(expected, paciente.toString());
    }
}