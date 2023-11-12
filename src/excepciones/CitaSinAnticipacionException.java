package excepciones;

public class CitaSinAnticipacionException extends CitaValidationException {
    public CitaSinAnticipacionException(String mensaje) {
        super(mensaje);
    }
}
