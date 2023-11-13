[Inicio](../README.md) | 
[Resumen](/doc/Resumen.md) | 
[__Estructura__](/doc/Estructura.md) | 
[Diagrama](/doc/Diagrama.md) |
[Patrones](/doc/Patrones.md) |
[Servicios](/doc/Servicios.md) |
[Ejecución](/doc/Ejecucion.md) |
[Test](/doc/Test.md)

# Reserva de Citas Médicas | Estructura del proyecto

La estructura del proyecto se organiza de la siguiente manera:

```markdown
CM
└───doc
│   └───imgs
│   │   │   CitaSinAnticipacionRule/
│   │   │   CitaValidationRule/
│   │   │   FinDeSemanaRule/
│   │   │   HorarioNoValidoRule/
│   │   │   SinDisponibilidadRule/
│   │   diagrama.png
│   Diagrama.md
│   Ejecucion.md
│   Estructura.md
│   Patrones.md
│   Resumen.md
│   Servicios.md
│
└───src
│   │
│   └───controlador
│   │   │   Controlador.java
│   │
│   └───excepciones
│   │   │   CitaSinAnticipacionException.java
│   │   │   CitaValidationException.java
│   │   │   FinDeSemanaException.java
│   │   │   HorarioNoValidoException.java
│   │   │   SinDisponibilidadException.java
│   │
│   └───fabrica
│   │   │   CitaMedicaFactory.java
│   │   │   SimpleCitaMedicaFactory.java
│   │
│   └───impresora
│   │   │   CitasPrinter.java
│   │   │   ConsoleCitasPrinter.java
│   │
│   └───modelo
│   │   │   Apoderado.java
│   │   │   CitaMedica.java
│   │   │   DatosContacto.java
│   │   │   Paciente.java
│   │   │   Persona.java
│   │
│   └───reglas
│   │   │   CitaSinAnticipacionRule.java
│   │   │   CitaValidationRule.java
│   │   │   FinDeSemanaRule.java
│   │   │   HorarioNoValidoRule.java
│   │   │   SinDisponibilidadRule.java
│   │
│   └───reservacitasmedicas
│   │   │   ReservaCitasMedicas.java
│   │
│   └───resources
│   │   │   med_input.txt
│   │
│   └───servicios
│   │   │   CitaLoader.java
│
└───test
│   └───controlador
│   │   │   ControladorTest.java
│   │
│   └───excepciones
│   │   │   CitaSinAnticipacionExceptionTest.java
│   │   │   CitaValidationExceptionTest.java
│   │   │   FinDeSemanaExceptionTest.java
│   │   │   HorarioNoValidoExceptionTest.java
│   │   │   SinDisponibilidadExceptionTest.java
│   │
│   └───fabrica
│   │   │   CitaMedicaFactoryTest.java
│   │   │   SimpleCitaMedicaFactoryTest.java
│   │
│   └───impresora
│   │   │   CitasPrinterTest.java
│   │   │   ConsoleCitasPrinterTest.java
│   │
│   └───modelo
│   │   │   ApoderadoTest.java
│   │   │   CitaMedicaTest.java
│   │   │   DatosContactoTest.java
│   │   │   PacienteTest.java
│   │   │   PersonaTest.java
│   │
│   └───reglas
│   │   │   CitaSinAnticipacionRuleTest.java
│   │   │   CitaValidationRuleTest.java
│   │   │   FinDeSemanaRuleTest.java
│   │   │   HorarioNoValidoRuleTest.java
│   │   │   SinDisponibilidadRuleTest.java
│   │
│   └───reservacitasmedicas
│   │   │   ReservaCitasMedicasTest.java
│   │
│
└───README.md
```


