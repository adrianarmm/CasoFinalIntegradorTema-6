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

        btnVenta.addActionListener(e -> openVentaDialog());
        btnNombre.addActionListener(e -> openNombreDialog());
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

    private void openVentaDialog() {
        JDialog dialog = new JDialog(this, "Añadir Venta", true);
        dialog.setLayout(new FlowLayout());
        productoField = new JTextField(10);
        cantidadField = new JTextField(10);
        dialog.add(new JLabel("Producto:"));
        dialog.add(productoField);
        dialog.add(new JLabel("Cantidad:"));
        dialog.add(cantidadField);
        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            try {
                String producto = productoField.getText();
                int cantidad = Integer.parseInt(cantidadField.getText());

                // Aquí agregarías la venta a tu set o base de datos

                JOptionPane.showMessageDialog(dialog, "Venta agregada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Por favor, ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        dialog.add(submit);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void openNumeroLetraDialog() {
        JDialog dialog = new JDialog(this, "Añadir Número y Letra", true);
        dialog.setLayout(new FlowLayout());
        numeroField = new JTextField(10);
        letraField = new JTextField(10);
        dialog.add(new JLabel("Número:"));
        dialog.add(numeroField);
        dialog.add(new JLabel("Letra:"));
        dialog.add(letraField);
        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            try {
                int numero = Integer.parseInt(numeroField.getText());
                char letra = letraField.getText().charAt(0);
                // Aquí agregarías el número y letra a tu set o base de datos
                JOptionPane.showMessageDialog(dialog, "Número y letra agregados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
            } catch (NumberFormatException | IndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(dialog, "Por favor, ingrese un número y letra válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        dialog.add(submit);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void openNumeroTextoDialog() {
        JDialog dialog = new JDialog(this, "Añadir Número y Texto", true);
        dialog.setLayout(new FlowLayout());
        numeroTextoField = new JTextField(10);
        textoField = new JTextField(10);
        dialog.add(new JLabel("Número:"));
        dialog.add(numeroTextoField);
        dialog.add(new JLabel("Texto:"));
        dialog.add(textoField);
        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            try {
                int numero = Integer.parseInt(numeroTextoField.getText());
                String texto = textoField.getText();
                // Aquí agregarías el número y texto a tu set o base de datos
                JOptionPane.showMessageDialog(dialog, "Número y texto agregados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        dialog.add(submit);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void openArchivoDialog() {
        JDialog dialog = new JDialog(this, "Añadir Archivo", true);
        dialog.setLayout(new FlowLayout());
        rutaField = new JTextField(10);
        dialog.add(new JLabel("Ruta:"));
        dialog.add(rutaField);
        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            String ruta = rutaField.getText();
            // Aquí agregarías la ruta a tu set o base de datos
            JOptionPane.showMessageDialog(dialog, "Ruta agregada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dialog.dispose();
        });
        dialog.add(submit);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }


    private void openNombreDialog() {
        JDialog dialog = new JDialog(this, "Añadir Nombre", true);
        dialog.setLayout(new FlowLayout());
        nombreField = new JTextField(10);
        dialog.add(new JLabel("Nombre:"));
        dialog.add(nombreField);
        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            String nombre = nombreField.getText();
            // Aquí agregarías el nombre a tu set o base de datos
            JOptionPane.showMessageDialog(dialog, "Nombre agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dialog.dispose();
        });
        dialog.add(submit);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GestionDatosDinamicos()::createAndShowGUI);
    }
}
