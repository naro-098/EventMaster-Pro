# EventMaster Pro

EventMaster Pro es una app desarrollada en Java usando Swing para la gestión de eventos y todo lo relacionado con estos, como locaciones, artistas, tickets y asistentes. 

## Funcionalidades

- Agregar eventos 
- Agregar y mostrar locaciones
- Asignar y validar tickets
- Exportar eventos y tickets a archivos CSV
- Mostrar ganancias por venta de tickets

## Tecnologías utilizadas

- Java
- Netbeans 

## Estructura del proyecto

- Main: menú principal para las acciones
- Event: clase para representar eventos
- Location: clase para gestionar las locaciones disponibles
- Ticket: clase para gestionar los tickets y sus precios
- User, Host, attendant
- Validator: interfaz para validar disponibilidad
- LocationNotFoundException: excepción personalizada

## Cómo ejecutar

1. Abre el proyecto en NetBeans.
2. Ejecuta Main.java.
3. Interactúa con la aplicación mediante las ventanas emergentes.



- files/events/events.csv: contiene todos los eventos registrados
- files/tickets/tickets.csv: contiene todos los tickets asignados

## Autores

Desarrollado por [Tu Nombre] como parte del curso de Construcción de Software I.
