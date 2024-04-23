import javax.swing.*;
import java.awt.*;

public class GestionDatosDinamicos extends JFrame {

    private JTextField productoField, cantidadField, nombreField, rutaField, numeroField, letraField, numeroTextoField, textoField;

    public GestionDatosDinamicos() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        setTitle("Gestión de Datos Dinámicos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS)); // Cambiado a X_AXIS para alinear horizontalmente

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
        JPanel panelVenta = new JPanel(new GridBagLayout());
        panelVenta.setBorder(BorderFactory.createTitledBorder("Agregar Venta"));

        productoField = new JTextField(10);
        cantidadField = new JTextField(10);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        panelVenta.add(new JLabel("Producto:"), gbc);
        panelVenta.add(productoField, gbc);
        panelVenta.add(new JLabel("Cantidad:"), gbc);
        panelVenta.add(cantidadField, gbc);

        JButton agregarVentaButton = new JButton("Agregar Venta");
        agregarVentaButton.addActionListener(e -> handleVentaAction());
        panelVenta.add(agregarVentaButton, gbc);

        add(panelVenta);
    }

    private void handleVentaAction() {
        try {
            String producto = productoField.getText();
            int cantidad = Integer.parseInt(cantidadField.getText());
            JOptionPane.showMessageDialog(this, "Venta agregada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addNombrePanel() {
        JPanel panelNombre = new JPanel(new GridBagLayout());
        panelNombre.setBorder(BorderFactory.createTitledBorder("Agregar Nombre"));

        nombreField = new JTextField(10);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        panelNombre.add(new JLabel("Nombre:"), gbc);
        panelNombre.add(nombreField, gbc);

        JButton agregarNombreButton = new JButton("Agregar Nombre");
        agregarNombreButton.addActionListener(e -> handleNombreAction());
        panelNombre.add(agregarNombreButton, gbc);

        add(panelNombre);
    }

    private void handleNombreAction() {
        String nombre = nombreField.getText();
        JOptionPane.showMessageDialog(this, "Nombre agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void addNumeroLetraPanel() {
        JPanel panelNumeroLetra = new JPanel(new GridBagLayout());
        panelNumeroLetra.setBorder(BorderFactory.createTitledBorder("Agregar Número y Letra"));

        numeroField = new JTextField(10);
        letraField = new JTextField(10);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        panelNumeroLetra.add(new JLabel("Número:"), gbc);
        panelNumeroLetra.add(numeroField, gbc);
        panelNumeroLetra.add(new JLabel("Letra:"), gbc);
        panelNumeroLetra.add(letraField, gbc);

        JButton agregarNumeroLetraButton = new JButton("Agregar Número y Letra");
        agregarNumeroLetraButton.addActionListener(e -> handleNumeroLetraAction());
        panelNumeroLetra.add(agregarNumeroLetraButton, gbc);

        add(panelNumeroLetra);
    }

    private void handleNumeroLetraAction() {
        try {
            int numero = Integer.parseInt(numeroField.getText());
            String letra = letraField.getText();
            JOptionPane.showMessageDialog(this, "Número y letra agregados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addNumeroTextoPanel() {
        JPanel panelNumeroTexto = new JPanel(new GridBagLayout());
        panelNumeroTexto.setBorder(BorderFactory.createTitledBorder("Agregar Número y Texto"));

        numeroTextoField = new JTextField(10);
        textoField = new JTextField(10);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        panelNumeroTexto.add(new JLabel("Número:"), gbc);
        panelNumeroTexto.add(numeroTextoField, gbc);
        panelNumeroTexto.add(new JLabel("Texto:"), gbc);
        panelNumeroTexto.add(textoField, gbc);

        JButton agregarNumeroTextoButton = new JButton("Agregar Número y Texto");
        agregarNumeroTextoButton.addActionListener(e -> handleNumeroTextoAction());
        panelNumeroTexto.add(agregarNumeroTextoButton, gbc);

        add(panelNumeroTexto);
    }

    private void handleNumeroTextoAction() {
        try {
            int numero = Integer.parseInt(numeroTextoField.getText());
            String texto = textoField.getText();
            JOptionPane.showMessageDialog(this, "Número y texto agregados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addArchivoPanel() {
        JPanel panelArchivo = new JPanel(new GridBagLayout());
        panelArchivo.setBorder(BorderFactory.createTitledBorder("Agregar Archivo"));

        rutaField = new JTextField(10);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        panelArchivo.add(new JLabel("Ruta:"), gbc);
        panelArchivo.add(rutaField, gbc);

        JButton agregarArchivoButton = new JButton("Agregar Archivo");
        agregarArchivoButton.addActionListener(e -> handleArchivoAction());
        panelArchivo.add(agregarArchivoButton, gbc);

        add(panelArchivo);
    }

    private void handleArchivoAction() {
        String ruta = rutaField.getText();
        JOptionPane.showMessageDialog(this, "Archivo agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GestionDatosDinamicos()::createAndShowGUI);
    }
}
