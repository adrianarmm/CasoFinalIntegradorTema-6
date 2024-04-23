import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

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

class Archivo implements Comparable<Archivo> {
    private final String nombre;
    private final String ruta;

    public Archivo(String nombre, String ruta) {
        this.nombre = nombre;
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Ruta: " + ruta;
    }

    @Override
    public int compareTo(Archivo otroArchivo) {
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
    private static List<Archivo> archivosIndexados = new ArrayList<>();

    private JTextField productoField, cantidadField, nombreField, rutaField;

    public GestionDatosDinamicosSwing() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        setTitle("Gestión de Datos Dinámicos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        JPanel panelVenta = new JPanel();
        panelVenta.setLayout(new FlowLayout());
        add(panelVenta);

        productoField = new JTextField(10);
        cantidadField = new JTextField(10);
        panelVenta.add(new JLabel("Producto:"));
        panelVenta.add(productoField);
        panelVenta.add(new JLabel("Cantidad:"));
        panelVenta.add(cantidadField);

        JButton agregarVentaButton = new JButton("Agregar Venta");
        agregarVentaButton.addActionListener(e -> {
            String producto = productoField.getText();
            int cantidad;
            try {
                cantidad = Integer.parseInt(cantidadField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, ingrese una cantidad válida.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            ventas.add(new Venta(producto, cantidad));
            productoField.setText("");
            cantidadField.setText("");
            JOptionPane.showMessageDialog(this,
                    "Venta agregada correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        panelVenta.add(agregarVentaButton);

        // Agrega más paneles y botones para otras funcionalidades como modificar y eliminar ventas, manejar nombres y archivos.

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GestionDatosDinamicosSwing()::createAndShowGUI);
    }
}
