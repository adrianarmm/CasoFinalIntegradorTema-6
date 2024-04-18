import java.util.ArrayList;
import java.util.Scanner;

public class GestionDatosDinamicos {
    private static ArrayList<Pareja<String, Double>> datos;
    private static Scanner scanner;

    public static void main(String[] args) {
        datos = new ArrayList<>();
        scanner = new Scanner(System.in);

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

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
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    // Métodos para agregar, modificar, eliminar, mostrar y filtrar datos
}