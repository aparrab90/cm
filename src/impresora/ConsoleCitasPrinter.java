package impresora;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import modelo.CitaMedica;

public class ConsoleCitasPrinter implements CitasPrinter {
    @Override
    public void printCitas(Map<LocalDate, LinkedList<CitaMedica>> mapaCitas) {
        for (LocalDate fecha : mapaCitas.keySet()) {
            System.out.println("Fecha: " + fecha);
            LinkedList<CitaMedica> citas = mapaCitas.get(fecha);
            for (CitaMedica cita : citas) {
                System.out.println("\t" + cita);
            }
        }
    }
    
}