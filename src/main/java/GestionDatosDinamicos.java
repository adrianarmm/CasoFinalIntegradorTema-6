import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GestionDatosDinamicos extends JFrame {

    private JTextField productoField, cantidadField, nombreField, rutaField, numeroField, letraField, numeroTextoField, textoField;

    public GestionDatosDinamicos() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        setTitle("Gestión de Datos Dinámicos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        addVentaPanel();
        addNombrePanel();
        addNumeroLetraPanel();
        addNumeroTextoPanel();
        addArchivoPanel();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton createCustomButton(String text, Color bgColor, Color fgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(bgColor.brighter());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(bgColor);
            }
        });
        return button;
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

        JButton agregarVentaButton = createCustomButton("Agregar Venta", Color.BLUE, Color.WHITE);
        agregarVentaButton.addActionListener(e -> handleVentaAction());
        panelVenta.add(agregarVentaButton, gbc);

        add(panelVenta);
    }

    private void handleVentaAction() {
        try {
            String producto = productoField.getText();
            int cantidad = Integer.parseInt(cantidadField.getText());
            JOptionPane.showMessageDialog(this, "Venta agregada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            productoField.setText("");
            cantidadField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addNombrePanel() {
        JPanel panelNombre = new JPanel(new GridBagLayout());
        panelNombre.setBorder(BorderFactory.createTitledBorder("Nombre"));

        nombreField = new JTextField(10);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        panelNombre.add(new JLabel("Nombre:"), gbc);
        panelNombre.add(nombreField, gbc);

        JButton mostrarNombreButton = createCustomButton("Mostrar Nombre", Color.GREEN, Color.WHITE);
        mostrarNombreButton.addActionListener(e -> handleNombreAction());
        panelNombre.add(mostrarNombreButton, gbc);

        add(panelNombre);
    }

    private void handleNombreAction() {
        String nombre = nombreField.getText();
        JOptionPane.showMessageDialog(this, "Nombre: " + nombre, "Nombre", JOptionPane.INFORMATION_MESSAGE);
    }

    private void addNumeroLetraPanel() {
        JPanel panelNumeroLetra = new JPanel(new GridBagLayout());
        panelNumeroLetra.setBorder(BorderFactory.createTitledBorder("Número y Letra"));

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

        JButton mostrarNumeroLetraButton = createCustomButton("Mostrar Número y Letra", Color.ORANGE, Color.WHITE);
        mostrarNumeroLetraButton.addActionListener(e -> handleNumeroLetraAction());
        panelNumeroLetra.add(mostrarNumeroLetraButton, gbc);

        add(panelNumeroLetra);
    }

    private void handleNumeroLetraAction() {
        try {
            int numero = Integer.parseInt(numeroField.getText());
            char letra = letraField.getText().charAt(0);
            JOptionPane.showMessageDialog(this, "Número: " + numero + ", Letra: " + letra, "Número y Letra", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException | StringIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número y una letra válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addNumeroTextoPanel() {
        JPanel panelNumeroTexto = new JPanel(new GridBagLayout());
        panelNumeroTexto.setBorder(BorderFactory.createTitledBorder("Número y Texto"));

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

        JButton mostrarNumeroTextoButton = createCustomButton("Mostrar Número y Texto", Color.RED, Color.WHITE);
        mostrarNumeroTextoButton.addActionListener(e -> handleNumeroTextoAction());
        panelNumeroTexto.add(mostrarNumeroTextoButton, gbc);

        add(panelNumeroTexto);
    }

    private void handleNumeroTextoAction() {
        try {
            int numero = Integer.parseInt(numeroTextoField.getText());
            String texto = textoField.getText();
            JOptionPane.showMessageDialog(this, "Número: " + numero + ", Texto: " + texto, "Número y Texto", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addArchivoPanel() {
        JPanel panelArchivo = new JPanel(new GridBagLayout());
        panelArchivo.setBorder(BorderFactory.createTitledBorder("Archivo"));

        rutaField = new JTextField(10);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        panelArchivo.add(new JLabel("Ruta:"), gbc);
        panelArchivo.add(rutaField, gbc);

        JButton abrirArchivoButton = createCustomButton("Abrir Archivo", Color.CYAN, Color.WHITE);
        abrirArchivoButton.addActionListener(e -> handleArchivoAction());
        panelArchivo.add(abrirArchivoButton, gbc);

        add(panelArchivo);
    }

    private void handleArchivoAction() {
        String ruta = rutaField.getText();
        JOptionPane.showMessageDialog(this, "Archivo abierto: " + ruta, "Archivo", JOptionPane.INFORMATION_MESSAGE);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GestionDatosDinamicos()::createAndShowGUI);
    }
}
