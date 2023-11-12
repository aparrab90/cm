package controlador;

import excepciones.*;
import fabrica.CitaMedicaFactory;
import impresora.ConsoleCitasPrinter;
import java.time.LocalDate;
import java.util.*;
import modelo.*;
import reglas.*;

public class Controlador {

    private Map<LocalDate, LinkedList<CitaMedica>> mapaCitas;
    private List<CitaValidationRule> validationRules;
    private CitaMedicaFactory citaMedicaFactory;
    private ConsoleCitasPrinter citasPrinter;

    public Controlador(CitaMedicaFactory factory, ConsoleCitasPrinter printer) {
        this.mapaCitas = new HashMap<>();
        this.citaMedicaFactory = factory;
        this.citasPrinter = printer;
        this.validationRules = Arrays.asList(
                new FinDeSemanaRule(),
                new CitaSinAnticipacionRule(),
                new HorarioNoValidoRule(),
                new SinDisponibilidadRule(this.mapaCitas) // Instantiate other validation rules
        );

    }

    public Map<LocalDate, LinkedList<CitaMedica>> getMapaCitas() {
        return mapaCitas;
    }

    public void imprimirCitas() {
        citasPrinter.printCitas(mapaCitas);
    }

    public void verificarYAgregarCita(CitaMedica cita) throws CitaValidationException {
        for (CitaValidationRule rule : validationRules) {
            rule.validate(cita);
        }
        agregarCita(cita);
    }

    public void agregarCita(CitaMedica cita) {
        mapaCitas.computeIfAbsent(LocalDate.parse(cita.getFecha()), k -> new LinkedList<>()).add(cita);
    }

   
}
