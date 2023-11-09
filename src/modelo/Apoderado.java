package modelo;

import java.time.LocalDate;
import java.time.Period;

public class Apoderado extends Persona {

    public Apoderado() {
        // Constructor por defecto
    }

    public Apoderado(String identificacion, String nombres, String apellidos, String fechaNacimiento, DatosContacto datos_contacto) {
        super(identificacion, nombres, apellidos, fechaNacimiento, datos_contacto);
    }

    public boolean isMayorEdad() {
        LocalDate fechaNacimiento = LocalDate.parse(this.getFechaNacimiento());
        // Obtiene la fecha actual
        LocalDate ahora = LocalDate.now();
        // Calcula la edad
        Period periodo = Period.between(fechaNacimiento, ahora);
        // Retorna true si la edad es 18 o más
        return periodo.getYears() >= 18;
    }
}
