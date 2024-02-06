import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class fenetre {

    public static final int LONGUEUR = 711;
    public static final int LARGEUR = 734;
    Menu panel = new Menu();

    fenetre() {
        creationFenetre();
    }

    private void creationFenetre() {
        JFrame frame = new JFrame("Le jeu de la vie");
        frame.setSize(LONGUEUR, LARGEUR);
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}