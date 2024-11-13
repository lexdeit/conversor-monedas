# Conversor de Moneda en Java

Este es un proyecto de aplicación de consola en Java para convertir montos de una moneda a otra utilizando la API [Exchange Rate API](https://www.exchangerate-api.com/). El usuario puede seleccionar monedas de origen y destino, y la aplicación realizará la conversión mostrando el monto convertido en pantalla. La aplicación está desarrollada en Java 21 y utiliza la biblioteca `GSON` para procesar respuestas JSON.

## Características

- Conversión de moneda en tiempo real utilizando la API de Exchange Rate.
- Selección dinámica de monedas a partir de una lista que puedes personalizar fácilmente.
- Menú intuitivo en consola que permite realizar múltiples conversiones sin reiniciar la aplicación.
- Configuración de salida sencilla para finalizar el programa.

## Requisitos

- Java 21
- IntelliJ IDEA (opcional, recomendado)
- Maven (para la gestión de dependencias)

## Dependencias

Este proyecto utiliza la biblioteca `GSON` para manejar el formato JSON. La dependencia de Maven está incluida en el archivo `pom.xml`:

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.9</version>
</dependency>
```

## Instalación y Configuración

- Clona el repositorio o descarga los archivos.
- Abre el proyecto en IntelliJ IDEA o en tu editor preferido.
- Asegúrate de tener configurado Java 21 en tu entorno.
- Importa las dependencias de Maven.

 ## Ejecución
  Para ejecutar la aplicación, simplemente ejecuta la clase Main desde tu entorno de desarrollo o usa el siguiente comando en la consola si estás en el directorio del proyecto:

```xml
mvn compile exec:java -Dexec.mainClass="com.example.currencyconverter.Main"
```

## Uso
1. Al iniciar la aplicación, verás un menú con opciones para seleccionar la moneda de origen.
2. Después, selecciona la moneda de destino.
3. Ingresa la cantidad que deseas convertir.
4. La aplicación mostrará el resultado de la conversión y te preguntará si deseas realizar otra conversión o salir.
5. Si decides continuar, el menú se reiniciará; de lo contrario, el programa finalizará.

## Ejemplo de Conversión
```
===== Bienvenido al Conversor de Moneda =====

Seleccione la moneda de origen:
1. MXN
2. USD
3. EUR
4. AUD
5. NZD
6. AED
7. CAD
Seleccione una opción: 1

Seleccione la moneda de destino:
1. MXN
2. USD
3. EUR
4. AUD
5. NZD
6. AED
7. CAD
Seleccione una opción: 2

Ingrese la cantidad a convertir: 100

Resultado: 100.0 MXN son 5.2 USD (Tasa: 0.05200)

¿Desea realizar otra conversión?
1. Sí
2. No, salir
Seleccione una opción: 1

```