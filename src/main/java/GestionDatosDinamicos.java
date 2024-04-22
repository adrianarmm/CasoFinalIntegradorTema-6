import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Venta {
    String producto;
    int cantidad;

    public Venta(String producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto: " + producto + ", Cantidad: " + cantidad;
    }
}

public class GestionGeneral {
    private static List<Venta> ventas = new ArrayList<>();
    private static Set<String> nombres = new TreeSet<>();
    private static Scanner scanner = new Scanner(System.in);

    private static void mostrarMenu() {
        System.out.println("\n1. Agregar Venta");
        System.out.println("2. Modificar Venta");
        System.out.println("3. Eliminar Venta");
        System.out.println("4. Mostrar Ventas");
        System.out.println("5. Filtrar Ventas por Cantidad");
        System.out.println("6. Agregar Nombre");
        System.out.println("7. Mostrar Nombres Ordenados");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Métodos para manejar ventas (agregarVenta, modificarVenta, etc.)
    // Añadiré solo los cambios relevantes para incluir el manejo de nombres.

    private static void agregarNombre() {
        System.out.print("Ingrese el nombre a agregar: ");
        String nombre = scanner.nextLine();
        nombres.add(nombre);
    }

    private static void mostrarNombresOrdenados() {
        System.out.println("Nombres ordenados:");
        nombres.forEach(System.out::println);
    }

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea restante

            switch (opcion) {
                case 1:
                    // Llamar a agregarVenta();
                    break;
                case 2:
                    // Llamar a modificarVenta();
                    break;
                case 3:
                    // Llamar a eliminarVenta();
                    break;
                case 4:
                    // Llamar a mostrarVentas();
                    break;
                case 5:
                    // Llamar a filtrarVentasPorCantidad();
                    break;
                case 6:
                    agregarNombre();
                    break;
                case 7:
                    mostrarNombresOrdenados();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 0);
        scanner.close();
    }
}
