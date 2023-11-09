# Reserva de Citas Médicas | Inicio
[__Inicio__](/doc/Readme.md) | [Diagrama](/doc/Clases,md) | [Reglas](/doc/Reglas.md)


## Objetivo del proyecto

El proyecto "Reserva de Citas Médicas" tiene como objetivo proporcionar una solución para la gestión de citas médicas, permitiendo a los pacientes programar citas con diferentes especialistas médicos. El sistema verifica la disponibilidad, aplica reglas de validación y permite imprimir un registro de citas médicas.

## Contexto detallado

La gestión eficiente de citas médicas es crucial en el entorno de la atención médica. Este proyecto aborda la necesidad de un sistema que permita a los pacientes programar citas con facilidad y garantice que se cumplan ciertas reglas y validaciones, como la disponibilidad de especialistas y la anticipación requerida para ciertos tipos de citas.

El proyecto se desarrolla en el contexto de un centro médico que atiende a pacientes de todas las edades y ofrece servicios médicos generales y especializados. La importancia de esta solución radica en mejorar la organización y la eficiencia de la programación de citas médicas.

## Estructura del proyecto

La estructura del proyecto se organiza de la siguiente manera:

```markdown
CM
│   README.md
└───src
│   Readme.md
│
└───src
│   │
│   └───controlador
│   │   │   Controlador.java
│   │
│   └───excepciones
│   │   │   CitaValidationException.java
│   │   │   ...
│   │
│   └───fabrica
│   │   │   CitaMedicaFactory.java
│   │   │   SimpleCitaMedicaFactory.java
│   │   │   ...
│   │
│   └───impresora
│   │   │   CitasPrinter.java
│   │   │   ConsoleCitasPrinter.java
│   │   │   ...
│   │
│   └───modelo
│   │   │   Apoderado.java
│   │   │   CitaMedica.java
│   │   │   DatosContacto.java
│   │   │   Paciente.java
│   │   │   Persona.java
│   │   │   ...
│   │
│   └───reglas
│   │   │   CitaValidationRule.java
│   │   │   CitaSinAnticipacionRule.java
│   │   │   FinDeSemanaRule.java
│   │   │   HorarioNoValidoRule.java
│   │   │   SinDisponibilidadRule.java
│   │   │   ...
│
└───resources
    │   med_input.txt
```


