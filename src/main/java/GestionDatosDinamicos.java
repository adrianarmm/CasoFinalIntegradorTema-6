import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.util.*;

public class GestionDatosDinamicos extends JFrame {
    private List ventas = new List();
    private Set<String> nombres = new TreeSet<>();
    private Map<Integer, Character> numerosLetras = new HashMap<>();
    private Map<Integer, String> numerosTexto = new HashMap<>();
    private List archivosIndexados = new List();

    private JTextField productoField, cantidadField, nombreField, rutaField, numeroField, letraField, numeroTextoField, textoField;

    public GestionDatosDinamicos() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        setTitle("Gestión de Datos Dinámicos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addVentaPanel();
        addNombrePanel();
        addNumeroLetraPanel();
        addNumeroTextoPanel();
        addArchivoPanel();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addVentaPanel() {
        JPanel panelVenta = new JPanel();
        panelVenta.setBorder(BorderFactory.createTitledBorder("Agregar Venta"));
        panelVenta.setLayout(new GridLayout(0, 2, 5, 5));

        productoField = new JTextField(10);
        cantidadField = new JTextField(10);
        panelVenta.add(new JLabel("Producto:"));
        panelVenta.add(productoField);
        panelVenta.add(new JLabel("Cantidad:"));
        panelVenta.add(cantidadField);

        JButton agregarVentaButton = new JButton("Agregar Venta");
        agregarVentaButton.addActionListener(e -> handleVentaAction());
        panelVenta.add(agregarVentaButton);

        add(panelVenta);
    }

    private void handleVentaAction() {
        try {
            String producto = productoField.getText();
            int cantidad = Integer.parseInt(cantidadField.getText());
            ventas.add(String.valueOf(new Ventas(producto, cantidad)));
            productoField.setText("");
            cantidadField.setText("");
            JOptionPane.showMessageDialog(this, "Venta agregada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addNombrePanel() {
        JPanel panelNombre = new JPanel();
        panelNombre.setBorder(BorderFactory.createTitledBorder("Agregar Nombre"));
        panelNombre.setLayout(new GridLayout(0, 2, 5, 5));

        nombreField = new JTextField(10);
        panelNombre.add(new JLabel("Nombre:"));
        panelNombre.add(nombreField);

        JButton agregarNombreButton = new JButton("Agregar Nombre");
        agregarNombreButton.addActionListener(e -> {
            String nombre = nombreField.getText();
            nombres.add(nombre);
            nombreField.setText("");
            JOptionPane.showMessageDialog(this, "Nombre agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        });
        panelNombre.add(agregarNombreButton);

        add(panelNombre);
    }

    private void addNumeroLetraPanel() {
        JPanel panelNumeroLetra = new JPanel();
        panelNumeroLetra.setBorder(BorderFactory.createTitledBorder("Agregar Número y Letra"));
        panelNumeroLetra.setLayout(new GridLayout(0, 2, 5, 5));

        numeroField = new JTextField(10);
        letraField = new JTextField(10);
        panelNumeroLetra.add(new JLabel("Número:"));
        panelNumeroLetra.add(numeroField);
        panelNumeroLetra.add(new JLabel("Letra:"));
        panelNumeroLetra.add(letraField);

        JButton agregarNumeroLetraButton = new JButton("Agregar Número y Letra");
        agregarNumeroLetraButton.addActionListener(e -> {
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
        });
        panelNumeroLetra.add(agregarNumeroLetraButton);

        add(panelNumeroLetra);
    }

    private void addNumeroTextoPanel() {
        JPanel panelNumeroTexto = new JPanel();
        panelNumeroTexto.setBorder(BorderFactory.createTitledBorder("Agregar Número y Texto"));
        panelNumeroTexto.setLayout(new GridLayout(0, 2, 5, 5));

        numeroTextoField = new JTextField(10);
        textoField = new JTextField(10);
        panelNumeroTexto.add(new JLabel("Número:"));
        panelNumeroTexto.add(numeroTextoField);
        panelNumeroTexto.add(new JLabel("Texto:"));
        panelNumeroTexto.add(textoField);

        JButton agregarNumeroTextoButton = new JButton("Agregar Número y Texto");
        agregarNumeroTextoButton.addActionListener(e -> {
            try {
                int numero = Integer.parseInt(numeroTextoField.getText());
                String texto = textoField.getText();
                numerosTexto.put(numero, texto);
                numeroTextoField.setText("");
                textoField.setText("");
                JOptionPane.showMessageDialog(this, "Número y texto agregados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panelNumeroTexto.add(agregarNumeroTextoButton);

        add(panelNumeroTexto);
    }

    private void addArchivoPanel() {
        JPanel panelArchivo = new JPanel();
        panelArchivo.setBorder(BorderFactory.createTitledBorder("Agregar Archivo"));
        panelArchivo.setLayout(new GridLayout(0, 2, 5, 5));

        nombreField = new JTextField(10);
        rutaField = new JTextField(10);
        panelArchivo.add(new JLabel("Nombre:"));
        panelArchivo.add(nombreField);
        panelArchivo.add(new JLabel("Ruta:"));
        panelArchivo.add(rutaField);

        JButton agregarArchivoButton = new JButton("Agregar Archivo");
        agregarArchivoButton.addActionListener(e -> {
            String nombre = nombreField.getText();
            String ruta = rutaField.getText();
            archivosIndexados.add(String.valueOf(new Archivos(nombre, ruta)));
            nombreField.setText("");
            rutaField.setText("");
            JOptionPane.showMessageDialog(this, "Archivo agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        });
        panelArchivo.add(agregarArchivoButton);

        add(panelArchivo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GestionDatosDinamicos()::createAndShowGUI);
    }
}
