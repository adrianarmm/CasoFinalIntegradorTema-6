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

        JButton btnVenta = new JButton("Añadir Venta");
        JButton btnNombre = new JButton("Añadir Nombre");
        JButton btnNumeroLetra = new JButton("Añadir Número y Letra");
        JButton btnNumeroTexto = new JButton("Añadir Número y Texto");
        JButton btnArchivo = new JButton("Añadir Archivo");

        customizeButton(btnVenta, new Color(255, 102, 102)); // Light red
        customizeButton(btnNombre, new Color(102, 204, 255)); // Light blue
        customizeButton(btnNumeroLetra, new Color(255, 178, 102)); // Orange
        customizeButton(btnNumeroTexto, new Color(153, 204, 255)); // Soft blue
        customizeButton(btnArchivo, new Color(102, 255, 178)); // Mint green

        btnVenta.addActionListener(e -> openVentaDialog());
        btnNombre.addActionListener(e -> openNombreDialog());
        btnNumeroLetra.addActionListener(e -> openNumeroLetraDialog());
        btnNumeroTexto.addActionListener(e -> openNumeroTextoDialog());
        btnArchivo.addActionListener(e -> openArchivoDialog());

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

    private void openVentaDialog() {
        JDialog dialog = createDialog("Añadir Venta");
        productoField = new JTextField(10);
        cantidadField = new JTextField(10);

        addComponentsToDialog(dialog, new JLabel("Producto:"), productoField);
        addComponentsToDialog(dialog, new JLabel("Cantidad:"), cantidadField);

        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            try {
                String producto = productoField.getText();
                int cantidad = Integer.parseInt(cantidadField.getText());
                JOptionPane.showMessageDialog(dialog, "Venta agregada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Por favor, ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        dialog.add(submit);
        dialog.pack();
        dialog.setVisible(true);
    }

    private JDialog createDialog(String title) {
        JDialog dialog = new JDialog(this, title, true);
        dialog.setLayout(new FlowLayout());
        dialog.setLocationRelativeTo(this);
        return dialog;
    }

    private void addComponentsToDialog(JDialog dialog, JLabel label, JTextField textField) {
        dialog.add(label);
        dialog.add(textField);
    }

    private void openNombreDialog() {
        JDialog dialog = createDialog("Añadir Nombre");
        nombreField = new JTextField(10);

        addComponentsToDialog(dialog, new JLabel("Nombre:"), nombreField);

        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            String nombre = nombreField.getText();
            JOptionPane.showMessageDialog(dialog, "Nombre agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dialog.dispose();
        });
        dialog.add(submit);
        dialog.pack();
        dialog.setVisible(true);
    }

    private void openNumeroLetraDialog() {
        JDialog dialog = createDialog("Añadir Número y Letra");
        numeroField = new JTextField(10);
        letraField = new JTextField(10);

        addComponentsToDialog(dialog, new JLabel("Número:"), numeroField);
        addComponentsToDialog(dialog, new JLabel("Letra:"), letraField);

        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            try {
                int numero = Integer.parseInt(numeroField.getText());
                String letra = letraField.getText();
                JOptionPane.showMessageDialog(dialog, "Número y letra agregados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        dialog.add(submit);
        dialog.pack();
        dialog.setVisible(true);
    }

    private void openNumeroTextoDialog() {
        JDialog dialog = createDialog("Añadir Número y Texto");
        numeroTextoField = new JTextField(10);
        textoField = new JTextField(10);

        addComponentsToDialog(dialog, new JLabel("Número:"), numeroTextoField);
        addComponentsToDialog(dialog, new JLabel("Texto:"), textoField);

        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            try {
                int numero = Integer.parseInt(numeroTextoField.getText());
                String texto = textoField.getText();
                JOptionPane.showMessageDialog(dialog, "Número y texto agregados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        dialog.add(submit);
        dialog.pack();
        dialog.setVisible(true);
    }

    private void openArchivoDialog() {
        JDialog dialog = createDialog("Añadir Archivo");
        rutaField = new JTextField(10);

        addComponentsToDialog(dialog, new JLabel("Ruta:"), rutaField);

        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            String ruta = rutaField.getText();
            JOptionPane.showMessageDialog(dialog, "Archivo agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dialog.dispose();
        });
        dialog.add(submit);
        dialog.pack();
        dialog.setVisible(true);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GestionDatosDinamicos()::createAndShowGUI);
    }
}
