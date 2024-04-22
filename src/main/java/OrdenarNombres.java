
import java.util.Set;
import java.util.TreeSet;

public class OrdenarNombres {
    public static void main(String[] args) {
        Set<String> nombres = new TreeSet<>();
        nombres.add("Ana");
        nombres.add("Pedro");
        nombres.add("Maria");
        nombres.add("Carlos");

        System.out.println("Nombres ordenados:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }
}
