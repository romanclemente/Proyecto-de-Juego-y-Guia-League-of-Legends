package Interfaz.Paneles;

import Interfaz.Ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Times extends JPanel implements ActionListener {
    private final int re_baron = 420, re_drake = 360, re_blue = 300, re_red = 300;
    private JLabel blue, blue_time, red, red_time, nash, nash_time, drake, drake_time;
    private JButton blue_btn, red_btn, nash_btn, drake_btn;
    private JPanel panel_blue, panel_red, panel_drake, panel_nashor;
    private Ventana ventana;

    public Times(Ventana ventana) throws HeadlessException {

        this.ventana = ventana;
        initGUI();
    }

    private void initGUI() {
        instancias();
        acciones();
        configurarPanel();
    }

    private void configurarPanel() {
        this.setLayout(new GridLayout(2, 2));
        this.setBackground(new Color(95, 95, 95));
        this.add(configurarPanelBlue());
        this.add(configurarPanelRed());
        this.add(configurarPanelNash());
        this.add(configurarPanelDrake());
    }

    private void acciones() {
        blue_btn.addActionListener(this);
        red_btn.addActionListener(this);
        drake_btn.addActionListener(this);
        nash_btn.addActionListener(this);
    }

    private void instancias() {
        panel_blue = new JPanel();
        panel_blue.setBackground(new Color(95, 95, 95));
        panel_red = new JPanel();
        panel_red.setBackground(new Color(95, 95, 95));
        panel_drake = new JPanel();
        panel_drake.setBackground(new Color(95, 95, 95));
        panel_nashor = new JPanel();
        panel_nashor.setBackground(new Color(95, 95, 95));
        blue_btn = new JButton("¡Tiempo!");
        red_btn = new JButton("¡Tiempo!");
        drake_btn = new JButton("¡Tiempo!");
        nash_btn = new JButton("¡Tiempo!");
        blue = new JLabel("Golem azul");
        blue.setForeground(new Color(255, 255, 255));
        blue.setFont(new Font("Arial", 0, 20));
        blue_time = new JLabel(String.valueOf(re_blue));
        blue_time.setForeground(new Color(255, 255, 255));
        blue_time.setFont(new Font("Arial", 0, 20));
        red = new JLabel("Golem rojo");
        red.setForeground(new Color(255, 255, 255));
        red.setFont(new Font("Arial", 0, 20));
        red_time = new JLabel(String.valueOf(re_red));
        red_time.setForeground(new Color(255, 255, 255));
        red_time.setFont(new Font("Arial", 0, 20));
        nash = new JLabel("Baron Nashor");
        nash.setForeground(new Color(255, 255, 255));
        nash.setFont(new Font("Arial", 0, 20));
        nash_time = new JLabel(String.valueOf(re_baron));
        nash_time.setForeground(new Color(255, 255, 255));
        nash_time.setFont(new Font("Arial", 0, 20));
        drake = new JLabel("Dragon Elemental");
        drake.setForeground(new Color(255, 255, 255));
        drake.setFont(new Font("Arial", 0, 20));
        drake_time = new JLabel(String.valueOf(re_drake));
        drake_time.setForeground(new Color(255, 255, 255));
        drake_time.setFont(new Font("Arial", 0, 20));
    }

    private JPanel configurarPanelDrake() {
        panel_drake.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        panel_drake.setBackground(new Color(95, 95, 95));
        panel_drake.add(drake);
        panel_drake.add(drake_time);
        panel_drake.add(drake_btn);
        return panel_drake;
    }

    private JPanel configurarPanelRed() {
        panel_red.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        panel_red.setBackground(new Color(95, 95, 95));
        panel_red.add(red);
        panel_red.add(red_time);
        panel_red.add(red_btn);
        return panel_red;
    }

    private JPanel configurarPanelNash() {
        panel_nashor.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        panel_nashor.setBackground(new Color(95, 95, 95));
        panel_nashor.add(nash);
        panel_nashor.add(nash_time);
        panel_nashor.add(nash_btn);
        return panel_nashor;
    }

    private JPanel configurarPanelBlue() {
        panel_blue.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        panel_blue.setBackground(new Color(95, 95, 95));
        panel_blue.add(blue);
        panel_blue.add(blue_time);
        panel_blue.add(blue_btn);
        return panel_blue;
    }

    public JLabel getBlue_time() {
        return blue_time;
    }

    public void setBlue_time(JLabel blue_time) {
        this.blue_time = blue_time;
    }

    public void CambiarTexto(String string) {
        this.blue_time.setText(string);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == blue_btn) {
            blue_btn.setEnabled(false);
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    int i = re_blue;
                    while (i != -1) {

                        blue_time.setText("" + i);
                        i--;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    blue_btn.setEnabled(true);
                    blue_time.setText(String.valueOf(re_blue));
                }
            });
            t.start();

        } else if (e.getSource() == red_btn) {
            red_btn.setEnabled(false);
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    int i = re_red;
                    while (i != -1) {

                        red_time.setText("" + i);
                        i--;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }

                    red_time.setText(String.valueOf(re_red));
                    red_btn.setEnabled(true);
                }
            });
            t.start();

        } else if (e.getSource() == drake_btn) {
            drake_btn.setEnabled(false);
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    int i = re_drake;
                    while (i != -1) {

                        drake_time.setText("" + i);
                        i--;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    drake_time.setText(String.valueOf(re_drake));
                    drake_btn.setEnabled(true);
                }
            });
            t.start();

        } else if (e.getSource() == nash_btn) {
            nash_btn.setEnabled(false);
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    int i = re_baron;
                    while (i != -1) {

                        nash_time.setText("" + i);
                        i--;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    nash_time.setText(String.valueOf(re_baron));
                    nash_btn.setEnabled(true);
                }
            });
            t.start();

        }
    }
}




