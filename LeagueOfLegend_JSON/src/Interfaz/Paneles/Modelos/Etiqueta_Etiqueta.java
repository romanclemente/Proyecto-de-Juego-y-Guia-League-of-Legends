package Interfaz.Paneles.Modelos;

import javax.swing.*;
import java.awt.*;

public class Etiqueta_Etiqueta extends JPanel {
    private JLabel etiqueta1, etiqueta2;


    public Etiqueta_Etiqueta(JLabel etiqueta1, JLabel etiqueta2) {
        this.etiqueta1 = etiqueta1;
        this.etiqueta2 = etiqueta2;
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
        etiqueta2.setFont(new Font("Arial", 0, 20));
        etiqueta2.setForeground(new Color(255, 255, 255));
    }

    private void configurarPanel() {
        this.setLayout(new FlowLayout((FlowLayout.CENTER), 50, 0));
        this.add(etiqueta1);
        this.add(etiqueta2);

    }

}
