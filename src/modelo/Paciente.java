package modelo;

public class Paciente extends Persona {
    private Apoderado apoderado;

    public Paciente() {
        // Constructor por defecto
    }

    public Paciente(String identificacion, String nombres, String apellidos, String fechaNacimiento, DatosContacto datos_contacto, Apoderado apoderado) {
        super(identificacion, nombres, apellidos, fechaNacimiento, datos_contacto);
        this.apoderado = apoderado;
    }

    public Apoderado getApoderado() {
        return apoderado;
    }

    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }

    @Override
    public String toString() {
        return super.toString() + "Paciente{" + "apoderado=" + apoderado + '}';
    }   

    Object getDatosContacto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
