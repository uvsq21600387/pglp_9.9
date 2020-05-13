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
     * @param nomVariable nom de variable pour créer le rectangle
     * @param topLeftPosition position du coin en haut à gauche du rectangle
     * @param longueurRectangle longueur du rectangle
     * @param largeurRectangle largeur du rectangle
     * @throws Exception si longueur ou largeur invalide
     */
    public Rectangle(final String nomVariable, final Position topLeftPosition,
            final int longueurRectangle, final int largeurRectangle)
            throws Exception {
        super(nomVariable);
        this.topLeft = topLeftPosition.clone();
        this.setLargeur(largeurRectangle);
        this.setLongueur(longueurRectangle);
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
    public void affiche() {
        super.affiche();
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
     * obtenir la largeur du rectangle.
     * @return la largeur du rectangle
     */
    public int getLargeur() {
        return largeur;
    }
    /**
     * modifier la largeur du rectangle.
     * @param largeurRectangle nouvelle valeur pour la largeur > 0
     * @throws Exception longueur invalide
     */
    public void setLargeur(final int largeurRectangle) throws Exception {
        if (largeurRectangle > 0) {
            this.largeur = largeurRectangle;
        } else {
            throw new Exception();
        }
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
     * @param longueurRectangle nouvelle valeur pour la longueur > 0
     * @throws Exception longueur invalide
     */
    public void setLongueur(final int longueurRectangle) throws Exception {
        if (longueurRectangle > 0) {
            this.longueur = longueurRectangle;
        } else {
            throw new Exception();
        }
    }
}
