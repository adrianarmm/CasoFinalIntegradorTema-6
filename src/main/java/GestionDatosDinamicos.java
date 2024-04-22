import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class GestionDatosDinamicos {

    private static List<Dato> datos = new ArrayList<>(); // Inicialización de la lista
    private static Scanner scanner = new Scanner(System.in); // Scanner como variable estática para reutilización

    private static void mostrarMenu() {
        System.out.println("1. Agregar Dato");
        System.out.println("2. Modificar Dato");
        System.out.println("3. Eliminar Dato");
        System.out.println("4. Mostrar Datos");
        System.out.println("5. Filtrar Datos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea restante

            switch (opcion) {
                case 1:
                    agregarDato();
                    break;
                case 2:
                    modificarDato();
                    break;
                case 3:
                    eliminarDato();
                    break;
                case 4:
                    mostrarDatos();
                    break;
                case 5:
                    filtrarDatos();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 0);
        System.out.println("Saliendo...");
        scanner.close();
    }

    // Métodos de operación (dejaré estos como ejemplos para que los completes)
    private static void agregarDato() {
        // Implementación para agregar un Dato
    }

    private static void modificarDato() {
        // Implementación para modificar un Dato
    }

    // Otros métodos como eliminarDato(), mostrarDatos(), filtrarDatos()

    private static int buscarDato(String buscardato) {
        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).getClave().equals(buscardato)) {
                return i;
            }
        }
        return -1;
    }
}
