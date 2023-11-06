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
public interface CitasPrinter {
    void printCitas(Map<LocalDate, LinkedList<CitaMedica>> mapaCitas);
}
