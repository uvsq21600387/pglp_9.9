package mathieu.pglp_9_9.forme;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Pattern composite pour les formes.
 */
public class GroupeForme extends Forme implements Iterable<Forme> {
    /**
     * liste des formes.
     */
    private ArrayList<Forme> formes;
    /**
     * constructeur du groupe.
     * @param variableName nom de la variable pour le groupe
     */
    public GroupeForme(final String variableName) {
        super(variableName);
        formes = new ArrayList<Forme>();
    }
    /**
     * deplace les formes.
     * @param x déplacement en abscisse
     * @param y deplacement en ordonée
     */
    @Override
    public void deplace(final int x, final int y) {
        for (Forme f : formes) {
            f.deplace(x, y);
        }
    }
    /**
     * affiche les formes et groupes de formes dans ce groupe.
     */
    public void affiche() {
        super.affiche();
        System.out.println("Groupe (");
        for (Forme f : formes) {
            f.affiche();
        }
        System.out.println(")");
    }
    /**
     * ajoute une forme ou un groupe au groupe.
     * @param f forme ou groupe à ajouter au groupe
     */
    public void add(final Forme f) {
        if (!formes.contains(f) && f != this) {
            formes.add(f);
        }
    }
    /**
     * supprime une forme ou un groupe du groupe.
     * @param f forme ou groupe à supprimer du groupe
     */
    public void remove(final Forme f) {
        formes.remove(f);
    }
    /**
     * obtenir la liste des formes et groupes du groupe.
     * @return la liste des formes et groupe du groupe
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Forme> getList() {
        return (ArrayList<Forme>) formes.clone();
    }
    /**
     * implementation de l'interface iterable.
     * @return iterateur sur les élements du groupe
     */
    public Iterator<Forme> iterator() {
        return formes.iterator();
    }
}
