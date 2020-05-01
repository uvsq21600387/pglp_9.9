package mathieu.pglp_9_9.forme;

/**
 * forme de type Rectangle avec en mémoire longueur, largeur
 * et position du coin en haut à gauche.
 */
public class Rectangle extends Forme {
    /**
     * position du coin en haut à gauche du rectangle.
     */
    private Position topLeft;
    /**
     * longueur du rectangle.
     */
    private int longueur;
    /**
     * largeur du rectangle.
     */
    private int largeur;
    /**
     * constructeur d'un rectangle avec position du coin en haut à gauche.
     * @param nom_de_variable nom de variable pour créer le rectangle
     * @param topLeftPosition position du coin en haut à gauche du rectangle
     * @param longueurRectangle longueur du rectangle
     * @param largeurRectangle largeur du rectangle
     */
    public Rectangle(final String nom_de_variable, final Position topLeftPosition,
            final int longueurRectangle, final int largeurRectangle) {
        super(nom_de_variable);
        this.topLeft = topLeftPosition.clone();
        this.longueur = longueurRectangle;
        this.largeur = largeurRectangle;
    }
    /**
     * deplace un rectangle.
     * @param x déplacement en abscisse
     * @param y deplacement en ordonée
     */
    @Override
    public void deplace(final int x, final int y) {
        topLeft.deplace(x, y);
    }
    /**
     * affiche un rectangle.
     */
    @Override
    public void affiche() {
        System.out.println("Rectangle (longueur = "
                + longueur + ", largeur = " + largeur
                + ", position du coin en haut à gauche = " + topLeft + ")");
    }
    /**
     * obtenir la position du coin en haut à gauche du rectangle.
     * @return position du coin en haut à gauche du rectangle
     */
    public Position getTopLeft() {
        return topLeft.clone();
    }
    /**
     * modifier la position du rectangle.
     * @param topLeftPosition nouvelle position du coin en haut à gauche
     */
    public void setTopLeft(final Position topLeftPosition) {
        this.topLeft = topLeft.clone();
    }
    /**
     * obtenir la largeur du rectangle.
     * @return la largeur du rectangle
     */
    public int getLargeur() {
        return largeur;
    }
    /**
     * modifier la largeur du rectangle.
     * @param largeur nouvelle valeur pour la largeur
     */
    public void setLargeur(final int largeur) {
        this.largeur = largeur;
    }
    /**
     * obtenir la longueur du rectangle.
     * @return la longueur du rectangle
     */
    public int getLongueur() {
        return longueur;
    }
    /**
     * modifier la longueur du rectangle.
     * @param longueurRectangle nouvelle valeur pour la longueur
     */
    public void setLongueur(final int longueurRectangle) {
        this.longueur = longueurRectangle;
    }
}
