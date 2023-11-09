package modelo;

public class CitaMedica {

    private String fecha;
    private String hora;
    private String tipo;
    private String especialidad;

    private Paciente paciente;
    private boolean nuevacita;

    public CitaMedica(String fecha, String hora, String tipo, String especialidad, Paciente paciente, boolean nuevacita) {
        this.fecha = fecha;
        this.hora = hora;
        this.tipo = tipo;
        this.especialidad = especialidad;
        this.paciente = paciente;
        this.nuevacita = nuevacita;
    }

    public boolean isNuevacita() {
        return nuevacita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String toString() {
        return "CitaMedica{" + "fecha=" + fecha + ", hora=" + hora + ", tipo=" + tipo + ", especialidad=" + especialidad + ", paciente=" + paciente + ", nuevacita=" + nuevacita + '}';
    }
}
