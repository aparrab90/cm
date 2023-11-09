package fabrica;

import modelo.CitaMedica;
import modelo.Paciente;

public class SimpleCitaMedicaFactory implements CitaMedicaFactory {
    @Override
    public CitaMedica createCitaMedica(String[] parts) {
        return new CitaMedica(parts[0], parts[1], parts[2], parts[3], new Paciente(), true);
    }
}