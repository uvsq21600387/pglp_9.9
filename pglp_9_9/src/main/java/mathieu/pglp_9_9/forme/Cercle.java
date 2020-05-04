package mathieu.pglp_9_9.forme;

/**
 * classe Cercle qui est une forme.
 */
public class Cercle extends Forme {
    /**
     * position du centre du cercle.
     */
    private Position centre;
    /**
     * rayon du cercle.
     */
    private int rayon;
    /**
     * constructeur de Cercle.
     * @param nomVariable nom de variable pour créer le cercle
     * @param p position du cercle
     * @param rayonCercle rayon du cercle
     */
    public Cercle(final String nomVariable, final Position p,
            final int rayonCercle) {
        super(nomVariable);
        centre = p.clone();
        rayon = rayonCercle;
    }
    /**
     * déplacer un cercle depuis sa position d'origine.
     * @param x déplacement en abscisse
     * @param y déplacement en ordonnée
     */
    @Override
    public void deplace(final int x, final int y) {
        centre.deplace(x, y);
    }
    /**
     * affiche le cercle.
     */
    @Override
    public void affiche() {
        System.out.println("Cercle ("
                + "centre = " + centre + ", rayon = " + rayon + ")");
    }
    /**
     * obtenir la valeur du rayon.
     * @return le rayon
     */
    public int getRayon() {
        return rayon;
    }
    /**
     * définir une nouvelle valeur pour le rayon.
     * @param newRayon nouvelle valeur pour le rayon
     */
    public void setRayon(final int newRayon) {
        this.rayon = newRayon;
    }
    /**
     * obtenir la position du centre du cercle.
     * @return la position du centre du cercle
     */
    public Position getCentre() {
        return centre.clone();
    }
    /**
     * définir une valeur pour le centre du cercle.
     * @param newCentre nouvelle position pour le centre
     */
    public void setCentre(final Position newCentre) {
        this.centre = newCentre.clone();
    }
}
