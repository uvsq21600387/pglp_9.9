package mathieu.pglp_9_9.forme;

/**
 * forme de type Triangle.
 */
public class Triangle extends Forme  {
    /**
     * ensemble des 3 points d'un triangle.
     */
    private Position[] points;
    /**
     * constructeur d'un triangle.
     * @param nomVariable nom de variable pour créer le triangle
     * @param point1 premier point du triangle
     * @param point2 deuxième point du triangle
     * @param point3 troisième point du triangle
     */
    public Triangle(final String nomVariable, final Position point1,
            final Position point2, final Position point3) {
        super(nomVariable);
        final int trois = 3;
        points = new Position[trois];
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
        final int trois = 3;
        for (int i = 0; i < trois; i++) {
            points[i].deplace(x, y);
        }
    }
    /**
     * affiche la forme.
     */
    public void affiche() {
        super.affiche();
        System.out.println("Triangle ("
                + "position des points = " + points[0] + ", "
                + points[1] + ", " + points[2] + ")");
    }
    /**
     * obtenir un point du triangle.
     * @param index valeur entre 0 et 2 indiquant le point souhaité
     * @return le point souhaité
     */
    public Position getPosition(final int index) {
        if (index < 0 || index > 2) {
            throw new IndexOutOfBoundsException();
        } else {
            return points[index].clone();
        }
    }
}
