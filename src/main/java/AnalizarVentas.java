import java.util.List;
import java.util.stream.Collectors;

public class AnalizarVentas {
    public static void main(String[] args) {
        List<Venta> ventas = List.of(
                new Venta("Manzanas", 50),
                new Venta("Platanos", 20),
                new Venta("Naranjas", 70)
        );

        int cantidadMinima = 30;
        List<Venta> ventasFiltradas = ventas.stream()
                .filter(v -> v.cantidad > cantidadMinima)
                .collect(Collectors.toList());

        System.out.println("Ventas con cantidad mayor a " + cantidadMinima + ":");
        ventasFiltradas.forEach(System.out::println);
    }
}
