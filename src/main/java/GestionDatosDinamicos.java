import javax.swing.*;
import java.awt.*;
import java.util.*;
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

class Archivo implements Comparable<Archivos> {
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
    public int compareTo(Archivos otroArchivo) {
        return this.nombre.compareTo(otroArchivo.nombre);
    }

    public String getNombre() {
        return nombre;
    }
}

public class GestionDatosDinamicos extends JFrame {
    private static List<Venta> ventas = new ArrayList<>();
    private static Set<String> nombres = new TreeSet<>();
    private static Map<Integer, Character> numerosLetras = new HashMap<>();
    private static Map<Integer, String> numerosTexto = new HashMap<>();
    private static List<Archivos> archivosIndexados = new ArrayList<>();

    private JTextField productoField, cantidadField, nombreField, rutaField;

    public GestionDatosDinamicos() {
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

JPanel panelNombre = new JPanel();
        panelNombre.setLayout(new FlowLayout());
        add(panelNombre);

        nombreField = new JTextField(10);
        panelNombre.add(new JLabel("Nombre:"));
        panelNombre.add(nombreField);

        JButton agregarNombreButton = new JButton("Agregar Nombre");
        agregarNombreButton.addActionListener(e -> {
            String nombre = nombreField.getText();
            nombres.add(nombre);
            nombreField.setText("");
            JOptionPane.showMessageDialog(this,
                    "Nombre agregado correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        panelNombre.add(agregarNombreButton);

        JPanel panelNumeroLetra = new JPanel();
        panelNumeroLetra.setLayout(new FlowLayout());
        add(panelNumeroLetra);

        JTextField numeroField = new JTextField(10);
        JTextField letraField = new JTextField(10);
        panelNumeroLetra.add(new JLabel("Número:"));
        panelNumeroLetra.add(numeroField);
        panelNumeroLetra.add(new JLabel("Letra:"));
        panelNumeroLetra.add(letraField);

        JButton agregarNumeroLetraButton = new JButton("Agregar Número-Letra");
        agregarNumeroLetraButton.addActionListener(e -> {
            int numero;
            try {
                numero = Integer.parseInt(numeroField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, ingrese un número válido.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            char letra = letraField.getText().charAt(0);
            numerosLetras.put(numero, letra);
            numeroField.setText("");
            letraField.setText("");
            JOptionPane.showMessageDialog(this,
                    "Número-Letra agregado correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        panelNumeroLetra.add(agregarNumeroLetraButton);

        JPanel panelNumeroTexto = new JPanel();
        panelNumeroTexto.setLayout(new FlowLayout());
        add(panelNumeroTexto);

        JTextField numeroTextoField = new JTextField(10);
        JTextField textoField = new JTextField(10);
        panelNumeroTexto.add(new JLabel("Número:"));
        panelNumeroTexto.add(numeroTextoField);
        panelNumeroTexto.add(new JLabel("Texto:"));
        panelNumeroTexto.add(textoField);

        JButton agregarNumeroTextoButton = new JButton("Agregar Número-Texto");
        agregarNumeroTextoButton.addActionListener(e -> {
            int numero;
            try {
                numero = Integer.parseInt(numeroTextoField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, ingrese un número válido.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            String texto = textoField.getText();
            numerosTexto.put(numero, texto);
            numeroTextoField.setText("");
            textoField.setText("");
            JOptionPane.showMessageDialog(this,
                    "Número-Texto agregado correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        panelNumeroTexto.add(agregarNumeroTextoButton);

        JPanel panelArchivo = new JPanel();
        panelArchivo.setLayout(new FlowLayout());
        add(panelArchivo);


        rutaField = new JTextField(10);
        panelArchivo.add(new JLabel("Nombre:"));
        panelArchivo.add(nombreField);
        panelArchivo.add(new JLabel("Ruta:"));
        panelArchivo.add(rutaField);

        JButton agregarArchivoButton = new JButton("Agregar Archivo");

        agregarArchivoButton.addActionListener(e -> {
            String nombre = nombreField.getText();
            String ruta = rutaField.getText();
            archivosIndexados.add(new Archivos(nombre, ruta));
            nombreField.setText("");
            rutaField.setText("");
            JOptionPane.showMessageDialog(this,
                    "Archivo agregado correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        panelArchivo.add(agregarArchivoButton);



        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GestionDatosDinamicos()::createAndShowGUI);
    }
}
