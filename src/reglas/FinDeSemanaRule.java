/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reglas;

import excepciones.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import modelo.CitaMedica;

/**
 *
 * @author gyecsisap
 */
public class FinDeSemanaRule implements CitaValidationRule {

    @Override
    public void validate(CitaMedica cita) throws CitaValidationException {
        LocalDate fechaCita = LocalDate.parse(cita.getFecha());

        if (fechaCita.getDayOfWeek() == DayOfWeek.SATURDAY || fechaCita.getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new FinDeSemanaException("No se puede agendar citas en fines de semana.");
        }
    }
}
