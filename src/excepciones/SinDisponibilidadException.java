package excepciones;

public class SinDisponibilidadException extends CitaValidationException {
    public SinDisponibilidadException(String mensaje) {
        super(mensaje);
    }
}