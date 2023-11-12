package fabrica;

import modelo.CitaMedica;
import modelo.Paciente;

public class SimpleCitaMedicaFactory implements CitaMedicaFactory {
    @Override
    public CitaMedica createCitaMedica(String[] parts) {
        if (parts.length < 3) { // X es el número mínimo de partes esperadas
            throw new IllegalArgumentException("Faltan datos para crear la cita médica.");
        }
        return new CitaMedica(parts[0], parts[1], parts[2], parts[3], new Paciente(), true);
    }
}
