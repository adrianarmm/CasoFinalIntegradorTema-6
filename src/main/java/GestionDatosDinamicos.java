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
        setLayout(new FlowLayout());

        // Creación de botones para cada acción
        JButton btnVenta = new JButton("Añadir Venta");
        JButton btnNombre = new JButton("Añadir Nombre");
        JButton btnNumeroLetra = new JButton("Añadir Número y Letra");
        JButton btnNumeroTexto = new JButton("Añadir Número y Texto");
        JButton btnArchivo = new JButton("Añadir Archivo");

        // Personalización de botones
        customizeButton(btnVenta, new Color(255, 102, 102)); // Light red
        customizeButton(btnNombre, new Color(102, 204, 255)); // Light blue
        customizeButton(btnNumeroLetra, new Color(255, 178, 102)); // Orange
        customizeButton(btnNumeroTexto, new Color(153, 204, 255)); // Soft blue
        customizeButton(btnArchivo, new Color(102, 255, 178)); // Mint green

        // Añadiendo escuchadores de eventos a los botones
        btnVenta.addActionListener(e -> openVentaDialog());
        btnNombre.addActionListener(e -> openNombreDialog());
        btnNumeroLetra.addActionListener(e -> openNumeroLetraDialog());
        btnNumeroTexto.addActionListener(e -> openNumeroTextoDialog());
        btnArchivo.addActionListener(e -> openArchivoDialog());

        // Añadir botones al JFrame
        add(btnVenta);
        add(btnNombre);
        add(btnNumeroLetra);
        add(btnNumeroTexto);
        add(btnArchivo);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void customizeButton(JButton button, Color bgColor) {
        button.setBackground(bgColor);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 12));
    }

    // Métodos para abrir diálogos específicos para cada acción
    private void openVentaDialog() {
        JDialog dialog = createDialog("Añadir Venta");
        productoField = new JTextField(10);
        cantidadField = new JTextField(10);
        addComponentsToDialog(dialog, new JLabel("Producto:"), productoField);
        addComponentsToDialog(dialog, new JLabel("Cantidad:"), cantidadField);
        addButtonToDialog(dialog, "Submit", e -> handleVenta(dialog));
        dialog.setVisible(true);
    }

    private void handleVenta(JDialog dialog) {
        try {
            String producto = productoField.getText();
            int cantidad = Integer.parseInt(cantidadField.getText());
            JOptionPane.showMessageDialog(dialog, "Venta agregada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dialog.dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(dialog, "Por favor, ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Ejemplo de otro método para abrir un diálogo:
    private void openNombreDialog() {
        JDialog dialog = createDialog("Añadir Nombre");
        nombreField = new JTextField(10);
        addComponentsToDialog(dialog, new JLabel("Nombre:"), nombreField);
        addButtonToDialog(dialog, "Submit", e -> handleNombre(dialog));
        dialog.setVisible(true);
    }

    private void handleNombre(JDialog dialog) {
        String nombre = nombreField.getText();
        JOptionPane.showMessageDialog(dialog, "Nombre agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        dialog.dispose();
    }

    private JDialog createDialog(String title) {
        JDialog dialog = new JDialog(this, title, true);
        dialog.setLayout(new FlowLayout());
        dialog.setLocationRelativeTo(this);
        dialog.pack();
        return dialog;
    }

    private void addComponentsToDialog(JDialog dialog, JLabel label, JTextField textField) {
        dialog.add(label);
        dialog.add(textField);
    }

    private void addButtonToDialog(JDialog dialog, String buttonText, ActionListener actionListener) {
        JButton button = new JButton(buttonText);
        button.addActionListener(actionListener);
        dialog.add(button);
    }


    private void openNumeroLetraDialog() {
        JDialog dialog = createDialog("Añadir Número y Letra");
        numeroField = new JTextField(10);
        letraField = new JTextField(10);
        addComponentsToDialog(dialog, new JLabel("Número:"), numeroField);
        addComponentsToDialog(dialog, new JLabel("Letra:"), letraField);
        addButtonToDialog(dialog, "Submit", e -> handleNumeroLetra(dialog));
        dialog.setVisible(true);
    }

    private void handleNumeroLetra(JDialog dialog) {
        try {
            int numero = Integer.parseInt(numeroField.getText());
            char letra = letraField.getText().charAt(0);
            JOptionPane.showMessageDialog(dialog, "Número y letra agregados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dialog.dispose();
        } catch (NumberFormatException | IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(dialog, "Por favor, ingrese un número y una letra válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openNumeroTextoDialog() {
        JDialog dialog = createDialog("Añadir Número y Texto");
        numeroTextoField = new JTextField(10);
        textoField = new JTextField(10);
        addComponentsToDialog(dialog, new JLabel("Número:"), numeroTextoField);
        addComponentsToDialog(dialog, new JLabel("Texto:"), textoField);
        addButtonToDialog(dialog, "Submit", e -> handleNumeroTexto(dialog));
        dialog.setVisible(true);
    }

    private void handleNumeroTexto(JDialog dialog) {
        try {
            int numero = Integer.parseInt(numeroTextoField.getText());
            String texto = textoField.getText();
            JOptionPane.showMessageDialog(dialog, "Número y texto agregados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dialog.dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(dialog, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openArchivoDialog() {
        JDialog dialog = createDialog("Añadir Archivo");
        rutaField = new JTextField(10);
        addComponentsToDialog(dialog, new JLabel("Ruta del archivo:"), rutaField);
        addButtonToDialog(dialog, "Submit", e -> handleArchivo(dialog));
        dialog.setVisible(true);
    }

    private void handleArchivo(JDialog dialog) {
        String ruta = rutaField.getText();
        JOptionPane.showMessageDialog(dialog, "Archivo agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        dialog.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GestionDatosDinamicos()::createAndShowGUI);
    }
}
