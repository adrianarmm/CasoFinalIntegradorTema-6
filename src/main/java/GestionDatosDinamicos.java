
import java.util.Scanner;
private static void GestionDatosDinamicos() {
    System.out.println("1. Agregar Dato");
    System.out.println("2. Modificar Dato");
    System.out.println("3. Eliminar Dato");
    System.out.println("4. Mostrar Datos");
    System.out.println("5. Filtrar Datos");
    System.out.println("0. Salir");
    System.out.print("Seleccione una opción: ");
}

public void main() {
    GestionDatosDinamicos();
    Scanner scanner = new Scanner(System.in);
    int opcion = scanner.nextInt();
    while (opcion != 0) {
        switch (opcion) {
            case 1:
                System.out.println("Agregar Dato");
                break;
            case 2:
                System.out.println("Modificar Dato");
                break;
            case 3:
                System.out.println("Eliminar Dato");
                break;
            case 4:
                System.out.println("Mostrar Datos");
                break;
            case 5:
                System.out.println("Filtrar Datos");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
        GestionDatosDinamicos();
        opcion = scanner.nextInt();
    }
    System.out.println("Saliendo...");
    scanner.close();
}

    private static int buscarDato(String buscardato) {
        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).getClave().equals(buscardato)) {
                return i;
            }
        }
        return -1;
    }
