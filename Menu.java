import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class Menu extends JPanel implements MouseListener, ActionListener {
    Data data = new Data();
    private Bouton bouton1 = new Bouton("PLAY/PAUSE");
    private Bouton bouton2 = new Bouton("Position aléatoire");
    private Bouton bouton3 = new Bouton("Changer vitesse");
    private Bouton bouton4 = new Bouton("Reinitialiser cellules");
    int compteur = 0;
    boolean depart = false;
    public static final Color brown = new Color(153,102,0);
    public int vitesse = 5;

    Menu() {
        bouton1.addActionListener(this);
        bouton2.addActionListener(this);
        bouton3.addActionListener(this);
        bouton4.addActionListener(this);
        this.add(bouton1);
        this.add(bouton2);
        this.add(bouton4);
        this.add(bouton3);
        addMouseListener(this);
        refresh();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        depart = false;
        int numeroCaseX = e.getX()/8;
        int numeroCaseY = e.getY()/8;
        System.out.println("X : " + numeroCaseX + " Y : "+ numeroCaseY);
        data.tableauCelulles[numeroCaseY][numeroCaseX] = true;

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void refresh() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    repaint();
                    if(depart) {
                        try {
                            Thread.sleep(1000 / vitesse);
                            data.calculGeneration();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }).start();
    }
    


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //System.out.println(data.tableauCelulles[50][50]);
        int xCarre = 1;
        int yCarre = 1;
        for (int i = 0; i <= fenetre.LARGEUR; i += 8) {
            g.fillRect(i, 0, 1, fenetre.LONGUEUR);
            g.fillRect(0, i, fenetre.LARGEUR, 1);
        }
        g.setColor(Color.blue);
        for (int i = 0; i < data.tableauCelulles.length; i++) {
            for (int j = 0; j < data.tableauCelulles.length; j++) {
                if (data.tableauCelulles[i][j] == true) {
                    g.fillRect(xCarre, yCarre, Data.TAILLECELLULE, Data.TAILLECELLULE);
                }
                xCarre += 8;
            }
            xCarre = 1;
            yCarre += 8;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bouton1) {
            if(depart) depart=false;
            else depart=true;
            System.out.println(depart);
        }else if(e.getSource()==bouton2) {
            data.randomiserData();
        }else if(e.getSource()==bouton3) {
            if(vitesse<95) {
                vitesse+=10;
            }else {
                vitesse=5;
            }
        }else if(e.getSource()==bouton4) {
            data.reset();
        }
    }
}