package fabrica;

import modelo.CitaMedica;

public interface CitaMedicaFactory {
    CitaMedica createCitaMedica(String[] parts);
}