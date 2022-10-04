import java.awt.*;

public class Oiseau extends Carre {

    protected int vitesseVertical;

    @Override
    public void dessiner(Graphics2D dessin) {

    }

    public void sauter {

    }

    public Oiseau(int x, int y, Color couleur, int largeur, int vitesseVertical, void sauter) {
        super(x, y, couleur, largeur);
        this.vitesseVertical = vitesseVertical;
        this.sauter = sauter;
    }

    public int getVitesseVertical() {
        return vitesseVertical;
    }

    public void setVitesseVertical(int vitesseVertical) {
        this.vitesseVertical = vitesseVertical;
    }

    public void getSauter() {
        return sauter;
    }

    public void setSauter(void sauter) {
        this.sauter = sauter;
    }
}
