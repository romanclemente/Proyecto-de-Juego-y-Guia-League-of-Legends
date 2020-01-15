package Interfaz.Paneles.Modelos;

import javax.swing.*;
import java.awt.*;

public class Etiqueta_Boton_vertical extends JPanel {
    private JLabel etiqueta;
    private JButton boton;

    public Etiqueta_Boton_vertical(JLabel etiqueta, JButton boton) {
        this.etiqueta = etiqueta;
        this.boton = boton;
        initGUI();
    }

    private void initGUI() {
        this.setBackground(new Color(95, 95, 95));
        configurarPanel();
    }

    private void configurarPanel() {
        this.setLayout(new GridLayout(2, 1));
        this.setSize(100, 100);
        this.add(boton);
        this.add(etiqueta);

    }

}
