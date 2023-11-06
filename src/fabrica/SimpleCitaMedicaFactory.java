/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabrica;

import modelo.CitaMedica;
import modelo.Paciente;

/**
 *
 * @author gyecsisap
 */
public class SimpleCitaMedicaFactory implements CitaMedicaFactory {
    @Override
    public CitaMedica createCitaMedica(String[] parts) {
        // Implement the logic to create a CitaMedica from parts
        return new CitaMedica(parts[0], parts[1], parts[2], parts[3], new Paciente(), true);
    }
}