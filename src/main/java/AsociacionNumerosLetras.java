import java.util.HashMap;
import java.util.Map;

public class AsociacionNumerosLetras {
    public static void main(String[] args) {
        Map<Integer, Character> numerosLetras = new HashMap<>();
        numerosLetras.put(1, 'A');
        numerosLetras.put(2, 'B');
        numerosLetras.put(3, 'C');
        numerosLetras.put(4, 'D');

        // Mostrar la letra asociada a un número
        int numero = 3;
        if (numerosLetras.containsKey(numero)) {
            System.out.println("El número " + numero + " está asociado a la letra " + numerosLetras.get(numero));
        } else {
            System.out.println("El número no tiene una letra asociada.");
        }
    }
}
