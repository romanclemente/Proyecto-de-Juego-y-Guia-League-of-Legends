package Interfaz.Paneles;

import Controlador.Controlador;
import Interfaz.Paneles.Modelos.Etiqueta_Field;
import Interfaz.Ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JPanel implements ActionListener {
    private Controlador controlador;
    private CardLayout cardLayout;
    private Juego juego;
    private JLabel nombre1, nombre2;
    private JButton listo;
    private JTextField nombre_txt, nombre2_txt;
    private JPanel inscripcion;
    private Ventana ventana;

    public Quiz(Ventana ventana, Controlador controlador) {
        this.controlador = controlador;
        this.ventana = ventana;
        initGUI();
    }

    private void initGUI() {
        instancias();
        acciones();
        configurarPanel();
    }

    private void acciones() {
        listo.addActionListener(this);
    }

    private void configurarPanel() {
        this.setLayout(cardLayout);
        this.setBackground(new Color(95, 95, 95));
        this.add(configurarPaneloggin(), "login");
        cardLayout.show(this, "login");
    }

    private JPanel configurarPaneloggin() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2, 1));
        jPanel.add(configurarInscripcion());
        jPanel.add(configurarBoton());
        return jPanel;
    }

    private JPanel configurarBoton() {
        JPanel jPanel = new JPanel();
        jPanel.setBackground(new Color(95, 95, 95));
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        jPanel.add(listo);
        return jPanel;
    }

    private void instancias() {
        listo = new JButton("Listo");
        inscripcion = new JPanel();
        inscripcion.setBackground(new Color(95, 95, 95));
        cardLayout = new CardLayout();
        nombre1 = new JLabel("Nombre jugador 1:");
        nombre2 = new JLabel("Nombre jugador 2:");
        nombre_txt = new JTextField();
        nombre2_txt = new JTextField();
    }

    private JPanel configurarInscripcion() {
        inscripcion.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        inscripcion.add(new Etiqueta_Field(nombre1, nombre_txt));
        inscripcion.add(new Etiqueta_Field(nombre2, nombre2_txt));
        return inscripcion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!this.nombre_txt.getText().equalsIgnoreCase("") && !this.nombre2_txt.getText().equalsIgnoreCase("")) {
            String player = this.nombre_txt.getText(), player2 = this.nombre2_txt.getText();
            juego = new Juego(player, player2, controlador, ventana);
            this.add(juego, "juego");
            cardLayout.show(this, "juego");
        }else{
            JOptionPane.showMessageDialog(this,"Es necesario un nombre de jugador","Valores requeridos",JOptionPane.WARNING_MESSAGE);
        }
    }
}
