package Interfaz.Paneles;

import Controlador.Controlador;
import Interfaz.Ventana;
import Logica.Campeon;
import Logica.Info;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Champs extends JPanel implements ActionListener {
    private Ventana ventana;
    private final String enlace = "https://ddragon.leagueoflegends.com/cdn/10.1.1/img/champion/";
    private ArrayList<JLabel> etiquetas;
    private ArrayList<JButton> botones;
    private ArrayList<Campeon> campeones;
    private ArrayList<String> texto, enlaces;

    Controlador controlador;

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public Champs(Ventana ventana) {
        this.ventana = ventana;
        controlador = new Controlador();
        initGUI();
    }

    private void initGUI() {
        instancias();
        acciones();
        configurarPanel();
    }

    private void configurarPanel() {
        this.setLayout(new GridLayout(botones.size() / 5, 5));
        for (JButton button : botones) {
            this.add(button);
        }
    }

    private void instancias() {
        campeones = controlador.getCampeones();
        texto = controlador.getCampeones_Name();
        enlaces = new ArrayList<>();
        botones = new ArrayList<>();
        etiquetas = new ArrayList<>();
        for (String string : texto) {
            String enlace_champ = this.enlace + string + ".png";
            enlaces.add(enlace_champ);
            JLabel jLabel = new JLabel(string);
            jLabel.setFont(new Font("Arial", 0, 20));
            jLabel.setForeground(new Color(255, 255, 255));
            etiquetas.add(jLabel);
        }
        for (String enlace : enlaces) {
            URL urlImagen;
            try {
                urlImagen = new URL(enlace);
                BufferedImage imagenInternet = ImageIO.read(urlImagen);
                BufferedImage resized = resize(imagenInternet, 200, 200);
                JButton boton = new JButton();
                boton.setContentAreaFilled(false);
                boton.setBorderPainted(false);
                boton.setIcon(new ImageIcon(resized));
                botones.add(boton);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

    private void acciones() {
        for (JButton jButton : botones) {
            jButton.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < botones.size(); i++) {
            if (e.getSource() == botones.get(i)) {
                conseguirCampeon(i);
            }
        }
    }

    private void conseguirCampeon(int i) {
        for (Campeon campeon : campeones) {
            if (campeon.getName().equalsIgnoreCase(texto.get(i))) {
                String enlace_perso = this.enlace + campeon.getName() + ".png";
                Info_Champ info_champ = new Info_Champ(campeon, enlace_perso, ventana, this);
                ventana.getPanel_card().add(info_champ, "info_champ");
                ventana.getCardLayout().show(ventana.getPanel_card(), "info_champ");
            }
        }
    }


}
