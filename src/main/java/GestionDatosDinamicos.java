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
    private static List<Archivo> archivosIndexados = new ArrayList<Archivo>();
    private JTextField productoField, cantidadField, nombreField, rutaField;

    public GestionDatosDinamicos() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        setTitle("Gestión de Datos Dinámicos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        addComponentsToPane(constraints);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addComponentsToPane(GridBagConstraints constraints) {
        addVentaPanel(constraints);
        addNombrePanel(constraints);
        addNumeroLetraPanel(constraints);
        addNumeroTextoPanel(constraints);
        addArchivoPanel(constraints);
    }

    private void addVentaPanel(GridBagConstraints constraints) {
        JPanel panelVenta = new JPanel(new GridBagLayout());
        productoField = new JTextField(10);
        cantidadField = new JTextField(10);

        addComponent(panelVenta, new JLabel("Producto:"), 1, 0, constraints);
        addComponent(panelVenta, productoField, 2, 0, constraints);
        addComponent(panelVenta, new JLabel("Cantidad:"), 1, 1, constraints);
        addComponent(panelVenta, cantidadField, 2, 1, constraints);

        JButton agregarVentaButton = new JButton("Agregar Venta");
        agregarVentaButton.addActionListener(e -> handleVentaAction());
        addComponent(panelVenta, agregarVentaButton, 1, 2, constraints);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(panelVenta, constraints);
    }

    private void handleVentaAction() {
        try {
            String producto = productoField.getText();
            int cantidad = Integer.parseInt(cantidadField.getText());
            ventas.add(new Venta(producto, cantidad));
            productoField.setText("");
            cantidadField.setText("");
            JOptionPane.showMessageDialog(this, "Venta agregada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addNombrePanel(GridBagConstraints constraints) {

        JPanel panelNombre = new JPanel(new GridBagLayout());
        nombreField = new JTextField(10);

        addComponent(panelNombre, new JLabel("Nombre:"), 1, 0, constraints);
        addComponent(panelNombre, nombreField, 2, 0, constraints);

        JButton agregarNombreButton = new JButton("Agregar Nombre");
        agregarNombreButton.addActionListener(e -> handleNombreAction());
        addComponent(panelNombre, agregarNombreButton, 1, 1, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(panelNombre, constraints);

    }

    private void handleNombreAction() {
        String nombre = nombreField.getText();
        nombres.add(nombre);
        nombreField.setText("");
        JOptionPane.showMessageDialog(this, "Nombre agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void addNumeroLetraPanel(GridBagConstraints constraints) {

        JPanel panelNumeroLetra = new JPanel(new GridBagLayout());
        JTextField numeroField = new JTextField(10);
        JTextField letraField = new JTextField(10);

        addComponent(panelNumeroLetra, new JLabel("Número:"), 1, 0, constraints);
        addComponent(panelNumeroLetra, numeroField, 2, 0, constraints);
        addComponent(panelNumeroLetra, new JLabel("Letra:"), 1, 1, constraints);
        addComponent(panelNumeroLetra, letraField, 2, 1, constraints);

        JButton agregarNumeroLetraButton = new JButton("Agregar Número y Letra");
        agregarNumeroLetraButton.addActionListener(e -> handleNumeroLetraAction(numeroField, letraField));
        addComponent(panelNumeroLetra, agregarNumeroLetraButton, 1, 2, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(panelNumeroLetra, constraints);
    }

    private void handleNumeroLetraAction(JTextField numeroField, JTextField letraField) {
        try {
            int numero = Integer.parseInt(numeroField.getText());
            char letra = letraField.getText().charAt(0);
            numerosLetras.put(numero, letra);
            numeroField.setText("");
            letraField.setText("");
            JOptionPane.showMessageDialog(this, "Número y letra agregados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException | StringIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número y una letra válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addNumeroTextoPanel(GridBagConstraints constraints) {

        JPanel panelNumeroTexto = new JPanel(new GridBagLayout());
        JTextField numeroField = new JTextField(10);
        JTextField textoField = new JTextField(10);

        addComponent(panelNumeroTexto, new JLabel("Número:"), 1, 0, constraints);
        addComponent(panelNumeroTexto, numeroField, 2, 0, constraints);
        addComponent(panelNumeroTexto, new JLabel("Texto:"), 1, 1, constraints);
        addComponent(panelNumeroTexto, textoField, 2, 1, constraints);

        JButton agregarNumeroTextoButton = new JButton("Agregar Número y Texto");
        agregarNumeroTextoButton.addActionListener(e -> handleNumeroTextoAction(numeroField, textoField));
        addComponent(panelNumeroTexto, agregarNumeroTextoButton, 1, 2, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(panelNumeroTexto, constraints);
    }

    private void handleNumeroTextoAction(JTextField numeroField, JTextField textoField) {
        try {
            int numero = Integer.parseInt(numeroField.getText());
            String texto = textoField.getText();
            numerosTexto.put(numero, texto);
            numeroField.setText("");
            textoField.setText("");
            JOptionPane.showMessageDialog(this, "Número y texto agregados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addArchivoPanel(GridBagConstraints constraints) {

        JPanel panelArchivo = new JPanel(new GridBagLayout());
        nombreField = new JTextField(10);
        rutaField = new JTextField(10);

        addComponent(panelArchivo, new JLabel("Nombre:"), 1, 0, constraints);
        addComponent(panelArchivo, nombreField, 2, 0, constraints);
        addComponent(panelArchivo, new JLabel("Ruta:"), 1, 1, constraints);
        addComponent(panelArchivo, rutaField, 2, 1, constraints);

        JButton agregarArchivoButton = new JButton("Agregar Archivo");
        agregarArchivoButton.addActionListener(e -> handleArchivoAction());
        addComponent(panelArchivo, agregarArchivoButton, 1, 2, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(panelArchivo, constraints);
    }

    private void handleArchivoAction() {
        String nombre = nombreField.getText();
        String ruta = rutaField.getText();
        archivosIndexados.add(new Archivo(nombre, ruta));
        nombreField.setText("");
        rutaField.setText("");
        JOptionPane.showMessageDialog(this, "Archivo agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void addComponent(JPanel panel, Component component, int x, int y, GridBagConstraints constraints) {
        constraints.gridx = x;
        constraints.gridy = y;
        panel.add(component, constraints);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GestionDatosDinamicos()::createAndShowGUI);
    }
}
