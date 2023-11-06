/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabrica;

import modelo.CitaMedica;

/**
 *
 * @author gyecsisap
 */
public interface CitaMedicaFactory {
    CitaMedica createCitaMedica(String[] parts);
}