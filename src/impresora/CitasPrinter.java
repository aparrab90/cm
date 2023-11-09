package impresora;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import modelo.CitaMedica;

public interface CitasPrinter {
    void printCitas(Map<LocalDate, LinkedList<CitaMedica>> mapaCitas);
}
