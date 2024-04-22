import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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

    // Getters necesarios para la manipulación y comparación
    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
}

public class GestionVentas {
    private static List<Venta> ventas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static void mostrarMenu() {
        System.out.println("\n1. Agregar Venta");
        System.out.println("2. Modificar Venta");
        System.out.println("3. Eliminar Venta");
        System.out.println("4. Mostrar Ventas");
        System.out.println("5. Filtrar Ventas por Cantidad");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarVenta() {
        System.out.print("Ingrese el producto: ");
        String producto = scanner.nextLine();
        System.out.print("Ingrese la cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea restante
        ventas.add(new Venta(producto, cantidad));
    }

    private static void modificarVenta() {
        System.out.print("Ingrese el índice de la venta a modificar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea restante
        if (indice >= 0 && indice < ventas.size()) {
            System.out.print("Ingrese el nuevo producto: ");
            String producto = scanner.nextLine();
            System.out.print("Ingrese la nueva cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea restante
            ventas.set(indice, new Venta(producto, cantidad));
        } else {
            System.out.println("Índice inválido");
        }
    }

    private static void eliminarVenta() {
        System.out.print("Ingrese el índice de la venta a eliminar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea restante
        if (indice >= 0 && indice < ventas.size()) {
            ventas.remove(indice);
        } else {
            System.out
