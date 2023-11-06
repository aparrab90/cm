/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


/**
 *
 * @author gyecsisap
 */
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
    
    
}
