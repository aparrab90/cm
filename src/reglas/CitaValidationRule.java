/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reglas;

import excepciones.CitaValidationException;
import modelo.CitaMedica;

/**
 *
 * @author gyecsisap
 */
public interface CitaValidationRule {
    void validate(CitaMedica cita) throws CitaValidationException;
}