package Interfaz.Paneles.Modelos;

import javax.swing.*;
import java.awt.*;

public class Etiqueta_Field extends JPanel {
    private JLabel etiqueta1;
    private JTextField jTextField;


    public Etiqueta_Field(JLabel etiqueta1, JTextField jTextField) {
        this.etiqueta1 = etiqueta1;
        this.jTextField = jTextField;
        initGUI();
    }

    private void initGUI() {
        this.setBackground(new Color(95, 95, 95));
        modificarEtiquetas();
        configurarPanel();
    }

    private void modificarEtiquetas() {
        etiqueta1.setFont(new Font("Arial", 0, 20));
        etiqueta1.setForeground(new Color(255, 255, 255));
        jTextField.setFont(new Font("Arial", 0, 20));
    }

    private void configurarPanel() {
        this.setLayout(new GridLayout( 1, 2));
        this.add(etiqueta1);
        this.add(jTextField);

    }

}
