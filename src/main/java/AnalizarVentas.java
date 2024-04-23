import java.util.List;
import java.util.stream.Collectors;

public class AnalizarVentas {
    public static void main(String[] args) {
        List<Ventas> ventas = List.of(
                new Ventas("Manzanas", 50),
                new Ventas("Platanos", 20),
                new Ventas("Naranjas", 70)
        );

        int cantidadMinima = 30;
        List<Ventas> ventasFiltradas = ventas.stream()
                .filter(v -> v.getCantidad() > cantidadMinima)
                .collect(Collectors.toList());

        System.out.println("Ventas con cantidad mayor a " + cantidadMinima + ":");
        ventasFiltradas.forEach(System.out::println);
    }
}
