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
    private static List<Archivos> archivosIndexados = new ArrayList<>();private JTextField productoField, cantidadField, nombreField, rutaField;

    public GestionDatosDinamicos() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        setTitle("Gestión de Datos Dinámicos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        // Panel de ventas
        JPanel panelVenta = new JPanel();
        panelVenta.setLayout(new GridBagLayout());

        productoField = new JTextField(10);
        cantidadField = new JTextField(10);

        constraints.gridx = 1;
        constraints.gridy = 0;
        panelVenta.add(new JLabel("Producto:"), constraints);
        constraints.gridx = 2;
        panelVenta.add(productoField, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panelVenta.add(new JLabel("Cantidad:"), constraints);
        constraints.gridx = 2;
        panelVenta.add(cantidadField, constraints);

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
                    "Ventaagregada correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        constraints.gridx = 1;
        constraints.gridy = 2;
        panelVenta.add(agregarVentaButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(panelVenta, constraints);

        // Panel de nombres
        JPanel panelNombre = new JPanel();
        panelNombre.setLayout(new GridBagLayout());

        nombreField = new JTextField(10);

        constraints.gridx = 1;
        constraints.gridy = 0;
        panelNombre.add(new JLabel("Nombre:"), constraints);
        constraints.gridx = 2;
        panelNombre.add(nombreField, constraints);

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

        constraints.gridx = 1;
        constraints.gridy = 1;
        panelNombre.add(agregarNombreButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(panelNombre, constraints);

        // Panel de números y letras
        JPanel panelNumeroLetra = new JPanel();
        panelNumeroLetra.setLayout(new GridBagLayout());

        JTextField numeroField = new JTextField(10);
        JTextField letraField = new JTextField(10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panelNumeroLetra.add(new JLabel("Número:"), constraints);
        constraints.gridx = 1;
        panelNumeroLetra.add(numeroField, constraints);
        constraints.gridx = 2;
        panelNumeroLetra.add(new JLabel("Letra:"), constraints);
        constraints.gridx = 3;
        panelNumeroLetra.add(letraField, constraints);

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

        constraints.gridx = 0;
        constraints.gridy = 1;
        panelNumeroLetra.add(agregarNumeroLetraButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(panelNumeroLetra, constraints);

        // Panel de números y texto
        JPanel panelNumeroTexto = new JPanel();
        panelNumeroTexto.setLayout(new GridBagLayout());

        JTextField numeroTextoField = new JTextField(10);
        JTextField textoField = new JTextField(10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panelNumeroTexto.add(new JLabel("Número:"), constraints);
        constraints.gridx = 1;
        panelNumeroTexto.add(numeroTextoField, constraints);
        constraints.gridx = 2;
        panelNumeroTexto.add(new JLabel("Texto:"), constraints);
        constraints.gridx = 3;
        panelNumeroTexto.add(textoField, constraints);

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

        constraints.gridx = 0;
        constraints.gridy = 1;
        panelNumeroTexto.add(agregarNumeroTextoButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(panelNumeroTexto, constraints);

        // Panel de archivos
        JPanel panelArchivo = newJPanel();
        panelArchivo.setLayout(new GridBagLayout());

        nombreField = new JTextField(10);
        rutaField = new JTextField(10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panelArchivo.add(new JLabel("Nombre:"), constraints);
        constraints.gridx = 1;
        panelArchivo.add(nombreField, constraints);
        constraints.gridx = 2;
        panelArchivo.add(new JLabel("Ruta:"), constraints);
        constraints.gridx = 3;
        panelArchivo.add(rutaField, constraints);

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

        constraints.gridx = 0;
        constraints.gridy = 1;
        panelArchivo.add(agregarArchivoButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(panelArchivo, constraints);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel newJPanel() {
        return new JPanel();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GestionDatosDinamicos()::createAndShowGUI);
    }
}