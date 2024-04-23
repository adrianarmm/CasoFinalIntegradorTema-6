import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

class archivo implements Comparable<archivo> {
    private final String nombre;
    private final String ruta;

    public archivo(String nombre, String ruta) {
        super();
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

public class GestionDatosDinamicosSwing extends JFrame {

    private static List<Venta> ventas = new ArrayList<>();
    private static Set<String> nombres = new TreeSet<>();
    private static Map<Integer, Character> numerosLetras = new HashMap<>();
    private static Map<Integer, String> numerosTexto = new HashMap<>();
    private static List<archivo> archivosIndexados = new ArrayList<>();

    private JTextField productoField;
    private JTextField cantidadField;
    private JTextField minCantidadField;
    private JTextField nombreField;
    private JTextField rutaField;

    public GestionDatosDinamicosSwing() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        setTitle("Gestión de Datos Dinámicos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        add(panel1);

        JButton agregarVentaButton = new JButton("Agregar Venta");
        agregarVentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String producto = productoField.getText();
                int cantidad;
                try {
                    cantidad = Integer.parseInt(cantidadField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(GestionDatosDinamicosSwing.this,
                            "Por favor, ingrese una cantidad válida.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                ventas.add(new Venta(producto, cantidad));
                productoField.setText("");
                cantidadField.setText("");
                JOptionPane.showMessageDialog(GestionDatosDinamicosSwing.this,
                        "Venta agregada correctamente.",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel1.add(agregarVentaButton);

        // Agregar el resto de los botones y campos de texto siguiendo el mismo patrón

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GestionDatosDinamicosSwing::new);
    }
}