package Interfaz.Paneles;

import Interfaz.Paneles.Modelos.Etiqueta_Etiqueta;
import Interfaz.Ventana;
import Logica.Campeon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Info_Champ extends JPanel implements ActionListener {
    private JLabel nombre, icon, roles;
    private JTextArea lore;
    private JButton volver;
    private JPanel superior, nm_ap_ic, lore_stats, stats;
    private Campeon campeon;
    private String imagen;
    private Ventana ventana;
    private Champs champs;

    public Info_Champ(Campeon campeon, String imagen, Ventana ventana, Champs champs) {
        this.campeon = campeon;
        this.ventana = ventana;
        this.imagen = imagen;
        this.champs = champs;
        initGUI();
    }

    private void initGUI() {
        instancias();
        acciones();
        configurarPanel();
    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(95, 95, 95));
        this.add(configurarPanel_Superior(), BorderLayout.NORTH);
        this.add(configurarLore(), BorderLayout.CENTER);
        this.add(volver, BorderLayout.SOUTH);
    }

    private JPanel configurarLore() {
        lore_stats.setLayout(new GridLayout(1, 2));
        lore_stats.add(lore);
        lore_stats.add(configurar_Stats());
        return lore_stats;
    }

    private JPanel configurar_Stats() {
        stats.setLayout(new GridLayout(4, 2));
        stats.add(new Etiqueta_Etiqueta(new JLabel("Vida:"), new JLabel(String.valueOf(campeon.getStats().getHp()))));
        stats.add(new Etiqueta_Etiqueta(new JLabel("Regeneracion de vida:"), new JLabel(campeon.getStats().getHpregen() + "%")));
        stats.add(new Etiqueta_Etiqueta(new JLabel("Armadura:"), new JLabel(String.valueOf(campeon.getStats().getArmor()))));
        stats.add(new Etiqueta_Etiqueta(new JLabel("Resistencia Magica:"), new JLabel(String.valueOf(campeon.getStats().getSpellblock()))));
        stats.add(new Etiqueta_Etiqueta(new JLabel("Daño de ataque:"), new JLabel(String.valueOf(campeon.getStats().getAttackdamage()))));
        stats.add(new Etiqueta_Etiqueta(new JLabel("Velocidad de ataque:"), new JLabel(String.valueOf(campeon.getStats().getAttackspeed()))));
        stats.add(new Etiqueta_Etiqueta(new JLabel("Velocidad de movimiento:"), new JLabel(String.valueOf(campeon.getStats().getMovespeed()))));
        stats.add(new Etiqueta_Etiqueta(new JLabel("Rango de ataque basico"), new JLabel(String.valueOf(campeon.getStats().getAttackrange()))));
        return stats;
    }

    private void instancias() {
        lore_stats = new JPanel();
        lore_stats.setBackground(new Color(95, 95, 95));
        stats = new JPanel();
        stats.setBackground(new Color(95, 95, 95));
        volver = new JButton("Volver");
        superior = new JPanel();
        superior.setBackground(new Color(95, 95, 95));
        nm_ap_ic = new JPanel();
        nm_ap_ic.setBackground(new Color(95, 95, 95));
        nombre = new JLabel(campeon.getName() + "," + campeon.getTitle());
        nombre.setFont(new Font("Arial", 0, 20));
        nombre.setForeground(new Color(255, 255, 255));
        lore = new JTextArea();
        lore.setEditable(false);
        adaptarTexto();
        lore.setFont(new Font("Arial", 0, 20));
        lore.setForeground(new Color(255, 255, 255));
        roles = new JLabel("");
        roles.setFont(new Font("Arial", 0, 20));
        roles.setForeground(new Color(255, 255, 255));
        for (String st : campeon.getTags()) {
            roles.setText(roles.getText() + " " + st);
        }
        icon = new JLabel();
        URL urlImagen;
        try {
            urlImagen = new URL(imagen);
            BufferedImage imagenInternet = ImageIO.read(urlImagen);
            icon.setIcon(new ImageIcon(imagenInternet));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        lore.setBackground(new Color(95, 95, 95));
    }

    private void adaptarTexto() {
        int i = 0;
        String[] partes = campeon.getBlurb().split(" ");
        String prueba = "";
        for (String st : partes) {
            i++;
            prueba += " " + st;
            if (i % 10 == 0) {
                prueba += "\n";
            }

        }
        lore.setText(prueba);
    }


    private JPanel configurarPanel_Superior() {
        superior.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        superior.add(configurarPanel_Nombre_Icono());
        superior.add(roles);
        return superior;
    }

    private JPanel configurarPanel_Nombre_Icono() {
        nm_ap_ic.setLayout(new GridLayout(3, 1));
        nm_ap_ic.add(icon);
        nm_ap_ic.add(nombre);
        return nm_ap_ic;
    }


    private void acciones() {
        volver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ventana.getCardLayout().show(ventana.getPanel_card(), "Champs");
        ventana.getCardLayout().removeLayoutComponent(this);
    }

}
