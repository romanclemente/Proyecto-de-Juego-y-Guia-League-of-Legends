package Interfaz;

import Interfaz.Paneles.Champs;
import Interfaz.Paneles.Panel_Principal;
import Interfaz.Paneles.Quiz;
import Interfaz.Paneles.Times;
import Logica.Rotaciones;

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


public class Ventana extends JFrame implements ActionListener {
    private ArrayList<JLabel> champs;
    private Rotaciones rotaciones;
    private Panel_Principal panel_principal;
    private Times times;
    private Quiz quiz;
    private Champs champs_panel;
    private JPanel panel_card, panel_champs;
    private CardLayout cardLayout;
    private Container container;
    private JScrollPane scrollPane;
    private JPanel panelLogo;
    private ImageIcon img;
    private JButton banner;

    public Ventana() throws HeadlessException {
        initGUI();
    }

    private void initGUI() {
        instancias();
        acciones();
        configurarContainer();
        setTitle("League Of Legends Guide");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }

    private void acciones() {
        banner.addActionListener(this);
    }

    private void instancias() {

        times = new Times(this);
        champs_panel = new Champs(this);
        champs_panel.setBackground(new Color(95, 95, 95));
        container = this.getContentPane();
        quiz = new Quiz(this,champs_panel.getControlador());
        panelLogo = new JPanel();
        panelLogo.setBackground(new Color(95, 95, 95));
        img = new ImageIcon(getClass().getResource("/Resources/Lol_logo.png"));
        banner = new JButton(img);
        banner.setBorderPainted(false);
        banner.setContentAreaFilled(false);
        banner.setBorder(null);
        cardLayout = new CardLayout();
        panel_card = new JPanel();
        panel_card.setBackground(new Color(95, 95, 95));
        panel_principal = new Panel_Principal(this);
        panel_principal.setBackground(new Color(95, 95, 95));
        panel_champs = new JPanel();
        panel_champs.setBackground(new Color(95, 95, 95));
        rotaciones = new Rotaciones();
        champs = new ArrayList<>();
        rellenarEtiquetas();
        scrollPane = new JScrollPane(champs_panel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        configurarLayout();

    }

    private JPanel configurarLayout() {
        panel_card.setLayout(cardLayout);
        panel_card.add(panel_principal, "Principal");
        panel_card.add(scrollPane, "Champs");
        panel_card.add(times, "Times");
        panel_card.add(quiz, "Quiz");
        cardLayout.show(panel_card, "Principal");
        return panel_card;
    }

    private void rellenarEtiquetas() {
        for (int i = 0; i < rotaciones.getImages().size(); i++) {
            champs.add(new JLabel());
        }
    }

    private JPanel panel_Champs() {
        URL urlImagen;
        panel_champs.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        for (int i = 0; i < rotaciones.getImages().size(); i++)
            try {
                urlImagen = new URL(rotaciones.getImages().get(i));
                BufferedImage imagenInternet = ImageIO.read(urlImagen);
                champs.get(i).setIcon(new ImageIcon(imagenInternet));
                panel_champs.add(champs.get(i));
                pack();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        return panel_champs;
    }

    private void configurarContainer() {
        container.setLayout(new BorderLayout());
        container.add(banner);
        container.add(logo_Panel(), BorderLayout.NORTH);
        container.add(configurarLayout(), BorderLayout.CENTER);
    }

    private JPanel logo_Panel() {
        panelLogo.setLayout(new GridLayout(2, 1));
        panelLogo.add(banner);
        panelLogo.add(panel_Champs());
        return panelLogo;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getPanel_card() {
        return panel_card;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cardLayout.show(panel_card, "Principal");
    }
}
