import Interfaz.Ventana;
import Logica.BBDD;
import Logica.Rotaciones;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               Ventana v = new Ventana();
            }
       });
    }
}
