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
import java.time.LocalDate;
import java.time.Period;

import java.util.ArrayList;
import java.util.Arrays;


import modelo.Apoderado;
import modelo.CitaMedica;
import modelo.DatosContacto;
import modelo.Paciente;

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
                } else if (line.contains("|")) {
                    boolean nuevacita = line.matches("\\d{4}-\\d{2}-\\d{2}.*");
                    if (!nuevacita) {
                        line = fecha + "|" + line;
                    }
                    String[] parts = line.split("\\|");
                    String[] persona = separarNombreApellido(parts[4]);
                    DatosContacto contactoPaciente = new DatosContacto(parts[8], "");
                    paciente = new Paciente(parts[7], persona[0], persona[1], parts[9], contactoPaciente, null);
                    // Verificación de paciente menor de edad y su apoderado
                    if (Arrays.asList(parts).contains("APO") || "PMENOR".equals(parts[5])) {
                        if (!esApoderadoValido(parts)) {
                            System.out.println("Apoderado inválido para la cita: " + line);
                            continue;
                        }
                        String[] apo = separarNombreApellido(parts[11]);
                        DatosContacto contacto = new DatosContacto("", "");
                        apoderado = new Apoderado(parts[13], apo[0], apo[1], parts[14], contacto);
                        if (!apoderado.isMayorEdad()) {
                            System.out.println("Apoderado menor de edad para la cita: " + line);
                        } else {
                            paciente.setApoderado(apoderado);
                            cita = new CitaMedica(parts[0], parts[1], parts[2], parts[3], paciente, nuevacita);
                            citas.add(cita);
                        }

                    } else {
                        if (!datosCompletos(parts)) {
                            System.out.println("Datos incompletos para la cita: " + line);
                            continue;
                        }
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
    
    private boolean datosCompletos(String[] parts) {
        if (parts.length < 10) {
            return false;
        }
        
        boolean fechaValida = !parts[0].trim().isEmpty();
        boolean horaValida = !parts[1].trim().isEmpty();
        boolean tipoConsultaValido = !parts[2].trim().isEmpty();
        boolean especialidadValida = !parts[3].trim().isEmpty();
        boolean nombreYApellidoValidos = !parts[4].trim().isEmpty();
        boolean tipoPacienteValido = !parts[5].trim().isEmpty();
        boolean tipoIdentificacionValido = !parts[6].trim().isEmpty();
        boolean identificacionValida = !parts[7].trim().isEmpty();
        boolean celularValido = !parts[8].trim().isEmpty();
        boolean fechaNacimientoValida = !parts[9].trim().isEmpty();

        return fechaValida && horaValida && tipoConsultaValido && especialidadValida &&
               nombreYApellidoValidos && tipoPacienteValido && tipoIdentificacionValido &&
               identificacionValida && celularValido && fechaNacimientoValida;
    }

    private boolean esApoderadoValido(String[] parts) {
        if (parts.length < 15 || !"APO".equals(parts[10])) {
            return false;
        }
        
        boolean nombreYApellidoValidosApoderado = !parts[11].trim().isEmpty();
        boolean tipoIdentificacionValidoApoderado = !parts[12].trim().isEmpty();
        boolean identificacionValidaApoderado = !parts[13].trim().isEmpty();
        boolean fechaNacimientoValidaApoderado = !parts[14].trim().isEmpty();
        
        return nombreYApellidoValidosApoderado && tipoIdentificacionValidoApoderado && 
        identificacionValidaApoderado && fechaNacimientoValidaApoderado;
    }
}
