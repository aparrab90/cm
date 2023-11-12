[Inicio](../README.md) | 
[Resumen](/doc/Resumen.md) | 
[__Estructura__](/doc/Estructura.md) | 
[Diagrama](/doc/Diagrama.md) |
[Patrones](/doc/Patrones.md) |
[Reglas](/doc/Reglas.md) |
[Servicios](/doc/Servicios.md)

## Estructura del proyecto

La estructura del proyecto se organiza de la siguiente manera:

```markdown
CM
└───doc
│   CitasMedicas.png
│   Diagrama.md
│   Estructura.md
│   Patrones.md
│   Reglas.md
│   Resumen.md
│   Servicios.md
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
│   └───servicios
│   │   │   CitaLoader.java
│
└───resources
│    │   med_input.txt
│
└───README.md
```


