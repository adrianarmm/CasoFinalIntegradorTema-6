import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GestionDatosDinamicos extends JFrame {

    public GestionDatosDinamicos() {
        setTitle("Gestión de Datos Dinámicos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        initializeComponents();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeComponents() {
        JButton btnVenta = new JButton("Añadir Venta");
        JButton btnNombre = new JButton("Añadir Nombre");
        JButton btnNumeroLetra = new JButton("Añadir Número y Letra");
        JButton btnNumeroTexto = new JButton("Añadir Número y Texto");
        JButton btnArchivo = new JButton("Añadir Archivo");

        customizeButton(btnVenta, new Color(255, 102, 102));
        customizeButton(btnNombre, new Color(102, 204, 255));
        customizeButton(btnNumeroLetra, new Color(255, 178, 102));
        customizeButton(btnNumeroTexto, new Color(153, 204, 255));
        customizeButton(btnArchivo, new Color(102, 255, 178));

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
    }

    private void customizeButton(JButton button, Color bgColor) {
        button.setBackground(bgColor);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 12));
    }



    private void openVentaDialog() {
        JDialog dialog = new JDialog(this, "Añadir Venta", true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setLayout(new FlowLayout());
        dialog.setSize(300, 150);

        JTextField txtVenta = new JTextField(20);
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        btnAceptar.addActionListener(e -> {
            // Aquí se añade la venta a la lista
            dialog.dispose();
        });

        btnCancelar.addActionListener(e -> dialog.dispose());

        dialog.add(new JLabel("Introduce la venta:"));
        dialog.add(txtVenta);
        dialog.add(btnAceptar);
        dialog.add(btnCancelar);

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void openNombreDialog() {
        JDialog dialog = new JDialog(this, "Añadir Nombre", true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setLayout(new FlowLayout());
        dialog.setSize(300, 150);

        JTextField txtNombre = new JTextField(20);
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        btnAceptar.addActionListener(e -> {
            // Aquí se añade el nombre a la lista
            dialog.dispose();
        });

        btnCancelar.addActionListener(e -> dialog.dispose());

        dialog.add(new JLabel("Introduce el nombre:"));
        dialog.add(txtNombre);
        dialog.add(btnAceptar);
        dialog.add(btnCancelar);

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void openNumeroLetraDialog() {
        JDialog dialog = new JDialog(this, "Añadir Número y Letra", true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setLayout(new FlowLayout());
        dialog.setSize(300, 150);

        JTextField txtNumero = new JTextField(10);
        JTextField txtLetra = new JTextField(10);
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        btnAceptar.addActionListener(e -> {
            // Aquí se añade el número y letra a la lista
            dialog.dispose();
        });

        btnCancelar.addActionListener(e -> dialog.dispose());

        dialog.add(new JLabel("Introduce el número:"));
        dialog.add(txtNumero);
        dialog.add(new JLabel("Introduce la letra:"));
        dialog.add(txtLetra);
        dialog.add(btnAceptar);
        dialog.add(btnCancelar);

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void openNumeroTextoDialog() {
        JDialog dialog = new JDialog(this, "Añadir Número y Texto", true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setLayout(new FlowLayout());
        dialog.setSize(300, 150);

        JTextField txtNumero = new JTextField(10);
        JTextField txtTexto = new JTextField(10);
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        btnAceptar.addActionListener(e -> {
            // Aquí se añade el número y texto a la lista
            dialog.dispose();
        });

        btnCancelar.addActionListener(e -> dialog.dispose());

        dialog.add(new JLabel("Introduce el número:"));
        dialog.add(txtNumero);
        dialog.add(new JLabel("Introduce el texto:"));
        dialog.add(txtTexto);
        dialog.add(btnAceptar);
        dialog.add(btnCancelar);

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void openArchivoDialog() {
        JDialog dialog = new JDialog(this, "Añadir Archivo", true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setLayout(new FlowLayout());
        dialog.setSize(300, 150);

        JTextField txtRuta = new JTextField(20);
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        btnAceptar.addActionListener(e -> {
            // Aquí se añade la ruta del archivo a la lista
            dialog.dispose();
        });

        btnCancelar.addActionListener(e -> dialog.dispose());

        dialog.add(new JLabel("Introduce la ruta del archivo:"));
        dialog.add(txtRuta);
        dialog.add(btnAceptar);
        dialog.add(btnCancelar);

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GestionDatosDinamicos());
    }
}
