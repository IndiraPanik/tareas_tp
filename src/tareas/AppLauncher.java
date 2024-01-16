package tareas;

import java.util.Scanner;

public class AppLauncher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorTareas gestorTareas = new GestorTareas();
        GestorUsuarios gestorUsuarios = new GestorUsuarios();
        int usuarioActual = -1;

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Agregar Tarea");
            System.out.println("4. Actualizar Estado de Tarea");
            System.out.println("5. Visualizar Tareas Pendientes");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
	            case 1:
	                System.out.print("Ingrese el nombre de usuario: ");
	                String nuevoUsuario = scanner.nextLine();
	                System.out.print("Ingrese la contraseña: ");
	                String nuevaContraseña = scanner.nextLine();
	                gestorUsuarios.crearUsuario(nuevoUsuario, nuevaContraseña);
	                System.out.println("Usuario creado correctamente. Ahora puedes iniciar sesión.");
	                break;
                case 2:
                    System.out.print("Ingrese el nombre de usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("Ingrese la contraseña: ");
                    String contraseña = scanner.nextLine();
                    if (gestorUsuarios.verificarCredenciales(nombreUsuario, contraseña)) {
                        System.out.println("Inicio de sesión exitoso.");
                        usuarioActual = obtenerIdUsuario(nombreUsuario);
                    } else {
                        System.out.println("Credenciales incorrectas. Vuelve a intentarlo.");
                    }
                    break;
                case 3:
                    if (usuarioActual != -1) {
                        System.out.print("Ingrese la descripción de la tarea: ");
                        String descripcion = scanner.nextLine();
                        gestorTareas.agregarTarea(usuarioActual, descripcion);
                    } else {
                        System.out.println("Debes iniciar sesión para agregar una tarea.");
                    }
                    break;
                case 4:
                    if (usuarioActual != -1) {
                        System.out.print("Ingrese el ID de la tarea a actualizar: ");
                        int idTarea = scanner.nextInt();
                        System.out.print("Ingrese el nuevo estado (1 para RESUELTO, 0 para NO RESUELTO): ");
                        int nuevoEstado = scanner.nextInt();
                        gestorTareas.actualizarEstadoTarea(idTarea, nuevoEstado);
                    } else {
                        System.out.println("Debes iniciar sesión para actualizar una tarea.");
                    }
                    break;
                case 5:
                    if (usuarioActual != -1) {
                        gestorTareas.visualizarTareasPendientes(usuarioActual);
                    } else {
                        System.out.println("Debes iniciar sesión para ver tareas pendientes.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
    
    private static int obtenerIdUsuario(String nombreUsuario) {
        GestorUsuarios gestorUsuarios = new GestorUsuarios();
        return gestorUsuarios.obtenerIdUsuario(nombreUsuario);
    }
}