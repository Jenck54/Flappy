import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Flappy extends Canvas implements KeyListener {

    protected int largeurEcran = 500;
    protected int hauteurEcran = 700;
    protected boolean pause = false;
    protected Oiseau oiseau;
    protected Tuyau tuyau;
    protected ArrayList<Deplacable> listeDeplacable = new ArrayList<>();
    protected ArrayList<Sprite> listeSprite = new ArrayList<>();


    public Flappy() throws InterruptedException {
        JFrame fenetre = new JFrame("Flappy");
        //On récupère le panneau de la fenetre principale
        JPanel panneau = (JPanel) fenetre.getContentPane();
        //On définie la hauteur / largeur de l'écran
        panneau.setPreferredSize(new Dimension(largeurEcran, hauteurEcran));
        setBounds(0, 0, largeurEcran,hauteurEcran);
        //On ajoute cette classe (qui hérite de Canvas) comme composant du panneau principal
        panneau.add(this);

        fenetre.pack();
        fenetre.setResizable(false);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.requestFocus();
        fenetre.addKeyListener(this);

        //On indique que le raffraichissement de l'ecran doit être fait manuellement.
        createBufferStrategy(2);
        setIgnoreRepaint(true);
        this.setFocusable(false);



        demarrer();
    }

    public void initialiser() {

        pause = false;

        if (oiseau == null) {
            oiseau = new Oiseau(hauteurEcran);
            tuyau = new Tuyau(200, hauteurEcran, largeurEcran);

            listeDeplacable.add(tuyau);
            listeDeplacable.add(oiseau);

            listeSprite.add(tuyau);
            listeSprite.add(oiseau);

            for (int i = 0; i < 50; i ++) {
                Nuage nuage = new Nuage(largeurEcran, hauteurEcran);
                listeDeplacable.add(nuage);
                listeSprite.add(nuage);

            }

        } else {
            for (Deplacable deplacable : listeDeplacable) {
                deplacable.reinitialiser(largeurEcran, hauteurEcran);
            }
        }
    }

    public void demarrer() throws InterruptedException {

        long indexFrame = 0;
        initialiser();

        while(true) {
            indexFrame ++;
            Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();

            //-----------------------------
            //reset dessin
            dessin.setColor(Color.WHITE);
            dessin.fillRect(0,0,largeurEcran,hauteurEcran);

            for (Sprite sprite : listeSprite) {
                sprite.dessiner(dessin);
            }

            if(!pause) {

                if (oiseau.getY() > hauteurEcran - oiseau.getLargeur()) {
                    System.out.println("Perdu");
                    pause = true;
                } else {
//                    oiseau.deplacer();
//                    tuyau.deplacer();
                    for(Deplacable deplacable : listeDeplacable) {
                        deplacable.deplacer(largeurEcran, hauteurEcran);
                    }

                    if (Sprite.testCollision(oiseau, tuyau)) {
                        System.out.println("Perdu");
                        pause = true;
                    }
                }
            } else {
                dessin.setColor(new Color(0,0,0,0.1f));
                dessin.fillRect(0,0,largeurEcran,hauteurEcran);
            }
            //-----------------------------
            dessin.dispose();
            getBufferStrategy().show();
            Thread.sleep(1000 / 60);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Flappy();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            oiseau.sauter();
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            initialiser();
        }

        if (e.getKeyCode() == KeyEvent.VK_P) {
            pause = !pause;
        }
    }
}
