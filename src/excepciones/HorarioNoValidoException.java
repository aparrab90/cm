package excepciones;

public class HorarioNoValidoException extends CitaValidationException {
    public HorarioNoValidoException(String mensaje) {
        super(mensaje);
    }
}