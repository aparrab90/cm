[Inicio](../README.md) | 
[Resumen](/doc/Resumen.md) | 
[Estructura](/doc/Estructura.md) | 
[Diagrama](/doc/Diagrama.md) |
[__Patrones__](/doc/Patrones.md) |
[Reglas](/doc/Reglas.md) |
[Servicios](/doc/Servicios.md)

## Patrones de Diseño Implementados y Principios SOLID

### Patrones de Diseño

#### Factory Pattern

Utilizamos el patrón de Fábrica para crear objetos CitaMedica. Este patrón nos permite encapsular la lógica de creación de diferentes tipos de citas médicas y hace que el código sea más mantenible y escalable.

```java
public class SimpleCitaMedicaFactory implements CitaMedicaFactory {
    public CitaMedica createCitaMedica(...) {

    }
}
```

#### Strategy Pattern

Para las reglas de validación, se implementa el patrón de Estrategia. Cada regla es una estrategia, lo que facilita la adición de nuevas reglas sin modificar las existentes.

```java
public class FinDeSemanaRule implements CitaValidationRule {
    public void validate(CitaMedica citaMedica) throws CitaValidationException {

    }
}
```

### SOLID Principles

#### Single Responsibility Principle (SRP)

Cada clase tiene una única responsabilidad. Por ejemplo, ConsoleCitasPrinter solo es responsable de imprimir las citas.

```java
public class ConsoleCitasPrinter implements CitasPrinter {
    public void print(List<CitaMedica> citas) {

    }
}
```

#### Interface Segregation Principle (ISP)

Las interfaces se mantienen pequeñas y específicas para las necesidades del cliente, como la interfaz CitaValidationRule.

```java
public interface CitaValidationRule {
    void validate(CitaMedica cita) throws CitaValidationException;
}
```

#### Dependency Inversion Principle (DIP)

Los módulos de alto nivel no dependen de módulos de bajo nivel; ambos dependen de abstracciones. Por ejemplo, Controlador depende de la abstracción CitaMedicaFactory, no de la fábrica concreta.

```java
public class Controlador {
    private CitaMedicaFactory citaMedicaFactory;

    public Controlador(CitaMedicaFactory factory) {
        this.citaMedicaFactory = factory;
    }
}
```
