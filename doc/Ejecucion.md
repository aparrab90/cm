[Inicio](../README.md) |
[Resumen](/doc/Resumen.md) |
[Estructura](/doc/Estructura.md) |
[Diagrama](/doc/Diagrama.md) |
[Patrones](/doc/Patrones.md) |
[Servicios](/doc/Servicios.md) |
[**Ejecución**](/doc/imgs.md) |
[Test](/doc/Test.md)


# Reserva de Citas Médicas | Manual de Ejecución

Este manual proporciona las instrucciones necesarias para ejecutar el Sistema de Gestión de Citas Médicas. Asegúrate de tener todas las dependencias instaladas antes de comenzar.

## Requisitos Previos

- Java 8 o superior instalado.
- [Git](https://github.com/aparrab90/cm.git) para clonar el repositorio.

## Pasos de Ejecución

### 1. Clonar el Repositorio

Abre la terminal y ejecuta el siguiente comando para clonar el repositorio:

```bash
git clone https://github.com/aparrab90/cm.git
```
### 1. Clonar el Repositorio Netbeans

- Abre NetBeans.

- Ve al menú "Team" y selecciona "Git" y luego "Clone...".

- En la ventana emergente, ingresa la URL del repositorio que deseas clonar en el campo "Repository URL".

- Copy code
```bash
https://github.com/aparrab90/cm.git
```
- Selecciona la carpeta de destino en tu sistema local donde deseas clonar el repositorio.
- Haz clic en "Next" y sigue las instrucciones para completar el proceso de clonación.




### 2. Ingresar nuevas citas médicas

Navega al directorio del proyecto y abre el archivo:
resources/`med_input.txt` e ingresa la fecha y horario.

### 3. Compilar el Proyecto

Navega al directorio del proyecto y ejecute el archivo principal: src/reservacitasmedicas/`ReservaCitasMedicas.java`.

### 4. Ejemplos

#### 4.1 FinDeSemanaRule

Regla que evita agendar citas en fines de semana.

- Ingreso de información y respuesta
  ![Texto Alternativo](/doc/imgs/FinDeSemanaRule/ima2.JPG)
- Code donde se valida
  ![Texto Alternativo](/doc/imgs/FinDeSemanaRule/ima1.JPG)

#### 4.2 CitaSinAnticipacionRule

Regla que valida que las citas con especialistas se agenden con anticipación.

- Ingreso de información y respuesta
  ![Texto Alternativo](/doc/imgs/CitaSinAnticipacionRule/ima1.JPG)
- Code donde se valida
  ![Texto Alternativo](/doc/imgs/CitaSinAnticipacionRule/ima2.JPG)

#### 4.3 HorarioNoValidoRule

Regla que valida que la cita está dentro del horario de atención.

- Ingreso de información y respuesta
  ![Texto Alternativo](/doc/imgs/HorarioNoValidoRule/ima1.JPG)
- Code donde se valida
  ![Texto Alternativo](/doc/imgs/HorarioNoValidoRule/ima2.JPG)


#### 4.4 SinDisponibilidadRule

Regla que verifica la disponibilidad de profesionales para una cita.

- Ingreso de información y respuesta
  ![Texto Alternativo](/doc/imgs/SinDisponibilidadRule/ima1.JPG)
- Code donde se valida
  ![Texto Alternativo](/doc/imgs/SinDisponibilidadRule/ima2.JPG)


#### 4.5 CitaValidationRule (Supera todas la validaciones)

La interfaz CitaValidationRule define un conjunto de reglas de validación que se aplican a las citas médicas. Las clases que implementan esta interfaz deben proporcionar una implementación del método validate.

- Ingreso de información y respuesta
  ![Texto Alternativo](/doc/imgs/CitaValidationRule/ima2.JPG)
- Code donde se valida
  ![Texto Alternativo](/doc/imgs/CitaValidationRule/ima1.JPG)