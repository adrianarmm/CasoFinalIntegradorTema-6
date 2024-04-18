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

    private static void mostrarMenu() {

    }

    // Métodos para agregar, modificar, eliminar, mostrar y filtrar datos

    private static void agregarDato() {
        System.out.print("Introduce el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce el valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consumir salto de línea
        datos.add(new Pareja<>(nombre, valor));
    }

    private static void modificarDato() {
        System.out.print("Introduce el nombre del dato a modificar: ");
        String nombre = scanner.nextLine();
        int indice = buscarDato(nombre);
        if (indice != -1) {
            System.out.print("Introduce el nuevo valor: ");
            double valor = scanner.nextDouble();
            scanner.nextLine(); // Consumir salto de línea
            datos.set(indice, new Pareja<>(nombre, valor));
        } else {
            System.out.println("El dato no existe.");
        }
    }

    private static int buscarDato(String buscardato) {
        return 0;
    }

    private static void eliminarDato() {
        System.out.print("Introduce el nombre del dato a eliminar: ");
        String nombre = scanner.nextLine();
        int indice = buscarDato(nombre);
        if (indice != -1) {
            datos.remove(indice);
        } else {
            System.out.println("El dato no existe.");
        }
    }

    private static void mostrarDatos() {
        System.out.println("Datos:");
        for (Pareja<String, Double> dato : datos) {
            System.out.println(dato);
        }
    }

    private static void filtrarDatos() {
        System.out.print("Introduce el valor mínimo: ");
        double valorMinimo = scanner.nextDouble();
        scanner.nextLine(); // Consumir salto de línea
        System.out.println("Datos con valor mayor o igual a " + valorMinimo + ":");
        for (Pareja<String, Double> dato : datos) {
            if (dato.getValor() >= valorMinimo) {
                System.out.println(dato);
            }
        }
    }

}