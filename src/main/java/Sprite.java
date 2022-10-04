import java.awt.*;

public abstract class Sprite {

    protected int x;

    protected int y;

    protected Color couleur;

    public abstract void dessiner(Graphics2D dessin);

    public Sprite(int x, int y, Color couleur) {
        this.x = x;
        this.y = y;
        this.couleur = couleur;
    }

    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
        this.couleur = Color.RED;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
}
