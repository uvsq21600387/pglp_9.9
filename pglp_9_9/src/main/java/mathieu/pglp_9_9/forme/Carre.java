package mathieu.pglp_9_9.forme;

/**
 * forme de type Carré avec en mémoire longueur
 * et position du coin en haut à gauche.
 */
public class Carre extends Forme {
    /**
     * position du coin en haut à gauche du carré.
     */
    private Position topLeft;
    /**
     * longueur des côtés du carré.
     */
    private int longueur;
    /**
     * constructeur d'un carré avec position du coin en haut à gauche.
     * @param nomVariable nom de variable pour créer le carré
     * @param topLeftPosition position du coin en haut à gauche du carré
     * @param longueurCarre longueur du carré
     */
    public Carre(final String nomVariable, final Position topLeftPosition,
            final int longueurCarre) {
        super(nomVariable);
        this.topLeft = topLeftPosition.clone();
        this.longueur = longueurCarre;
    }
    /**
     * deplace un carré.
     * @param x déplacement en abscisse
     * @param y deplacement en ordonée
     */
    @Override
    public void deplace(final int x, final int y) {
        topLeft.deplace(x, y);
    }
    /**
     * affiche un carré.
     */
    @Override
    public void affiche() {
        System.out.println("Carre (longueur = "
                + longueur
                + ", position du coin en haut à gauche = " + topLeft + ")");
    }
    /**
     * obtenir la position du coin en haut à gauche du carré.
     * @return position du coin en haut à gauche du carré
     */
    public Position getTopLeft() {
        return topLeft.clone();
    }
    /**
     * modifier la position du carré.
     * @param topLeftPosition nouvelle position du coin en haut à gauche
     */
    public void setTopLeft(final Position topLeftPosition) {
        this.topLeft = topLeft.clone();
    }
    /**
     * obtenir la longueur du carré.
     * @return la longueur du carré
     */
    public int getLongueur() {
        return longueur;
    }
    /**
     * modifier la longueur du carré.
     * @param longueurCarre nouvelle valeur pour la longueur
     */
    public void setLongueur(final int longueurCarre) {
        this.longueur = longueurCarre;
    }
}
