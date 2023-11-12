[Inicio](../README.md) | 
[Resumen](/doc/Resumen.md) | 
[Estructura](/doc/Estructura.md) | 
[__Diagrama__](/doc/Diagrama.md) | 
[Patrones](/doc/Patrones.md) | 
[Servicios](/doc/Servicios.md) |
[Ejecución](/doc/Ejecucion.md) 

# Reserva de Citas Médicas | Diagrama

Se detalla el diagrama de clase de dominio, las clases, atributos, métodos y relaciones.

![Texto Alternativo](/doc/imgs/diagrama.png)

## Controlador

La clase `Controlador` es una parte esencial del sistema de gestión de citas médicas. Es responsable de administrar las citas médicas, aplicar reglas de validación y gestionar la impresión de citas.

### Atributos

- `mapaCitas`: Un mapa que almacena las citas médicas organizadas por fecha.
- `validationRules`: Una lista de reglas de validación que se aplican a cada cita médica.
- `citaMedicaFactory`: La fábrica utilizada para crear instancias de citas médicas.
- `citasPrinter`: La impresora utilizada para mostrar las citas médicas en la consola.

### Métodos

- `verificarYAgregarCita(CitaMedica cita)`: Este método se encarga de verificar si una cita médica cumple con las reglas de validación y, si es así, la agrega al mapa de citas.
- `agregarCita(CitaMedica cita)`: Agrega una cita médica al mapa de citas.
- `cargarCitasMedicas(String fileName)`: Lee citas médicas desde un archivo utilizando el servicio `CitaLoader` y las carga en el sistema, aplicando las reglas de validación.
- `imprimirCitas()`: Imprime todas las citas médicas en el mapa.

## CitaLoader (Servicio)

La clase `CitaLoader` es un servicio encargado de cargar citas médicas desde un archivo. Utiliza la fábrica de citas y el controlador para procesar y validar las citas antes de agregarlas al sistema.

## CitaMedica

La clase `CitaMedica` representa una cita médica individual.

### Atributos

- `fecha`: La fecha de la cita médica.
- `hora`: La hora de la cita médica.
- `tipo`: El tipo de cita médica (general, especialista, etc.).
- `especialidad`: La especialidad médica (si es una cita de especialista).
- `paciente`: El paciente que tiene la cita médica.
- `nuevacita`: Indica si la cita es una nueva cita o una que se ha cargado desde un archivo.

### Métodos

- `isNuevacita()`: Comprueba si la cita es una nueva cita.
- Otros métodos relevantes que puedas haber implementado.

## CitaValidationRule (Interfaz)

La interfaz `CitaValidationRule` define un conjunto de reglas de validación que se aplican a las citas médicas. Las clases que implementan esta interfaz deben proporcionar una implementación del método `validate`.

## Persona (Clase base)

La clase `Persona` es una clase base que representa a una persona con atributos compartidos como identificación, nombres, apellidos, fecha de nacimiento y datos de contacto.

### Métodos

- Otros métodos relevantes que puedas haber implementado.

## Paciente

La clase `Paciente` extiende `Persona` y representa a un paciente, incluyendo una relación con un apoderado.

### Atributos

- `apoderado` (Opcional): El apoderado del paciente, si corresponde.

### Métodos

- `getApoderado()`: Devuelve el apoderado asociado al paciente.
- `setApoderado(Apoderado apoderado)`: Establece el apoderado del paciente, si corresponde.
- Otros métodos relevantes que puedas haber implementado.

## Apoderado

La clase `Apoderado` extiende `Persona` y representa al apoderado de un paciente.

### Métodos

- `isMayorEdad()`: Comprueba si el apoderado es mayor de edad.
- Otros métodos relevantes que puedas haber implementado.

## DatosContacto

La clase `DatosContacto` representa los datos de contacto de una persona, como teléfono y correo electrónico.

### Atributos

- `telefonoContacto`: El número de teléfono de contacto.
- `correoElectronico`: La dirección de correo electrónico de contacto.

### Métodos

- Otros métodos relevantes que puedas haber implementado.