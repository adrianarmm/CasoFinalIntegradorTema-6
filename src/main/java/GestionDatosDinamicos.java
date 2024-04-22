import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private static Map<Integer, Character> numerosLetras = new HashMap<>();
    private static Map<Integer, String> numerosTexto = new HashMap<>();
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
        System.out.println("9. Asociar Número con Letra");
        System.out.println("10. Mostrar Asociación Número-Letra");
        System.out.println("11. Asociar Número con su Representación Textual");
        System.out.println("12. Mostrar Asociación Número-Texto");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Implementaciones para manejar ventas y nombres

    private static void asociarNumeroConLetra() {
        System.out.print("Ingrese un número: ");
        int numero = scanner.nextInt();
        System.out.print("Ingrese una letra: ");
        char letra = scanner.next().charAt(0);
        numerosLetras.put(numero, letra);
    }

    private static void mostrarAsociacionNumeroLetra() {
        numerosLetras.forEach((numero, letra) -> System.out.println("Número: " + numero + " - Letra: " + letra));
    }

    private static void asociarNumeroConTexto() {
        System.out.print("Ingrese un número: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea restante
        System.out.print("Ingrese su representación textual: ");
        String texto = scanner.nextLine();
        numerosTexto.put(numero, texto);
    }

    private static void mostrarAsociacionNumeroTexto() {
        numerosTexto.forEach((numero, texto) -> System.out.println("Número: " + numero + " - Texto: " + texto));
    }

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea restante

            switch (opcion) {
                case 1:
                    // agregarVenta();
                    break;
                case 2:
                    // modificarVenta();
                    break;
                case 3:
                    // eliminarVenta();
                    break;
                case 4:
                    // mostrarVentas();
                    break;
                case 5:
                    // filtrarVentasPorCantidad();
                    break;
                case 6:
                    // agregarNombre();
                    break;
                case 7:
                    // mostrarNombresOrdenados();
                    break;
                case 8:
                    // filtrarVentasPorCantidadMinima();
                    break;
                case 9:
                    asociarNumeroConLetra();
                    break;
                case 10:
                    mostrarAsociacionNumeroLetra();
                    break;
                case 11:
                    asociarNumeroConTexto();
                    break;
                case 12:
                    mostrarAsociacionNumeroTexto();
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
