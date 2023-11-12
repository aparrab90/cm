package reglas;

import excepciones.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import modelo.CitaMedica;

public class FinDeSemanaRule implements CitaValidationRule {

    @Override
    public void validate(CitaMedica cita) throws CitaValidationException {
        LocalDate fechaCita = LocalDate.parse(cita.getFecha());

        if (fechaCita.getDayOfWeek() == DayOfWeek.SATURDAY || fechaCita.getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new FinDeSemanaException("No se puede agendar citas en fines de semana.");
        }
    }
}
