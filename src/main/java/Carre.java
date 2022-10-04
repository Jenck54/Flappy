import java.awt.*;

public abstract class Carre extends Sprite {

    protected int largeur;

    public Carre(int x, int y, Color couleur, int largeur) {
        super(x, y, couleur);
        this.largeur = largeur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
}
