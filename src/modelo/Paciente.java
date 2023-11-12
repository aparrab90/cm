package modelo;

public class Paciente extends Persona {
    private Apoderado apoderado;

    public Paciente() {
        // Constructor por defecto
    }

    public Paciente(String identificacion, String nombres, String apellidos, String fechaNacimiento, DatosContacto datosContacto, Apoderado apoderado) {
        super(identificacion, nombres, apellidos, fechaNacimiento, datosContacto);
        this.apoderado = apoderado;
    }

    public Apoderado getApoderado() {
        return apoderado;
    }

    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }

    @Override
    public DatosContacto getDatosContacto() {
        // Si el paciente es menor de edad y tiene un apoderado, retorna los datos de contacto del apoderado
        if (this.apoderado != null) {
            return (DatosContacto) apoderado.getDatosContacto();
        }
        // De lo contrario, retorna los datos de contacto del paciente
        return (DatosContacto) super.getDatosContacto();
    }

    @Override
    public String toString() {
        String apoderadoString = (apoderado != null) ? apoderado.toString() : "Sin apoderado";
        return super.toString() + " Paciente{" + "apoderado=" + apoderadoString + '}';
    }
}
