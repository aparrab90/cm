# Test Packages
## **PruebasUnitariasFuncionales**
## HorariosConsecutivos
### Descripción
HorariosConsecutivosTest es una clase de prueba destinada a validar que las citas médicas se programen en intervalos consecutivos permitidos (por ejemplo, cada 20 minutos). Esta prueba verifica si el sistema rechaza correctamente las citas programadas en intervalos no permitidos, como a las 08:50 cuando solo se permiten horarios como 08:00, 08:20, 08:40, etc.
### Resultado Esperado
El sistema debe identificar y rechazar los intentos de programar citas en horarios no consecutivos. Se espera que en estos casos, la aplicación genere mensajes de error claros, indicando que la cita está programada en un intervalo no permitido. Estos mensajes deben reflejarse en la salida del sistema (outContent) capturada durante la prueba.
### Archivo de Input
El archivo de prueba med_input_HorariosConsecutivos.txt contiene los siguientes registros para evaluar la validación de horarios consecutivos en el sistema:
2023-11-17
08:20|ESPECIALISTA|OTORIN|MARIA NUNEZ         |PMENOR|P|AJH0000001|099000001|2015-01-03|APO|MARIA NUNEZ         |C|0202020202|1986-01-02|

NUEVA CITA
2023-11-17|08:00|ESPECIALISTA|OTORIN|MARIA A         |ADULTO|P|AJH0000002|099000001|1986-01-01|
2023-11-17|08:50|ESPECIALISTA|OTORIN|MARIA C         |ADULTO|P|AJH0000002|099000001|1986-01-01|
2023-11-17|12:20|ESPECIALISTA|OTORIN|MARIA C         |ADULTO|P|AJH0000002|099000001|1986-01-01|

## HorariosFinDeSemana
### Descripción
HorariosFinDeSemanaTest es una clase de prueba enfocada en verificar que el sistema de reservas de citas médicas rechaza correctamente las citas programadas para los fines de semana. Este test es fundamental para garantizar que el sistema cumpla con la regla de negocio que establece que no se deben agendar citas durante los sábados y domingos.
### Resultado Esperado
Se espera que el sistema identifique y rechace los intentos de programar citas durante los fines de semana. La aplicación debería generar mensajes de error claros que indiquen que las citas no pueden ser agendadas en estos días. Estos mensajes deben reflejarse en la salida del sistema (outContent) capturada durante la prueba.
### Archivo de Input
El archivo de prueba med_input_FinDeSemana.txt contiene registros de citas médicas, incluyendo algunas programadas para los días sábado y domingo, para evaluar la capacidad del sistema de rechazar estas citas. El archivo incluye los siguientes registros:
2023-11-17
08:00|GENERAL|      |JUAN PEREZ|ADULTO|C|0101010101|099000000|1986-01-01|
08:00|ESPECIALISTA|TRAUMA|JUANA RAMIREZ|ADULTO|C|0101010102|099000000|1986-01-02|
08:20|ESPECIALISTA|OTORIN|MARIA NUNEZ|PMENOR|P|AJH0000001|099000001|2015-01-03|APO|MARIA NUNEZ|C|0202020202|1986-01-02|
08:00|ESPECIALISTA|GINECO|LORENA DIAZ|ADULTO|C|0101010103|099000000|1986-01-04|
09:00|ESPECIALISTA|GINECO|LORENA DIAZ|ADULTO|C|0101010104|099000000|1986-01-05|

NUEVA CITA
2023-11-18|08:20|ESPECIALISTA|OTORIN|MARIA A|ADULTO|P|AJH0000002|099000001|1986-01-01|
2023-11-19|09:20|ESPECIALISTA|OTORIN|MARIA C|ADULTO|P|AJH0000002|099000001|1986-01-01|

## HorariosFueraHorario
### Descripción
HorariosFueraHorarioTest es una clase de prueba diseñada para validar que el sistema de reservas de citas médicas cumple con las restricciones de horario establecidas. En particular, esta prueba verifica si el sistema rechaza correctamente las citas programadas fuera del horario de atención definido, como citas muy tempranas en la mañana o tarde en la noche.
### Resultado Esperado
El sistema debe identificar y rechazar los intentos de programar citas fuera de los horarios de atención permitidos. Se espera que genere mensajes de error claros que indiquen que la cita está fuera del horario de atención. Estos mensajes deben aparecer en la salida del sistema (outContent) capturada durante la prueba.
### Archivo de Input
El archivo med_input_FueraHorario.txt incluye registros de citas médicas programadas fuera del horario de atención normal, así como citas dentro del horario para comprobar la consistencia de la validación. El contenido del archivo es el siguiente:
2023-11-17
08:00|GENERAL|      |JUAN PEREZ|ADULTO|C|0101010101|099000000|1986-01-01|
08:00|ESPECIALISTA|TRAUMA|JUANA RAMIREZ|ADULTO|C|0101010102|099000000|1986-01-02|
08:20|ESPECIALISTA|OTORIN|MARIA NUNEZ|PMENOR|P|AJH0000001|099000001|2015-01-03|APO|MARIA NUNEZ|C|0202020202|1986-01-02|
08:00|ESPECIALISTA|GINECO|LORENA DIAZ|ADULTO|C|0101010103|099000000|1986-01-04|
09:00|ESPECIALISTA|GINECO|LORENA DIAZ|ADULTO|C|0101010104|099000000|1986-01-05|

NUEVA CITA
2023-11-16|07:20|ESPECIALISTA|OTORIN|MARIA A|ADULTO|P|AJH0000002|099000001|1986-01-01|
2023-11-16|19:20|ESPECIALISTA|OTORIN|MARIA C|ADULTO|P|AJH0000002|099000001|1986-01-01|
2023-11-17|07:20|ESPECIALISTA|OTORIN|MARIA x|ADULTO|P|AJH0000002|099000001|1986-01-01|
2023-11-17|15:20|ESPECIALISTA|OTORIN|MARIA y|ADULTO|P|AJH0000002|099000001|1986-01-01|

## HorariosFuturos
### Descripción
HorariosFuturosTest es una clase de prueba diseñada para asegurarse de que el sistema de reservas de citas médicas solo acepte citas que estén programadas para fechas futuras. Esta prueba es crucial para evitar la programación de citas en fechas pasadas, lo cual sería inválido en el contexto de un sistema de reservas médicas.
### Resultado Esperado
Se espera que el sistema identifique y rechace cualquier intento de programar una cita en una fecha pasada. En caso de que se ingresen citas para fechas anteriores a la actual, el sistema debe generar mensajes de error indicando que las citas deben ser programadas para el futuro. Estos mensajes deberían ser capturados en la salida del sistema (outContent).
### Archivo de Input
El archivo med_input_HorarioFuturo.txt utilizado en esta prueba contiene registros de citas médicas con fechas tanto pasadas como futuras para evaluar la capacidad del sistema de manejar adecuadamente estos casos. El contenido del archivo es el siguiente:
2023-11-17
08:00|GENERAL     |      |JUAN PEREZ          |ADULTO|C|0101010101|099000000|1986-01-01|
08:00|ESPECIALISTA|TRAUMA|JUANA RAMIREZ       |ADULTO|C|0101010102|099000000|1986-01-02|
08:20|ESPECIALISTA|OTORIN|MARIA NUNEZ         |PMENOR|P|AJH0000001|099000001|2015-01-03|APO|MARIA NUNEZ         |C|0202020202|1986-01-02|
08:00|ESPECIALISTA|GINECO|LORENA DIAZ         |ADULTO|C|0101010103|099000000|1986-01-04|
09:00|ESPECIALISTA|GINECO|LORENA DIAZ         |ADULTO|C|0101010104|099000000|1986-01-05|

NUEVA CITA
2023-11-09|07:20|ESPECIALISTA|OTORIN|MARIA A         |ADULTO|P|AJH0000002|099000001|1986-01-01|
2023-11-09|15:20|ESPECIALISTA|OTORIN|MARIA C         |ADULTO|P|AJH0000002|099000001|1986-01-01|
2023-11-09|19:20|ESPECIALISTA|OTORIN|MARIA C         |ADULTO|P|AJH0000002|099000001|1986-01-01|
2023-11-10|07:20|ESPECIALISTA|OTORIN|MARIA x         |ADULTO|P|AJH0000002|099000001|1986-01-01|
2023-11-10|15:20|ESPECIALISTA|OTORIN|MARIA y         |ADULTO|P|AJH0000002|099000001|1986-01-01|

## PacienteDatosIncompletos
### Descripción
PacienteDatosIncompletosTest es una clase de prueba enfocada en asegurar que el sistema de reserva de citas médicas maneje adecuadamente los casos donde los datos del paciente están incompletos. La prueba verifica si el sistema identifica correctamente los registros de citas médicas que no cumplen con los requisitos mínimos de datos del paciente, como la falta de información esencial (nombre, identificación, fecha de nacimiento, etc.).
### Resultado Esperado
Se espera que el sistema detecte y rechace las citas que tengan datos incompletos del paciente. En tales casos, el sistema debe generar mensajes de error señalando la falta de datos completos. Estos mensajes deben ser visibles en la salida del sistema (outContent).
### Archivo de Input
El archivo med_input_PacienteDatosIncompletos.txt utilizado para esta prueba contiene varios registros de citas con distintas combinaciones de datos incompletos para evaluar cómo el sistema maneja cada uno de estos casos. El contenido del archivo incluye:
2023-11-17
08:00|ESPECIALISTA|OTORIN|MARIA NUNEZ         |PMENOR|P|AJH0000001|099000001|2015-01-03|APO|MARIA NUNEZ         |C|0202020202|1986-01-02|

NUEVA CITA
2023-11-17|08:20|ESPECIALISTA|OTORIN|MARIA           |ADULTO|P|AJH0000002|099000001|1986-01-01|APO|MARIA NUNEZ         |C|0202020202|1986-01-02|
2023-11-17|08:40|ESPECIALISTA|OTORIN|      C         |ADULTO|P|AJH0000002|099000001|1986-01-01|
2023-11-17|09:00|ESPECIALISTA|OTORIN|MARIA C         |ADULTO|P|AJH0000002|099000001|          |
2023-11-17|08:20|ESPECIALISTA|OTORIN|MARIA A         |ADULTO|P|          |099000001|1986-01-01|
2023-11-17|08:20|ESPECIALISTA|OTORIN|MARIA A         |ADULTO|P|AJH0000002|         |1986-01-01|

## PacienteMenorEdad
### Descripción
PacienteMenorEdadTest es una clase de prueba diseñada para verificar la correcta gestión de citas médicas para pacientes menores de edad en el sistema de reserva. Esta prueba se enfoca en asegurar que el sistema exija un apoderado válido, quien debe ser mayor de edad, para los pacientes menores. Se comprueba si el sistema rechaza las citas de menores de edad cuando no se cumple este requisito.
### Resultado Esperado
El sistema debe generar mensajes de error cuando una cita para un paciente menor de edad no cuenta con un apoderado válido o cuando el apoderado registrado es menor de edad. Estos mensajes deben aparecer en la salida del sistema (outContent).
### Archivo de Input
El archivo med_input_PacienteMenorEdad.txt utilizado para las pruebas incluye varios escenarios, donde algunos cumplen y otros no cumplen con los requisitos de un apoderado válido. El contenido del archivo es el siguiente:
2023-11-17
08:00|ESPECIALISTA|OTORIN|MARIA NUNEZ         |ADULTO|C|0101010101|099000000|1986-01-01|

NUEVA CITA
2023-11-17|08:20|ESPECIALISTA|OTORIN|MARIA C         |PMENOR|C|0202020202|099000001|2021-01-01|
2023-11-17|08:40|ESPECIALISTA|OTORIN|MARIA A         |PMENOR|C|0303030303|099000001|2020-01-01|APO|MARIA NUNEZ         |C|0505050505|1986-01-02|
2023-11-17|09:00|ESPECIALISTA|OTORIN|MARIA D         |PMENOR|C|0404040404|099000001|2020-01-01|APO|JUAN NUNEZ          |C|0606060606|2016-01-02|

## PacientesSimultaneos
### Descripción
PacientesSimultaneosTest se enfoca en validar la regla que impide que un mismo paciente tenga citas médicas simultáneas. Esta prueba es crucial para asegurar que el sistema de reserva de citas médicas funcione correctamente y no permita la asignación de múltiples citas en el mismo intervalo de tiempo para un solo paciente.
### Resultado Esperado
La aplicación debe generar un mensaje de error indicando que un paciente no puede tener citas simultáneas. Este mensaje debe ser visible en la salida del sistema (outContent), confirmando que la cita adicional no se ha agregado al sistema de manera incorrecta.
### Archivo de Input
El archivo med_input_PacientesSimultaneos.txt utilizado para las pruebas incluye citas programadas para el mismo paciente en diferentes horarios pero en la misma fecha. Esto simula el intento de agendar citas simultáneas para un solo paciente. El contenido del archivo es:
2023-11-17
08:00|ESPECIALISTA|OTORIN|MARIA NUNEZ         |ADULTO|C|0101010101|099000000|1986-01-01|

NUEVA CITA
2023-11-17|08:20|ESPECIALISTA|OTORIN|MARIA C         |ADULTO|C|0101010101|099000000|1986-01-01|
2023-11-17|08:40|ESPECIALISTA|OTORIN|MARIA A         |ADULTO|C|0101010101|099000000|1986-01-01|


## **_controlador_**
## ControladorTest
### Descripción
Se centra en probar la adición de citas médicas y su correcta impresión en la consola.
### Métodos de Prueba:
#### testAgregarYImprimirCitas()
**Descripción:** Este método prueba tanto la funcionalidad de agregar citas al controlador como la impresión de estas citas.
**Escenario de Prueba:**
**Precondiciones:** Se crea una instancia de Controlador, un paciente con sus datos de contacto, y una cita médica.
**Acción:** Se agrega la cita al controlador y luego se imprimen las citas.
**Resultado esperado:** Se espera que el mapa de citas del controlador contenga la cita agregada y que la salida impresa contenga la información detallada de la cita.

## **_excepciones_**
## CitaSinAnticipacionExceptionTest
### Descripción
Se centra en probar que la excepción maneja correctamente los mensajes de error y que se lanza como se espera bajo ciertas condiciones.
### Métodos de Prueba:
#### testExceptionMessage()
**Descripción:** Prueba que el mensaje de la excepción CitaSinAnticipacionException se establece y recupera correctamente.
**Escenario de Prueba:**
**Precondiciones:** Se crea una instancia de CitaSinAnticipacionException con un mensaje de error específico.
**Acción:** Se recupera el mensaje de la excepción creada.
**Resultado esperado:** El mensaje recuperado debe coincidir exactamente con el mensaje de error proporcionado al crear la excepción.
#### testExceptionThrowing()
**Descripción:** Verifica que la excepción CitaSinAnticipacionException se lance correctamente.
**Escenario de Prueba:**
**Precondiciones:** Ninguna.
**Acción:** Se lanza explícitamente una CitaSinAnticipacionException.
**Resultado esperado:** Se espera que la excepción CitaSinAnticipacionException sea lanzada, como se indica en la anotación @Test(expected = CitaSinAnticipacionException.class).

## CitaValidationExceptionTest
### Descripción
Se centra en asegurar que la excepción gestiona correctamente los mensajes de error y se lanza adecuadamente bajo ciertas condiciones.
### Métodos de Prueba:
#### testExceptionMessage()
**Descripción:** Prueba que el mensaje de la excepción CitaValidationException se establece y recupera correctamente.
**Escenario de Prueba:**
**Precondiciones:** Se crea una instancia de CitaValidationException con un mensaje de error específico.
**Acción:** Se recupera el mensaje de la excepción creada.
**Resultado esperado:** El mensaje recuperado debe coincidir exactamente con el mensaje de error proporcionado al crear la excepción.
#### testExceptionIsThrown()
**Descripción:** Verifica que la excepción CitaValidationException se lance correctamente.
**Escenario de Prueba:**
**Precondiciones:** Ninguna.
**Acción:** Se lanza explícitamente una CitaValidationException.
**Resultado esperado:** Se espera que la excepción CitaValidationException sea lanzada, como se indica en la anotación @Test(expected = CitaValidationException.class).

## FinDeSemanaExceptionTest
### Descripción
Se enfoca en asegurar que la excepción maneje correctamente los mensajes de error y se lance adecuadamente bajo ciertas condiciones.
### Métodos de Prueba:
#### testExceptionMessage()
**Descripción:** Prueba que el mensaje de la excepción FinDeSemanaException se establece y recupera correctamente.
**Escenario de Prueba:**
**Precondiciones:** Se crea una instancia de FinDeSemanaException con un mensaje de error específico.
**Acción:** Se recupera el mensaje de la excepción creada.
**Resultado esperado:** El mensaje recuperado debe coincidir exactamente con el mensaje de error proporcionado al crear la excepción.
#### testExceptionIsThrown()
**Descripción:** Verifica que la excepción FinDeSemanaException se lance correctamente.
**Escenario de Prueba:**
**Precondiciones:** Ninguna.
**Acción:** Se lanza explícitamente una FinDeSemanaException.
**Resultado esperado:** Se espera que la excepción FinDeSemanaException sea lanzada, como se indica en la anotación @Test(expected = FinDeSemanaException.class).

## HorarioNoValidoExceptionTest
### Descripción
Se enfoca en asegurar que la excepción maneja correctamente los mensajes de error y se lanza adecuadamente bajo condiciones específicas.
### Métodos de Prueba:
#### testExceptionMessage()
**Descripción:** Prueba que el mensaje de la excepción HorarioNoValidoException se establece y recupera correctamente.
**Escenario de Prueba:**
**Precondiciones:** Se crea una instancia de HorarioNoValidoException con un mensaje de error específico.
**Acción:** Se recupera el mensaje de la excepción creada.
**Resultado esperado:** El mensaje recuperado debe coincidir exactamente con el mensaje de error proporcionado al crear la excepción.
#### testExceptionIsThrown()
**Descripción:** Verifica que la excepción HorarioNoValidoException se lance correctamente.
**Escenario de Prueba:**
**Precondiciones:** Ninguna.
**Acción:** Se lanza explícitamente una HorarioNoValidoException.
**Resultado esperado:** Se espera que la excepción HorarioNoValidoException sea lanzada, como se indica en la anotación @Test(expected = HorarioNoValidoException.class).

## SinDisponibilidadExceptionTest
### Descripción
Se centra en asegurar que la excepción maneja correctamente los mensajes de error y se lanza adecuadamente bajo ciertas condiciones.
### Métodos de Prueba:
#### testExceptionMessage()
**Descripción:** Prueba que el mensaje de la excepción SinDisponibilidadException se establece y recupera correctamente.
**Escenario de Prueba:**
**Precondiciones:** Se crea una instancia de SinDisponibilidadException con un mensaje de error específico.
**Acción:** Se recupera el mensaje de la excepción creada.
**Resultado esperado:** El mensaje recuperado debe coincidir exactamente con el mensaje de error proporcionado al crear la excepción.
#### testExceptionIsThrown()
**Descripción:** Verifica que la excepción SinDisponibilidadException se lance correctamente.
**Escenario de Prueba:**
**Precondiciones:** Ninguna.
**Acción:** Se lanza explícitamente una SinDisponibilidadException.
**Resultado esperado:** Se espera que la excepción SinDisponibilidadException sea lanzada, como se indica en la anotación @Test(expected = SinDisponibilidadException.class).

## **_fabrica_**
## CitaMedicaFactoryTest
### Descripción
Se centra en probar la creación de objetos CitaMedica a partir de un arreglo de cadenas, asegurando que los objetos se creen correctamente y que la fábrica maneje adecuadamente los datos inválidos.
### Métodos de Prueba:
#### testCreateCitaMedica()
**Descripción:** Verifica la creación exitosa de una instancia de CitaMedica utilizando datos válidos.
**Escenario de Prueba:**
**Precondiciones:** Se configura una instancia de CitaMedicaFactory.
**Acción:** Se invoca createCitaMedica con un arreglo de cadenas que representa datos válidos de una cita médica.
**Resultado esperado:** Se espera que se cree una instancia de CitaMedica no nula y que sus propiedades coincidan con los datos proporcionados.
#### testCreateCitaMedicaWithInvalidData()
**Descripción:** Prueba la capacidad de la fábrica de manejar datos inválidos al crear una cita médica.
**Escenario de Prueba:**
**Precondiciones:** Se configura una instancia de CitaMedicaFactory.
**Acción:** Se invoca createCitaMedica con un arreglo de cadenas que representa datos insuficientes o inválidos para una cita médica.
**Resultado esperado:** Se espera que se lance una excepción IllegalArgumentException debido a los datos insuficientes o inválidos.

## SimpleCitaMedicaFactoryTest
### Descripción
Se centra en probar la creación de objetos CitaMedica utilizando diferentes conjuntos de datos, incluyendo casos con datos insuficientes y nulos.
### Métodos de Prueba:
#### testCreateCitaMedica()
**Descripción:** Verifica la creación exitosa de una instancia de CitaMedica utilizando datos válidos.
**Escenario de Prueba:**
**Precondiciones:** Se instancia SimpleCitaMedicaFactory.
**Acción:** Se invoca createCitaMedica con un arreglo de cadenas que representa datos válidos de una cita médica.
**Resultado esperado:** Se espera que se cree una instancia de CitaMedica no nula con propiedades que coincidan con los datos proporcionados, incluyendo la asignación de un paciente y la marca de nueva cita.
#### testCreateCitaMedicaWithInsufficientData()
**Descripción:** Prueba el manejo de datos insuficientes por parte de la fábrica al crear una cita médica.
**Escenario de Prueba:**
**Precondiciones:** Se instancia SimpleCitaMedicaFactory.
**Acción:** Se invoca createCitaMedica con un arreglo de cadenas que contiene datos insuficientes para una cita médica.
**Resultado esperado:** Se espera que se lance una excepción ArrayIndexOutOfBoundsException debido a la falta de datos suficientes.
#### testCreateCitaMedicaWithNullData()
**Descripción:** Verifica el manejo de datos nulos por parte de la fábrica.
**Escenario de Prueba:**
**Precondiciones:** Se instancia SimpleCitaMedicaFactory.
**Acción:** Se invoca createCitaMedica con un valor null.
**Resultado esperado:** Se espera que se lance una excepción NullPointerException al pasar null como parámetro.


## **_impresora_**
## CitasPrinterTest
### Descripción
Se centra en probar si las citas se imprimen correctamente en la consola.
### Métodos de Prueba:
#### testPrintCitas()
**Descripción:** Verifica que el método printCitas de una implementación de CitasPrinter imprime correctamente las citas médicas.
**Escenario de Prueba:**
**Precondiciones:** Se redirige la salida estándar (System.out) a un ByteArrayOutputStream para capturar la salida impresa.
Se crea una implementación ficticia de CitasPrinter (CitasPrinterImpl).
Se preparan datos de prueba, incluyendo una fecha, una cita médica y un mapa que asocia fechas con listas de citas médicas.
**Acción:** Se invoca printCitas con el mapa de citas.
**Resultado esperado:** La salida impresa debe coincidir con el formato y contenido esperado, incluyendo los detalles de la cita médica.
**Implementación de Prueba:** CitasPrinterImpl es una clase interna que implementa la interfaz CitasPrinter, utilizada solo con fines de prueba para simular la impresión de citas médicas.

## ConsoleCitasPrinterTest
### Descripción
El objetivo principal es asegurar que las citas se impriman correctamente, siguiendo el formato establecido.
### Métodos de Prueba:
#### testPrintCitas()
**Descripción:** Evalúa la correcta impresión de citas médicas en la consola por parte de ConsoleCitasPrinter.
**Escenario de Prueba:**
**Precondiciones:** Se redirige la salida estándar (System.out) a un ByteArrayOutputStream para capturar la salida impresa.
Se crea una instancia de ConsoleCitasPrinter.
Se preparan datos de prueba, incluyendo una fecha específica, una cita médica y un mapa que asocia fechas con listas de citas médicas.
**Acción:** Se invoca el método printCitas con el mapa de citas.
**Resultado esperado:** Se espera que la salida impresa en la consola coincida con el formato y contenido esperado, mostrando los detalles de la cita médica en la forma especificada.


## **_modelo_**
## ApoderadoTest
### Descripción
Se centra en probar el método isMayorEdad, que determina si un apoderado es legalmente mayor de edad.
### Métodos de Prueba:
#### testIsMayorEdadTrue()
**Descripción:** Evalúa que el método isMayorEdad retorne true cuando la fecha de nacimiento corresponde a una persona mayor de edad.
**Escenario de Prueba:**
**Precondiciones:** Se crea una instancia de Apoderado con una fecha de nacimiento que asegure que la persona es mayor de edad (20 años antes de la fecha actual).
**Acción:** Se invoca el método isMayorEdad.
**Resultado esperado:** El método isMayorEdad debe retornar true, indicando que el apoderado es mayor de edad.
#### testIsMayorEdadFalse()
**Descripción:** Verifica que el método isMayorEdad retorne false cuando la fecha de nacimiento corresponde a una persona menor de edad.
**Escenario de Prueba:**
**Precondiciones:** Se crea una instancia de Apoderado con una fecha de nacimiento que asegure que la persona es menor de edad (10 años antes de la fecha actual).
**Acción:** Se invoca el método isMayorEdad.
**Resultado esperado:** El método isMayorEdad debe retornar false, indicando que el apoderado no es mayor de edad.

## CitaMedicaTest
### Descripción
Esta clase de prueba se centra en validar la funcionalidad de la clase CitaMedica del modelo de dominio, asegurando que todas las propiedades y comportamientos de las instancias de CitaMedica se manejan de manera correcta.
### Métodos de Prueba:
#### testIsNuevaCita()
**Descripción:** Verifica que el método isNuevacita de CitaMedica retorne true para una cita marcada como nueva.
**Resultado esperado:** El método isNuevacita debe retornar true, indicando que la cita es nueva.
#### testGetPaciente()
**Descripción:** Comprueba que el método getPaciente retorne el objeto Paciente correcto asociado a la cita médica.
**Resultado esperado:** El paciente obtenido a través de getPaciente debe coincidir con el paciente usado en la configuración inicial.
#### testGetFecha()
**Descripción:** Evalúa que el método getFecha retorne la fecha correcta de la cita médica.
**Resultado esperado:** La fecha obtenida debe coincidir con la fecha establecida durante la creación de la instancia de prueba.
#### testGetHora()
**Descripción:** Prueba que el método getHora retorne la hora correcta de la cita médica.
**Resultado esperado:** La hora obtenida debe ser la misma que se estableció en la instancia de prueba.
#### testGetTipo()
**Descripción:** Verifica que el método getTipo retorne el tipo correcto de la cita médica.
**Resultado esperado:** El tipo de cita obtenido debe ser igual al configurado inicialmente.
#### testGetEspecialidad()
**Descripción:** Comprueba que el método getEspecialidad retorne la especialidad médica correcta de la cita.
**Resultado esperado:** La especialidad obtenida debe coincidir con la configurada en la instancia de prueba.

## DatosContactoTest
### Descripción
DatosContactoTest está diseñado para asegurar que la clase DatosContacto del modelo de dominio maneje adecuadamente los datos de contacto de un paciente, incluyendo el número de teléfono y el correo electrónico.
### Métodos de Prueba:
#### testGetTelefonoContacto()
**Descripción:** Verifica que el método getTelefonoContacto retorne correctamente el número de teléfono establecido.
**Resultado esperado:** El número de teléfono obtenido mediante getTelefonoContacto debe coincidir con el configurado en la instancia de prueba.
#### testSetTelefonoContacto()
**Descripción:** Evalúa que el método setTelefonoContacto actualice correctamente el número de teléfono en la instancia de DatosContacto.
**Resultado esperado:** Tras actualizar el número de teléfono con setTelefonoContacto, el número obtenido con getTelefonoContacto debe reflejar el cambio realizado.
#### testGetCorreoElectronico()
**Descripción:** Comprueba que el método getCorreoElectronico retorne de forma correcta el correo electrónico asignado.
**Resultado esperado:** El correo electrónico obtenido con getCorreoElectronico debe ser el mismo que el proporcionado durante la configuración inicial.
#### testSetCorreoElectronico()
**Descripción:** Prueba que el método setCorreoElectronico modifique adecuadamente el correo electrónico en la entidad DatosContacto.
**Resultado esperado:** Después de utilizar setCorreoElectronico para cambiar el correo, getCorreoElectronico debe devolver el nuevo correo electrónico establecido.

## PacienteTest
### Descripción
Esta clase de prueba garantiza que los datos del paciente y su apoderado (en caso de que lo tenga) se manejen correctamente.
### Métodos de Prueba:
#### testGetIdentificacion()
**Descripción:** Verifica que el método getIdentificacion retorne la identificación correcta del paciente.
**Resultado esperado:** La identificación obtenida debe coincidir con la establecida en setUp.
#### testGetNombres()
**Descripción:** Comprueba que el método getNombres retorne los nombres del paciente de manera precisa.
**Resultado esperado:** Los nombres obtenidos deben ser iguales a los proporcionados en setUp.
#### testGetApellidos()
**Descripción:** Evalúa que el método getApellidos devuelva los apellidos del paciente de forma correcta.
**Resultado esperado:** Los apellidos obtenidos deben coincidir con los asignados en setUp.
#### testGetFechaNacimiento()
**Descripción:** Prueba que el método getFechaNacimiento proporcione la fecha de nacimiento del paciente adecuadamente.
**Resultado esperado:** La fecha de nacimiento obtenida debe ser igual a la configurada en setUp.
#### testGetDatosContacto()
**Descripción:** Asegura que el método getDatosContacto devuelva los datos de contacto del paciente correctamente.
**Resultado esperado:** Los datos de contacto obtenidos deben ser los mismos que los establecidos en setUp.
#### testGetApoderado()
**Descripción:** Verifica que el método getApoderado retorne el apoderado del paciente, si lo hay.
**Resultado esperado:** El apoderado obtenido debe ser el mismo que el proporcionado en setUp.
#### testSetApoderado()
**Descripción:** Evalúa la capacidad de cambiar el apoderado de un paciente mediante el método setApoderado.
**Resultado esperado:** El apoderado debe actualizarse correctamente y reflejar el cambio cuando se obtiene con getApoderado.

## PersonaTest
### Descripción
PersonaTest proporciona un conjunto completo de pruebas para la clase Persona, asegurando la correcta inicialización y manejo de sus propiedades. Estas pruebas son fundamentales para garantizar la integridad de la entidad Persona en el contexto del dominio de reserva de citas médicas.
### Métodos de Prueba:
#### testConstructorWithArgs()
**Descripción:** Verifica que el constructor con parámetros de la clase Persona inicialice correctamente todas las propiedades.
**Resultado esperado:** La instancia creada debe tener todos los campos (identificación, nombres, apellidos, fecha de nacimiento y datos de contacto) correctamente asignados.
#### testDefaultConstructor()
**Descripción:** Comprueba que el constructor por defecto de la clase Persona crea una instancia sin lanzar errores.
**Resultado esperado:** Una instancia de Persona debe ser creada sin valores iniciales para sus propiedades.
#### testSetIdentificacion()
**Descripción:** Evalúa la funcionalidad del método setIdentificacion para actualizar la identificación de una Persona.
**Resultado esperado:** La identificación de la Persona debe actualizarse correctamente.
#### testSetNombres()
**Descripción:** Prueba la capacidad del método setNombres para cambiar los nombres de una Persona.
**Resultado esperado:** Los nombres de la Persona deben ser actualizados efectivamente.
#### testSetApellidos()
**Descripción:** Verifica la funcionalidad del método setApellidos en la actualización de los apellidos de una Persona.
**Resultado esperado:** Los apellidos de la Persona deben cambiar conforme a lo establecido en la prueba.
#### testSetFechaNacimiento()
**Descripción:** Comprueba que el método setFechaNacimiento actualice correctamente la fecha de nacimiento de una Persona.
**Resultado esperado:** La fecha de nacimiento de la Persona debe ser actualizada con el nuevo valor proporcionado.


## **_modelo_**
## CitaSinAnticipacionRuleTest
### Descripción
CitaSinAnticipacionRuleTest se encarga de probar la regla CitaSinAnticipacionRule, la cual valida que las citas con especialistas se agenden con al menos 24 horas de anticipación. Este conjunto de pruebas es crucial para garantizar que las citas se programen correctamente conforme a las normas establecidas.
### Métodos de Prueba:
#### testCitaEspecialistaSinAnticipacion()
**Descripción:** Evalúa el escenario donde se intenta agendar una cita con un especialista sin la anticipación requerida, lo que debería resultar en una excepción CitaSinAnticipacionException.
**Escenario de Prueba:** Creación de una cita de especialista para el día siguiente.
**Resultado esperado:** Se espera que la regla lance una CitaSinAnticipacionException, indicando que no se cumple con la anticipación mínima.
#### testCitaEspecialistaConAnticipacion()
**Descripción:** Verifica que la regla permita agendar una cita de especialista cuando se cumple con la anticipación mínima requerida.
**Escenario de Prueba:** Programación de una cita de especialista con más de 24 horas de anticipación.
**Resultado esperado:** La regla no debería lanzar ninguna excepción, validando correctamente la cita.
#### testCitaNoEspecialista()
**Descripción:** Comprueba que la regla CitaSinAnticipacionRule no aplique a citas que no son con especialistas, incluso si no se cumple con la anticipación de 24 horas.
**Escenario de Prueba:** Creación de una cita médica general para el día siguiente.
**Resultado esperado:** La regla no debe lanzar una excepción CitaSinAnticipacionException, ya que la restricción de anticipación solo aplica a citas con especialistas.

## FinDeSemanaRuleTest
### Descripción
FinDeSemanaRuleTest se enfoca en probar la regla FinDeSemanaRule, que asegura que no se puedan agendar citas médicas durante los fines de semana. Estas pruebas verifican que la regla funcione correctamente tanto para rechazar citas en días no permitidos como para aceptar citas en días hábiles.
### Métodos de Prueba:
#### testCitaEnSabado()
**Descripción:** Evalúa si la regla rechaza correctamente una cita programada para un sábado.
**Escenario de Prueba:** Creación de una cita médica en un sábado próximo.
**Resultado esperado:** Se espera que la regla lance una FinDeSemanaException, indicando que no se pueden agendar citas en sábado.
#### testCitaEnDomingo()
**Descripción:** Verifica si la regla rechaza adecuadamente una cita programada para un domingo.
**Escenario de Prueba:** Programación de una cita médica en un domingo próximo.
**Resultado esperado:** La regla debería lanzar una FinDeSemanaException, confirmando que los domingos no están permitidos para agendar citas.
#### testCitaEnDiaDeSemana()
**Descripción:** Comprueba que la regla FinDeSemanaRule permite agendar citas en días de semana, excluyendo el fin de semana.
**Escenario de Prueba:** Creación de una cita médica en un día de semana (ejemplo: lunes).
**Resultado esperado:** La regla no debe lanzar una FinDeSemanaException, validando correctamente la cita para un día de semana.

## HorarioNoValidoRuleTest
### Descripción
HorarioNoValidoRuleTest se enfoca en evaluar la funcionalidad de la regla HorarioNoValidoRule, que se asegura de que las citas médicas se programen dentro de los horarios establecidos. Esta clase de pruebas verifica el comportamiento esperado de la regla tanto para horarios válidos como para horarios que caen fuera del rango permitido.
### Métodos de Prueba:
#### testCitaAntesDeHorario()
**Descripción:** Verifica si la regla rechaza citas programadas antes del horario de inicio.
**Escenario de Prueba:** Programar una cita médica una hora antes del horario de inicio en un día laboral.
**Resultado esperado:** Lanzamiento de HorarioNoValidoException, indicando que la cita está fuera del horario de atención.
#### testCitaDespuesDeHorario()
**Descripción:** Evalúa si la regla rechaza citas programadas después del horario de cierre.
**Escenario de Prueba:** Programar una cita médica una hora después del horario de cierre en un día laboral que no sea viernes.
**Resultado esperado:** Lanzamiento de HorarioNoValidoException, confirmando que la cita está fuera del horario de atención.
#### testCitaDespuesDeHorarioEnViernes()
**Descripción:** Comprueba si la regla rechaza citas programadas después del horario de cierre específico para los viernes.
**Escenario de Prueba:** Agendar una cita una hora después del horario de cierre en un viernes.
**Resultado esperado:** Lanzamiento de HorarioNoValidoException, asegurando que la cita no cumple con el horario especial de los viernes.
#### testCitaDentroDeHorario()
**Descripción:** Asegura que la regla permite citas que se programan dentro del horario establecido.
**Escenario de Prueba:** Programar una cita médica una hora después del inicio de la jornada en un día laboral.
**Resultado esperado:** La cita debe ser validada sin lanzar una excepción, demostrando que se encuentra dentro del horario permitido.

## SinDisponibilidadRuleTest
### Descripción
SinDisponibilidadRuleTest evalúa la implementación de SinDisponibilidadRule, una regla que verifica la disponibilidad de citas médicas según el tipo (general o especialista) y la capacidad máxima permitida. La clase de prueba garantiza que la regla funcione correctamente tanto para casos donde hay disponibilidad como donde no la hay.
### Métodos de Prueba:
#### testSinDisponibilidadEspecialista()
**Descripción:** Verifica que la regla lance una excepción cuando se excede el número máximo de citas para especialistas.
**Escenario de Prueba:** Llenar el mapa de citas con el número máximo permitido de citas para especialistas y luego intentar agregar otra.
**Resultado esperado:** Se debe lanzar SinDisponibilidadException, indicando que no hay disponibilidad para más citas de especialistas.
#### testSinDisponibilidadGeneral()
**Descripción:** Evalúa que la regla lance una excepción cuando se alcanza el límite de citas para médicos generales.
**Escenario de Prueba:** Completar el mapa de citas con el máximo de citas para médicos generales y añadir una adicional.
**Resultado esperado:** Lanzamiento de SinDisponibilidadException, señalando la falta de disponibilidad para citas generales adicionales.
#### testConDisponibilidadEspecialista()
**Descripción:** Confirma que la regla permita agregar una cita cuando aún hay disponibilidad para especialistas.
**Escenario de Prueba:** Llenar el mapa de citas con menos del máximo de citas para especialistas y agregar una cita nueva.
**Resultado esperado:** La cita nueva debe ser validada sin lanzar excepciones, demostrando que aún hay disponibilidad.
#### testConDisponibilidadGeneral()
**Descripción:** Asegura que la regla permita añadir una cita para médicos generales cuando no se ha alcanzado el límite.
**Escenario de Prueba:** Agregar citas para médicos generales sin superar el límite y luego agregar una más.
**Resultado esperado:** La cita adicional debe ser validada sin lanzar SinDisponibilidadException, indicando que todavía hay cupos disponibles.


## **_servicios_**
## CitaLoaderTest
### Descripción
CitaLoaderTest se enfoca en probar la funcionalidad de la clase CitaLoader, la cual es responsable de cargar citas médicas desde un archivo de texto y agregarlas al controlador de citas. Este conjunto de pruebas garantiza que el proceso de carga de citas se realice correctamente y que las citas se agreguen al sistema de manera adecuada.
### Métodos de Prueba:
#### testCargarCitasMedicas()
**Descripción:** Evalúa la capacidad de CitaLoader para cargar citas desde un archivo y verificar que estas se agreguen al mapa de citas en el Controlador.
**Escenario de Prueba:** Utilizar un archivo de prueba con datos de citas para cargarlas en el sistema.
**Acción:** Ejecutar el método cargarCitasMedicas() de CitaLoader.
**Resultado esperado:** El mapa de citas en Controlador debe contener las citas cargadas, indicando que el proceso de carga fue exitoso y las citas se agregaron correctamente.
#### crearArchivoDePrueba()
**Descripción:** Método auxiliar para crear un archivo de prueba con datos de citas médicas.
**Acción:** Crea un archivo temporal con datos simulados de citas médicas.
**Resultado esperado:** Se crea un archivo que será utilizado por el método testCargarCitasMedicas().

## **_reservacitasmedicas_**
## ReservaCitasMedicasTest
### Descripción
ReservaCitasMedicasTest es una clase de prueba para el método main de la aplicación ReservaCitasMedicas. Esta prueba verifica si el método principal es capaz de leer correctamente las citas desde un archivo de entrada y procesarlas adecuadamente, asegurando que la lógica principal de la aplicación funcione como se espera.
### Métodos de Prueba:
#### setUpStreams()
**Descripción:** Configura un flujo de salida personalizado para capturar la salida de la consola durante las pruebas.
**Escenario de Prueba:** Utilizar un archivo de prueba con datos de citas para cargarlas en el sistema.
**Resultado esperado:** Todas las impresiones en la consola durante las pruebas se capturan en outContent.
#### testMain()
**Descripción:** Prueba el comportamiento del método main en ReservaCitasMedicas.
**Escenario de Prueba:** Se utiliza un archivo de prueba con datos de citas médicas válidos.
**Precondiciones:** El archivo de prueba debe existir y contener datos válidos.
**Acción:** Se ejecuta el método main con la ruta del archivo de prueba como argumento.
**Resultado esperado:** Se espera que la salida impresa contenga información relevante de las citas, indicando que el método main ha procesado correctamente las citas del archivo.
#### restoreStreams()
**Descripción:** Restaura el flujo de salida estándar después de completar las pruebas.
**Acción:** Restablece System.out al flujo de salida original.
**Resultado esperado:** Después de las pruebas, la salida de la consola vuelve a su comportamiento normal.