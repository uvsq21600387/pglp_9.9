package mathieu.pglp_9_9.forme;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * forme de type Triangle.
 */
public class Triangle extends Forme  {
    /**
     * serial number.
     */
    private static final long serialVersionUID = -5845584621462344970L;
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
    /**
     * deserialize vers le fichier voulu.
     * @param path nom du fichier pour deserializer
     * @return l'instance de classe créé avec deserialization
     */
    public static Triangle deserialize(final String path) {
        ObjectInputStream reader = null;
        Triangle dp = null;
        try {
            FileInputStream file = new FileInputStream(path);
            reader = new ObjectInputStream(file);
            dp = (Triangle) reader.readObject();
        } catch (IOException e) {
            System.err.println(
            "La deserialization a échoué depuis le fichier \""
            + path + "\"");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return dp;
    }
}
