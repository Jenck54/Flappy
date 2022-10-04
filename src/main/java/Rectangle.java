import java.awt.*;

public abstract class Rectangle extends Carre {

    protected int hauteur;

    public Rectangle(int x, int y, Color couleur, int largeur, int hauteur) {
        super(x, y, couleur, largeur);
        this.hauteur = hauteur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }
}
