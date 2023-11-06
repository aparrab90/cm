/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author gyecsisap
 */
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
