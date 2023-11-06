/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reglas;

import excepciones.CitaValidationException;
import excepciones.HorarioNoValidoException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import modelo.CitaMedica;

/**
 *
 * @author gyecsisap
 */
public class HorarioNoValidoRule implements CitaValidationRule {

    private static final LocalTime INICIO_JORNADA = LocalTime.of(8, 0);
    private static final LocalTime FIN_JORNADA = LocalTime.of(19, 0);
    private static final LocalTime FIN_JORNADA_VIERNES = LocalTime.of(13, 0);

    @Override
    public void validate(CitaMedica cita) throws CitaValidationException {
        LocalDate fechaCita = LocalDate.parse(cita.getFecha());
        LocalTime horaCita = LocalTime.parse(cita.getHora());
          if (!esHorarioValido(fechaCita, horaCita)) {
            throw new HorarioNoValidoException("La cita está fuera del horario de atención.");
        }
    }
    
     private boolean esHorarioValido(LocalDate fecha, LocalTime hora) {
        LocalTime finJornadaActual = fecha.getDayOfWeek() == DayOfWeek.FRIDAY ? FIN_JORNADA_VIERNES : FIN_JORNADA;
        LocalTime ultimaCitaPermitida = finJornadaActual.minusMinutes(20);

        return !hora.isBefore(INICIO_JORNADA) && !hora.isAfter(ultimaCitaPermitida);
    }
    
}
