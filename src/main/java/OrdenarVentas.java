import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

public class OrdenarVentas {
    public static void main(String[] args) {
        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta("Manzanas", 50));
        ventas.add(new Venta("Bananas", 20));
        ventas.add(new Venta("Naranjas", 70));

        // Ordenar por cantidad
        ventas.sort(Comparator.comparingInt(v -> v.cantidad));
        System.out.println("Ordenado por cantidad:");
        ventas.forEach(System.out::println);

        // Ordenar por nombre del producto
        ventas.sort(Comparator.comparing(v -> v.producto));
        System.out.println("\nOrdenado por nombre del producto:");
        ventas.forEach(System.out::println);
    }
}