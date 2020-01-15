package Interfaz.Paneles;

import Interfaz.Paneles.Modelos.Etiqueta_Boton;
import Interfaz.Ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel_Principal extends JPanel implements ActionListener {
    private Etiqueta_Boton guia, quiz, crono;
    private JLabel et_guia, et_quiz, et_built, et_crono;
    private JButton btn_guia, btn_quiz, btn_built, btn_crono;
    private JPanel boton;
    private Ventana ventana;

    public Panel_Principal(Ventana ventana) {
        this.ventana = ventana;
        initGUI();
    }

    private void initGUI() {
        instancias();
        acciones();
        configurarPanel();
    }

    private void acciones() {
        btn_guia.addActionListener(this);
        btn_crono.addActionListener(this);
        btn_quiz.addActionListener(this);
    }

    private void configurarPanel() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        this.add(guia);
        this.add(quiz);
        this.add(crono);
    }


    private void instancias() {
        boton = new JPanel();
        boton.setBackground(new Color(95, 95, 95));
        et_guia = new JLabel("Campeones");
        et_quiz = new JLabel("Quiz");
        et_built = new JLabel("¡Buildeate!");
        et_crono = new JLabel("Timing");
        btn_guia = new JButton();
        btn_quiz = new JButton();
        btn_built = new JButton();
        btn_crono = new JButton();
        configurarEtiquetas();
        configurarBotones();
        guia = new Etiqueta_Boton(et_guia, btn_guia);
        quiz = new Etiqueta_Boton(et_quiz, btn_quiz);
        crono = new Etiqueta_Boton(et_crono, btn_crono);

    }


    private void configurarEtiquetas() {
        et_guia.setForeground(new Color(255, 255, 255));
        et_guia.setFont(new Font("Arial", 0, 20));
        et_quiz.setForeground(new Color(255, 255, 255));
        et_quiz.setFont(new Font("Arial", 0, 20));
        et_crono.setForeground(new Color(255, 255, 255));
        et_crono.setFont(new Font("Arial", 0, 20));
        et_built.setForeground(new Color(255, 255, 255));
        et_built.setFont(new Font("Arial", 0, 20));
    }

    private void configurarBotones() {
        btn_guia.setIcon(new ImageIcon(getClass().getResource("../../Resources/amumu.jpg")));
        btn_guia.setContentAreaFilled(false);
        btn_guia.setBorderPainted(false);
        btn_quiz.setIcon(new ImageIcon(getClass().getResource("../../Resources/tumblr_pwwuxyuIAE1vo6vclo5_250.jpg")));
        btn_quiz.setContentAreaFilled(false);
        btn_quiz.setBorderPainted(false);
        btn_crono.setIcon(new ImageIcon(getClass().getResource("../../Resources/Featherknight-Summoner-Icon-TFT-LoL.jpeg")));
        btn_crono.setContentAreaFilled(false);
        btn_crono.setBorderPainted(false);
        btn_built.setIcon(new ImageIcon(getClass().getResource("../../Resources/vi.png")));
        btn_built.setContentAreaFilled(false);
        btn_built.setBorderPainted(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_guia) {
            ventana.getCardLayout().show(ventana.getPanel_card(), "Champs");
        } else if (e.getSource() == btn_crono) {
            ventana.getCardLayout().show(ventana.getPanel_card(), "Times");
        } else if (e.getSource() == btn_quiz) {
            ventana.getCardLayout().show(ventana.getPanel_card(), "Quiz");
        }
    }
}
