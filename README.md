# Sistema de Gestión de Tareas

Este proyecto es un Sistema de Gestión de Tareas simple desarrollado en Java utilizando una base de datos SQLite para el almacenamiento de usuarios y tareas. La aplicación permite a los usuarios agregar nuevas tareas, actualizar el estado de las tareas (resuelto o no resuelto) y visualizar las tareas pendientes.

## Requisitos

- Java 8 o superior
- Eclipse IDE (u otro entorno de desarrollo Java)
- Añadir como build path los ".jar" que estan dentro del repositorio 

## Configuración de la Base de Datos

La aplicación utiliza una base de datos SQLite para almacenar información sobre usuarios y tareas. Asegúrate de tener el controlador JDBC de SQLite correctamente configurado en tu proyecto.

La URL de conexión a la base de datos se encuentra en la clase `conexion.ConexionBD`. Ajusta la URL según tu configuración.

## Ejecución

1. Clona este repositorio o descarga el código fuente.
2. Abre el proyecto en Eclipse o tu entorno de desarrollo Java preferido.
3. Configura el controlador JDBC de SQLite en tu Build Path.
4. Ejecuta la clase `AppLauncher` para iniciar la aplicación.

## Funcionalidades

- **Agregar Tarea:** Permite a los usuarios agregar nuevas tareas proporcionando el ID de usuario y una descripción.
- **Actualizar Estado de Tarea:** Permite a los usuarios actualizar el estado de las tareas a "Resuelto" o "No Resuelto".
- **Visualizar Tareas Pendientes:** Permite a los usuarios visualizar las tareas pendientes proporcionando el ID de usuario.

## Uso

1. Inicia sesión.
2. Crea nuevas tareas.
3. Actualiza el estado de las tareas según sea necesario.
4. Visualiza las tareas pendientes.
