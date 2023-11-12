package reglas;

import excepciones.CitaValidationException;
import modelo.CitaMedica;

public interface CitaValidationRule {
    void validate(CitaMedica cita) throws CitaValidationException;
}