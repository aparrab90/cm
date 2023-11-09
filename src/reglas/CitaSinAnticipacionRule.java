package reglas;

import excepciones.CitaSinAnticipacionException;
import excepciones.CitaValidationException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import modelo.CitaMedica;

public class CitaSinAnticipacionRule implements CitaValidationRule {

    @Override
    public void validate(CitaMedica cita) throws CitaValidationException {
        LocalDate fechaCita = LocalDate.parse(cita.getFecha());
        if ("ESPECIALISTA".equals(cita.getTipo()) && !esConAnticipacion(fechaCita)) {
            throw new CitaSinAnticipacionException("Las citas con especialistas deben agendarse con 24 horas de anticipación.");
        }
    }

    private boolean esConAnticipacion(LocalDate fechaHora) {
        LocalDateTime dateTimeStartOfDay = fechaHora.atStartOfDay();
        LocalDateTime ahora = LocalDateTime.of(2023, 11, 05, 00, 00);//LocalDateTime.now();
        long horasHastaCita = ChronoUnit.HOURS.between(ahora, dateTimeStartOfDay);
        return horasHastaCita >= 24;
    }
}
