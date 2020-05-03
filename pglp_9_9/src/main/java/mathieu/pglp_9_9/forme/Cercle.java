package mathieu.pglp_9_9.forme;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * classe Cercle qui est une forme.
 */
public class Cercle extends Forme {
    /**
     * serial number.
     */
    private static final long serialVersionUID = -1029141195274921930L;
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
     * @param nom_de_variable nom de variable pour créer le cercle
     * @param p position du cercle
     * @param rayon_cercle rayon du cercle
     */
    public Cercle(final String nom_de_variable, final Position p,
            final int rayon_cercle) {
        super(nom_de_variable);
        centre = p.clone();
        rayon = rayon_cercle;
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
     * obtenir la valeur du rayon
     * @return le rayon
     */
    public int getRayon() {
        return rayon;
    }
    /**
     * définir une nouvelle valeur pour le rayon.
     * @param rayon nouvelle valeur pour le rayon
     */
    public void setRayon(final int rayon) {
        this.rayon = rayon;
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
     * @param centre nouvelle position pour le centre
     */
    public void setCentre(final Position centre) {
        this.centre = centre.clone();
    }
    /**
     * deserialize vers le fichier voulu.
     * @param path nom du fichier pour deserializer
     * @return l'instance de classe créé avec deserialization
     */
    public static Cercle deserialize(final String path) {
        ObjectInputStream reader = null;
        Cercle dp = null;
        try {
            FileInputStream file = new FileInputStream(path);
            reader = new ObjectInputStream(file);
            dp = (Cercle) reader.readObject();
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
