/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import controlador.Controlador;
import excepciones.CitaSinAnticipacionException;
import excepciones.CitaValidationException;
import excepciones.FinDeSemanaException;
import excepciones.HorarioNoValidoException;
import excepciones.SinDisponibilidadException;
import fabrica.CitaMedicaFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;


import modelo.Apoderado;
import modelo.CitaMedica;
import modelo.DatosContacto;
import modelo.Paciente;


/**
 *
 * @author gyecsisap
 */
public class CitaLoader {

    private CitaMedicaFactory citaMedicaFactory;
    private Controlador controlador;

    public CitaLoader(CitaMedicaFactory citaMedicaFactory, Controlador controlador) {
        this.citaMedicaFactory = citaMedicaFactory;
        this.controlador = controlador;
    }

    public void cargarCitasMedicas(String fileName) throws CitaValidationException {
        ArrayList<CitaMedica> citas = new ArrayList<>();
        String fecha = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            CitaMedica cita;
            Paciente paciente;
            Apoderado apoderado;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.matches("\\d{4}-\\d{2}-\\d{2}") && (!line.contains("|"))) {
                    fecha = line;
                } else if (line.contains("NUEVA CITA")) {
                    continue;
                } else if (line.contains("|")) {
                    boolean nuevacita = line.matches("\\d{4}-\\d{2}-\\d{2}.*");
                    if (!nuevacita) {
                        line = fecha + "|" + line;
                    }
                    String[] parts = line.split("\\|");
                    String[] persona = separarNombreApellido(parts[4]);
                    DatosContacto contactoPaciente = new DatosContacto(parts[8], "");
                    paciente = new Paciente(parts[7], persona[0], persona[1], parts[9], contactoPaciente, null);
                    if (Arrays.asList(parts).contains("APO")) {
                        String[] apo = separarNombreApellido(parts[11]);
                        DatosContacto contacto = new DatosContacto("", "");
                        apoderado = new Apoderado(parts[13], apo[0], apo[1], parts[14], contacto);
                        if (apoderado.isMayorEdad()) {
                            paciente.setApoderado(apoderado);
                            cita = new CitaMedica(parts[0], parts[1], parts[2], parts[3], paciente, nuevacita);
                            citas.add(cita);
                        } else {
                            System.out.println("NO SE PUDE AGREGAR ");
                        }

                    } else {
                        cita = new CitaMedica(parts[0], parts[1], parts[2], parts[3], paciente, nuevacita);
                        citas.add(cita);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (CitaMedica cita : citas) {
            if (!cita.isNuevacita()) {
                controlador.agregarCita(cita);
            } else {

                try {
                    controlador.verificarYAgregarCita(cita);
                    // Cita agendada correctamente.
                } catch (FinDeSemanaException | HorarioNoValidoException | CitaSinAnticipacionException | SinDisponibilidadException e) {
                    // Manejar la excepción, por ejemplo, mostrando el mensaje de error:
                    System.out.println(e.getMessage() + " " + cita.getFecha() + " " + cita.getHora());
                }
            }

        }
    }

    public static String[] separarNombreApellido(String nombreCompleto) {
        String nombre;
        String apellido;
        String[] partesNombreApellido = nombreCompleto.split(" ");
        if (partesNombreApellido.length >= 2) {
            nombre = partesNombreApellido[0];
            apellido = partesNombreApellido[1];
        } else {
            nombre = nombreCompleto;
            apellido = "";
        }
        String[] persona = {nombre, apellido};
        return persona;
    }

}
