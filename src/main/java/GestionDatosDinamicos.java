import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

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

public class GestionDatosDinamicos {
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
        System.out.println("8. Filtrar Ventas por Cantidad Mínima");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Métodos previamente descritos para manejar ventas y nombres.
    // Por simplicidad, se omiten aquí pero deben ser incluidos en tu implementación.

    private static void filtrarVentasPorCantidadMinima() {
        System.out.print("Ingrese la cantidad mínima: ");
        int cantidadMinima = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea restante

        List<Venta> ventasFiltradas = ventas.stream()
                .filter(v -> v.cantidad > cantidadMinima)
                .collect(Collectors.toList());

        System.out.println("Ventas con cantidad mayor a " + cantidadMinima + ":");
        ventasFiltradas.forEach(System.out::println);
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
                    // Llamar a agregarNombre();
                    break;
                case 7:
                    // Llamar a mostrarNombresOrdenados();
                    break;
                case 8:
                    filtrarVentasPorCantidadMinima();
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
