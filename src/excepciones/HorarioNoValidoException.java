/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author gyecsisap
 */
public class HorarioNoValidoException extends CitaValidationException {
    public HorarioNoValidoException(String mensaje) {
        super(mensaje);
    }
}