[Inicio](../README.md) | 
[Resumen](/doc/Resumen.md) | 
[Estructura](/doc/Estructura.md) | 
[Diagrama](/doc/Diagrama.md) |
[Patrones](/doc/Patrones.md) |
[__Servicios__](/doc/Servicios.md) |
[Ejecución](/doc/Ejecucion.md) 

# Reserva de Citas Médicas | Servicios

### CitaLoader

El servicio `CitaLoader` se encarga de cargar citas médicas desde un archivo y agregarlas al sistema. Implementa la lógica para interpretar la información del archivo y crear instancias de `CitaMedica` correspondientes. También utiliza el `Controlador` para verificar y agregar las citas al sistema.

#### Métodos

- `cargarCitasMedicas(String fileName)`: Carga las citas médicas desde un archivo y las agrega al sistema.

#### Ejemplo de Uso

```java
CitaMedicaFactory citaMedicaFactory = new SimpleCitaMedicaFactory();
Controlador controlador = new Controlador(citaMedicaFactory, new ConsoleCitasPrinter());
CitaLoader citaLoader = new CitaLoader(citaMedicaFactory, controlador);

try {
    citaLoader.cargarCitasMedicas("archivo_citas.txt");
} catch (CitaValidationException e) {
    System.out.println("Error al cargar las citas médicas: " + e.getMessage());
}
