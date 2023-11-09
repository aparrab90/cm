package reglas;

import excepciones.CitaValidationException;
import excepciones.SinDisponibilidadException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import modelo.CitaMedica;

public class SinDisponibilidadRule implements CitaValidationRule {

    private static final int MAX_ESPECIALISTAS = 3;
    private static final int MAX_GENERALES = 2;
    private Map<LocalDate, LinkedList<CitaMedica>> mapaCitas ;
    public SinDisponibilidadRule(Map<LocalDate, LinkedList<CitaMedica>> mapaCitas) {
        this.mapaCitas = mapaCitas;
    }
    
    
    @Override
    public void validate(CitaMedica cita) throws CitaValidationException {
        if (!hayDisponibilidadProfesional(cita)) {
            throw new SinDisponibilidadException("No hay disponibilidad para el profesional seleccionado en ese horario.");
        }
    }

    private boolean hayDisponibilidadProfesional(CitaMedica cita) {
        LinkedList<CitaMedica> citasFecha = mapaCitas.getOrDefault(LocalDate.parse(cita.getFecha()), new LinkedList<>());

        // Si hay espacio en la fecha indicada para el tipo de cita, se permite agendar.
        long conteoCitasMismoTipoYHora = citasFecha.stream()
                .filter(c -> (c.getFecha().equals(cita.getFecha()) && c.getTipo().equals(cita.getTipo()) && c.getHora().equals(cita.getHora())))
                .count();

        int maxCitasSimultaneas = "GENERAL".equals(cita.getTipo()) ? MAX_GENERALES : MAX_ESPECIALISTAS;

        return conteoCitasMismoTipoYHora < maxCitasSimultaneas;
    }
}
