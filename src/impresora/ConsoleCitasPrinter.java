/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impresora;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import modelo.CitaMedica;

/**
 *
 * @author gyecsisap
 */
public class ConsoleCitasPrinter implements CitasPrinter {
    @Override
    public void printCitas(Map<LocalDate, LinkedList<CitaMedica>> mapaCitas) {
        for (LocalDate fecha : mapaCitas.keySet()) {
            System.out.println("Fecha: " + fecha);
            LinkedList<CitaMedica> citas = mapaCitas.get(fecha);
            for (CitaMedica cita : citas) {
                System.out.println("\t" + cita); // Asegúrate de tener un método toString() adecuado en tu clase CitaMedica
            }
        }
    }
    
}