package mathieu.pglp_9_9.forme;

/**
 * forme de type Triangle.
 */
public class Triangle extends Forme {
    /**
     * ensemble des 3 points d'un triangle.
     */
    private Position[] points;
    /**
     * constructeur d'un triangle.
     * @param nom_de_variable nom de variable pour créer le triangle
     * @param point1 premier point du triangle
     * @param point2 deuxième point du triangle
     * @param point3 troisième point du triangle
     */
    public Triangle(final String nom_de_variable, final Position point1,
            final Position point2, final Position point3) {
        super(nom_de_variable);
        points[0] = point1.clone();
        points[1] = point2.clone();
        points[2] = point3.clone();
    }
    /**
     * deplace les trois points du triangle.
     * @param x déplacement en abscisse
     * @param y deplacement en ordonnée
     */
    @Override
    public void deplace(final int x, final int y) {
        for (int i = 0; i < 3; i++) {
            points[i].deplace(x, y);
        }
    }
    /**
     * affiche la forme.
     */
    @Override
    public void affiche() {
        System.out.println("Triangle ("
                + "position des points = " + points[0] + ", "
                + points[1] + ", " + points[2] + ", " + ")");
    }
    /**
     * obtenir un point du triangle.
     * @param index valeur entre 0 et 2 indiquant le point souhaité
     * @return le point souhaité
     */
    public Position getPosition(final int index) {
        if(index < 0 || index > 2) {
            throw new IndexOutOfBoundsException();
        } else {
            return points[index].clone();
        }
    }
    /**
     * définir une nouvelle valeur pour un point.
     * @param point nouvelle valeur pour le point
     * @param index valeur entre 0 et 2 indiquant le point à modifier
     */
    public void setPosition(final Position point, final int index) {
        if(index < 0 || index > 2) {
            throw new IndexOutOfBoundsException();
        } else {
            points[index] = point.clone();
        }
    }
}
