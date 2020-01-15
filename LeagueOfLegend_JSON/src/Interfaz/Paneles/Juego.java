package Interfaz.Paneles;

import Controlador.Controlador;
import Interfaz.Paneles.Modelos.Etiqueta_Etiqueta;
import Interfaz.Ventana;
import Logica.Campeon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Juego extends JPanel implements ActionListener {
    private JLabel player, player2, contador, contador2, pregunta, segundero;
    private String nombre, nombre2;
    private JPanel jugadores;
    private JProgressBar bar;
    private Controlador controlador;
    private JButton boton, respuesta1, respuesta2, respuesta3, respuesta4;
    private Ventana ventana;
    private int x = 0;

    public Juego(String player, String player2, Controlador controlador, Ventana ventana) {
        nombre = player;
        nombre2 = player2;
        this.controlador = controlador;
        this.ventana = ventana;
        initGUI();
    }

    private void acciones() {
        boton.addActionListener(this);
    }

    private void configurarPanel() {
        this.setLayout(new GridLayout(3, 1));
        this.setBackground(new Color(95, 95, 95));
        this.add(new Etiqueta_Etiqueta(pregunta, segundero));
        this.add(configurarJugadores());
        this.add(boton);

    }

    private JPanel bar_Panel() {
        JPanel jPanel = new JPanel();
        jPanel.setBackground(new Color(95, 95, 95));
        jPanel.setLayout(new GridLayout(2, 1));
        jPanel.add(configurarBotonera());
        jPanel.add(bar);
        return jPanel;
    }

    private void initGUI() {
        instancias();
        acciones();
        configurarPanel();
    }

    private void instancias() {
        bar = new JProgressBar(0, 10);
        bar.setMinimum(0);
        bar.setMaximum(10);
        bar.setPreferredSize(new Dimension(10, 500));
        respuesta1 = new JButton();
        respuesta2 = new JButton();
        respuesta3 = new JButton();
        respuesta4 = new JButton();
        boton = new JButton("YA");
        player = new JLabel(nombre);
        player.setFont(new Font("Arial", 0, 20));
        player.setForeground(new Color(255, 255, 255));
        player2 = new JLabel(nombre2);
        player2.setFont(new Font("Arial", 0, 20));
        player2.setForeground(new Color(255, 255, 255));
        contador = new JLabel("0");
        contador.setFont(new Font("Arial", 0, 20));
        contador.setForeground(new Color(255, 255, 255));
        contador2 = new JLabel("0");
        contador2.setFont(new Font("Arial", 0, 20));
        contador2.setForeground(new Color(255, 255, 255));
        segundero = new JLabel("10");
        segundero.setFont(new Font("Arial", 0, 20));
        segundero.setForeground(new Color(255, 255, 255));
        pregunta = new JLabel("¿ESTAIS TODOS LISTOS?");
        pregunta.setFont(new Font("Arial", 0, 20));
        pregunta.setForeground(new Color(255, 255, 255));
        jugadores = new JPanel();
    }

    private JPanel configurarJugadores() {
        jugadores.setLayout(new GridLayout(1, 2));
        jugadores.setBackground(new Color(95, 95, 95));
        jugadores.add(new Etiqueta_Etiqueta(player, contador));
        jugadores.add(new Etiqueta_Etiqueta(player2, contador2));
        return jugadores;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton) {
            this.remove(boton);
            this.add(bar_Panel());
            ventana.pack();
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    int i = 10;
                    while (i != -1) {
                        if (x == 2) {
                            x = 0;
                        }
                        bar.setValue(0);
                        removerActions();
                        Campeon campeon = seleccionarCampeonAleatorio();
                        SeleccionarPregunta(x, campeon);
                        resultadoPregunta(campeon);
                        try {
                            Thread.sleep(11000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        x++;
                        if (i == 0) {
                            if (Integer.parseInt(contador.getText()) > Integer.parseInt(contador2.getText())) {
                                pregunta.setText("Ha ganado el jugador: " + nombre);
                            } else if (Integer.parseInt(contador2.getText()) > Integer.parseInt(contador.getText())) {
                                pregunta.setText("Ha ganado el jugador: " + nombre2);
                            } else {
                                pregunta.setText("Empate");
                            }
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            System.exit(0);
                        }
                        i--;


                    }
                }
            });
            t.start();
        }

        if (e.getSource() == respuesta1) {
            if (x == 0) {
                contador.setText(String.valueOf(Integer.parseInt(contador.getText()) + 1));
                respuesta1.setEnabled(false);
                respuesta2.setEnabled(false);
                respuesta3.setEnabled(false);
                respuesta4.setEnabled(false);
            } else {
                contador2.setText(String.valueOf(Integer.parseInt(contador2.getText()) + 1));
                respuesta1.setEnabled(false);
                respuesta1.setEnabled(false);
                respuesta2.setEnabled(false);
                respuesta3.setEnabled(false);
                respuesta4.setEnabled(false);
            }
        } else if (e.getSource() == respuesta2) {
            if (x == 0) {
                contador.setText(String.valueOf(Integer.parseInt(contador.getText()) + 1));
                respuesta1.setEnabled(false);
                respuesta2.setEnabled(false);
                respuesta3.setEnabled(false);
                respuesta4.setEnabled(false);
            } else {
                contador2.setText(String.valueOf(Integer.parseInt(contador2.getText()) + 1));
                respuesta1.setEnabled(false);
                respuesta2.setEnabled(false);
                respuesta3.setEnabled(false);
                respuesta4.setEnabled(false);
            }

        } else if (e.getSource() == respuesta3) {
            if (x == 0) {
                contador.setText(String.valueOf(Integer.parseInt(contador.getText()) + 1));
                respuesta1.setEnabled(false);
                respuesta2.setEnabled(false);
                respuesta3.setEnabled(false);
                respuesta4.setEnabled(false);
            } else {
                contador2.setText(String.valueOf(Integer.parseInt(contador2.getText()) + 1));
                respuesta1.setEnabled(false);
                respuesta2.setEnabled(false);
                respuesta3.setEnabled(false);
                respuesta4.setEnabled(false);
            }

        } else if (e.getSource() == respuesta4) {
            if (x == 0) {
                contador.setText(String.valueOf(Integer.parseInt(contador.getText()) + 1));
                respuesta1.setEnabled(false);
                respuesta2.setEnabled(false);
                respuesta3.setEnabled(false);
                respuesta4.setEnabled(false);
            } else {
                contador2.setText(String.valueOf(Integer.parseInt(contador2.getText()) + 1));
                respuesta1.setEnabled(false);
                respuesta2.setEnabled(false);
                respuesta3.setEnabled(false);
                respuesta4.setEnabled(false);
            }
        }

    }

    private void removerActions() {
        respuesta1.removeActionListener(this);
        respuesta1.setText("");
        respuesta1.setEnabled(true);
        respuesta2.removeActionListener(this);
        respuesta2.setText("");
        respuesta2.setEnabled(true);
        respuesta3.removeActionListener(this);
        respuesta3.setText("");
        respuesta3.setEnabled(true);
        respuesta4.removeActionListener(this);
        respuesta4.setText("");
        respuesta4.setEnabled(true);
    }

    private void resultadoPregunta(Campeon campeon) {
        int buton = (int) (Math.random() * 3);
        switch (buton) {
            case 0:
                respuesta1.setText(campeon.getName());
                respuesta1.addActionListener(this);
                break;
            case 1:
                respuesta2.setText(campeon.getName());
                respuesta2.addActionListener(this);
                break;
            case 2:
                respuesta3.setText(campeon.getName());
                respuesta3.addActionListener(this);
                break;
            case 3:
                respuesta4.setText(campeon.getName());
                respuesta4.addActionListener(this);
                break;
        }
        if (respuesta1.getText().equalsIgnoreCase("")) {
            respuesta1.setText(seleccionarCampeonAleatorio().getName());
            respuesta1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    respuesta1.setEnabled(false);
                    respuesta2.setEnabled(false);
                    respuesta3.setEnabled(false);
                    respuesta4.setEnabled(false);
                }
            });
        }
        if (respuesta2.getText().equalsIgnoreCase("")) {
            respuesta2.setText(seleccionarCampeonAleatorio().getName());
            respuesta2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    respuesta1.setEnabled(false);
                    respuesta2.setEnabled(false);
                    respuesta3.setEnabled(false);
                    respuesta4.setEnabled(false);
                }
            });
        }
        if (respuesta3.getText().equalsIgnoreCase("")) {
            respuesta3.setText(seleccionarCampeonAleatorio().getName());
            respuesta3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    respuesta1.setEnabled(false);
                    respuesta2.setEnabled(false);
                    respuesta3.setEnabled(false);
                    respuesta4.setEnabled(false);
                }
            });
        }
        if (respuesta4.getText().equalsIgnoreCase("")) {
            respuesta4.setText(seleccionarCampeonAleatorio().getName());
            respuesta4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    respuesta1.setEnabled(false);
                    respuesta2.setEnabled(false);
                    respuesta3.setEnabled(false);
                    respuesta4.setEnabled(false);
                }
            });
        }


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int contador_bar = 0;
                int i = 10;
                while (i != -1) {
                    segundero.setText(String.valueOf(i));
                    bar.setValue(contador_bar);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    contador_bar++;
                    i--;
                }

            }
        });
        t.start();

    }

    //0 armor, 1 crecarmor, 2 hpbase, 3 crecehp, 4reghp, 5crecireghp, 6daño, 7veldaño, 8magicresis
    private void SeleccionarPregunta(int x, Campeon campeon) {
        double value = 0;
        String jugador;
        int preguntaRandom = (int) (Math.random() * controlador.getPreguntas().size());
        if (x == 0) {
            jugador = this.nombre + ":";
        } else {
            jugador = this.nombre2 + ":";
        }
        switch (preguntaRandom) {
            case 0:
                value = campeon.getStats().getArmor();
                break;
            case 1:
                value = campeon.getStats().getArmorperlevel();
                break;
            case 2:
                value = campeon.getStats().getHp();
                break;
            case 3:
                value = campeon.getStats().getHpperlevel();
                break;
            case 4:
                value = campeon.getStats().getHpregen();
                break;
            case 5:
                value = campeon.getStats().getHpregenperlevel();
                break;
            case 6:
                value = campeon.getStats().getAttackdamage();
                break;
            case 7:
                value = campeon.getStats().getAttackspeed();
                break;
            case 8:
                value = campeon.getStats().getSpellblock();
                break;
        }
        pregunta.setText(jugador + " " + controlador.getPreguntas().get(preguntaRandom) + " " + value);
    }

    private Campeon seleccionarCampeonAleatorio() {
        int campeonAleatorio = (int) (Math.random() * controlador.getCampeones().size());

        return controlador.getCampeones().get(campeonAleatorio);
    }

    private JPanel configurarBotonera() {
        JPanel botons = new JPanel();
        botons.setLayout(new GridLayout(2, 2));
        botons.setBackground(new Color(95, 95, 95));
        botons.add(respuesta1);
        botons.add(respuesta2);
        botons.add(respuesta3);
        botons.add(respuesta4);
        return botons;
    }
}

