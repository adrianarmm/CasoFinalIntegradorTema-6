import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

class Venta {
    private final String producto;
    private final int cantidad;

    public Venta(String producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto: " + producto + ", Cantidad: " + cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
}

public class GestionDatosDinamicos {
    private static List<Venta> ventas = new ArrayList<>();
    private static Set<String> nombres = new TreeSet<>();
    private static Map<Integer, Character> numerosLetras = new HashMap<>();
    private static Map<Integer, String> numerosTexto = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    private static List<archivo> archivosIndexados = new ArrayList<>();

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
        System.out.println("13. Indexar Archivo");
        System.out.println("14. Mostrar Archivos Indexados Ordenados");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

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

    private static void agregarVenta() {
        System.out.print("Ingrese el nombre del producto: "); String producto = scanner.nextLine();
        System.out.print("Ingrese la cantidad: ");
        int cantidad = scanner.nextInt();
        ventas.add(new Venta(producto, cantidad));
    }

    private static void modificarVenta() {
        System.out.print("Ingrese el índice de la venta a modificar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea restante

        if (indice >= 0 && indice < ventas.size()) {
            System.out.print("Ingrese el nuevo nombre del producto: ");
            String producto = scanner.nextLine();
            System.out.print("Ingrese la nueva cantidad: ");
            int cantidad = scanner.nextInt();
            ventas.set(indice, new Venta(producto, cantidad));
        } else {
            System.out.println("El índice proporcionado no es válido.");
        }
    }

    private static void eliminarVenta() {
        System.out.print("Ingrese el índice de la venta a eliminar: ");
        int indice = scanner.nextInt();
        if (indice >= 0 && indice < ventas.size()) {
            ventas.remove(indice);
        } else {
            System.out.println("El índice proporcionado no es válido.");
        }
    }

    private static void mostrarVentas() {
        ventas.forEach(System.out::println);
    }
    private static void filtrarVentasPorCantidad() {
        System.out.print("Ingrese la cantidad mínima: ");
        int cantidadMinima = scanner.nextInt();
        List<Venta> ventasFiltradas = ventas.stream()
                .filter(venta -> venta.getCantidad() >= cantidadMinima)
                .collect(Collectors.toList());
        ventasFiltradas.forEach(System.out::println);
    }

    private static void agregarNombre() {
        System.out.print("Ingrese un nombre: ");
        String nombre = scanner.nextLine();
        nombres.add(nombre);
    }

    private static void mostrarNombresOrdenados() {
        if (nombres.isEmpty()) {
            System.out.println("No hay nombres para mostrar.");
            return;
        }

        System.out.println("Nombres ordenados:");
        System.out.println("==================");

        int contador = 1;
        for (String nombre : nombres) {
            System.out.println(contador + ". " + nombre);
            contador++;
        }

        System.out.println("==================");
        System.out.println("Total de nombres: " + nombres.size());
    }


    private static void filtrarVentasPorCantidadMinima() {
        System.out.print("Ingrese la cantidad mínima: ");
        int cantidadMinima;
        try {
            cantidadMinima = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next(); // Limpiar el buffer del scanner.
            return;
        } finally {
            scanner.nextLine(); // Asegurarse de consumir el salto de línea después de leer el número.
        }

        List<Venta> ventasFiltradas = ventas.stream()
                .filter(venta -> venta.getCantidad() >= cantidadMinima)
                .collect(Collectors.toList());

        if (ventasFiltradas.isEmpty()) {
            System.out.println("No hay ventas que cumplan el criterio.");
        } else {
            System.out.println("Ventas con cantidad mayor a " + cantidadMinima + ":");
            ventasFiltradas.forEach(System.out::println);
        }
    }

    private static void indexarArchivo(String rutaDirectorio) {
        File directorio = new File(rutaDirectorio);
        File[] archivosEnDirectorio = directorio.listFiles();
        if (archivosEnDirectorio != null) {
            for (File archivo : archivosEnDirectorio) {
                if (archivo.isFile()) {
                    archivosIndexados.add(new archivo(archivo.getName(), archivo.getAbsolutePath()));
                } else if (archivo.isDirectory()) {
                    indexarArchivo(archivo.getAbsolutePath()); // Llamada recursiva para subdirectorios
                }
            }
        }
    }

    private static void mostrarArchivosIndexadosOrdenados() {
        Collections.sort(archivosIndexados);
        for (archivo archivo : archivosIndexados) {
            System.out.println(archivo);
        }
    }

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea restante

            switch (opcion) {
                case 1:
                    agregarVenta();
                    break;
                case 2:
                    modificarVenta();
                    break;
                case 3:
                    eliminarVenta();
                    break;
                case 4:
                    mostrarVentas();
                    break;
                case 5:
                    filtrarVentasPorCantidad();
                    break;
                case 6:
                    agregarNombre();
                    break;
                case 7:
                    mostrarNombresOrdenados();
                    break;
                case 8:
                    filtrarVentasPorCantidadMinima();
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
                case 13:
                    System.out.print("Ingrese la ruta del directorio a indexar: ");
                    String ruta = scanner.nextLine();
                    indexarArchivo(ruta);
                    break;
                case 14:
                    mostrarArchivosIndexadosOrdenados();
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

class archivo implements Comparable<archivo> {
    private final String nombre;
    private final String ruta;

    public archivo(String nombre, String ruta) {
        this.nombre = nombre;
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Ruta: " + ruta;
    }

    @Override
    public int compareTo(archivo otroArchivo) {
        return this.nombre.compareTo(otroArchivo.nombre);
    }

    public String getNombre() {
        return nombre;
    }
}