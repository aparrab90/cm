package reglas;

import excepciones.CitaValidationException;
import excepciones.HorarioNoValidoException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import modelo.CitaMedica;

public class HorarioNoValidoRule implements CitaValidationRule {

    static final LocalTime INICIO_JORNADA = LocalTime.of(8, 0);
    static final LocalTime FIN_JORNADA = LocalTime.of(19, 0);
    static final LocalTime FIN_JORNADA_VIERNES = LocalTime.of(13, 0);

    @Override
    public void validate(CitaMedica cita) throws CitaValidationException {
        LocalDate fechaCita = LocalDate.parse(cita.getFecha());
        LocalTime horaCita = LocalTime.parse(cita.getHora());
        
        if (fechaCita.isBefore(LocalDate.now())) {
            throw new HorarioNoValidoException("Las citas deben ser programadas para el futuro.");
        }
        
        if (!esHorarioValido(fechaCita, horaCita)) {
            throw new HorarioNoValidoException("La cita está fuera del horario de atención.");
        }
        
        if (!esIntervaloPermitido(horaCita)) {
            throw new HorarioNoValidoException("La cita está en un intervalo no permitido.");
        }
    }
    
    private boolean esHorarioValido(LocalDate fecha, LocalTime hora) {
        LocalTime finJornadaActual = fecha.getDayOfWeek() == DayOfWeek.FRIDAY ? FIN_JORNADA_VIERNES : FIN_JORNADA;
        LocalTime ultimaCitaPermitida = finJornadaActual.minusMinutes(20);

        return !hora.isBefore(INICIO_JORNADA) && !hora.isAfter(ultimaCitaPermitida);
    }
     
    private boolean esIntervaloPermitido(LocalTime hora) {
        int minutos = hora.getMinute();
        return minutos % 20 == 0;
    }
}
