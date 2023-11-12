[Inicio](../README.md) | 
[__Resumen__](Readme.md) | 
[Estructura](Estructura.md) | 
[Diagrama](Diagrama.md) |
[Patrones](Patrones.md) |
[Servicios](Servicios.md) |
[Ejecución](Ejecucion.md) 

# Reserva de Citas Médicas | Resumen

## Objetivo del Proyecto

El proyecto "Reserva de Citas Médicas" tiene como objetivo proporcionar una solución para la gestión de citas médicas, permitiendo a los pacientes programar citas con diferentes especialistas médicos. El sistema verifica la disponibilidad, aplica reglas de validación y permite imprimir un registro de citas médicas, aplicando reglas de validación y utilizando patrones de diseño para mejorar la modularidad y la extensibilidad del código.

## Contexto Detallado

El sistema de reserva de citas médicas permite programar y gestionar citas para pacientes. Cuenta con reglas de validación que aseguran que las citas se programen adecuadamente y se eviten conflictos en el horario del profesional médico.

La gestión eficiente de citas médicas es crucial en el entorno de la atención médica. Este proyecto aborda la necesidad de un sistema que permita a los pacientes programar citas con facilidad y garantice que se cumplan ciertas reglas y validaciones, como la disponibilidad de especialistas y la anticipación requerida para ciertos tipos de citas.

El proyecto se desarrolla en el contexto de un centro médico que atiende a pacientes de todas las edades y ofrece servicios médicos generales y especializados. La importancia de esta solución radica en mejorar la organización y la eficiencia de la programación de citas médicas.


## Estructura del Proyecto

El proyecto se organiza en los siguientes paquetes y clases:

- **`fabrica`**: Contiene las clases relacionadas con la creación de citas médicas.

  - `CitaMedicaFactory`: Interfaz para crear instancias de `CitaMedica`.
  - `SimpleCitaMedicaFactory`: Implementación de `CitaMedicaFactory` que utiliza una lógica simple para crear citas médicas.

- **`impresora`**: Contiene clases relacionadas con la impresión de citas médicas.

  - `CitasPrinter`: Interfaz para imprimir citas médicas.
  - `ConsoleCitasPrinter`: Implementación de `CitasPrinter` que imprime las citas en la consola.

- **`modelo`**: Contiene las clases que representan el modelo de datos.

  - `CitaMedica`: Representa una cita médica con atributos como fecha, hora, tipo, etc.
  - `Persona`: Clase base para representar a una persona con atributos compartidos como identificación, nombres, apellidos, etc.
  - `Paciente`: Representa a un paciente que tiene una relación con un apoderado.
  - `Apoderado`: Representa al apoderado de un paciente.
  - `DatosContacto`: Representa los datos de contacto, como teléfono y correo electrónico.

- **`reglas`**: Contiene reglas de validación aplicadas a las citas médicas.

  - `CitaValidationRule`: Interfaz para las reglas de validación.
  - `CitaSinAnticipacionRule`: Regla que valida que las citas con especialistas se agenden con anticipación.
  - `FinDeSemanaRule`: Regla que evita agendar citas en fines de semana.
  - `HorarioNoValidoRule`: Regla que valida que la cita está dentro del horario de atención.
  - `SinDisponibilidadRule`: Regla que verifica la disponibilidad de profesionales para una cita.

- **`reservacitasmedicas`**: Contiene la clase principal `ReservaCitasMedicas` que carga y gestiona las citas médicas.

## Reglas

El sistema aplica varias reglas de validación para garantizar la coherencia y la integridad de las citas médicas. Algunas de las reglas incluyen la validación de anticipación para citas con especialistas, la prohibición de agendar citas en fines de semana y la verificación de la disponibilidad de profesionales.

## Clases

### CitaMedica

La clase `CitaMedica` representa una cita médica con atributos como fecha, hora, tipo, especialidad, paciente y si es una nueva cita.

### Persona

La clase `Persona` es una clase base que representa a una persona con atributos compartidos como identificación, nombres, apellidos, fecha de nacimiento y datos de contacto.

### Paciente

La clase `Paciente` extiende `Persona` y representa a un paciente, incluyendo una relación con un apoderado.

### Apoderado

La clase `Apoderado` extiende `Persona` y representa al apoderado de un paciente.

### DatosContacto

La clase `DatosContacto` representa los datos de contacto de una persona, como teléfono y correo electrónico.

### CitaValidationRule

La interfaz `CitaValidationRule` define el contrato para las reglas de validación aplicadas a las citas médicas.

### CitaSinAnticipacionRule

La clase `CitaSinAnticipacionRule` implementa la regla de validación que requiere anticipación para citas con especialistas.

### FinDeSemanaRule

La clase `FinDeSemanaRule` implementa la regla de validación que prohíbe agendar citas en fines de semana.

### HorarioNoValidoRule

La clase `HorarioNoValidoRule` implementa la regla de validación que verifica que la cita esté dentro del horario de atención.

### SinDisponibilidadRule

La clase `SinDisponibilidadRule` implementa la regla de validación que verifica la disponibilidad de profesionales para una cita.

### ReservaCitasMedicas

La clase principal `ReservaCitasMedicas` carga y gestiona las citas médicas utilizando un controlador.

### Controlador

La clase `Controlador` gestiona la lógica de negocio, utiliza la fábrica y las reglas de validación para operar con las citas médicas.

## Patrones Aplicados

### Patrón Factory

Se utiliza el patrón de fábrica (`Factory Pattern`) para crear instancias de `CitaMedica` a través de la interfaz `CitaMedicaFactory`. Esto permite encapsular la lógica de creación y facilita la extensibilidad del sistema.

### Patrón Strategy

Se implementa el patrón de estrategia (`Strategy Pattern`) para las reglas de validación. Cada regla es una estrategia independiente, lo que permite agregar nuevas reglas sin modificar el código existente.

### Principios SOLID

#### Single Responsibility Principle (SRP)

Cada clase tiene una única responsabilidad. Por ejemplo, `ConsoleCitasPrinter` es responsable solo de imprimir citas.

#### Interface Segregation Principle (ISP)

Las interfaces se mantienen pequeñas y específicas. La interfaz `CitaValidationRule` es un ejemplo, ya que define solo el método necesario para la validación de citas.

#### Dependency Inversion Principle (DIP)

Se aplica el principio de inversión de dependencias. `Controlador` depende de la abstracción `CitaMedicaFactory`, permitiendo una mayor flexibilidad y extensibilidad.

## Conclusiones

El proyecto utiliza patrones de diseño y principios SOLID para mejorar la organización, mantenibilidad y extensibilidad del código. La aplicación de reglas de validación garantiza la integridad de las citas médicas y proporciona un sistema robusto para la reserva de citas.

<span style="float:right;"> <small> [< Volver al Inicio](../README.md)</small></span>
